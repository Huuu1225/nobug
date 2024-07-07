package com.cqdx.nobug.mapper;

import com.cqdx.nobug.entity.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserPhoto, Long> {
}
