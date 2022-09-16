package com.example.miniproject2team3.repository;

import com.example.miniproject2team3.service.Player;
import com.example.miniproject2team3.service.Result;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<Player, Long> {

    List<Player> findByName(String username);



}
