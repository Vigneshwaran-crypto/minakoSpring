package com.example.minakospring.minako.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.minakospring.minako.Entities.Users;

@Repository
public interface UserRep extends JpaRepository<Users,Long> {

    
}