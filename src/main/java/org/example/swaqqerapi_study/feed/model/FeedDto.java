package org.example.swaqqerapi_study.feed.model;

import lombok.Builder;
import lombok.Getter;

public class FeedDto {

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String contents;
        private String writer;
        private Long likesCount;

        public static ListRes from(Feed entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .writer(entity.getUser().getName())
                    .likesCount(Long.valueOf(entity.getLikesList().size()))
                    .build();
        }
    }
}
