package com.reviwgames.dslist.services;


import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.entities.Game;
import com.reviwgames.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // registra como um serviço do sistema
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
