package customer;

import dbutil.ConnectionPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashley, Phat, Yonas
 */
public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String country;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String password, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int addCustomer(String firstName, String lastName, String email, String password, String country) {

        int rowsAffected = 0;

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "insert into customer (firstName, lastName, email, password, country) values(?,?,?,?,?)";

            PreparedStatement stmt = cp.connection.prepareStatement(query);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, country);

            rowsAffected = stmt.executeUpdate();

            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return rowsAffected;
    }

    public int updateCustomer(String firstName, String lastName, String email, String password, String country) {

        int rowsAffected = 0;

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "update customer set firstName = ?, lastName = ?, email = ?, password = ?, country = ?  where email = ? ";

            PreparedStatement stmt = cp.connection.prepareStatement(query);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, country);
            stmt.setString(6, email);

            rowsAffected = stmt.executeUpdate();

            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return rowsAffected;
    }

    public int deleteCustomer(String email) {

        int rowsAffected = 0;

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "delete from customer where email = ? ";

            PreparedStatement stmt = cp.connection.prepareStatement(query);
            stmt.setString(1, email);

            rowsAffected = stmt.executeUpdate();

            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return rowsAffected;

    }

    public Customer isCustomer(String email, String password) {

        ResultSet rs = null;
        Customer customer = null;

        //use prepared statements to avoid sql injection.
        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "Select * from customer c where c.email = ? and password = ? ";

            PreparedStatement stmt = cp.connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {

                customer = new Customer(rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("country"));

            }

            rs.close();
            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return customer;
    }

    public List<Customer> listCustomer() {

        ResultSet rs = null;
        List<Customer> customers = new ArrayList<Customer>();

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "Select * from customer";
            PreparedStatement stmt = cp.connection.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {

                customers.add(new Customer(rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("country")));

            }

            rs.close();
            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return customers;
    }
}
