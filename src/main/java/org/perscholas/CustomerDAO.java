package org.perscholas;

public interface CustomerDAO {
    enum SQL {
        GET_CUSTOMER_BY_ID("SELECT * FROM Customer WHERE id = ?"),
        REMOVE_CUSTOMER("DELETE FROM Customer WHERE id = ?"),
        ADD_CUSTOMER("INSERT INTO Customer VALUES (?, ?, ?)");
        private final String query;
        private SQL(String s) {
            this.query = s;
        }
        public String getQuery() {
            return query;
        }
    }

    Customer getCustomerByID(int id);
    boolean addCustomer(Customer c);
    boolean removeCustomer(int id);
}
