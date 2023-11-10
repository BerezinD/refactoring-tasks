package task1;

import org.graalvm.collections.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int a[] = new int[l];
        for (int i = 0; i < l; i++) { // loop for reading the input
            a[i] = s.nextInt();
        }
        Pair<Integer, Integer> duplicatesNumberAndSum = getDuplicatesNumberAndAverage(a, l);
        System.out.println(duplicatesNumberAndSum.getLeft() + " " + duplicatesNumberAndSum.getRight());
    }

    static Pair<Integer, Integer> getDuplicatesNumberAndAverage(int[] a, int l) {
        Arrays.sort(a); // Sort array, O(n*log(n)) performance complexity
        int r = 0;
        for (int i = 0; i < l - 1; i++) { // additional loop, O(n)
            if (a[i] == a[i+1]) {
                r += 1;
            }
        }
        int m = 0;
        for (int i = 0; i < l; i++) { // additional loop, O(n)
            m = m + a[i];
        }
        m = m / l;
        return Pair.create(r, m);
    }

    static Pair<Integer, Integer> getDuplicatesNumberAndAverageV2(int[] inputArray, int arraySize) {
        Arrays.sort(inputArray);
        int r = 0;
        int m = 0;
        for (int i = 0; i < arraySize - 1; i++) {
            if (inputArray[i] == inputArray[i+1]) {
                r++;
            }
            m = m + inputArray[i];
        }
        m = (m + inputArray[arraySize-1]) / arraySize;
        return Pair.create(r, m);
    }

    static Pair<Integer, Integer> getDuplicatesNumberAndAverageV3(int[] inputArray) {
        Set<Integer> uniqueIntegers = new HashSet<>(); // A time complexity transformed to a memory complexity
        int notUniqueInt = 0;
        int average = 0;
        for (int j : inputArray) {
            if (!uniqueIntegers.add(j)) {
                notUniqueInt++;
            }
            average = average + j; // Sum up all the elements
        }
        average = average / inputArray.length;
        return Pair.create(notUniqueInt, average);
    }
}
