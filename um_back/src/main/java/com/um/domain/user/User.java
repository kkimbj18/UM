package com.um.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length = 20, nullable = false, unique = true)
    private String account;

    @Column(length = 20, nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> role = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthories() {
        return nthis.role.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    }

    @Column(length = 20, nullable = false) // unique?
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String phonenumber;

    @Column(length = 50, nullable = false)
    private String address;

    @Override
    public String getUsername() {
        return account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}