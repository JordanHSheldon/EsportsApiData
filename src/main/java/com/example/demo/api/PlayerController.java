package com.example.demo.api;

import com.example.demo.Model.Player;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PlayerService;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/player")
@RestController
public class PlayerController {
    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }
    @PostMapping(path = "/add")
    public void insertPlayer(@RequestBody @Valid Player player){
        playerService.insertPlayer(player);
    }
    @PostMapping(path = "/getAll")
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayers();
    }

    @PostMapping(path = "/{id}")
    public Player getPlayerById(@PathVariable("id") @Valid UUID id){
        return playerService.getPlayerById(id).orElse(null);
    }

    @PostMapping(path = "/delete/{id}")
    public void deletePlayerById(@PathVariable("id") @Valid UUID id){
        playerService.deletePlayerById(id);
    }
    @Validated
    @PutMapping(path = "/update/{id}")
    public void updatePlayer(@PathVariable("id") @NonNull @Valid UUID id, @NonNull @Valid @RequestBody Player newPlayer){
        playerService.updatePlayer(id, newPlayer);
    }

}
