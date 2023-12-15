/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.listeners;

import java.util.List;
import org.itson.dtos.UniserPartidaDTO;

/**
 *
 * @author Usuario
 */
public interface Observador {
    public void setearValoresSalaEspera(List<UniserPartidaDTO> valores);
}
