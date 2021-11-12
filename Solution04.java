package ru.nikonova.deeplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution04 {

    /**
     * @param array array of given numbers
     * @param count number of groups
     * @return true if the array can be distributed into groups with the same sum, else false
     */

    public static boolean distribution(int[] array, int count) {
        int totalSum = Arrays.stream(array).sum();
        if (totalSum % count != 0) {
            return false;
        }
        List<Integer> freeNumbers =  Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int groupSum = totalSum / count;
        for (int i = 0; i < count; i++) {
            List<Integer> list = new ArrayList<>();
            int listSum = enumeration(freeNumbers, list, 0, groupSum);
            if (listSum != groupSum) {
                int element = 0;
                while (listSum != groupSum && element != list.size()) {
                    int temp = list.remove(element);
                    listSum -= temp;
                    listSum = enumeration(freeNumbers, list, listSum, groupSum);
                    freeNumbers.add(temp);
                    freeNumbers.sort(Comparator.reverseOrder());
                    element++;
                }
                for (Integer integer: list) {
                    System.out.print(integer + " ");
                }
                System.out.println("\nsum = " + listSum);
                if (listSum != groupSum) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int enumeration(List<Integer> freeNumbers, List<Integer> list, int listSum, int groupSum) {
        int sum = listSum;
        Iterator<Integer> iterator = freeNumbers.iterator();
        while (sum < groupSum && iterator.hasNext()) {
            int element = iterator.next();
            if (element <= groupSum - sum) {
                list.add(element);
                iterator.remove();
                sum += element;
            }
        }
        return sum;
    }

}
