package org.example.swaqqerapi_study.user;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.user.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDto.SingupReq dto) {
        userService.signup(dto);

        return ResponseEntity.ok("등록 성공");
    }
}
