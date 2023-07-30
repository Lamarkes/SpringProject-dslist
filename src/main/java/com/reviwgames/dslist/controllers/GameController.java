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

@RestController // anotaçao para indicar que esta classe é um controlador Rest
@RequestMapping(value = "/games") // vai mapear a classe com o /games
public class GameController {


    @Autowired
    private GameService gameService; // injeção de dependencia do Service

    //GetMapping(value = "")-> usado para mapear requisicoes GET usadas nos controllers
    //passando um id como argumento na rota, que sera redirecionado para as configuracoes da classe
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }
    //GetMapping->  retorno padrao para o RequestMapping
    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

}
