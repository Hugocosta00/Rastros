package rastros;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Jogo implements Cloneable{
    char[][] board = new char[7][7];
    int row_a=2;
    int col_a=4;
    int nBlocked;
    int[][] blocked;
    Player player1;
    Player player2;
    String winner;
    public Jogo(){
        for(int row = 0; row < this.board.length; ++row) {
            for(int col = 0; col < this.board[0].length; ++col) {
                this.board[row][col] = 'O';
            }
        }
        blocked = new int[47][2];
        nBlocked = 0;
        setInicio();
        setFim();
    }
    public Jogo(Player a,Player b) {
        for(int row = 0; row < this.board.length; ++row) {
            for(int col = 0; col < this.board[0].length; ++col) {
                this.board[row][col] = 'O';
            }
        }
        blocked = new int[47][2];
        nBlocked = 0;
        coinFlip(a, b);
        setInicio();
        setFim();

    }

    private void setFim(){
        this.board[6][0] = 'u';
        this.board[0][6] = 'd';
    }
    private void setInicio(){
        this.board[row_a][col_a]= 'X';
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }


    public void setRow_a(int row_a) {
        this.row_a = row_a;
    }

    public void setCol_a(int col_a) {
        this.col_a = col_a;
    }

    public int getRow_a() {
        return row_a;
    }
    public int getCol_a() {
        return col_a;
    }

    public void setnBlocked(int nBlocked) {
        this.nBlocked = nBlocked;
    }

    public void setBlocked(int[][] blocked) {
        this.blocked = blocked;
    }

    public int getnBlocked() {
        return nBlocked;
    }

    public int[][] getBlocked() {
        return blocked;
    }
    
    public String partida(){
        while(!round()){
        }
        
        return winner;
    }
    
    public boolean round() {
        System.out.println("------ "+player1.getNome()+" ------");
        active_board();
        player1.makeMove(this);
        if(checkWinner(player1)){
            System.out.println("Player "+player1.getNome()+" Won");
            this.winner=player1.getNome();
            return true;
        }
        System.out.println("------ "+player2.getNome()+" ------");
        active_board();
        player2.makeMove(this);
        if(checkWinner(player2)){
            System.out.println("Player "+player2.getNome()+" Won");
            this.winner=player2.getNome();  // alterar ________________________________________________
            return true;
        }
        
        return false;
    }

    public void active_board(){

        for(int row = 0; row < this.board.length; ++row) {

            for(int col = 0; col < this.board[0].length; ++col) {

                    System.out.print("|" +  this.board[row][col]);
            }

            System.out.println("|");
        }
    }

    public boolean checkWinner(Player j){
        if(row_a==6 && col_a==0){
            return true;
        }
        if(row_a==0 && col_a==6){
            return true;
        }
         
        if(getRow_a()+1>=7 && getCol_a()+1>=7){
            if(board[getRow_a()-1][getCol_a()-1]=='F' && 
                board[getRow_a()-1][getCol_a()]=='F' && 
                board[getRow_a()][getCol_a()-1]=='F'){
                return true;
            }
            
        }
        else if(getRow_a()-1<0 && getCol_a()-1<0){
            if(board[getRow_a()+1][getCol_a()+1]=='F' && 
                board[getRow_a()+1][getCol_a()]=='F' && 
                board[getRow_a()][getCol_a()+1]=='F'){
                return true;
            }
            
        }
        else if(getCol_a()+1>=7){
            if(board[getRow_a()-1][getCol_a()-1]=='F' && 
                board[getRow_a()-1][getCol_a()]=='F' && 
                board[getRow_a()][getCol_a()-1]=='F' && 
                board[getRow_a()+1][getCol_a()-1]=='F' && 
                board[getRow_a()+1][getCol_a()]=='F'){
                return true;
            }
        }
        else if(getCol_a()-1<0){
            if(board[getRow_a()-1][getCol_a()]=='F' && 
                board[getRow_a()-1][getCol_a()+1]=='F' && 
                board[getRow_a()][getCol_a()+1]=='F' && 
                board[getRow_a()+1][getCol_a()]=='F' && 
                board[getRow_a()+1][getCol_a()+1]=='F'){
                return true;
            } 
        }
        else if(getRow_a()+1>=7){
            if(board[getRow_a()-1][getCol_a()-1]=='F' && 
                board[getRow_a()-1][getCol_a()]=='F' && 
                board[getRow_a()-1][getCol_a()+1]=='F' && 
                board[getRow_a()][getCol_a()-1]=='F' && 
                board[getRow_a()][getCol_a()+1]=='F'){
                return true;
            } 
        }
        else if(getRow_a()-1<0){
            if(board[getRow_a()][getCol_a()-1]=='F' && 
                board[getRow_a()][getCol_a()+1]=='F' && 
                board[getRow_a()+1][getCol_a()-1]=='F' && 
                board[getRow_a()+1][getCol_a()]=='F' && 
                board[getRow_a()+1][getCol_a()+1]=='F'){
                return true;
            } 
        }
        else if(board[getRow_a()-1][getCol_a()-1]=='F' && 
                board[getRow_a()-1][getCol_a()]=='F' && 
                board[getRow_a()-1][getCol_a()+1]=='F' && 
                board[getRow_a()][getCol_a()-1]=='F' && 
                board[getRow_a()][getCol_a()+1]=='F' && 
                board[getRow_a()+1][getCol_a()-1]=='F' && 
                board[getRow_a()+1][getCol_a()]=='F' && 
                board[getRow_a()+1][getCol_a()+1]=='F'){
            return true;
        }
        return false;
    }
    
    private void coinFlip(Player a,Player b){
        Random rand = new Random();
        int randNum = rand.nextInt(1000);
        if(randNum<=499){
            this.player1=a;
            this.player1.setTurn("First");
            this.player2=b;
            this.player2.setTurn("Second");
        }else{
            this.player1=b;
            this.player1.setTurn("First");
            this.player2=a;
            this.player2.setTurn("Second");
        }
        System.out.println(this.player1.nome+" joga primeiro!");
    }
    
    public boolean checkMove(int move){
        /* verificar se a jogada é possivel
        |7|8|9|
        |4|x|6|
        |1|2|3|
        */
        
        switch(move){
            case 1:{
                try{
                    if(this.board[getRow_a()+1][getCol_a()-1]!='F')
                        return true;
                    else
                        return false;
                }catch(Exception e){
                    return false;
                }
            }
            case 2:{
                try{
                    if(this.board[getRow_a()+1][getCol_a()]!='F')
                        return true;
                    else
                        return false;
                }catch(Exception e){
                    return false;
                }
                
            }
            case 3:{
                try{
                    if(this.board[getRow_a()+1][getCol_a()+1]!='F')
                        return true;
                    else
                        return false;
                }catch(Exception e){
                    return false;
                }
                
            }
            case 4:{
                try{
                    if(this.board[getRow_a()][getCol_a()-1]!='F')
                        return true;
                    else
                        return false;
                }catch(Exception e){
                    return false;
                }
                
            }
            case 6:{
                try{
                    if(this.board[getRow_a()][getCol_a()+1]!='F')
                        return true;
                    else
                        return false;
                }catch(Exception e){
                    return false;
                }
                
            }
            case 7:{
                try{
                    if(this.board[getRow_a()-1][getCol_a()-1]!='F')
                        return true;
                    else
                        return false;
                }catch(Exception e){
                    return false;
                }
                
            }
            case 8:{
                try{
                    if(this.board[getRow_a()-1][getCol_a()]!='F')
                        return true;
                    else
                        return false;
                    
                }catch(Exception e){
                    return false;
                }
            }
            case 9:{
                try{
                    if(this.board[getRow_a()-1][getCol_a()+1]!='F')
                        return true;
                    else
                        return false;
                }catch(Exception e){
                    return false;
                }
            }
            default:
                return false;
        }
    }

    public void movePiece(int move){
        switch(move){
            case 7:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.col_a=getCol_a()-1;
                this.row_a=getRow_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 8:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.row_a=getRow_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 9:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.col_a=getCol_a()+1;
                this.row_a=getRow_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 6:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.col_a=getCol_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 3:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.col_a=getCol_a()+1;
                this.row_a=getRow_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 2:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.row_a=getRow_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 1:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.col_a=getCol_a()-1;
                this.row_a=getRow_a()+1;
                this.board[row_a][col_a]='X';
                break;
            }
            case 4:{
                this.board[getRow_a()][getCol_a()]='F';
                this.blocked[nBlocked][0]=getRow_a();
                this.blocked[nBlocked][1]=getCol_a();
                this.nBlocked++;
                this.col_a=getCol_a()-1;
                this.board[row_a][col_a]='X';
                break;
            }
        }

    }

    public Jogo getClone() {

        Jogo cloned= new Jogo();

        cloned.setRow_a(this.getRow_a());
        cloned.setCol_a(this.getCol_a());
        cloned.setBlocked(this.getBlocked());
        cloned.setnBlocked(this.nBlocked);
        for (int row = 0; row < 7; row++){
            for (int col = 0; col < 7; col++){
                cloned.board[row][col] = this.board[row][col];
            }
        }
        return cloned;
    }


    public boolean isFinished(){
        if(row_a==6 && col_a==0){
            return true;
        }
        if(row_a==0 && col_a==6){
            return true;
        }
        return false;
    }




}
