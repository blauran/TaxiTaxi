package com.taxiService.taxi.models.data;

import com.taxiService.taxi.models.Role;
import com.taxiService.taxi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    List<User> findAllByRole(Role role);
}
