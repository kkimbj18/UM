package com.um.service;

import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import com.um.web.dto.UserCreateDto;
import com.um.web.dto.UserProfileUpdateDto;
import com.um.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto getProfile(int userId)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return UserResponseDto.builder()
                .account(user.getAccount())
                .address(user.getAddress())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    @Transactional
    public String updateProfile(UserProfileUpdateDto userProfileUpdateDto)
    {
        User user = userRepository.findById(userProfileUpdateDto.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        user.updateProfile(userProfileUpdateDto.getAddress(),userProfileUpdateDto.getPhoneNumber());
        return "프로필 업데이트 완료.";
    }

    @Transactional
    public String updatePassword(int userId,String password,PasswordEncoder passwordEncoder)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        user.updatePassword(passwordEncoder.encode(password));
        return "비밀번호 업데이트 완료.";
    }

    @Transactional
    public int join(UserCreateDto userCreateDto, PasswordEncoder passwordEncoder) {
        User user = userRepository.save(User.builder()
                .account(userCreateDto.getAccount())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .role(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER로 설정
                .address(userCreateDto.getAddress())
                .name(userCreateDto.getName())
                .phoneNumber(userCreateDto.getPhoneNumber())
                .build());

        return user.getUserId();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByAccount(name)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
