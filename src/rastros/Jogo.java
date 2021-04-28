package rastros;

import java.util.Arrays;
import java.util.Scanner;

public class Jogo{
    char[][] board = new char[7][7];
    int size = 7;
    //int[] currSquare = {5,5};   //initial square is 5,5
    int row_a=2;
    int col_a=4;

    public Jogo() {
        for(int row = 0; row < this.board.length; ++row) {
            for(int col = 0; col < this.board[0].length; ++col) {
                this.board[row][col] = 'O';
            }
        }
        setInicio();
        setFim();

    }
    public void setFim(){
        this.board[6][0] = 'u';
        this.board[0][6] = 'd';
    }
    public void setInicio(){
        this.board[row_a][col_a]= 'X';
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


    public int getRow_a() {
        return row_a;
    }
    public int getCol_a() {
        return col_a;
    }
    /*
    public void setCurrSquare(int[] currSquare) {
        this.currSquare = currSquare;
    }*/

    public void active_board(){

        for(int row = 0; row < this.board.length; ++row) {

            for(int col = 0; col < this.board[0].length; ++col) {

                    System.out.print("|" +  this.board[row][col]);
            }

            System.out.println("|");
        }
    }

    public void checkWinner(){
        if(row_a==6 && col_a==0){
            System.out.println("Winner");
        }
        if(row_a==0 && col_a==6){
            System.out.println("Winner");
        }

    }

    public void move(){
        Scanner ler= new Scanner(System.in);
        System.out.println("Escolha o movimento que deseja fazer");
        System.out.println("|7|8|9|");
        System.out.println("|4|X|6|");
        System.out.println("|1|2|3|");
        int op=ler.nextInt();
        switch(op){
            case 7:{
                // transformar em metodos individuais

                this.board[getRow_a()][getCol_a()]='F';
                this.col_a=getCol_a()-1;
                this.row_a=getRow_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 8:{
                this.board[getRow_a()][getCol_a()]='F';
                this.row_a=getRow_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 9:{
                this.board[getRow_a()][getCol_a()]='F';
                this.col_a=getCol_a()+1;
                this.row_a=getRow_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 6:{
                this.board[getRow_a()][getCol_a()]='F';
                this.col_a=getCol_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 3:{
                this.board[getRow_a()][getCol_a()]='F';
                this.col_a=getCol_a()+1;
                this.row_a=getRow_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 2:{
                this.board[getRow_a()][getCol_a()]='F';
                this.row_a=getRow_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 1:{
                this.board[getRow_a()][getCol_a()]='F';
                this.col_a=getCol_a()-1;
                this.row_a=getRow_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 4:{
                this.board[getRow_a()][getCol_a()]='F';
                this.col_a=getCol_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
        }

    }



}
