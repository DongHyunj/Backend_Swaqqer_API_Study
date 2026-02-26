package org.example.swaqqerapi_study.feed;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.feed.model.Feed;
import org.example.swaqqerapi_study.feed.model.FeedDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedSerivce {
    private final FeedRepository feedRepository;

    public List<FeedDto.ListRes> list() {
        List<Feed> feedList = feedRepository.findAll();
        return feedList.stream().map(FeedDto.ListRes::from).toList();
    }
}
