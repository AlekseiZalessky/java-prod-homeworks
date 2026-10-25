import java.util.*;

public class HW2 {

    public static void main(String[] args) {
        Integer[] arr1 = {10, 20 ,30};
        String[] words = {"яблоко", "банан", "арбуз", "апельсин", "персик", "банан", "слива", "арбуз", "манго", "киви", "банан", "яблоко"};

        changeArr(arr1, 0, 2);
        System.out.println("result changeArr: " + Arrays.toString(arr1));

        changeArr(words, 0, 2);
        System.out.println("result changeArr: " + Arrays.toString(words));

        ArrayList<?> list1 = arrayToList(arr1);
        ArrayList<?> list2 = arrayToList(words);

        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);

        analizArray(words);
    }

    public static <T> void changeArr(T[] array, int index1, int index2) {
        if (array == null ) {
            throw new IllegalArgumentException("array can't be null");
        }
        if (index1 < 0 || index1 > array.length - 1
                || index2 < 0 || index2 > array.length - 1) {
            throw new IllegalArgumentException("invalid index");
        }
        if (index1 == index2) {
            return;
        }

        T item1 = array[index1];
        T item2 = array[index2];
        array[index1] = item2;
        array[index2] = item1;
    }

    public static <T> ArrayList<T> arrayToList(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array can't be null");
        }
        return new ArrayList<>(Arrays.asList(array));
    }

    public static <T> void analizArray(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array can't be null");
        }

        Map<T, Integer>  map = new HashMap<>();

        for (T item : array) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        System.out.println("уникальные слова:  " + map.keySet());

        map.forEach((k, v) -> System.out.println(k + " встречается в массиве " + v + " раз"));
    }
}
