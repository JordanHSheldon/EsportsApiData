package com.example.demo.dao;

import com.example.demo.Model.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerDao {
    int insertPlayer(UUID id, Player player);
    default int insertPlayer(Player player){
        UUID id = UUID.randomUUID();
        return insertPlayer(id,player);
    }
    List<Player> getAllPlayers();
    Optional<Player> getPlayerById(UUID id);
    int deletePlayerById(UUID id);
    int updatePlayerById(UUID id, Player player);
}
