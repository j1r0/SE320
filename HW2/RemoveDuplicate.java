package HW2;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.print(newList);
    }

    // Removes Duplicates; uses sets to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        HashSet<E> set = new HashSet<E>();
        ArrayList<E> noDuplicatesList = new ArrayList<>();
        set.addAll(list);
        noDuplicatesList.addAll(set);
        return noDuplicatesList;
    }
}