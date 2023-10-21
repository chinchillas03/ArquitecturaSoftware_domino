/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.listeners;

/**
 *
 * @author Usuario
 */
public interface CrearPartidaListener {
    
    /**
     * Este método se llama cuando el usuario hace clic en el botón para seleccionar la cantidad de fichas en la partida.
     *
     * @param cantidadFichas La cantidad de fichas seleccionada por el usuario para la partida.
     */
    void clickSeleccionarCantidadFichas(Integer cantidadFichas);
    
    /**
     * Este método se llama cuando el usuario hace clic en el botón "Cancelar" durante la configuración de la partida.
     * Permite al usuario cancelar la operación y volver atrás.
     */
    void clickCancelar();
    
}
