/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastros;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Joao
 */
public class AStarPlayer extends Player{
    
    public AStarPlayer(String nome) {
        this.nome=nome;
    }
    
    public void makeMove(Jogo jogo){
        Node initialNode = new Node(jogo.getRow_a(),jogo.getCol_a());
        Node finalNode;
        Node temp;
        Random rand = new Random();
        int op;
        int[] bestMove = new int[2];
        if("First".equals(this.turn)){
            finalNode=new Node(6,0);
        }else{
            finalNode=new Node(0,6);
        }
        AStar aStar = new AStar(7,7,initialNode,finalNode);
        int[][] blocksArray = generateBlockedArray(jogo.getBlocked(), jogo.getnBlocked());
        aStar.setBlocks(blocksArray);
        List<Node> path = aStar.findPath();
        if(!path.isEmpty()){
            temp=path.get(1);
            bestMove[0]=temp.getRow();
            bestMove[1]=temp.getCol();

            //System.out.println("best move "+bestMove[0]+","+bestMove[1]);

            if(jogo.getCol_a() == bestMove[1]){
                if(jogo.getRow_a()-1 == bestMove[0]){
                    jogo.movePiece(8);
                }
                else if(jogo.getRow_a()+1 == bestMove[0]){
                    jogo.movePiece(2);
                }

            }else if(jogo.getCol_a()-1 == bestMove[1]){
                if(jogo.getRow_a() == bestMove[0]){
                    jogo.movePiece(4);
                }else if(jogo.getRow_a()-1 == bestMove[0]){
                    jogo.movePiece(7);
                }
                else if(jogo.getRow_a()+1 == bestMove[0]){
                    jogo.movePiece(1);
                }
            }
            else if(jogo.getCol_a()+1 == bestMove[1]){
                if(jogo.getRow_a() == bestMove[0]){
                    jogo.movePiece(6);
                }else if(jogo.getRow_a()-1 == bestMove[0]){
                    jogo.movePiece(9);
                }
                else if(jogo.getRow_a()+1 == bestMove[0]){
                    jogo.movePiece(3);
                }
            }
        }else{
            do{
                do{
                    op = rand.nextInt(10);
                }while(op==5 || op== 0);
            }while(!jogo.checkMove(op));
            jogo.movePiece(op);
        }
    }
    
    public int[][] generateBlockedArray(int[][] array,int size){
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i][0] = array[i][0];
            result[i][1] = array[i][1];
        }
        
        return result;
    }
    
}
