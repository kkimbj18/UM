package com.um.service;

import com.um.domain.item.Item;
import com.um.domain.item.ItemRepository;
import com.um.domain.review.Review;
import com.um.domain.review.ReviewRepository;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import com.um.web.dto.ReviewCreateDto;
import com.um.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<Integer> postReview(ReviewCreateDto reviewCreateDto){
        List<Integer> list = new ArrayList<>();

        User user = userRepository.findById(reviewCreateDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException
                        ("해당 유저가 존재하지 않습니다. (UserId : " + reviewCreateDto.getUserId() + ")"));
        Item item = itemRepository.findById(reviewCreateDto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException
                        ("해당 아이템이 존재하지 않습니다. (ItemId : " + reviewCreateDto.getItemId() + ")"));

        Review review = reviewRepository.save(Review.builder()
                .item(item)
                .user(user)
                .content(reviewCreateDto.getContent())
                .photo(reviewCreateDto.getPhoto())
                .rating(reviewCreateDto.getRating())
                .build());

        list.add(review.getUser().getUserId());
        list.add(review.getItem().getItemId());

        return list;
    }
}
