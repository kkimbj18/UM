package com.um.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Getter
@NoArgsConstructor
public class UserCreateDto
{
    private String account;
    private String password;
    private String phoneNumber;
    private String address;
    private String name;

    @Builder
    public UserCreateDto(String account, String password, String phoneNumber, String address, String name)
    {
        this.account = account;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
    }
}
