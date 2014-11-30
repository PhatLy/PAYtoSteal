/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import customer.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import product.*;

/**
 *
 * @author Ashley, Phat, Yonas
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart c = (Cart) session.getAttribute("cart");

        //Order number is the first 6 letters of the session id
        String orderNumber = session.getId().substring(0, 6);
        Customer customer = (Customer) session.getAttribute("customer");
        int sku = Integer.parseInt(request.getParameter("hidSku"));

        if (request.getParameter("hidAction").equals("add")) {

            String itemName = request.getParameter("hidItemName");
            double price = Double.parseDouble(request.getParameter("hidItemPrice"));

            //brand new order
            if (c == null) {
                c = new Cart();

                //set order number
                c.setOrderNumber(orderNumber);
                c.setOrderDate(c.getOrderDate());
                c.setTotalAmount(c.getTotalAmount());

                //add the item.
                //we are adding items by reference. (item sku)
                //store sku only. We'll pull the product name and other details from the DB when we list the cart items.
                c.addItem(orderNumber, sku, itemName, price);
            } //existing order.
            //increment qty by 1 if same sku
            //add a new item, if there is no match to sku
            else {
                c.addItem(orderNumber, sku, itemName, price);
            }

            if (customer != null) //if customer is logged in. Grab the email id into the cart/order.
            {
                c.setCustomerEmail(customer.getEmail());
            }

            //update session with the updated object 
            dispatcherWrapper(session, request, response, c, "/cart.jsp");

        }

        if (request.getParameter("hidAction").equals("update")) {

            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            c.updateItem(sku, quantity);

            String url;
            if (c.getItems().isEmpty())//cart is empty take the custoemr to the index page
            {
                url = "/IndexServlet";
            } else {
                url = "/cart.jsp";
            }

            dispatcherWrapper(session, request, response, c, url);

        }

    }

    public void dispatcherWrapper(HttpSession session, HttpServletRequest request, HttpServletResponse response, Cart cart, String url)
            throws ServletException, IOException {
        //update session with the updated object 
        session.setAttribute("cart", cart);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
