package org.example.swaqqerapi_study.feed.model;

import lombok.Builder;
import lombok.Getter;
import org.example.swaqqerapi_study.user.model.AuthUserDetails;

import java.util.List;

public class FeedDto {

    @Getter
    public static class Reg {
        private String contents;
        private List<Long> imageIdxList;

        public Feed toEntity(AuthUserDetails user) {
            return Feed.builder()
                    .contents(contents)
                    .user(user.toEntity())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String contents;
        private String writer;
        private List<String> images;
        private Long likesCount;
        private boolean isLikes;

        public static ListRes from(Feed entity, AuthUserDetails user) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .writer(entity.getUser().getName())
                    .images(entity.getFeedImageList().stream().map(FeedImage::getImageUrl).toList())
                    .likesCount(Long.valueOf(entity.getLikesList().size()))
                    .isLikes(entity.getLikesList().stream().anyMatch(
                            likes -> likes.getUser().getIdx() == user.getIdx()
                    ))
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ImageUploadRes {
        private Long idx;
        private String imageUrl;

        public static ImageUploadRes from(FeedImage entity) {
            return ImageUploadRes.builder()
                    .idx(entity.getIdx())
                    .imageUrl(entity.getImageUrl())
                    .build();
        }
    }
}
