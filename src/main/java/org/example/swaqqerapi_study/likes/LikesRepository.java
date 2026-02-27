package org.example.swaqqerapi_study.likes;

import org.example.swaqqerapi_study.feed.model.Feed;
import org.example.swaqqerapi_study.likes.model.Likes;
import org.example.swaqqerapi_study.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserAndFeed(User user, Feed feed);
}
