/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDefensa;


import Conexion.Persistencia;
import Exception.BDException;
import java.sql.SQLException;
import Exception.ProfesorException;
import java.util.List;

/**
 *
 * @author julia
 */
public class FachadaProfesores {
    private GestorLicencias gestor;

     public void guardarPersonas(Profesores Perso) throws Exception {
         Persistencia pers = new Persistencia();
        pers.guardarPersonas(Perso);
    }
     
   public Profesores busquedaPorCi (String ci)throws ProfesorException, BDException, SQLException, Exception {
       Profesores per = new Profesores();
       Persistencia pers = new Persistencia();
       per = pers.buscabusca_ci(ci);
       return per;
       
   } 
   
   public void eliminarPersona (String ci) throws ProfesorException, Exception {
    Persistencia pers = new Persistencia();
     pers.eliminarPersona (ci);
   }
   
   public void registrarPersona (Administradores login) throws Exception {
       Persistencia pers = new Persistencia();
       pers.Registro(login);
   }
   public boolean iniciarSesion (String usuario, String contrasenia) throws Exception {
       Persistencia pers = new Persistencia();
       return pers.iniciarRegistro(usuario, contrasenia);
   }
    public List<Profesores> obtenerProfesores() throws Exception {
    Persistencia pers = new Persistencia();
    List<Profesores> lista = pers.obtenerProfesores();
    return lista;
   
    }
}

     
   

 
    

