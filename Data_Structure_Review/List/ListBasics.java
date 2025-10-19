import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListBasics {
    public static void print(String label, MyList myList){
        int[] arr = myList.toArray();
        StringBuilder sb = new StringBuilder();
        sb.append(label).append(" [");
        for (int i = 0; i < myList.size(); i++){
            sb.append(arr[i]);
            if (i != myList.size() - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // Initialize a empty list
        List<Integer> nums1 = new ArrayList<>();

        // Initialize with val
        List<Integer> nums = new ArrayList<>(List.of(1,3,2,5,4));

        // Access / update (O(1) amortized)
        nums.get(1);
        nums.set(2, 713);

        // Clear
        nums.clear();

        // Append elements (amortized O(1))
        nums1.add(1);
        nums1.add(3);
        nums1.add(2);
        nums1.add(5);
        nums1.add(4);
        System.out.println(nums1);

        // Insert in the middle (O(n))
        nums1.add(2, 713);
        System.out.println(nums1);

        // Remove at index (O(n))
        nums1.remove(2);
        System.out.println(nums1);

        // Loops by idx
        int count = 0;
        for(int i = 0; i < nums1.size(); i++){
            count += nums1.get(i);
        }

        // Loop by foreach pattern
        count = 0;
        for (int num : nums1){ // the type is must
            count += num;
        }

        // Sort (in place)
        Collections.sort(nums1);
        System.out.println(nums1);

        // Reverse
        Collections.reverse(nums1);
        System.out.println(nums1);


        // usage of MyList:
        MyList myList = new MyList();
        myList.add(10); 
        myList.add(20); 
        myList.add(30);
        print("After adds", myList);

        myList.insert(1, 15);
        print("After insert@1", myList);

        System.out.println("get(2) = " + myList.get(2));
        myList.set(2, 99);
        print("After set(2,99)", myList);

        int removed = myList.remove(1);
        System.out.println("removed: " + removed);
        print("After remove@1", myList);

        // Force growth
        for (int i = 0; i < 20; i++) myList.add(i);
        System.out.println("size=" + myList.size() + " cap=" + myList.capacity());
        print("Final", myList);
    }
}

class MyList{
    private int cap = 10;
    private int size = 0;
    private int[] arr = new int[cap];
    private final int extendRatio = 2;

    public int size(){
        return size;
    }

    public int capacity(){
        return cap;
    }

    public int get(int idx){
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Out of range");

        return arr[idx];
    }

    public void set(int idx, int val){
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Out of range");

        arr[idx] = val;
    }

    public void add(int val){
        if (size == cap) extendCap();

        arr[size] = val;
        size++;
    }

    public void insert(int idx, int val){
        if (size == cap) extendCap();

        for(int i = size; i > idx; i--){
            arr[i] = arr[i - 1];
        }

        arr[idx] = val;
        size++;
    }

    public int remove(int idx){
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Out of range");

        int num = arr[idx];

        for(int i = idx; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }

        size--;
        return num;
    }

    public int[] toArray(){
        int[] out = new int[size];

        System.arraycopy(arr, 0, out, 0, size);
        return out;
    }

    private void extendCap(){
        int[] out = new int[cap * extendRatio];
        cap = out.length;
        System.arraycopy(arr, 0, out, 0, size);
        arr = out;
    }

}
