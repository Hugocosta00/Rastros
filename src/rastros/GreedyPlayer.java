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
public class GreedyPlayer extends Player{

    public GreedyPlayer(String nome) {
        this.nome=nome;
    }
    
    @Override
    public void makeMove(Jogo jogo){
        Random rand = new Random();
        int op;
        
        if(this.turn=="First"){
            if(jogo.checkMove(1)){
                jogo.movePiece(1);
            }else if(jogo.checkMove(4)){
                jogo.movePiece(4);
            }else if(jogo.checkMove(2)){
                jogo.movePiece(2);
            }else{
                do{
                    do{
                        op = rand.nextInt(10);
                    }while(op==5 || op== 0 || op== 1 || op== 4 || op== 2);
                }while(!jogo.checkMove(op));
            }
        }else{
            if(jogo.checkMove(9)){
                jogo.movePiece(9);
            }else if(jogo.checkMove(6)){
                jogo.movePiece(6);
            }else if(jogo.checkMove(8)){
                jogo.movePiece(8);
            }else{
                do{
                    do{
                        op = rand.nextInt(10);
                    }while(op==5 || op== 0 || op== 9 || op== 6 || op== 8);
                }while(!jogo.checkMove(op));
            }
        }
    }
}
