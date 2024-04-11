package com.telusk.springbootbookstore.user.repository;

import com.telusk.springbootbookstore.user.entity.AddressEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepo extends JpaRepository<AddressEntity ,Long> {

}
