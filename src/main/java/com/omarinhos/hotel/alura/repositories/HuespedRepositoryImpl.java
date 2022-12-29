package com.omarinhos.hotel.alura.repositories;

import com.omarinhos.hotel.alura.models.Huesped;
import com.omarinhos.hotel.alura.models.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HuespedRepositoryImpl implements IRepository<Huesped>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }
    
    @Override
    public void create(Huesped h) throws SQLException{
        try ( PreparedStatement stmt = getConnection().prepareStatement(
        "INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva) "
                + "VALUES (?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, h.getNombre());
            stmt.setString(2, h.getApellido());
            stmt.setString(3, h.getFechaNacimiento());
            stmt.setString(4, h.getNacionalidad());
            stmt.setString(5, h.getNacionalidad());
            stmt.setInt(6, h.getReserva().getId());

            stmt.executeUpdate();

        }
    }

    @Override
    public List<Huesped> read() throws SQLException{
        List<Huesped> huespedes = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  
                ResultSet rs = stmt.executeQuery("SELECT * FROM huespedes")) {

            while (rs.next()) {
                Huesped huesped = crearHuesped(rs);
                huespedes.add(huesped);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return huespedes;
    }

    @Override
    public void update(Huesped h) throws SQLException{
        try ( PreparedStatement stmt = getConnection().prepareStatement(
        "UPDATE huespedes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, "
                + "nacionalidad = ?, telefono = ?, id_reserva = ? WHERE id = ?")) {

            stmt.setString(1, h.getNombre());
            stmt.setString(2, h.getApellido());
            stmt.setString(3, h.getFechaNacimiento());
            stmt.setString(4, h.getNacionalidad());
            stmt.setString(5, h.getNacionalidad());
            stmt.setInt(6, h.getReserva().getId());
            stmt.setInt(7, h.getId());

            stmt.executeUpdate();

        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try ( PreparedStatement stmt = getConnection().prepareStatement(
        "DELETE FROM huespedes WHERE id = " + id)) {
            
            stmt.executeUpdate();

        }
    }

    @Override
    public Huesped findBy(String apellido) throws SQLException{
        Huesped huesped = null;
        try ( PreparedStatement stmt = getConnection().prepareCall(
                "SELECT * FROM huespedes WHERE apellido LIKE '%"+ apellido + "%'");  
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                huesped = crearHuesped(rs);
            }

        }
        return huesped;
    }

    private Huesped crearHuesped(ResultSet rs) throws SQLException{
        Huesped huesped = new Huesped();
        huesped.setId(rs.getInt(1));
        huesped.setNombre(rs.getString(2));
        huesped.setApellido(rs.getString(3));
        huesped.setFechaNacimiento(rs.getString(4));
        huesped.setNacionalidad(rs.getString(5));
        huesped.setTelefono(rs.getString(6));
        Reserva reserva = new Reserva();
        reserva.setId(rs.getInt(7));
        huesped.setReserva(reserva);
        return huesped;
    }
    
}