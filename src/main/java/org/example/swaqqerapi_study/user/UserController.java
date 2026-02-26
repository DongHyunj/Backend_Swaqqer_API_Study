package org.example.swaqqerapi_study.user;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.user.model.AuthUserDetails;
import org.example.swaqqerapi_study.user.model.UserDto;
import org.example.swaqqerapi_study.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDto.SingupReq dto) {
        userService.signup(dto);

        return ResponseEntity.ok("등록 성공");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto.LoginReq dto) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword(), null);

        Authentication authentication = authenticationManager.authenticate(token);
        AuthUserDetails user = (AuthUserDetails) authentication.getPrincipal();

        if(user != null) {
            String jwt = jwtUtil.createToken(user.getIdx(), user.getUsername());

            UserDto.LoginRes result = UserDto.LoginRes.from(user);

            return ResponseEntity.ok()
                    .header("Set-Cookie", "ATOKEN=" + jwt + "; Path=/")
                    .body(result);
        }

        return ResponseEntity.ok("로그인 실패");
    }

}
