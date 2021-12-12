/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class Vecinos {
    
    private String nombre;
    private String edificio;
    private int cedula;
    private String apartamento;
    private long telefono;
    
    private Vecinos siguiente;
    
    private Apartamentos en_donde_estoy;
    
    public Vecinos(String nombre,String edificio,int cedula,String apartamento,long telefono){
    
        this.nombre=nombre;
        this.edificio=edificio;
        this.cedula=cedula;
        this.apartamento=apartamento;
        this.telefono=telefono;
        siguiente = null;
        en_donde_estoy =null;
    }
    
    //-----getters y setters-----
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Vecinos getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Vecinos siguiente) {
        this.siguiente = siguiente;
    }

    public Apartamentos getEn_donde_estoy() {
        return en_donde_estoy;
    }

    public void setEn_donde_estoy(Apartamentos en_donde_estoy) {
        this.en_donde_estoy = en_donde_estoy;
    }
    
    //-----mis metodos-----
    public String Imprimir(){
    
        return ("Nombre: "+nombre+"\nCedula: "+cedula+"\nTelefono: "+telefono+"\nVive en el edificio "+edificio+", apartamento "+apartamento);
    }
}
