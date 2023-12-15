/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dtos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class AvatarDTO implements Serializable{
    
    private String path;

    public AvatarDTO() {
    }

    public AvatarDTO(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
