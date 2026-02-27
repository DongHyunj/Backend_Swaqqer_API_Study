package org.example.swaqqerapi_study.likes;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.common.model.BaseResponse;
import org.example.swaqqerapi_study.user.model.AuthUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/likes")
@RestController
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    @GetMapping("/{feedIdx}")
    public ResponseEntity likes(@AuthenticationPrincipal AuthUserDetails user, @PathVariable Long feedIdx) {
        likesService.likes(user, feedIdx);

        return ResponseEntity.ok(BaseResponse.success(true));
    }
}
