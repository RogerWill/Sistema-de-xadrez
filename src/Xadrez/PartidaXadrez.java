package Xadrez;

import Jogo.Peca;
import Jogo.Posicao;
import Jogo.Tabuleiro;
import Pecas.Xadrez.Rei;
import Pecas.Xadrez.Torre;

public class PartidaXadrez{

    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        posicaoIninicial();
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for(int i=0; i< tabuleiro.getLinhas(); i++){
            for(int j=0; j< tabuleiro.getColunas(); j++){
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
            }
        }
        return mat;
    }

    public PecaXadrez movimentoXadrez(PosicaoXadrez posicaoInicial, PosicaoXadrez posicaoAlvo){
        Posicao inicial = posicaoInicial.paraPosicao();
        Posicao alvo = posicaoAlvo.paraPosicao();
        validarPosicaoInicial(inicial);
        Peca pecaCapturada = movimento(inicial, alvo);
        return (PecaXadrez) pecaCapturada;
    }
    private Peca movimento(Posicao inicial, Posicao alvo){
        Peca p = tabuleiro.removerPeca(inicial);
        Peca pecaCapturada = tabuleiro.removerPeca(alvo);
        tabuleiro.colocarPeca(p, alvo);
        return pecaCapturada;
    }

    private void validarPosicaoInicial(Posicao posicao){
        if(!tabuleiro.posicaoExiste(posicao)){
            throw new ChessException("não existe peca na posição de origem");
        }
        if(tabuleiro.peca(posicao).existeAlgumMovimento()){
            throw new ChessException("não existe movimentos possiveis para a peca escolhida");
        }
    }
    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
    }
    private void posicaoIninicial(){
        colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
    }
}
