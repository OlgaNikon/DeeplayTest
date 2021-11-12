package ru.nikonova.deeplay;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution02 {

    public static int findSum1(int number) {
        int result = 0;
        int temp = number;
        while (temp != 0) {
            result += temp % 10;
            temp /= 10;
        }
        return result;
    }

    public static int findSum2(int number) {
        return Arrays.stream(IntStream.iterate(number, i -> i / 10 != 0 || i % 10 != 0, i -> i / 10).map(i -> i % 10).toArray()).sum();
    }

}
