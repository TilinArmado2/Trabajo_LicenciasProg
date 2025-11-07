/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Ubicación: CapaDefensa/Profesores.java
package CapaDefensa;

import java.util.Date;
import java.util.List;

public class Profesores {
    private String CI; 
    private String nombre;
    private String turno;
    private String grupos;
    private String fechaInicio;
    private String fechaFin;
    
    public Profesores(String CI, String nombre, String turno, String grupos, String fechaInicio, String fechaFin) {
    this.CI = CI;
    this.nombre = nombre;
    this.turno = turno;
    this.grupos = grupos;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
}
    public Profesores() {
}

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    


    }
    


