package servlet;

import customer.Customer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yonas
 */
public class CustomerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Customer cust = new Customer();
        HttpSession session = request.getSession();

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password1");
        String country = request.getParameter("country");

        //request is to add a new customer
        if (request.getParameter("hidAction").equals("Create")) {
            cust.addCustomer(firstName, lastName, email, password, country);
            request.setAttribute("msg", "Account created successfuly!");

            String url = "/IndexServlet";

            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        //request is to update customer record
        if (request.getParameter("hidAction").equals("Update")) {
            cust.updateCustomer(firstName, lastName, email, password, country);

            //update session
            cust = (Customer) session.getAttribute("customer");

            cust.setFirstName(firstName);
            cust.setLastName(lastName);
            cust.setEmail(email);
            cust.setPassword(password);
            cust.setCountry(country);

            session.setAttribute("customer", cust);

            request.setAttribute("msg", "Account updated successfuly!");

            String url = "/customer.jsp";

            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
        
        //request is to delete a customer
        if (request.getParameter("hidAction").equals("Delete")) {
            
            cust.deleteCustomer(email);
            request.setAttribute("msg", "Account deleted successfuly!");

            //auto logout customer.
            session.invalidate(); 
            
            //take to home page
            String url = "/IndexServlet";

            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        if (request.getParameter("hidAction").equals("Login")) {

            Customer validCust = cust.isCustomer(request.getParameter("acctName"), request.getParameter("password"));

            if (validCust != null) {

                if (session.getAttribute("customer") == null) {//session is not yet created so create a new one
                    session.setAttribute("customer", validCust);
                }

                String url = "/customer.jsp?action=Update&email=" + validCust.getEmail();

                //pass session variable to the request object
                request.setAttribute("customer", (Customer) session.getAttribute("customer"));

                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } else {
                request.setAttribute("msg", "Invalid login!");

                String url = "/index.jsp";

                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            }

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
