/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastros;

import java.util.Random;

/**
 *
 * @author Joao
 */
public class RandomPlayer extends Player{
    
    public RandomPlayer(String nome) {
        this.nome=nome;
    }
    
    @Override
    public void makeMove(Jogo jogo){
        Random rand = new Random();
        int op;
        do{
            do{
                op = rand.nextInt(9);
            }while(op==5);
        }while(!jogo.checkMove(op));
        jogo.movePiece(op);
    }
}
