import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.function.*;

import collection.*;
import static collection.CollectionOps.*; // Use static methods without the "Collection." prefix

public class Main {
    public static void main(String[] args) {    
         ArrayList<String> names = new ArrayList<String>();

         // Test print for an empty list
         print(names); System.out.println();

         // Test print for a list containing one element
         names.add("a");
         print(names); System.out.println();

         // Test print for a list containing more than one elment
         names.add("b");
         names.add("c");
         print(names); System.out.println();
         
         // Test the return value from reverse
         print(reverse(names));
         System.out.println();
         // Test that reverse mutates its argument
         print(names);
         System.out.println();

         // Assignment 4: Write code to test less here 
         IntegerComparator intcomp = new IntegerComparator(); 
         List<Integer> li1 = new ArrayList<Integer>(); 
         li1.add(4);
         li1.add(2);
         li1.add(1);
         li1.add(5);
         li1.add(3);
         List<Integer> li2 = new ArrayList<Integer>(); 
         li2.add(8);
         li2.add(6);
         li2.add(7);
         li2.add(9);
         List<Integer> li3 = new ArrayList<Integer>(); 
         li3.add(8);
         li3.add(3);
         li3.add(7);
         li3.add(9);
         
         System.out.println(less(li1,li2,intcomp));
         System.out.println(less(li2,li1,intcomp));
         System.out.println(less(li1,li3,intcomp));

         // Assignment 5: Write code to test map here
         List<Double> l1 = new ArrayList<Double>(); 
         l1.add(5.668);
         l1.add(-4.3);
         l1.add(0.0);
         l1.add(9.32);
         l1.add(-3.98);
         l1.add(0.0);
         
         Collection<Integer> l2 = map(new Sign(),l1);
         print(l2); 
         
         
         // Assignment 5: Write code to test filter here
         List<Integer> l3 = new ArrayList<Integer>(); 
         l3.add(5);
         l3.add(4);
         l3.add(3);
         l3.add(0);
         l3.add(8);
         l3.add(9);
         
         Collection<Integer> l4 = filter(new isEven(),l3);
         System.out.println();
         print(l4); 
         
         ArrayList<Person> p1 = new ArrayList<>();
         p1.add(new Person("Nisse","nisse@hipnet.moc","male",23));
         p1.add(new Person("Lisa","lisa@shipnet.sea","female",67));
         p1.add(new Person("Ada","ada@jahuu.vanu","female",49));
         p1.add(new Person("Kal","karl@gotnet.vg","male",78));
         p1.add(new Person("Beda","beda@fishnet.cod","female",102));
        
         // Assignment 6: Write code using lambdas here
         Collection<Person> p2 = filter(x -> x.getGender().equals("female") && x.getAge() >= 65, p1);
         Collection<String> p3 = map(x -> x.getEmail(), p2);
         System.out.println();
         print(p3);         
    }
}














