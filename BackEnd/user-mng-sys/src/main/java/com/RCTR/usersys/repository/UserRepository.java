package com.RCTR.usersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RCTR.usersys.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
