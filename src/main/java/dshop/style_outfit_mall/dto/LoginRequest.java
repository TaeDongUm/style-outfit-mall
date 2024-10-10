package dshop.style_outfit_mall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String email;       // 사용자 이메일
    private String password;    // 사용자 비밀번호
}
