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
public class Jogo {
    char[][] board = new char[7][7];
    int size = 7; 
    int[] currSquare = {5,5};   //initial square is 5,5
    
    public Jogo() {
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getCurrSquare() {
        return currSquare;
    }

    public void setCurrSquare(int[] currSquare) {
        this.currSquare = currSquare;
    }
    
    
    
    
    
    
    
}
