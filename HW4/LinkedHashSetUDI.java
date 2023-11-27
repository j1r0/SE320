/*
 * By: Jim Pamplona
 * 
 * 1. Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and 
 * {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find their union, difference, and intersection. 
 * (You can clone the sets to preserve the original sets from being changed by these set methods.)
 * 
 */
 
 import java.util.LinkedHashSet;

public class LinkedHashSetUDI {
    public static void main(String[] args) {
        String[] names1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        String[] names2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
        LinkedHashSet<String> set1 = toLinkedHashSet(names1);
        LinkedHashSet<String> set2 = toLinkedHashSet(names2);

        System.out.println("-----Union of the sets-----\n" + setUnion(set1, set2) + "\n");

        System.out.println("-----Difference of the sets-----\nset1: " +setDifference(set1, set2) +"\nset2: " + setDifference(set2, set1) + "\n");

        System.out.println("-----Intersection of the sets-----\n" + setIntersection(set1, set2) + "\n");
    }

    //used to turn string into hash sets (not needed but i didnt want to have too many 'add' calls)
    public static LinkedHashSet<String> toLinkedHashSet(String[] names){
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        for (String name: names){
            set.add(name);
        }
        return set;
    }

    // Union is all of set 1 and set 2 with no duplicates
    public static LinkedHashSet<String> setUnion(LinkedHashSet<String> set1, LinkedHashSet<String> set2){
        LinkedHashSet<String> unionSet = new LinkedHashSet<String>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }
    
    // Difference is everything in set1 that is not in set 2, vice versa
    public static LinkedHashSet<String> setDifference(LinkedHashSet<String> set1, LinkedHashSet<String> set2){
        LinkedHashSet<String> differenceSet = new LinkedHashSet<String>(set1);
        differenceSet.removeAll(set2);
        return differenceSet;
    }

    //Intersection is everything that is common in set1 and set2
    public static LinkedHashSet<String> setIntersection(LinkedHashSet<String> set1, LinkedHashSet<String> set2){
        LinkedHashSet<String> intersectionSet = new LinkedHashSet<String>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }
}
