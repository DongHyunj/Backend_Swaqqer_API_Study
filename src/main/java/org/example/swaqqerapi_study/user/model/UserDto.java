package org.example.swaqqerapi_study.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

public class UserDto {
    @Getter
    public static class SingupReq {
        @Pattern(message = "이메일 형식이 아닙니다.", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        private String email;
        @Pattern(regexp = "^[가-힣\\s]*$", message = "한글과 공백만 입력 가능합니다.")
        private String name;
        @Pattern(message = "비밀번호는 숫자,영문,특수문자( !@#$%^&*() )를 조합해 8~20자로 생성해주세요.", regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()])(?=.*[0-9]).{8,20}$")
        private String password;

        public User toEntity() {
            return User.builder()
                    .email(this.email)
                    .name(this.name)
                    .password(this.password)
                    .build();
        }
    }

    @Getter
    public static class LoginReq {
        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        private String email;
        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;
    }

    @Getter
    @Builder
    public static class LoginRes {
        private Long idx;
        private String email;
        private String name;

        public static LoginRes from(AuthUserDetails entity) {
            return LoginRes.builder()
                    .idx(entity.getIdx())
                    .email(entity.getEmail())
                    .name(entity.getUsername())
                    .build();
        }
    }
}
