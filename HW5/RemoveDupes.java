/*
 * By: Jim Pamplona
 * 
 * 2. Write a precondition or requires clause for the method removeDuplicates, 
 * so all duplicates from List lst are removed.
 */

package HW5;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class RemoveDupes {
    /**
     * Removes duplicates from a given List.
     * requires: The List lst should not be null or its size should not be '0', and
     * it should allow modification of elements.
     * 
     * @param lst The List duplicates are to be removed from.
     */

    public static void removeDuplicates(List lst) {
        if (lst == null || lst.size() == 0)
            return;
        List copy = new ArrayList(lst);
        Iterator elements = copy.iterator();
        Object pre = elements.next();
        while (elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex))
                lst.remove(nex);
            else
                pre = nex;
        }
    }
}