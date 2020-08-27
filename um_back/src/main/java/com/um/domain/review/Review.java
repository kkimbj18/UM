package com.um.domain.review;

import com.um.domain.item.Item;
import com.um.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private short rating;

    @Column(name = "photo")
    private String photo;
}
