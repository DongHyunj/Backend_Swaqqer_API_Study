package org.example.swaqqerapi_study.feed;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="게시판 기능")
public class FeedController {
    private final FeedSerivce feedSerivce;

    @Operation(summary = "게시글 등록", description = "제목, 내용을 입력해서 게시글을 작성하는 기능")
    @PostMapping("/reg")
    public ResponseEntity reg(@AuthenticationPrincipal AuthUserDetails user, @RequestBody FeedDto.RegReq dto) {
        feedSerivce.reg(user, dto);

        return ResponseEntity.ok(BaseResponse.success("성공"));
    }

    @Operation(summary = "게시글 목록 조회", description = "게시글 번호, 내용, 작성자, 이미지들, 좋아요 개수, 좋아요가 있는 게시글들을 조회하는 기능")
    @GetMapping("/list")
    public ResponseEntity list(@AuthenticationPrincipal AuthUserDetails user) {
        List<FeedDto.ListRes> result = feedSerivce.list(user);

        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @Operation(summary = "이미지 업로드", description = "게시글 작성 중에 이미지를 포함하면 이미지를 DB에 등록하는 기능")
    @PostMapping("/upload/image")
    public ResponseEntity uploadImage(List<MultipartFile> images) {
        List<FeedDto.ImageUploadRes> result = feedSerivce.uploadImage(images);
        return ResponseEntity.ok(BaseResponse.success(result));
    }
}
