package org.example.swaqqerapi_study.feed;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.common.model.BaseResponse;
import org.example.swaqqerapi_study.feed.model.FeedDto;
import org.example.swaqqerapi_study.user.model.AuthUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/feed")
@RestController
@RequiredArgsConstructor
public class FeedController {
    private final FeedSerivce feedSerivce;

    @PostMapping("/reg")
    public ResponseEntity reg(@AuthenticationPrincipal AuthUserDetails user, @RequestBody FeedDto.Reg dto) {
        feedSerivce.reg(user, dto);

        return ResponseEntity.ok(BaseResponse.success("성공"));
    }

    @GetMapping("/list")
    public ResponseEntity list(@AuthenticationPrincipal AuthUserDetails user) {
        List<FeedDto.ListRes> result = feedSerivce.list(user);

        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @PostMapping("/upload/image")
    public ResponseEntity uploadImage(List<MultipartFile> images) {
        List<FeedDto.ImageUploadRes> result = feedSerivce.uploadImage(images);
        return ResponseEntity.ok(BaseResponse.success(result));
    }
}
