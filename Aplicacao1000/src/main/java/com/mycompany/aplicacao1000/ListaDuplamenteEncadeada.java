/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacao1000;

/**
 *
 * @author thuts
 */
public class ListaDuplamenteEncadeada {
    private No cabeca;
    private No cauda;

    public void inserirOrdenado(int dado) {
        No novoNo = new No(dado);

        if (cabeca == null) {
            cabeca = cauda = novoNo;
        } else if (dado <= cabeca.dado) {
            novoNo.prox = cabeca;
            cabeca.ant = novoNo;
            cabeca = novoNo;
        } else if (dado >= cauda.dado) {
            cauda.prox = novoNo;
            novoNo.ant = cauda;
            cauda = novoNo;
        } else {
            No atual = cabeca;

            while (atual != null && atual.dado < dado) {
                atual = atual.prox;
            }

            if (atual != null) {
                novoNo.prox = atual;
                novoNo.ant = atual.ant;
                atual.ant.prox = novoNo;
                atual.ant = novoNo;
            }
        }
    }

    public void imprimirCrescente() {
        No atual = cabeca;

        while (atual != null) {
            System.out.print(atual.dado + " " + "\n");
            atual = atual.prox;
        }

        System.out.println();
    }

    public void imprimirDecrescente() {
        No atual = cauda;

        while (atual != null) {
            System.out.print(atual.dado + " "  + "\n");
            atual = atual.ant;
        }

        System.out.println();
    }

    public void removerPrimos() {
        No atual = cabeca;

        while (atual != null) {
            if (ehPrimo(atual.dado)) {
                No anterior = atual.ant;
                No proximo = atual.prox;

                if (anterior != null) {
                    anterior.prox = proximo;
                } else {
                    cabeca = proximo;
                }

                if (proximo != null) {
                    proximo.ant = anterior;
                } else {
                    cauda = anterior;
                }

                atual = proximo;
            } else {
                atual = atual.prox;
            }
        }
    }

    private boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }
}
