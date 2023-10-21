/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author gianf
 */
public class NodoSimple<T>{
    private NodoSimple<T> pNext;
    private T data;

    public NodoSimple(T data) {
        this.pNext = null;
        this.data = data;
    }

    public NodoSimple<T> getpNext() {
        return pNext;
    }

    public void setpNext(NodoSimple<T> pNext) {
        this.pNext = pNext;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
    
}
