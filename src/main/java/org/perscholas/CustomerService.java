package org.perscholas;

import java.sql.SQLException;

public class CustomerService implements CustomerDAO{
    @Override
    /*
     * Retrieves a customer from the database
     * or null if there was no corresponding customer for that id
     */
    public Customer getCustomerByID(int id) {
        DatabaseConnection db = new DatabaseConnection();
        Customer result = null;
        try {
            db.ps = db.conn.prepareStatement(SQL.GET_CUSTOMER_BY_ID.getQuery());
            db.rs = db.ps.executeQuery();

            int customerID = db.rs.getInt("id");
            String fname = db.rs.getString("fname");
            String lname = db.rs.getString("lname");
            String email = db.rs.getString("email");

            result = new Customer(customerID, fname, lname, email);
        }
        catch(SQLException exc) {
            exc.printStackTrace();
        }
        db.dispose();
        return result;
    }

    @Override
    public boolean addCustomer(Customer c) {
        boolean result = false;
        DatabaseConnection db = new DatabaseConnection();

        try {
            db.ps = db.conn.prepareStatement(SQL.ADD_CUSTOMER.getQuery());
            db.ps.setString(1, c.getFname());

        }
        catch(SQLException exc) {
            exc.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean removeCustomer(int id) {
        return false;
    }
}
