package com.um.web.controller;

import com.um.config.security.JwtTokenProvider;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import com.um.service.UserService;
import com.um.web.dto.UserCreateDto;
import com.um.web.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;

    //회원가입
    @CrossOrigin
    @PostMapping("/signup")
    public int join(@RequestBody UserCreateDto userCreateDto) {
        /*
        Optional<User> searchMember = userRepository.findByAccount(userCreateDto.getAccount());
        if(searchMember == null)
            userService.join(userCreateDto, passwordEncoder);
        */
        userService.join(userCreateDto, passwordEncoder);
        return userCreateDto.getUserId();
    }

    @CrossOrigin
    @GetMapping("/check")
    public List<User> check(){
        return userRepository.findAll();
    }
    //로그인
    @CrossOrigin
    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto userLoginDto) {
        User member = userRepository.findByAccount(userLoginDto.getAccount())
            .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 계정 입니다."));
        if(!passwordEncoder.matches(userLoginDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getName(), member.getRole());
    }
}