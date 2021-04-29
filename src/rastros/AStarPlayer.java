/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastros;

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
        if(this.turn=="First"){
            finalNode=new Node(6,0);
        }else{
            finalNode=new Node(0,6);
        }
        AStar aStar = new AStar(7,7,initialNode,finalNode);
        int[][] blocksArray;
    }
    
}
