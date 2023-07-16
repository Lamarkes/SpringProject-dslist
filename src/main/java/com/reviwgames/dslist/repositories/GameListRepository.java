package com.reviwgames.dslist.repositories;

import com.reviwgames.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {

}
