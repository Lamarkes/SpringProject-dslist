package com.reviwgames.dslist.services;


import com.reviwgames.dslist.dto.GameDTO;
import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.entities.Game;
import com.reviwgames.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/*@Service -> e indica que a classe é um componente a ser gerenciado pelo Spring.
	podem ser usadas para permitir a injeção de dependências em outras classes,
	permitindo que o Spring gerencie o ciclo de vida desses componentes, como a
	criação e destruição de instâncias de objetos*/
@Service // registra como um serviço do sistema
//@Component- mesma ideia do @Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // esta anotaçao garante que a operaação com o bd aconteça
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get(); // busca o game por id e armazena na variavel result
        return new GameDTO(result); // converte o game na variavel result em um gameDTO
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        // busca todos os Games registrados por meio do gameReposiroty no bd e converte em uma List
        List<Game> result = gameRepository.findAll();
        // converte a variavel result do tipo Game para GameMinDTO por meio de stream()
        return result.stream().map(GameMinDTO::new).toList();

    }
}
