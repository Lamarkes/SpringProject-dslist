package com.reviwgames.dslist.repositories;

import com.reviwgames.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}
