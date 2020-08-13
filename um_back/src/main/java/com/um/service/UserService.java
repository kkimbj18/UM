package com.um.service;

import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import com.um.web.dto.UserCreateDto;
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
    public void join(UserCreateDto userCreateDto, PasswordEncoder passwordEncoder) {
        userRepository.save(User.builder()
                .account(userCreateDto.getAccount())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .role(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER로 설정
                .address(userCreateDto.getAddress())
                .name(userCreateDto.getName())
                .phoneNumber(userCreateDto.getPhoneNumber())
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByAccount(name)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

}
