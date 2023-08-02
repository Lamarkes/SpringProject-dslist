package com.reviwgames.dslist.controllers;

import com.reviwgames.dslist.dto.GameListDTO;
import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.dto.ReplacementDTO;
import com.reviwgames.dslist.services.GameListService;
import com.reviwgames.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {


    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    //GetMapping-> usado para mapear requisicoes GET usadas nos controllers
    //passando um id como argumento na rota, que sera redirecionado para as configuracoes da classe
    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findAll(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId,body.getSourceIndex(),body.getDestinationIndex());
    }
}
