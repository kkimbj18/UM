package com.um.web.controller;

import com.um.config.security.JwtTokenProvider;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import com.um.service.UserService;
import com.um.web.dto.UserCreateDto;
import com.um.web.dto.UserLoginDto;
import com.um.web.dto.UserProfileUpdateDto;
import com.um.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;

    //프로필 확인
    @CrossOrigin
    @GetMapping("/profile")
    public UserResponseDto getProfile(@RequestParam("userId") int userId) {
        return userService.getProfile(userId);
    }
    @CrossOrigin
    @PutMapping("/profile/update/password")
    public String updatePassword(@RequestParam("userId") int userId ,String password){
        return userService.updatePassword(userId,password,passwordEncoder);
    }
    @CrossOrigin
    @PutMapping("/profile/update")
    public String updateProfile(@RequestBody UserProfileUpdateDto userProfileUpdateDto)
    {
        return userService.updateProfile(userProfileUpdateDto);
    }
    //회원가입
    @CrossOrigin
    @PostMapping("/signup")
    public int join(@RequestBody UserCreateDto userCreateDto) {
        int id;

        Optional<User> searchMember = userRepository.findByAccount(userCreateDto.getAccount());

        if(!searchMember.isPresent())
            id = userService.join(userCreateDto, passwordEncoder);
        else
            throw new IllegalArgumentException("이미 가입된 계정입니다.");

        //userService.join(userCreateDto, passwordEncoder);
        return id;
    }
    //모든 회원 정보 불러오기
    @CrossOrigin
    @GetMapping("/userCheck")
    public List<User> check(){
        return userRepository.findAll();
    }
    //로그인
    @CrossOrigin
    @PostMapping("/login")
    public List<String> login(@RequestBody UserLoginDto userLoginDto) {
        List<String> list = new ArrayList<>();

        User member = userRepository.findByAccount(userLoginDto.getAccount())
            .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 계정 입니다."));
        if(!passwordEncoder.matches(userLoginDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        //return jwtTokenProvider.createToken(member.getName(), member.getRole());
        list.add(jwtTokenProvider.createToken(member.getName(), member.getRole()));
        list.add(Integer.toString(member.getUserId()));

        return list;
    }
}