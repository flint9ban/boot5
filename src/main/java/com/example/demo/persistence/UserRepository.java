package com.example.demo.persistence;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liyi on 17/7/6.
 */


public interface UserRepository extends JpaRepository<User,Long>{

    List<User> findByName(String name);

    List<User> findByNameContaining(String name);
}
