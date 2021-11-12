package ru.nikonova.deeplay;

import java.util.Arrays;
import java.util.Comparator;

public class Solution01 {

    public static int[] findMax1(int[] array) {
        if (array.length < 3) {
            return array;
        }
        int[] result = new int[3];
        Arrays.sort(array);
        int element = array.length - 1;
        for (int i = 0; i < 3; i++) {
            result[i] = array[element];
            element--;
        }
        return result;
    }

    public static int[] findMax2(int[] array) {
        return Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).limit(3).mapToInt(x -> x).toArray();
    }

}
