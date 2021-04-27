package rastros;

import java.util.Scanner;

public abstract class Player {
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void makeMove(Jogo jogo){
        
    }
}
