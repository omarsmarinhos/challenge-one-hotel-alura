package com.omarinhos.hotel.alura.repositories;

import com.omarinhos.hotel.alura.models.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositoryImpl implements IRepository<Reserva>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }
    
    @Override
    public void create(Reserva r) throws SQLException{
        try ( PreparedStatement stmt = getConnection().prepareStatement(
        "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago) "
                + "VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, r.getFechaEntrada());
            stmt.setString(2, r.getFechaSalida());
            stmt.setDouble(3, r.getValor());
            stmt.setString(4, r.getFormaPago());

            stmt.executeUpdate();

        }
    }

    @Override
    public List<Reserva> read() throws SQLException{
        List<Reserva> reservas = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  
                ResultSet rs = stmt.executeQuery("SELECT * FROM reservas")) {

            while (rs.next()) {
                Reserva reserva = crearReserva(rs);
                reservas.add(reserva);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservas;
    }

    @Override
    public void update(Reserva r) throws SQLException{
        try ( PreparedStatement stmt = getConnection().prepareStatement(
        "UPDATE reservas SET fecha_entrada = ?, fecha_salida = ?, valor = ?, forma_pago = ? WHERE id = ?")) {

            stmt.setString(1, r.getFechaEntrada());
            stmt.setString(2, r.getFechaSalida());
            stmt.setDouble(3, r.getValor());
            stmt.setString(4, r.getFormaPago());
            stmt.setInt(5, r.getId());

            stmt.executeUpdate();

        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try ( PreparedStatement stmt = getConnection().prepareStatement(
        "DELETE FROM reservas WHERE id = " + id)) {
            
            stmt.executeUpdate();

        }
    }

    @Override
    public Reserva findBy(String id) throws SQLException{
        Reserva reserva = null;
        try ( PreparedStatement stmt = getConnection().prepareCall(
                "SELECT * FROM reservas WHERE id LIKE '%"+ id + "%'");  
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                reserva = crearReserva(rs);
            }

        }
        return reserva;
    }

    @Override
    public int lastId() throws SQLException {
        int id = 0;
        try (Statement stmt = getConnection().createStatement();
              ResultSet rs = stmt.executeQuery("select id from reservas order by id desc limit 1")) {

            if (rs.next()) {
                id = rs.getInt("id");
            }

        }
        return id;
    }

    private Reserva crearReserva(ResultSet rs) throws SQLException{
        Reserva reserva = new Reserva();
        reserva.setId(rs.getInt(1));
        reserva.setFechaEntrada(rs.getString(2));
        reserva.setFechaSalida(rs.getString(3));
        reserva.setValor(rs.getDouble(4));
        reserva.setFormaPago(rs.getString(5));
        return reserva;
    }
    
}