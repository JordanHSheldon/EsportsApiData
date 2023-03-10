package com.example.demo.service;

import com.example.demo.Model.Player;
import com.example.demo.dao.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerDao playerDao;

    @Autowired
    public PlayerService(@Qualifier("fakeDao") PlayerDao playerDao){
            this.playerDao = playerDao;
    }
    public int insertPlayer(Player player){
        return playerDao.insertPlayer(player);
    }
    public int insertPlayerWithUUID(Player player){
        return playerDao.insertPlayer(player);
    }

    public List<Player> getAllPlayers(){
        return playerDao.getAllPlayers();
    }

    public Optional<Player> getPlayerById(UUID id){
        return playerDao.getPlayerById(id);
    }
    public int deletePlayerById(UUID id){
        return playerDao.deletePlayerById(id);
    }

    public int updatePlayer(UUID id, Player newPlayer){
        return playerDao.updatePlayerById(id, newPlayer);
    }
}
