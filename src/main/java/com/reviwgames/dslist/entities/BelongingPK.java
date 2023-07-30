package com.reviwgames.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

// esta classe existe para ter a asossiacao das chaves primarias do Game e GameList,
// pois elas nao precisam estar direatamente na classe Belongoing
// a partir desta classe que sera instanciada na classe Belongoing sendo como o ID, utilizando o @EmbeddedId
// tornando ela assim uma chave primaria multipla

// serve para representar que esta classe ira representar 2 campos na tabela como as chaves estrangeiras
/*junto com o @EmbeddedId serve para indicar que uma classe é uma classe incorporada, ou seja, ela
representa uma parte de um objeto maior que é armazenado como um único valor no banco de dados.*/
@Embeddable
public class BelongingPK implements Serializable {
    private static final Long Serializable = 1L;
    @ManyToOne // configuracao para fazer o mapeamento ORM muitos para um
    /*Essa anotação é usada para configurar o nome da coluna de chave estrangeira na tabela
    da classe atual que será usada para fazer o mapeamento com a classe Game*/
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public BelongingPK(){};

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongingPK that)) return false;
        return Objects.equals(game, that.game) && Objects.equals(gameList, that.gameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameList);
    }
}
