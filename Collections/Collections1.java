/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author dmitriysinitsyn
 */
public class Collections1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    
    
        ArrayList<String> letter = new ArrayList<String>();
        letter.add("a");
        letter.add("b");
        letter.add("c");
        letter.add("d");
        
        letter.remove("e");

        System.out.println(letter);



        LinkedList<String> c1 = new LinkedList<String>();
        c1.add("a1");
        c1.add("b1");
        c1.add("c1");
        c1.add("d1");
        
        c1.remove("b1");

        for(String s: c1) {
          System.out.println(s);
        }

        HashMap<String, Integer> points = new HashMap<String, Integer>();
        points.put("Me", 154);
        points.put("Cat", 42);
        points.put("Mom", 733);
        System.out.println(points.get("Cat")); 


        HashSet<String> set = new HashSet<String>();
        set.add("AAA");
        set.add("BBB");
        set.add("CCC");
        System.out.println(set);

        ArrayList<String> names = new ArrayList<String>();
        names.add("Bob");
        names.add("Dmitriy");
        names.add("Michael");
        names.add("Fred");

        Collections.sort(names);

        System.out.println(names);


        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(31);
        nums.add(3);
        nums.add(3);
        nums.add(14);
        nums.add(11);

        Collections.sort(nums);
        System.out.println(nums);

        LinkedList<String> Citys = new LinkedList<String>();
        Citys.add("NY");
        Citys.add("SLC");
        Citys.add("Provo");
        Citys.add("Novosibirsk");

        Iterator<String> ci = Citys.iterator();
        String value = ci.next();
        System.out.println(value);
    
    
    }
    
}
