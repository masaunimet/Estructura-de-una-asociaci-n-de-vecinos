/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Tony
 */
public class Edificio {
    
    private String nombre_edificio;
    
    private Apartamentos primero;
    private Apartamentos ultimo;
    private int tamano;
    
    private Edificio siguiente;
    
    public Edificio(String nombre){
    
        primero = ultimo = null;
        tamano =0;
        this.nombre_edificio=nombre;
        siguiente =null;
    }

    //-----getters y setters-----
    public String getnombre() {
        return nombre_edificio;
    }

    public void setnombre(String nombre) {
        this.nombre_edificio = nombre;
    }

    public Apartamentos getPrimero() {
        return primero;
    }

    public void setPrimero(Apartamentos primero) {
        this.primero = primero;
    }

    public Apartamentos getUltimo() {
        return ultimo;
    }

    public void setUltimo(Apartamentos ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
     public Edificio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Edificio siguiente) {
        this.siguiente = siguiente;
    }
    
    //-----mis metodos-----
    public boolean EstaVacia(){
    
        return (getPrimero() ==null);
    }
    
    public void Insertar_Apartamento(String numero){
    
        Apartamentos aux = new Apartamentos(numero);
    
        if(EstaVacia()){
        
            primero = ultimo =aux;
        }
        else{
        
            ultimo.setSiguiente(aux);
            ultimo = aux;
        }
        
        tamano++;
        
        aux.setEn_donde_estoy(this);
    }
    
    public String Imprimir(){
    
        return ("El edificio se llama: "+nombre_edificio+"\nTiene un total de "+tamano+" apartamento(s)");
    }
    
    
}

