package Xadrez;

import Jogo.Peca;
import Jogo.Posicao;
import Jogo.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    protected boolean existePecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }


}
