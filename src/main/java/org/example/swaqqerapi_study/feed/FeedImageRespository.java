package org.example.swaqqerapi_study.feed;

import org.example.swaqqerapi_study.feed.model.FeedImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedImageRespository extends JpaRepository<FeedImage, Long> {
}
