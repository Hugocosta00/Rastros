package rastros;

public class Rastros {

    public static void main(String[] args) {

        Jogo jogo = new Jogo();
        jogo.active_board();
        while(true){
            jogo.move();
            jogo.active_board();
            jogo.checkWinner();

        }






    }
    
}
