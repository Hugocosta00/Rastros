package rastros;

public class MinimaxPlayer extends Player{

    private static final int[][] board_max={{4,4,4,4,4,4,-3},{5,5,5,5,5,5,4},{6,6,6,6,0,5,4},{7,7,7,7,6,5,4},{8,8,8,7,6,5,4},{9,9,8,7,6,5,4},{10,9,8,7,6,5,4}};
    private static final int[][] board_max_inverted={{4,5,6,7,8,9,10},{4,5,6,7,8,9,9},{4,5,6,7,0,8,8},{4,5,6,7,7,7,7},{4,5,6,6,6,6,6},{4,5,5,5,5,5,5},{-3,4,4,4,4,4,4}};
    private static final int default_depth=5;

    public MinimaxPlayer(String nome){
        this.nome=nome;
    }

    private int getHeuristic(Jogo jogo){
        if(turn=="First"){
            return board_max[jogo.getRow_a()][jogo.getCol_a()];
        }else{
            return board_max_inverted[jogo.getRow_a()][jogo.getCol_a()];
        }

    }



    public void makeMove(Jogo jogo){
        int jogadaSelecionada=0;
        int valorJogadaSelecionada=Integer.MIN_VALUE;

        for(int jogada=1; jogada<=9; jogada++){
            if(jogada==5){
                continue;
            }
            Jogo clone= jogo.getClone();
            if(clone.checkMove(jogada)){
                clone.movePiece(jogada);
                int valor=minimax(clone, default_depth, false);

                if(valor>valorJogadaSelecionada){
                    valorJogadaSelecionada=valor;
                    jogadaSelecionada=jogada;
                }
            }


        }
        jogo.movePiece(jogadaSelecionada);



    }
    public int minimax(Jogo jogo, int depth, boolean playerMax){


        if(jogo.isFinished()) {
            if(turn=="First"){
                if(jogo.getRow_a()==6 && jogo.getCol_a()==0){
                    return 10;
                }
            }else{
                return -3;
            }
        }

        if(depth==0){
            return getHeuristic(jogo);
        }

        if(playerMax){
            int valorM=Integer.MIN_VALUE;
            for(int jogada=1; jogada<=9; jogada++){
                if(jogada==5){
                    continue;
                }
                if(jogo.checkMove(jogada)){
                    Jogo clone= jogo.getClone();
                    clone.movePiece(jogada);
                    valorM=Math.max(valorM, minimax(clone, depth-1, false));
                }

            }
            return valorM;
        }else{
            int valorM=Integer.MAX_VALUE;
            for(int jogada=1; jogada<=9; jogada++){
                if(jogada==5){
                    continue;
                }
                if(jogo.checkMove(jogada)){
                    Jogo clone= jogo.getClone();
                    clone.movePiece(jogada);
                    valorM=Math.min(valorM, minimax(clone, depth-1, true));

                }

            }
            return valorM;

        }




    }

}
