package rastros;

public class Rastros {

    public static void main(String[] args) {
        Player a=new AStarPlayer("AStar");
        Player b=new GreedyPlayer("Greedy");
        String winner;
        int[] stats={0,0};
        Jogo jogo; 
        
        for(int i=0;i<1000;i++){
            jogo = new Jogo(a,b);
            winner=jogo.partida();
            if (winner.equals(a.getNome())) {
                stats[0]++;
            }else if(winner.equals(b.getNome())){
                stats[1]++;
            }
        }
        
        System.out.println(a.getNome()+" : "+stats[0]+" vitorias");
        System.out.println(b.getNome()+" : "+stats[1]+" vitorias");
       
    }
    
}
