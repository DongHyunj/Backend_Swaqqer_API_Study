package org.example.swaqqerapi_study.feed;

import org.example.swaqqerapi_study.feed.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
