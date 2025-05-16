package yooni.spring.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import yooni.spring.domain.Member;

import java.util.Collection;
import java.util.Collections;

@Getter
public class MemberDetail implements UserDetails {

    private final Member member;

    public MemberDetail(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 정보가 있다면 여기에 반환
        return Collections.emptyList();  // 또는 List.of(new SimpleGrantedAuthority(...))
    }

    @Override
    public String getPassword() {
        return member.getPassword();  // Member 엔티티에 비밀번호 필드가 있어야 함
    }

    @Override
    public String getUsername() {
        return member.getEmail();  // 일반적으로 이메일을 username으로 사용
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 비활성화 정책을 도입하지 않는 경우 true
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 잠금 정책 미적용 시 true
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호 유효 기간 미적용 시 true
    }

    @Override
    public boolean isEnabled() {
        return true; // 활성 사용자 여부
    }
}
