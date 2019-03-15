/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

/**
 *
 * @author Raymond Chu
 */
import java.util.List;
import java.util.ArrayList;
import moving.domain.Box;
import moving.domain.Thing;
public class Packer {
    private int boxesVolume;
    
    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        
        for (Thing t: things) {
            Box box = new Box(boxesVolume);
            box.addThing(t);
            boxes.add(box);
            
        }
        int total = 0;
        for (Box b: boxes) {
            total += b.getVolume();
        }
        System.out.println(total);
        return boxes;
        
    }
}
    
    
