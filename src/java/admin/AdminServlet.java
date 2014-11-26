/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.Item;

/**
 *
 * @author Yonas
 */
public class AdminServlet extends HttpServlet {

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

        Item it = new Item();

        String sku = "";
        String imgSrc = "";
        String itemName = "";
        double price = 0;
        String description = "";
        double discount = 0;

        String discountStartTime = "";
        String discountEndTime = "";

        String action = request.getParameter("hidAction");

        //request is to add a new customer
        if (action != null && action.equals("Create")) {

            sku = request.getParameter("txtSku");
            imgSrc = request.getParameter("txtImgSrc");
            itemName = request.getParameter("txtItemName");
            price = Double.parseDouble(request.getParameter("txtPrice"));
            description = request.getParameter("txtDescription");
            discount = Double.parseDouble(request.getParameter("txtDiscount"));

            discountStartTime = request.getParameter("txtDiscountStartTime");
            discountEndTime = request.getParameter("txtDiscountEndTime");

            it.addItem(sku, imgSrc, itemName, price, description, discount, discountStartTime, discountEndTime);

            request.setAttribute("msg", "Product created successfuly!");

            String url = "/admin/product.jsp";

            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        //default action is to list all items
        //typing 0 lists all
        if (action != null && action.equals("List")) {
            
            request.setAttribute("items", it.listItems(0));

            String url = "/admin/productList.jsp";

            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
        
        
        if (action != null && action.equals("Delete")) {
            
            it.deleteItem(sku);
            
            request.setAttribute("items", it.listItems(0));

            String url = "/admin/productList.jsp";

            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
        

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
