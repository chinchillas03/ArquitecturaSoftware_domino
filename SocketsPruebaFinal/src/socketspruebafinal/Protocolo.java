/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketspruebafinal;

import java.util.List;
import org.itson.observador.protocoloObservable;

/**
 *
 * @author Usuario
 */
public class Protocolo{
    
    private List<protocoloObservable> presentadorConexion;
    private List<protocoloObservable> agregarFicha;
    private List<protocoloObservable> salir;
    private List<protocoloObservable> mostrarMarcador;
    private List<protocoloObservable> cambiarAvatar;

    public void setPresentadorConexion(protocoloObservable presentadorConexion) {
        this.presentadorConexion.add(presentadorConexion);
    }

    public void setAgregarFicha(protocoloObservable agregarFicha) {
        this.agregarFicha.add(agregarFicha);
    }

    public void setSalir(protocoloObservable salir) {
        this.salir.add(salir);
    }

    public void setMostrarMarcador(protocoloObservable mostrarMarcador) {
        this.mostrarMarcador.add(mostrarMarcador);
    }

    public void setCambiarAvatar(protocoloObservable cambiarAvatar) {
        this.cambiarAvatar.add(cambiarAvatar);
    }
    
    public void unirsePartida(){
        for (protocoloObservable observable : presentadorConexion) {
            observable.unirsePartida();
        }
    }
    
    public void agregarFicha(){
        for (protocoloObservable observable : presentadorConexion) {
            observable.agregarFicha();
        }
    }
    
    public void cambiarAvatar(){
        for (protocoloObservable observable : presentadorConexion) {
            observable.cambiarAvatar();
        }
    }
    
    public void salir(){
        for (protocoloObservable observable : presentadorConexion) {
            observable.salir();
        }
    }
    
    public void mostrarMarcador(){
        for (protocoloObservable observable : presentadorConexion) {
            observable.mostrarMarcador();
        }
    }
}
