package rastros;

public class Rastros {

    public static void main(String[] args) {
        Player a=new ScannerPlayer("joao");
        Player b=new ScannerPlayer("vasco");
        Jogo jogo = new Jogo(a,b);
        //jogo.active_board();
        while(!jogo.round()){
        }






    }
    
}
