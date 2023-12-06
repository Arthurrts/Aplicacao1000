/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aplicacao1000;

/**
 *
 * @author thuts
 */
public class Aplicacao1000 {
    public static void main(String[] args) {
        int[] vetor = new int[1000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 19999) - 9999;
        }

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        for (int i = 0; i < vetor.length; i++) {
            lista.inserirOrdenado(vetor[i]);
        }

        System.out.println("Lista em ordem crescente:");
        lista.imprimirCrescente();

        System.out.println("\nLista em ordem decrescente:");
        lista.imprimirDecrescente();

        lista.removerPrimos();

        System.out.println("\nLista após remover números primos em ordem crescente:");
        lista.imprimirCrescente();

        System.out.println("\nLista após remover números primos em ordem decrescente:");
        lista.imprimirDecrescente();
    }
}
