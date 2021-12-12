
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class Asociacion_Vecinos {
    
    private Edificio primero_edificio;
    private Edificio ultimo_edificio;
    private int tamano_edificio;
    
    private Vecinos primero_vecino;
    private Vecinos ultimo_vecino;
    private int tamano_vecino;
    
    public Asociacion_Vecinos(){
    
        primero_edificio = ultimo_edificio =null;
        ultimo_vecino=primero_vecino=null;
        tamano_vecino = tamano_edificio =0;
    }
    
    //-----getters y setters-----
    public Edificio getPrimero_edificio() {
        return primero_edificio;
    }

    public Edificio getUltimo_edificio() {
        return ultimo_edificio;
    }

    public int getTamano_edificio() {
        return tamano_edificio;
    }

    public Vecinos getPrimero_vecino() {
        return primero_vecino;
    }

    public Vecinos getUltimo_vecino() {
        return ultimo_vecino;
    }

    public int getTamano_vecino() {
        return tamano_vecino;
    }
    
    //-----mis metodos-----
    public boolean EstaVaciaEdificio(){
    
        return (getPrimero_edificio() ==null);
    }
    
    public boolean EstaVaciaVecino(){
    
        return (getPrimero_vecino() ==null);
    }
    
    public void Insertar_Edificio(String nombre){
    
        Edificio aux = new Edificio(nombre);
    
        if(EstaVaciaEdificio()){
        
            primero_edificio = ultimo_edificio =aux;
        }
        else{
        
            ultimo_edificio.setSiguiente(aux);
            ultimo_edificio = aux;
        }
        
        tamano_edificio++;
    }
    
    public void Insertar_Vecino_AV(String nombre,String edificio,int cedula,String apartamento,long telefono, Apartamentos apa){
    
        Vecinos aux = new Vecinos( nombre, edificio, cedula, apartamento, telefono);
    
        if(EstaVaciaEdificio()){
        
            primero_vecino = ultimo_vecino =aux;
        }
        else{
        
            ultimo_vecino.setSiguiente(aux);
            ultimo_vecino = aux;
        }
        
        tamano_vecino++;
        
        aux.setEn_donde_estoy(apa);
    }
    
    public void Ordenar_Vecinos(Asociacion_Vecinos lista){
    
        if(!EstaVaciaVecino()){
        
            if(primero_vecino == ultimo_vecino){
            
            }
            else{
                Vecinos aux = primero_vecino;
                Vecinos mayor = primero_vecino;
                
                for (int i = 0; i < tamano_vecino; i++) {
                    
                    if(aux.getCedula() > mayor.getCedula()){
                        
                        mayor = aux;
                    }
                    
                    aux = aux.getSiguiente();
                }
                
                lista.Eliminar(getIndex(mayor));
                Ordenar_Vecinos(lista);
                lista.Insertar_Vecino_AV(mayor.getNombre(),mayor.getEdificio(),mayor.getCedula(),mayor.getApartamento(),mayor.getTelefono(),mayor.getEn_donde_estoy());
            }
        }
    }
    
    public void Eliminar(int pos){
    
        if(!EstaVaciaVecino()){
        
            if(pos>-1 && pos<tamano_vecino){
            
                if(pos ==0){
                
                    EliminarPrimero();
                }
                
                else if(pos ==(tamano_vecino-1)){
                
                    EliminarUltimo();
                }
                
                else{
                    
                    Vecinos aux = primero_vecino;
                    Vecinos ant = primero_vecino;
                    
                    for (int i = 0; i < pos; i++) {
                        
                        ant = aux;
                        aux=aux.getSiguiente();
                    }
                    
                    ant.setSiguiente(aux.getSiguiente());
                    tamano_vecino--;
                }
            }
            
            else{
            
                JOptionPane.showMessageDialog(null, "La lista aun no tiene esta posicion: "+pos);
            }
        }
    }
    
    public int getIndex(Vecinos nodo){
    
        if(!EstaVaciaVecino()){
        
            int contador =0;
            Vecinos aux = primero_vecino;
            
            while(aux != nodo){
                
                contador++;
                aux =aux.getSiguiente();
            }
            
            return contador;
        }
        else{
        
            return -1;
        }
    }
    
    public void EliminarUltimo(){
    
        if(!EstaVaciaVecino()){
        
            if(primero_vecino ==ultimo_vecino){
            
                primero_vecino = ultimo_vecino = null;
            }
            
            else{
            
                ultimo_vecino = Anterior(ultimo_vecino);
                ultimo_vecino.setSiguiente(null);
            }
            
            tamano_vecino--;
        }
    }
    
    public void EliminarPrimero(){
    
        if(!EstaVaciaVecino()){
        
            if(primero_vecino ==ultimo_vecino){
            
                primero_vecino = ultimo_vecino = null;
            }
            
            else{
            
                primero_vecino = primero_vecino.getSiguiente();
            }
            
            tamano_vecino--;
        }
    }
    
    public Vecinos Anterior(Vecinos nodo){
        
        if(!EstaVaciaVecino()){
    
            if(nodo != primero_vecino){
                Vecinos ant = primero_vecino;
                Vecinos aux = primero_vecino;

                while(aux !=nodo){

                    ant = aux;
                    aux = aux.getSiguiente();
                }

                return (ant);
            }
            else{

                return null;
            }
        }
        
        return null;
    }
    
    public Apartamentos [] Busqueda_Apartamento(String apartamento){
        
        if(!EstaVaciaEdificio()){
            
            Edificio aux = primero_edificio;
            Apartamentos aux2 =aux.getPrimero();
            
            int contador =0;
            
            Apartamentos [] lista = new Apartamentos [tamano_edificio];
            
            while(aux !=null){
                
                aux2 = aux.getPrimero();
            
                while(aux2 !=null){
                
                    if(aux2.getNumero().equalsIgnoreCase(apartamento)){
                    
                        lista[contador] = aux2;
                        contador++;
                        break;
                    }
                    
                    aux2 = aux2.getSiguiente();
                }
                
                aux = aux.getSiguiente();
            }
            
            return lista;
        }
        
        return null;
    }
    
    //------metodos que me piden-----
    
    public void VaciarTodo(){
    
        primero_edificio = ultimo_edificio =null;
        primero_vecino = ultimo_vecino = null;
        tamano_vecino = tamano_edificio=0;
    
    }
    
    public Vecinos Buscar_Vecino(int cedula){
    
        if(!EstaVaciaVecino()){
        
            Vecinos aux = primero_vecino;
            
            while(aux != null){
            
                if(aux.getCedula() == cedula){
                
                    return aux;
                }
                
                aux = aux.getSiguiente();
            }
        }
        
        return null;
    }
    
    public Apartamentos Buscar_Apartamento(Vecinos nodo){
    
        if(!EstaVaciaVecino()){
        
            return nodo.getEn_donde_estoy();
        }
        
        return null;
    }
    
    public Edificio Buscar_Edificio_Apartamento(Apartamentos nodo){
    
        if(!EstaVaciaEdificio()){
        
            return nodo.getEn_donde_estoy();
        }
        
        return null;
    }
    
    public void Direccion_Vecino(long cedula2){
        
        try{
            
            int cedula =(int) cedula2;
    
            if(!EstaVaciaVecino()){

                Vecinos aux = primero_vecino;

                while(aux !=null){

                    if(aux.getCedula() == cedula){

                        JOptionPane.showMessageDialog(null, "la direccion del vecion es: "+aux);
                        return;
                    }

                    aux = aux.getSiguiente();
                }
            }

            JOptionPane.showMessageDialog(null, "La cedula no pertenece a ningun vecino");
            
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null, "La cedula no pertenece a ningun vecino");
        }
    }
    
    public void CargarDatos(){
        
        String linea;
        String lector="";
        String path = "test\\datos.txt";
        String [] arreglo;
    
        File file = new File(path);
        
        try{
        
            if(!file.exists()){
            
                file.createNewFile();
            }
            
            else{
            
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                
                while((linea = br.readLine())!= null){
                
                    if(!linea.isEmpty()){
                    
                        lector += linea+"\n";
                    }
                }
                
                arreglo = lector.split("\n");
                String apartamento ="";
                String Nombre ="";
                
                for (int i = 0; i < arreglo.length; i++) {
                    
                    if(arreglo[i].toLowerCase().equals("edif,,")){
                    
                        Insertar_Edificio(arreglo[i+1].replaceAll(",,", ""));
                        i++;
                        Nombre = arreglo[i].replaceAll(",,", "");
                        continue;
                    }
                    
                    if(arreglo[i].equals("apto,,")){
                    
                        ultimo_edificio.Insertar_Apartamento(arreglo[i+1].replaceAll(",,", ""));
                        i++;
                        apartamento = arreglo[i].replaceAll(",,", "");
                        continue;
                    }
                    
                    else{
                        
                         if(!arreglo[i].equals(",,")){
                             
                            String lineatemp = arreglo[i];

                            String [] arreglo_Vecinos = lineatemp.split(",");

                            ultimo_edificio.getUltimo().Insertar_Vecino(arreglo_Vecinos[1], Nombre, Integer.parseInt(arreglo_Vecinos[0]), apartamento, Long.parseLong(arreglo_Vecinos[2]));
                        
                            if(primero_vecino ==null){
                            
                                primero_vecino =ultimo_vecino = ultimo_edificio.getUltimo().Insertar_Vecino_Nodo(arreglo_Vecinos[1], Nombre, Integer.parseInt(arreglo_Vecinos[0]), apartamento, Long.parseLong(arreglo_Vecinos[2]));
                            }
                            else{
                            
                                ultimo_vecino.setSiguiente(ultimo_edificio.getUltimo().Insertar_Vecino_Nodo(arreglo_Vecinos[1], Nombre, Integer.parseInt(arreglo_Vecinos[0]), apartamento, Long.parseLong(arreglo_Vecinos[2])));
                                ultimo_vecino = ultimo_vecino.getSiguiente();
                            }
                            
                            tamano_vecino ++;
                        }
                    }
                }
            }
            
        }catch(IOException error){
             JOptionPane.showMessageDialog(null, "Hubo un error: "+error.getMessage());
        }
    }
}

