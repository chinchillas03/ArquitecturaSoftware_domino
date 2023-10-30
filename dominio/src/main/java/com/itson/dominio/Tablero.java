/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Tablero {
    
    private List<FichaTablero> fichas;

    public Tablero() {
    }

    public Tablero(List<FichaTablero> fichas) {
        this.fichas = fichas;
    }

    public List<FichaTablero> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaTablero> fichas) {
        this.fichas = fichas;
    }
    public boolean verificaFicha(){
        return fichas.isEmpty();
    }
    public void addFicha(){
        
    }
    
    
}
