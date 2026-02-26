package org.example.swaqqerapi_study.user.model;

import lombok.Builder;
import lombok.Getter;

public class UserDto {
    @Getter
    public static class SingupReq {
        private String email;
        private String name;
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
        private String email;
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
