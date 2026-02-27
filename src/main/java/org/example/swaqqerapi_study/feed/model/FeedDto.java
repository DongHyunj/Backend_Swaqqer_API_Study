package org.example.swaqqerapi_study.feed.model;

import lombok.Builder;
import lombok.Getter;
import org.example.swaqqerapi_study.user.model.AuthUserDetails;

public class FeedDto {

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String contents;
        private String writer;
        private Long likesCount;
        private boolean isLikes;

        public static ListRes from(Feed entity, AuthUserDetails user) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .writer(entity.getUser().getName())
                    .likesCount(Long.valueOf(entity.getLikesList().size()))
                    .isLikes(entity.getLikesList().stream().anyMatch(
                            likes -> likes.getUser().getIdx() == user.getIdx()
                    ))
                    .build();
        }
    }
}
