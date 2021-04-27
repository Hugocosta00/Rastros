package rastros;

public class Rastros {

    public static void main(String[] args) {
        Player a=new ScannerPlayer("Coisa1");
        Player b=new ScannerPlayer("Coisa2");
        Jogo jogo = new Jogo(a,b);
        jogo.active_board();
        while(!jogo.round()){
        }






    }
    
}
