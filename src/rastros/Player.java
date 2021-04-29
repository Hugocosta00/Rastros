package rastros;

import java.util.Scanner;

public abstract class Player {
    String nome;
    String turn;

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void makeMove(Jogo jogo){
        
    }
}
