package com.reviwgames.dslist.services;


import com.reviwgames.dslist.dto.GameDTO;
import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.entities.Game;
import com.reviwgames.dslist.projections.GameMinProjection;
import com.reviwgames.dslist.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


/*@Service -> e indica que a classe é um componente a ser gerenciado pelo Spring.
	podem ser usadas para permitir a injeção de dependências em outras classes,
	permitindo que o Spring gerencie o ciclo de vida desses componentes, como a
	criação e destruição de instâncias de objetos*/
@Service // registra como um serviço do sistema
//@Component- mesma ideia do @Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // é usada quando você deseja apenas ler os dados durante a transação e não modificar nada
    public GameDTO findById(Long id){
        Optional<Game> result = gameRepository.findById(id); // busca o game por id e armazena na variavel result
        if (result.isPresent()) {
            return new GameDTO(result.get()); // converte o game na variavel result em um gameDTO
        }else {
            throw new EntityNotFoundException();
        }
        }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        // busca todos os Games registrados por meio do gameReposiroty no bd e converte em uma List
        List<Game> result = gameRepository.findAll();
        // converte a variavel result do tipo Game para GameMinDTO por meio de stream()
        return result.stream().map(GameMinDTO::new).toList();

    }

    @Transactional(readOnly = true) // comentar sobre
    public List<GameMinDTO> findByList(Long listId){
        // busca todos os GameMinProject registrados por meio do gameReposiroty no bd e converte em uma List
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        // converte a variavel result do tipo GameMinProject para GameMinDTO por meio de stream()
        return result.stream().map(GameMinDTO::new).toList();

    }

    public void remove(Long id){ // neste caso a classe so tem objetivo de excluir e nao é necessario retornar nada
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()){
            gameRepository.delete(optionalGame.get());
        }else {
            throw new EntityNotFoundException();
        }
    }
}
