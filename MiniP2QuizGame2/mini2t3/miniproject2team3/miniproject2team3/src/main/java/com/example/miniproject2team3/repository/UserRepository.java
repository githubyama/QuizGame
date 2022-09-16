package com.example.miniproject2team3.repository;

import com.example.miniproject2team3.service.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Player, Long> {

    List<Player> findByName(String username);
    @Query(value = " select name, total_score from player join result on player.id = result.id", nativeQuery = true)
    List<Player> findPlayersWithNativeQuery();

}
