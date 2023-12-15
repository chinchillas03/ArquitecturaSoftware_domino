/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.listeners;

import java.util.List;
import org.itson.dtos.UnirsePartidaDTO;

/**
 *
 * @author Usuario
 */
public interface Observador {
    void setearValoresSalaEspera(List<UnirsePartidaDTO> valores);
    void enviarFicha();
    void cambiarAvatar();
    void salir();
    void mostrarMarcador();
    void salirTodos();
    void jalarPozo();
    void pasarTurno();
}
