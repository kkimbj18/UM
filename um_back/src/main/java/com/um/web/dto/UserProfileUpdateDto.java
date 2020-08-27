package com.um.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileUpdateDto {
    private int userId;
    private String phoneNumber;
    private String address;
}
