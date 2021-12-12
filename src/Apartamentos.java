/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class Apartamentos {
    
    private Vecinos primero;
    private Vecinos ultimo;
    private int tamano;
    private String numero;
    
    private Apartamentos siguiente;
    
    private Edificio en_donde_estoy;
    
    public Apartamentos(String numero){
    
        primero = ultimo = null;
        tamano =0;
        this.numero=numero;
        siguiente = null;
        en_donde_estoy = null;
    }

    //-----getters y setters-----
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Vecinos getPrimero() {
        return primero;
    }

    public void setPrimero(Vecinos primero) {
        this.primero = primero;
    }

    public Vecinos getUltimo() {
        return ultimo;
    }

    public void setUltimo(Vecinos ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    public Apartamentos getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Apartamentos siguiente) {
        this.siguiente = siguiente;
    }
    
    public Edificio getEn_donde_estoy() {
        return en_donde_estoy;
    }

    public void setEn_donde_estoy(Edificio en_donde_estoy) {
        this.en_donde_estoy = en_donde_estoy;
    }
    
    //-----mis metodos-----
    public boolean EstaVacia(){
    
        return (getPrimero() ==null);
    }
    
    public void Insertar_Vecino(String nombre,String edificio,int cedula,String apartamento,long telefono){
    
        Vecinos aux = new Vecinos(nombre, edificio, cedula, apartamento, telefono);
    
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
    
    public Vecinos Insertar_Vecino_Nodo(String nombre,String edificio,int cedula,String apartamento,long telefono){
        
        Vecinos aux = new Vecinos(nombre, edificio, cedula, apartamento, telefono);
        
        aux.setEn_donde_estoy(this);
    
        return aux ;
    }
    
    public String Imprimir(){
    
        return ("El apartamento es el numero: "+numero+"\nTiene un total de "+tamano+" vecino(s)");
    }
}
