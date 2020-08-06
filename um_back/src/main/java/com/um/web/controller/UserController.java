package com.um.web.controller;

import com.um.config.security.JwtTokenProvider;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    //회원가입
    @PostMapping("/user/signup")
    public int join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
            .account(user.get("account"))
            .password(passwordEncoder.encode(user.get("password")))
            .role(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER로 설정
            .address(user.get("address"))
            .name(user.get("name"))
            .phonenumber(user.get("phoneNumber"))
            .build()).getUserId();
    }

    //로그인
    @PostMapping("/user/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByAccount(user.get("account"))
            .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if(!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRole());
    }
}