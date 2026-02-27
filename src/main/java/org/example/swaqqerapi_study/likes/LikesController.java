package org.example.swaqqerapi_study.likes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="좋아요 기능")
public class LikesController {
    private final LikesService likesService;

    @Operation(summary = "좋아요 등록 기능", description = "좋아요를 한번 누르면 좋아요 등록, 한번 더 누르면 절회")
    @GetMapping("/{feedIdx}")
    public ResponseEntity likes(@AuthenticationPrincipal AuthUserDetails user, @PathVariable Long feedIdx) {
        likesService.likes(user, feedIdx);

        return ResponseEntity.ok(BaseResponse.success(true));
    }
}
