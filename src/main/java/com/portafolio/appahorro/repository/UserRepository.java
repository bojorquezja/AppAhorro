package com.portafolio.appahorro.repository;

import com.portafolio.appahorro.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String s);

    List<User> findAll();
}
