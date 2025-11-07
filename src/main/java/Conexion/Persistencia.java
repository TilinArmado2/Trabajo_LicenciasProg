/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import CapaDefensa.Administradores;
import CapaDefensa.GestorLicencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import CapaDefensa.Profesores;
import Exception.BDException;
import Exception.ProfesorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author julia
 */
public class Persistencia {

    private static final String SQLGuardar = ("INSERT INTO licenciaprofesores.profesores(CI,NOMBRE,TURNO,GRUPOS,FECHAINICIO,FECHAFIN)VALUES (?,?,?,?,?,?)");
   
    private static final String SQLBuscar = ("SELECT * FROM licenciaprofesores.profesores where CI=?");
    
    private static final String SQLEliminar = ("DELETE FROM licenciaprofesores.profesores where CI=?");
    
    private static final String SQLRegistro = ("INSERT INTO licenciaprofesores.administrador (NOMBREU, CONTRASENIA) VALUES(?, ?)");
    
    private static final String SQLInicio=("SELECT * FROM licenciaprofesores.administrador WHERE nombreU=? AND contrasenia=?");
    
    private static final String SQLMostrar=("SELECT * FROM profesores");
    
    public SQL cone = new SQL();
    public PreparedStatement ps;
    public ResultSet rs;
    
    public void guardarPersonas(Profesores pers) throws Exception, SQLException {

        try {
            int resultado = 0;

            Connection con = cone.getConnection();
            ps = (PreparedStatement) con.prepareStatement(SQLGuardar);
            ps.setString(1, pers.getCI());
            ps.setString(2, pers.getNombre());
            ps.setString(3, pers.getTurno());
            ps.setString(4, pers.getGrupos());
            ps.setString(5, pers.getFechaInicio());
            ps.setString(6, pers.getFechaFin());

            resultado = ps.executeUpdate();

        } catch (SQLException e) {

            throw new Exception("Detonó la base");

        }
    }

    public Profesores buscabusca_ci(String Cedula) throws Exception, SQLException {
        Profesores perso = new Profesores();
        try {
            Connection con;
            con = cone.getConnection();
            ps = (PreparedStatement) con.prepareStatement(SQLBuscar);
            ps.setString(1, Cedula);
            rs = ps.executeQuery();

            if (rs.next()) {
                String ci = rs.getString("CI");
                String nombre = rs.getString("NOMBRE");
                String turno = rs.getString("TURNO");
                String grupo = rs.getString("GRUPOS");
                String Fechain = rs.getString("FECHAINICIO");
                String Fechafin = rs.getString("FECHAFIN");

                perso.setCI(ci);
                perso.setNombre(nombre);
                perso.setTurno(turno);
                perso.setGrupos(grupo);
                perso.setFechaInicio(Fechain);
                perso.setFechaFin(Fechafin);
                
                
            } else {
                throw new ProfesorException("La persona no esta ingresada, pancho");
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
            throw new ProfesorException("nana, no tengo ni idea");
        }
        return perso;
    }

    public void eliminarPersona(String ID) throws ProfesorException, Exception {

        try {
            String Eliminacion = null;
            Connection conexion;
            conexion = cone.getConnection();

            ps = conexion.prepareStatement(SQLEliminar);
            ps.setString(1, ID);
            int resultado = ps.executeUpdate();

            if (rs.next()) {
                Eliminacion = "Persona Eliminada";

            } else {
                Eliminacion = "La persona que desea eliminar no se encuentra";
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     public void Registro(Administradores log) throws Exception {
        try {

            Connection con = cone.getConnection();
            ps = con.prepareStatement(SQLRegistro);
            ps.setString(1, log.getNombre());
            ps.setString(2, log.getContrasenia());
            int resultado = ps.executeUpdate();
            if (resultado <= 0) {
                throw new Exception("No se registró la persona");
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error");
        }
    }
    public boolean iniciarRegistro (String nombreU, String contrasenia)throws Exception{
        boolean valido = false; 
        try{
            Connection con = cone.getConnection();
            ps = con.prepareStatement(SQLInicio);
            ps.setString(1, nombreU);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
                if (rs.next()){
                    valido=true;
                }
            con.close();
        }catch (SQLException e){
            throw new Exception("Error");
            
                     
        }return valido;
    }
   public List<Profesores> obtenerProfesores() throws SQLException, BDException {
    List<Profesores> lista = new ArrayList<>();

    Connection con = cone.getConnection(); 
    PreparedStatement ps = con.prepareStatement(SQLMostrar);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
        Profesores p = new Profesores(
            rs.getString("CI"),
            rs.getString("NOMBRE"),
            rs.getString("TURNO"),
            rs.getString("GRUPOS"),
            rs.getString("FECHAINICIO"),
            rs.getString("FECHAFIN")
        );
        lista.add(p);
    }

    rs.close();
    ps.close();
    con.close();

    return lista;
}
       
     }


