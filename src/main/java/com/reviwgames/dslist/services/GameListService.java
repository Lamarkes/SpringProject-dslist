package com.reviwgames.dslist.services;

import com.reviwgames.dslist.dto.GameListDTO;
import com.reviwgames.dslist.dto.GameMinDTO;
import com.reviwgames.dslist.entities.GameList;
import com.reviwgames.dslist.projections.GameMinProjection;
import com.reviwgames.dslist.repositories.GameListRepository;
import com.reviwgames.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // registra como um serviço do sistema
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex,int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i < max; i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }
}
