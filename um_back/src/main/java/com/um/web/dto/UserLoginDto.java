package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginDto {
    private String account;
    private String password;

    @Builder
    public UserLoginDto(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
