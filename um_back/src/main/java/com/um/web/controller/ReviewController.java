package com.um.web.controller;

import com.um.domain.review.ReviewRepository;
import com.um.service.ReviewService;
import com.um.web.dto.ReviewCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

    @CrossOrigin
    @PostMapping("/review/post")
    public List<Integer> postReview(@RequestBody ReviewCreateDto reviewCreateDto){

        return reviewService.postReview(reviewCreateDto);
    }
}
