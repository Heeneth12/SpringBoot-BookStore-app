package com.telusk.springbootbookstore.user.repository;

import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

}
