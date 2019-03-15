/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author Raymond Chu
 */
public class Item implements Thing, Comparable<Item>{
    private String name;
    private int volume;
    
    public Item(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }
    
    public int getVolume() {
        return this.volume;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name + " (" + this.volume + " dm^3)";
    }
    
    public int compareTo(Item item) {
        return this.getVolume() - item.getVolume();
    }
}
