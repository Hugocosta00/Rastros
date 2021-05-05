package rastros;

import java.util.Scanner;

public class Rastros {

    public static void main(String[] args) {
        Player a=null;
        Player b = null;
        String winner;
        Scanner scanner = new Scanner(System.in);
        int n,input;
        String nome;
        int[] stats={0,0};
        Jogo jogo;
        do{
            System.out.println("Selecione o Modo:");
            System.out.println("1-Humano vs Humano");
            System.out.println("2-Humano vs Computador");
            System.out.println("3-Computador vs Computador");
            System.out.println("0-Sair");
            input = scanner.nextInt();
            switch(input){
                case 1:{
                    System.out.println("Introduza um nome:");
                    nome=scanner.next();
                    a=new ScannerPlayer(nome);
                    System.out.println("Introduza um nome:");
                    nome=scanner.next();
                    b=new ScannerPlayer(nome);
                    jogo = new Jogo(a,b);
                    winner=jogo.partida();
                    break;
                }
                case 2:{
                    System.out.println("Introduza um nome:");
                    nome=scanner.next();
                    a=new ScannerPlayer(nome);
                    System.out.println("Selecione o algoritmo:\n1-Random\n2-Greedy\n3-AStar\n4-MinMax");
                    n=scanner.nextInt();
                    switch(n){
                        case 1:{
                            b=new RandomPlayer("Computador");
                            break;
                        }
                        case 2:{
                            b=new GreedyPlayer("Computador");
                            break;
                        }
                        case 3:{
                            b=new AStarPlayer("Computador");
                            break;
                        }
                        case 4:{
                            break;
                        }
                    }
               
                    jogo = new Jogo(a,b);
                    winner=jogo.partida();
                    break;
                }
                case 3:{
                    System.out.println("Selecione o algoritmo:\n1-Random\n2-Greedy\n3-AStar\n4-MinMax");
                    n=scanner.nextInt();
                    switch(n){
                        case 1:{
                            a=new RandomPlayer("Computador1");
                            break;
                        }
                        case 2:{
                            a=new GreedyPlayer("Computador1");
                            break;
                        }
                        case 3:{
                            a=new AStarPlayer("Computador1");
                            break;
                        }
                        case 4:{
                            break;
                        }
                    }
                    System.out.println("Selecione o algoritmo:\n1-Random\n2-Greedy\n3-AStar\n4-MinMax");
                    n=scanner.nextInt();
                    switch(n){
                        case 1:{
                            b=new RandomPlayer("Computador2");
                            break;
                        }
                        case 2:{
                            b=new GreedyPlayer("Computador2");
                            break;
                        }
                        case 3:{
                            b=new AStarPlayer("Computador2");
                            break;
                        }
                        case 4:{
                            break;
                        }
                    }
                    
                    System.out.println("Nº de Simulações:");
                    n=scanner.nextInt();
                    for(int i=0;i<n;i++){
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
                    stats[0]=0;
                    stats[1]=0;
                    break;
                }
            }
        }while(input!=0);
       
    }
    
}
