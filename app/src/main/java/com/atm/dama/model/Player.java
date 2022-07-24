package com.atm.dama.model;

public class Player {

    public static String getNomePlayer1() {
        return nomePlayer1;
    }

    public static void setNomePlayer1(String nome) {
        nomePlayer1 = nome;
    }

    public static String getNomePlayer2() {
        return nomePlayer2;
    }

    public  static void setNomePlayer2(String nome) {
        nomePlayer2 = nome;
    }

    private static String nomePlayer1="JOGADOR";
    private static String nomePlayer2="JOGADOR";
}
