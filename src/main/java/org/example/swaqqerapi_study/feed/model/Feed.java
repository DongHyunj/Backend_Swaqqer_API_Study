package org.example.swaqqerapi_study.feed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.swaqqerapi_study.likes.model.Likes;
import org.example.swaqqerapi_study.user.model.User;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    @OneToMany(mappedBy = "feed")
    private List<Likes> likesList;

    @OneToMany(mappedBy = "feed")
    public List<FeedImage> feedImageList;

}
