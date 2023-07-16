package com.reviwgames.dslist.services;


import com.reviwgames.dslist.dto.GameDTO;
import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.entities.Game;
import com.reviwgames.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // registra como um serviço do sistema
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get(); // busca o game por id e armazena na variavel result
        return new GameDTO(result); // converte o game na variavel result em um gameDTO
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
