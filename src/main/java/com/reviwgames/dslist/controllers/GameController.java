package com.reviwgames.dslist.controllers;

import com.reviwgames.dslist.dto.GameDTO;
import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // anotaçao para indicar que esta classe é um controlador Rest
@RequestMapping(value = "/games") // vai mapear a classe com o /games
public class GameController {


    @Autowired
    private GameService gameService; // injeção de dependencia do Service

    //GetMapping(value = "")-> usado para mapear requisicoes GET usadas nos controllers
    //passando um id como argumento na rota, que sera redirecionado para as configuracoes da classe
    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        if (result != null){
        return ResponseEntity.ok().body(result);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    //GetMapping->  retorno padrao para o RequestMapping
    @GetMapping
    public ResponseEntity findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return ResponseEntity.ok().body(result);
    }

  @DeleteMapping(value = "/{id}")
   public ResponseEntity remove(@PathVariable Long id){
        if (gameService.findById(id) != null){
            gameService.remove(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
