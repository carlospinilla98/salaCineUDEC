/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocine;

import java.util.Scanner;

/**
 *
 * @author Carlos Pinilla
 */
public class SalaCine {
    private int filas;
    private int columnas;
    private int general;
    private int preferencial;
    private int vip;
    private Silla [][] silla; 
    private int totalVentas;
    private int contadorHombres;
    private int contadorMujer;
    private int contadorNiños;
    private int contadorAdultos;
    private byte aux;
    Scanner teclado =new Scanner(System.in); 
    public SalaCine() {
        
        pedirDimencion();
        pedirClases();
        
        silla = new Silla[filas][columnas];
        imprimirSilla();
        
        do{
        
        sillasVacias();
        llenarSilla();
        tarifa();
            System.out.println("1.INGRESAR OTRO CLIENTE.");
            System.out.println("2.SABER ESTADISTICAS DE VENTAS.");
            aux=teclado.nextByte();
            if(aux==1){ 
                aux=1;
            }else{
                aux=0;
            }
            
        }while(aux==1);
        imprimirEstadisticas();
    }
    
    
    
    private void pedirDimencion(){
        System.out.print("FILAS : ");
        filas = teclado.nextInt();
        System.out.print("COLUMNAS : ");
        columnas = teclado.nextInt();        
    } 
    
    private void pedirClases() {   
        
        while(true) {
            System.out.print("CANTIDAD DE FILAS GENERALES : ");
            general = teclado.nextInt();   
            if(general <= filas) 
                break;
        }
        if(general != filas) {
            while(true) {
                System.out.print("CANTIDAD DE FILAS PREFERENCIALES : ");
                preferencial = teclado.nextInt();   
                if((general + preferencial) <= filas) 
                    break;
            }
            vip = filas - (general + preferencial);           
        }
    }
    
    private void imprimirSilla(){
        int contador = 1;
        for(int i=0 ; i< filas ; i++) {
            for(int j=0 ; j< columnas ; j++){
                Silla silla;
                if((i+1) <= general) {
                    silla = new Silla(contador++, TipoSilla.GENERAL,0, null);
                } else if ((i+1) <= (general + preferencial)) {
                    silla = new Silla(contador++, TipoSilla.PREFERENCIAL,0, null);
                } else {
                   silla = new Silla(contador++, TipoSilla.EJECUTIVA,0, null);
                }
                this.silla[i][j] = silla;
            }
        }
        
        for(int i=0 ; i< filas ; i++) {
            for(int j=0 ; j< columnas ; j++){
                    if(this.silla[i][j].getTipoSilla() == TipoSilla.GENERAL) {
                        System.out.print(this.silla[i][j].getNumero() + "-X ");
                    } else if(this.silla[i][j].getTipoSilla() == TipoSilla.PREFERENCIAL) {
                        System.out.print(this.silla[i][j].getNumero() + "-O ");
                    } else {
                        System.out.print(this.silla[i][j].getNumero() + "-V ");
                    }
            }
            System.out.println("");
        }                       
        
    }
    byte deseo;
    private void sillasVacias(){
        OUTER:
        while (true) {
            System.out.println("INGRESE TIPO DE SILLA QUE DESEA");
            if(general!=0){
                System.out.println("1.GENERAL.");
            }
            if(preferencial!=0){
                System.out.println("2.PREFERENCIAL.");
            }
            if(vip!=0){
                System.out.println("3.VIP.");
            }
            deseo= teclado.nextByte();
            switch (deseo) {
                
                case 1:
                    if(general!=0){
                        System.out.println("SILLAS DISPONIBLES:");
                    for(int i=0 ; i< filas ; i++) {
                        for(int j=0 ; j< columnas ; j++){
                            if((this.silla[i][j].getTipoSilla() == TipoSilla.GENERAL)&&(this.silla[i][j].getEstado()==0)) {
                                System.out.print("("+this.silla[i][j].getNumero() + "-G)");
                            }
                        }
                        System.out.println("");
                        
                    }       break OUTER;
                    }
            
                case 2:
                    if(preferencial!=0){
                        System.out.println("SILLAS DISPONIBLES:");
                    for(int i=0 ; i< filas ; i++) {
                        for(int j=0 ; j< columnas ; j++){
                            if((this.silla[i][j].getTipoSilla() == TipoSilla.PREFERENCIAL)&&(this.silla[i][j].getEstado()==0)) {
                                System.out.print(" (" +this.silla[i][j].getNumero() + "-P)  ");
                            }
                        }
                        System.out.println("");
                        
                    }   break OUTER;
                    }
                case 3:
                    if(vip!=0){
                        System.out.println("SILLAS DISPONIBLES:");
                    for(int i=0 ; i< filas ; i++) {
                        for(int j=0 ; j< columnas ; j++){
                            if((this.silla[i][j].getTipoSilla() == TipoSilla.EJECUTIVA)&&(this.silla[i][j].getEstado()==0)) {
                                System.out.print(" ("+this.silla[i][j].getNumero() + "+V)  ");
                            }
                        }
                        System.out.println("");
                        
                    }   break OUTER;
                    }
                default:
                    System.out.println("TIPO SILLA INCORRECTO");
                    break;
            }
        }
    }
    int numero; 
    int  edad;
    String identificacion;
    String nombre;
    String apellido;
    byte genero;
    Persona persona;    
    private void llenarSilla(){
        int aux=0;
        
        switch(deseo){
            case 1:
                do{
                    System.out.print("NUMERO DE SILLA : ");
                    numero = teclado.nextInt();
                    if(numero<=general*columnas){
                        for(int i=0 ; i< filas ; i++) {
                            for(int j=0 ; j< columnas ; j++){
                                 if((this.silla[i][j].getNumero()==numero)&&(this.silla[i][j].getEstado()==0)) {
                                    aux=1;
                                }
                            }
                        }  
                        
                    }
                
                }while(aux!=1);
            break;
            case 2:
                do{
                    System.out.print("NUMERO DE SILLA : ");
                    numero = teclado.nextInt();
                    if((general*columnas<numero)&&(numero<= preferencial*columnas+general*columnas)){
                        for(int i=0 ; i< filas ; i++) {
                            for(int j=0 ; j< columnas ; j++){
                                 if((this.silla[i][j].getNumero()==numero)&&(this.silla[i][j].getEstado()==0)) {
                                    aux=1;
                                }
                            }
                        }  
                        
                    }
                
                }while(aux!=1);
            break;
            case 3:
                do{
                    System.out.print("NUMERO DE SILLA : ");
                    numero = teclado.nextInt();
                    if((preferencial*columnas+general*columnas<numero)&&(numero<=vip*columnas+preferencial*columnas+general*columnas)){
                        for(int i=0 ; i< filas ; i++) {
                            for(int j=0 ; j< columnas ; j++){
                                 if((this.silla[i][j].getNumero()==numero)&&(this.silla[i][j].getEstado()==0)) {
                                    aux=1;
                                }
                            }
                        }  
                        
                    }
                
                }while(aux!=1);
                
                     
                        
            
            break;
        }
        
        System.out.print("IDENTIFICACION : ");
        identificacion = teclado.next();
        System.out.print("NOMBRE : ");
        nombre = teclado.next();
        System.out.print("APELLIDO : ");
        apellido = teclado.next();
        System.out.println("EDAD : ");
        edad= teclado.nextInt();
        while(true){
            System.out.print("**GENERO**");
            System.out.print("1.MASCULINO");
            System.out.print("2.FEMENINO");
            genero = teclado.nextByte();
            
            
            if(genero==1){
                persona = new Persona(identificacion,nombre,apellido,edad,Genero.MASCULINO);
                contadorHombres++;
                break;
            }else if(genero==2){
                persona = new Persona(identificacion,nombre,apellido,edad,Genero.FEMENINO);
                contadorMujer++;
                break;
            }else{
                System.out.println("GENERO NO ADMITIDO");
            }
        }
        for(int i=0 ; i< filas ; i++) {
            for(int j=0 ; j< columnas ; j++){
                if(this.silla[i][j].getNumero()==numero) {
                    this.silla[i][j].setEstado(1);
                    this.silla[i][j].setPersona(persona);
                }
            }
        }        
    }
    
    private void tarifa(){
        
        for(int i=0 ; i< filas ; i++) {
            for(int j=0 ; j< columnas ; j++){
                if(this.silla[i][j].getNumero()== numero) {
                    int taquilla;
                    int precioEdad=0;
                    int precioTipoSilla=0;
                    if((edad>= 5) && (edad <= 17)){
                        precioEdad=1000;
                        contadorNiños++;
                    }else if ((edad >=18) && (edad <= 80)){
                        precioEdad=2000;
                        contadorAdultos++;
                    }
                    switch (deseo) {
                        case 1:
                            precioTipoSilla = 1000;
                            break;
                        case 2:
                            precioTipoSilla = 2000;
                            break;
                        case 3:
                            precioTipoSilla = 3000;
                            break;
                        default:
                            break;
                    }
                    taquilla = precioEdad + precioTipoSilla;
                    totalVentas+=taquilla;
                    System.out.println("TIQUETE");
                    System.out.println("NOMBRE: "+nombre+"");
                    System.out.println("APELLIDO: "+apellido+"");
                    System.out.println("IDENTIFICACION: "+identificacion+"");
                    
                    
                    System.out.println("PRECIO TAQUILLA : "+taquilla);
                }
            }
        }
    }
    
    private void imprimirEstadisticas(){
        System.out.println("TOTAL VENTAS: "+totalVentas);
        System.out.println("TOTAL HOMBRES: "+ contadorHombres);
        System.out.println("TOTAL MUJERES: "+ contadorMujer);
        System.out.println("TOTAL NIÑOS: "+ contadorNiños);
        System.out.println("TOTAL ADULTOS: "+ contadorAdultos);

    
    
    }
    
    
    
}








