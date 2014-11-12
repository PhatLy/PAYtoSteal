/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.Item;
import product.util.ProdMgmt;
import java.util.*;

/**
 *
 * @author Ashley, Phat, Yonas
 */
public class ProductsServlet extends HttpServlet {

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
        
        int itemListLimit = request.getParameter("itemCount") == null ? Integer.parseInt(request.getParameter("txtNumber")) : Integer.parseInt(request.getParameter("itemCount"));
        
        ProdMgmt pm = new ProdMgmt();
        Item[] items = pm.getItems();
        
        //now display products per the list limit submitted from
        //index page.
        //itemListLimit can not be greater than the number of 
        //products we've so. if itemListLimit is larger than item[]
        //take the size of the item[] array.
        //and show a message to the customer.
        String msg = "";
        if(itemListLimit > items.length)
        {
            //itemListLimit = items.length; yonas: moved this down as the message below needs 
            //to display the original #of products the user requested to view.
            msg = "You requested " + itemListLimit + " items to be listed. \n"
                  + "Sorry, we only have "+ items.length +" this time. Check us back soon!";
            itemListLimit = items.length;
        }   
        
        //we'll need to remember the value of itemListLimit while the user is in active session
        //the continue shopping button will use this session variable
        //to take the user back to the products page with the 
        //correct number of items listed.
        HttpSession session = request.getSession();
        session.setAttribute("itemListLimit", itemListLimit);
        
        request.setAttribute("msg", msg);
        ArrayList<Item> list = new ArrayList<>();        
        
        for(int i = 0; i < itemListLimit; i++)
        {
            list.add(items[i]);
        }
        request.setAttribute("items", list);
        request.setAttribute("itemCount", itemListLimit);
        
        String url = "/products.jsp";
        
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
