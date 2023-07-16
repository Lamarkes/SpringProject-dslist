package com.reviwgames.dslist.controllers;

import com.reviwgames.dslist.dto.GameDTO;
import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {


    @Autowired
    private GameService gameService;

    //GetMapping-> usado para mapear requisicoes GET usadas nos controllers
    //passando um id como argumento na rota, que sera redirecionado para as configuracoes da classe
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

}
