/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Ficha;
import com.itson.dominio.FichaJuego;
import java.util.List;

/**
 *
 * @author aroco
 */
public interface IJugadorPartida{
    boolean quitarFicha(Ficha ficha);
    int verificarNumFichas();
    FichaJuego getMulaMasAlta();
    List<FichaJuego> getFichasJuego();
}
