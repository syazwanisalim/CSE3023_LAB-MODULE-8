/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

/**
 *
 * @author USER
 */

import com.model.Car;
import java.sql.*;
import java.util.*;



public class CarDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/carshop";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String INSERT =
        "INSERT INTO CarPricelist (Brand, Model, Cylinder, Price) VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL =
        "SELECT * FROM CarPricelist";

    private static final String SELECT_BY_ID =
        "SELECT * FROM CarPricelist WHERE Car_id=?";

    private static final String DELETE =
        "DELETE FROM CarPricelist WHERE Car_id=?";

    private static final String UPDATE =
        "UPDATE CarPricelist SET Brand=?, Model=?, Cylinder=?, Price=? WHERE Car_id=?";

    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void insertCar(Car car) throws SQLException {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setString(1, car.getBrand());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getCylinder());
            ps.setDouble(4, car.getPrice());
            ps.executeUpdate();
        }
    }

    public List<Car> selectAllCars() {
        List<Car> cars = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cars.add(new Car(
                    rs.getInt("Car_id"),
                    rs.getString("Brand"),
                    rs.getString("Model"),
                    rs.getInt("Cylinder"),
                    rs.getDouble("Price")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    public Car selectCar(int id) {
        Car car = null;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                car = new Car(
                    rs.getInt("Car_id"),
                    rs.getString("Brand"),
                    rs.getString("Model"),
                    rs.getInt("Cylinder"),
                    rs.getDouble("Price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    public boolean deleteCar(int id) throws SQLException {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateCar(Car car) throws SQLException {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setString(1, car.getBrand());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getCylinder());
            ps.setDouble(4, car.getPrice());
            ps.setInt(5, car.getCar_id());

            return ps.executeUpdate() > 0;
        }
    }
}