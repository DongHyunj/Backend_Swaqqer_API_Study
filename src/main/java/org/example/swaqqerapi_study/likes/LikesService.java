package org.example.swaqqerapi_study.likes;

import lombok.RequiredArgsConstructor;
import org.example.swaqqerapi_study.feed.model.Feed;
import org.example.swaqqerapi_study.likes.model.Likes;
import org.example.swaqqerapi_study.user.model.AuthUserDetails;
import org.example.swaqqerapi_study.user.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;

    public void likes(AuthUserDetails user, Long feedIdx) {
        User userEntity = user.toEntity();
        Feed feedEntity = Feed.builder().idx(feedIdx).build();
        Optional<Likes> result =  likesRepository.findByUserAndFeed(userEntity, feedEntity);

        if(result.isPresent()) {
            likesRepository.delete(result.get());
        } else {
            Likes likes = Likes.builder()
                    .user(userEntity)
                    .feed(feedEntity)
                    .build();

            likesRepository.save(likes);
        }
    }
}
