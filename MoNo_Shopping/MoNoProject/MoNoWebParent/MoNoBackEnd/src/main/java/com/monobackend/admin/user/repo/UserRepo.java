package com.monobackend.admin.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mono.common.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
