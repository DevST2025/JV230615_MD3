import fakecolletion.MyArrayList;
import fakecolletion.MyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList<String> arr = new MyArrayList<>();
        arr.add("Son");
        arr.add(0, "alo");
        arr.add("Hung");
        arr.add("Phuc");
        arr.add("Chau");
        System.out.println(Arrays.toString(arr.toArr()));
        List<String> arrayList = new LinkedList<>();
    }
}
