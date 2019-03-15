/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;
import java.util.HashMap;
import java.util.Map;
import budget.Product;
/**
 *
 * @author Raymond Chu
 */
public class Budget {

    private Map<Product, Double> allProducts;
    private double price;
    
    public Budget() {
        this.allProducts = new HashMap<Product, Double>();
    }
    
    
    public void deleteProduct(Product newProduct) {
        if (!allProducts.containsKey(newProduct)) {
            System.out.println("Product not found!");
        } else {
            allProducts.remove(newProduct);
        }
    }
    
    public String toString() {
        for (Product item: allProducts.keySet()) {
            return item.getItem() + " is a " + item.getType() + " and costs: " + allProducts.get(item);
         }
    }

    public void addProduct(Product newProduct, double price) {
        if (allProducts.containsKey(newProduct)) {
            System.out.println("Item is already added! Updating price");
            double currentPrice = allProducts.get(newProduct);
            allProducts.put(newProduct, currentPrice + price);
        } else {
        allProducts.put(newProduct, price);
        }
    }
    
    public double getPrice(String item) {
        for (Product items: allProducts.keySet()) {
            if (items.getItem().equals(item)) {
                return allProducts.get(items);
            }
        }
        return 0;
    }

    
            
}
