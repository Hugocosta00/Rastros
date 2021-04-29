package rastros;

public class Rastros {

    public static void main(String[] args) {
        Player a=new RandomPlayer("Random");
        Player b=new AStarPlayer("AStar");
        String winner;
        int[] stats={0,0};
        Jogo jogo; 
        
        for(int i=0;i<10000;i++){
            jogo = new Jogo(a,b);
            winner=jogo.partida();
            if (winner==a.getNome()) {
                stats[0]++;
            }else{
                stats[1]++;
            }
        }
        
        System.out.println(a.getNome()+" : "+stats[0]+" vitorias");
        System.out.println(b.getNome()+" : "+stats[1]+" vitorias");
       
    }
    
}
