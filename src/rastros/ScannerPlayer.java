package rastros;

import java.util.Scanner;

public class ScannerPlayer extends Player{

    public ScannerPlayer(String nome) {
        this.nome=nome;
    }
    
    @Override
    public void makeMove(Jogo jogo){
        int op;
        Scanner ler= new Scanner(System.in);
        System.out.println("|7|8|9|");
        System.out.println("|4|X|6|");
        System.out.println("|1|2|3|");
        do{
            System.out.println("Escolha o movimento que deseja fazer");
            op=ler.nextInt();
        }while(!jogo.checkMove(op));
        jogo.movePiece(op);
        
    }
}
