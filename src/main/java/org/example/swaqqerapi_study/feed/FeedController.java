package org.example.swaqqerapi_study.feed;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.feed.model.FeedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/feed")
@RestController
@RequiredArgsConstructor
public class FeedController {
    private final FeedSerivce feedSerivce;

    @GetMapping("/list")
    public ResponseEntity list() {
        List<FeedDto.ListRes> result = feedSerivce.list();

        return ResponseEntity.ok(result);
    }
}
