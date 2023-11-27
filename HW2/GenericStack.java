package HW2;

public class GenericStack<E> {

    /*Attributes:
     * objArray: Array of Objects is created. Cannot instantiate an Array of E.
     * defaultCapacity: Default Capacity of Array is set at 5. Variable is static as it never changes.
     * specifiedCapacity: Used for user to enter desired capacity of Array.  
     */
    private Object[] objArray;
    private static int defaultCapacity = 5;
    private int specifiedCapacity;

    // Constructs GenericStack with default capacity
    public GenericStack() {
        objArray = new Object[defaultCapacity];

    }

    // Constructs GenericStack with user-specified capacity
    public GenericStack(int size) {
        if (size <= 0) {
            size = 1;
        }
        objArray = new Object[size];
        this.specifiedCapacity = size;
    }

    // Gets size of array by iterating until it hits null
    public int getSize() {
        int index = 0;
        while (objArray[index] != null) {
            index++;
        }
        return index;
    }

    //Suppresses Unchecked warning - not sure how to clear warning without this
    // Traverses until null to peek the last item pushed
    @SuppressWarnings("unchecked")
    public E peek() {
        int index = 0;
        while (objArray[index + 1] != null) {
            index++;
        }
        return (E) objArray[index];
    }

    // Traverses until null to push an item to the last free index, acts as "top" of stack
    public void push(E o) {
        for (int i = 0; i < specifiedCapacity; i++) {
            if (objArray[specifiedCapacity - 1] == null) {
                if (objArray[i] == null) {
                    objArray[i] = o;

                    return;
                } else {
                    continue;
                }
            } else {

    // if the stack is full, this doubles the size of the array
                System.out.println("This worked!");
                Object[] oldObjArray = new Object[specifiedCapacity];

                for (int j = 0; j < specifiedCapacity; j++) {
                    oldObjArray[j] = objArray[j];
                }

                objArray = new Object[specifiedCapacity * 2];

                for (int j = 0; j < specifiedCapacity; j++) {
                    objArray[j] = oldObjArray[j];
                }
                specifiedCapacity *= 2;
            }

        }

    }

    // Traverses until null, pops out the value before null and returns that value. Value in stack is set to null
    @SuppressWarnings("unchecked")
    public E pop() {
        int index = 0;
        while (objArray[index + 1] != null) {
            index++;
        }
        E valuePopped = (E) (objArray[index]);
        objArray[index] = null;

        return valuePopped;
    }

    public boolean isEmpty() {
        return objArray[0] == null;
    }

    // Returns string version of stack
    @Override
    public String toString() {
        String arrayString = "";
        int index = 0;
        while (objArray[index] != null) {
            arrayString += objArray[index].toString() + " ";
            index++;
        }

        return "stack: " + arrayString + "<- Top";
    }

}