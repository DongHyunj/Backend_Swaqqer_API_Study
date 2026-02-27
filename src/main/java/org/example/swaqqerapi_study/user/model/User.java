package org.example.swaqqerapi_study.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.swaqqerapi_study.feed.model.Feed;
import org.example.swaqqerapi_study.likes.model.Likes;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String name;
    @Setter
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Feed> feedList;

    @OneToMany(mappedBy = "user")
    private List<Likes> likesList;
}
