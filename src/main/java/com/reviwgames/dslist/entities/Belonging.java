package com.reviwgames.dslist.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    /*indica que uma classe é incorporada, ou seja, ela representa uma parte de um
    objeto maior que é armazenado como um único valor no banco de dados*/
    @EmbeddedId
    private BelongingPK id = new BelongingPK(); // deve ser iniciado para nao começar como nulo
    private Integer position;

    public Belonging(){}

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setGameList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Belonging belonging)) return false;
        return Objects.equals(id, belonging.id) && Objects.equals(position, belonging.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
