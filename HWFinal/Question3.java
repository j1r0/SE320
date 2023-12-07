/*
 * By: Jim Pamplona
 * 
 * Implement the following generic method for linear search (return the 
 * first index value if the key is found in the list, return -1 otherwise).
 */

package HWFinal;

public class Question3 {
public static <E extends Comparable<E>> int linearSearch(E[] list, E
key) {
    for (int i = 0; i < list.length; i++){
        int comparedAns = list[i].compareTo(key);
        if (comparedAns == 0) {
            return i;
        } else {
             continue;
        }
    }
    return -1;
}
public static void main(String[] args) {
Integer[] list = {3, 3, 4, 5, 1, -3, -5, -1};
System.out.println(linearSearch(list, 2));
System.out.println(linearSearch(list, 5));
}
}
