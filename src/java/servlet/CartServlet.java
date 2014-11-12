/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.servlet.RequestDispatcher;
import product.*;
import product.util.ProdMgmt;

/**
 *
 * @author Ashley, Phat, Yonas
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get product name
        String itemName = request.getParameter("itemName");
        
        
        Item item = null;
        
        ProdMgmt pm = new ProdMgmt();
        Item[] items = pm.getItems();
        
       
        //search for the product and set the item object
        for (Item i : items) {
            if(i.getItemName().equals(itemName))
                item = i;
        }
        
        HttpSession session = request.getSession();
        Cart c = (Cart) session.getAttribute("cart");  

        if (c == null) {
            c = new Cart();
        }
        
        ArrayList<LineItem> line = c.getItems();
        
        LineItem lItem = null;
        for (int i = 0; i < c.getSize(); i++) {
            if (line.get(i).getItem().getItemName().equals(item.getItemName())) {
                lItem = line.get(i);
            }
        }
        
        if (lItem == null) {
            lItem = new LineItem(item, 0);
        }
            
        c.addItem(lItem);
        session.setAttribute("cart", c);
        
        String url = "/cart.jsp";
        
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
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
