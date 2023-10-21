/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.listeners;

/**
 *
 * @author Usuario
 */
public interface ConfigurarJugadorListener {

    /**
     * Este método se llama cuando el usuario hace clic en el botón "Aplicar" en
     * la pantalla de configuración de jugador.
     *
     * @param nombre El nombre proporcionado por el usuario para su jugador.
     */
    void clickBotonAplicar(String nombre);

    /**
     * Este método se llama cuando el usuario hace clic en el botón "Cancelar"
     * en la pantalla de configuración de jugador. Cancela la configuración del
     * jugador y revierte cualquier cambio realizado.
     */
    void clickBotonCancelar();

}
