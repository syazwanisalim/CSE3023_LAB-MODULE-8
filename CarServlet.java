/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;



import com.DAO.CarDAO;
import com.model.Car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/list", "/new", "/insert", "/edit", "/update", "/delete"})
public class CarServlet extends HttpServlet {

    private CarDAO carDAO;

    public void init() {
        carDAO = new CarDAO();
    }
    
    @Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
    doGet(request, response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showForm(request, response);
                    break;
                case "/insert":
                    insertCar(request, response);
                    break;
                case "/delete":
                    deleteCar(request, response);
                    break;
                case "/edit":
                    showEdit(request, response);
                    break;
                case "/update":
                    updateCar(request, response);
                    break;
                default:
                    listCars(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listCars(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Car> list = carDAO.selectAllCars();
        request.setAttribute("listCars", list);

        RequestDispatcher rd = request.getRequestDispatcher("carList.jsp");
        rd.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("carForm.jsp");
        rd.forward(request, response);
    }

    private void insertCar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        Car car = new Car(
                request.getParameter("brand"),
                request.getParameter("model"),
                Integer.parseInt(request.getParameter("cylinder")),
                Double.parseDouble(request.getParameter("price"))
        );

        carDAO.insertCar(car);
        response.sendRedirect("list");
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        carDAO.deleteCar(id);
        response.sendRedirect("list");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Car car = carDAO.selectCar(id);

        request.setAttribute("car", car);
        RequestDispatcher rd = request.getRequestDispatcher("carForm.jsp");
        rd.forward(request, response);
    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        Car car = new Car(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("brand"),
                request.getParameter("model"),
                Integer.parseInt(request.getParameter("cylinder")),
                Double.parseDouble(request.getParameter("price"))
        );

        carDAO.updateCar(car);
        response.sendRedirect("list");
    }
}