/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocine;

/**
 *
 * @author Carlos Pinilla
 */
public class Silla {
    private int numero;
    private TipoSilla tipoSilla;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    private Persona persona;

    public Silla(int numero, TipoSilla tipoSilla,int estado, Persona persona) {
        this.numero = numero;
        this.tipoSilla = tipoSilla;
        this.estado = estado;
        this.persona = persona;
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoSilla getTipoSilla() {
        return tipoSilla;
    }

    public void setTipoSilla(TipoSilla tipoSilla) {
        this.tipoSilla = tipoSilla;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
