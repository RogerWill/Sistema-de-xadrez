package Aplicacao;

import Jogo.Tabuleiro;
import Xadrez.PartidaXadrez;

public class Main {
    public static void main(String[] args) {

        PartidaXadrez partidaXadrez = new PartidaXadrez();
        UI.printTabuleiro(partidaXadrez.getPecas());

    }
}