package com.um.domain.brand;

import com.um.domain.user.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@NoArgsConstructor
@Entity
@Table(name="brand")
public class Brand {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Image logo;
}
