/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Empuhalaand
 */
package CapaDefensa;
import Conexion.Persistencia;
import Exception.BDException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GestorLicencias {
    private List<Profesores> listaLicencias;
    private Persistencia Persistencia;

    public GestorLicencias() {
        listaLicencias = new ArrayList<>();
    }

    public void agregarLicencia(Profesores profesor) {
        listaLicencias.add(profesor);
    }

    public List<Profesores> obtenerTodas() {
        return listaLicencias;
    }
    public List<Profesores> obtenerProfesores() throws BDException, SQLException {
    
    listaLicencias = new ArrayList<>(Persistencia.obtenerProfesores());
        return listaLicencias;
    }
   
    
}


