package com.telusk.springbootbookstore.user.repository;

import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password")
    UserEntity findByUsernameAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM UserEntity u WHERE u.firstName = :firstName")
    UserEntity findByFirstName(@Param("firstName") String firstName);

}
