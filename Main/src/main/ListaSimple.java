/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import main.NodoSimple;

/**
 *
 * @author gianf
 */
public class ListaSimple<T> {

    private NodoSimple<T> pFirst;
    private NodoSimple<T> pLast;
    private int size;

    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public boolean Esvacia() {
        return this.pFirst == null;
    }

    public void AgregarInicio(T data) {
        NodoSimple<T> nodo = new NodoSimple<T>(data);
        if (Esvacia()) {
            this.pFirst = nodo;

        } else {
            nodo.setpNext(pFirst);
            this.pFirst = nodo;
        }
        this.size++;
    }

    public void AgregarFinal(T data) {
        NodoSimple<T> nodo = new NodoSimple<T>(data);
        if (Esvacia()) {
            this.pFirst = nodo;
            this.pLast = nodo;
        } else {
            this.pLast.setpNext(nodo);
           this. pLast = nodo;
        }
        this.size++;
    }

    public void Imprimir() {
        NodoSimple pAux = pFirst;
        while (pAux != null) {
            System.out.println(pAux.getData());
            pAux = pAux.getpNext();
        }
    }

    public NodoSimple<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodoSimple<T> pFirst) {
        this.pFirst = pFirst;
    }

    public NodoSimple<T> getpLast() {
        return pLast;
    }

    public void setpLast(NodoSimple<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
