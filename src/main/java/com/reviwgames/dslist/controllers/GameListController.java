package com.reviwgames.dslist.controllers;

import com.reviwgames.dslist.dto.GameListDTO;
import com.reviwgames.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {


    @Autowired
    private GameListService gameListService;

    //GetMapping-> usado para mapear requisicoes GET usadas nos controllers
    //passando um id como argumento na rota, que sera redirecionado para as configuracoes da classe
    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

}
