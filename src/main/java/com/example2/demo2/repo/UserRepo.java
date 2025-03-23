package com.example2.demo2.repo;

import com.example2.demo2.model.UserModel;
import org.springframework.boot.env.ConfigTreePropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {

    @Query(value = "SELECT * FROM user_model WHERE id=?1 ",nativeQuery = true)
    UserModel getUserbyId(Integer id );


//    @Query(value = "SELECT * FROM user_model WHERE id=?1 AND name=?2")
//    UserModel getUserbyId(Integer id , String name);
}
