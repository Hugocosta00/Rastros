package rastros;

public class Rastros {

    public static void main(String[] args) {
        Player a=new RandomPlayer("joao");
        Player b=new RandomPlayer("vasco");
        Jogo jogo = new Jogo(a,b);
        //jogo.active_board();
        while(!jogo.round()){
        }






    }
    
}
