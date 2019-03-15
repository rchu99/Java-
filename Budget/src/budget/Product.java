/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Raymond Chu
 */
public class Product {
    private String item;
    private String type;
    private HashMap<Integer, String> product;
    private final String[] TYPE = {"Nothing","Luxury","Necessity","Comfort"};
    
    public Product(String item, int type) {
        this.item = item;
        this.type = TYPE[type];
    }
    
    public String getItem() {
        return this.item;
    }
    
    public String getType() {
        return this.type;
    }
    
    public String toString() {
        return "The product you have put in is: " + this.item;
    }
}
