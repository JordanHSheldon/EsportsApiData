package com.example.demo.dao;

import com.example.demo.Model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PlayerDataService implements PlayerDao {
    private static List<Player> DB = new ArrayList<Player>();
    @Override
    public int insertPlayer(UUID id, Player newPlayer){
        DB.add(new Player(id, newPlayer.getName(), newPlayer.lname, newPlayer.alias));
        return 0;
    }

    public List<Player> getAllPlayers(){
        return DB;
    }

    @Override
    public Optional<Player> getPlayerById(UUID id) {
        return DB.stream()
                 .filter(player -> player.getId().equals(id))
                 .findFirst();
    }

    @Override
    public int deletePlayerById(UUID id) {
        Optional <Player> playerMaybe = getPlayerById(id);
        if(playerMaybe.isEmpty()){
            return 0;
        }
        DB.remove(playerMaybe.get());
        return 1;
    }

    @Override
    public int updatePlayerById(UUID id, Player newPlayer) {
        return getPlayerById(id)
                .map(player-> {
                    int indexOfPlayerToUpdate = DB.indexOf(player);
                    if (indexOfPlayerToUpdate >= 0){
                        DB.set(indexOfPlayerToUpdate, new Player(id, newPlayer.getName(), newPlayer.lname, newPlayer.alias));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
