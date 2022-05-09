package org.perscholas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        CustomerService customerService = new CustomerService();
        customerService.removeCustomer(1);
    }
}
