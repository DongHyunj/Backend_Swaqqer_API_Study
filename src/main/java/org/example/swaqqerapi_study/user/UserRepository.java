package org.example.swaqqerapi_study.user;

import org.example.swaqqerapi_study.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
