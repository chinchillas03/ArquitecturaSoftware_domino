/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class Avatar {
    private String text;
    private ImageIcon icon;

    public Avatar(ImageIcon icon) {
        this.icon = icon;
    }

    public Avatar(String text, ImageIcon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return text;
    }
}