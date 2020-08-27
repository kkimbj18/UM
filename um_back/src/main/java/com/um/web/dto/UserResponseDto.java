package com.um.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String account;
    private String name;
    private String phoneNumber;
    private String address;
}
