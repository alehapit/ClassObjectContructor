package library.model;

import java.util.List;

public class LibraryUtils {

    //============================
    // 1. Generic findMin()
    //============================
    public static <T extends Comparable<T>> T findMin(T[] array) {

        if (array == null || array.length == 0)
            return null;

        T min = array[0];

        for (T item : array) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }

        return min;
    }

    //============================
    // 2. printAll()
    //============================
    public static void printAll(List<?> list) {

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    //============================
    // 3. copyList()
    //============================
    public static <T> void copyList(
            List<? super T> dest,
            List<? extends T> src) {

        for (T item : src) {
            dest.add(item);
        }
    }
}
