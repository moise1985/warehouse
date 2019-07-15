package com.sda.warehouseManagement;

import com.sda.warehouseManagement.dao.OrderDao;
import com.sda.warehouseManagement.dao.ProductDao;
import com.sda.warehouseManagement.dao.UserDao;
import com.sda.warehouseManagement.model.Order;
import com.sda.warehouseManagement.model.OrderStatus;
import com.sda.warehouseManagement.model.Product;
import com.sda.warehouseManagement.model.User;

/**
 * Hello world!
 *
 */
public class WarehouseManagementApp 
{
    public static void main( String[] args )
    {
        // Insert two new users in the database
        User user1 = new User();
        user1.setFirstName("Alin");
        user1.setLastName("Moise");
        user1.setAdmin(true);
   
        //set the rest of the fields - ??? cum setez param la date
        
        UserDao.createNewUser(user1);
        
        
        // Insert two new products in the database
        Product product1 = new Product();
        product1.setName("lemn");
        ProductDao.createNewProduct(product1); 
        
        Product product2 = new Product();
        product1.setName("caramida");
        ProductDao.createNewProduct(product2);
        
        
        // Insert new order into the database for user alin and product lemn
        Order order1 = new Order();
        order1.setStatus(OrderStatus.PLACED);
        
        for(User u: UserDao.getAllUsers()) {
            if(u.getFirstName().equals("Alin")) {
                order1.setUser(u);
            }
        }
        
        for(Product p: ProductDao.getAllProducts()) {
            if(p.getName().equals("lemn")) {
                order1.getProductList().add(p);
            }
        }
        // save the order in the database
        OrderDao.createNewOrder(order1);
        
    }
}
