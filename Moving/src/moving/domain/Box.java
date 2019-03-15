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
import java.util.ArrayList;
import java.util.List;
public class Box implements Thing{
    private final int maxCapacity;
    private List<Thing> box;
    
    
    public Box(int maximumCapacity) {
        this.maxCapacity = maximumCapacity;
        this.box = new ArrayList<Thing>();
       
    }
    
    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() <= maxCapacity) {
            box.add(thing);
            return true;
        }
        return false;
    }
    
    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (Thing thing: box) {
            totalVolume += thing.getVolume();
        }
        return totalVolume;
    }
    
}
