package task1;

import org.graalvm.collections.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ApplicationTest {

    /**
     * Generates 10 times different arrays. Include random input, don't use it on a production
     */
    @Test
    void getDuplicatesNumberAndAverage() {
        for (int i = 0; i < 10; i++) {
            int length = new Random().nextInt(10001);
            int[] inputArray = generateRandomArray(length);

            Pair<Integer, Integer> result1 = Application.getDuplicatesNumberAndAverage(inputArray, length);
            Pair<Integer, Integer> result2 = Application.getDuplicatesNumberAndAverageV2(inputArray, length);
            Pair<Integer, Integer> result3 = Application.getDuplicatesNumberAndAverageV3(inputArray);

            Assertions.assertEquals(result1, result2);
            Assertions.assertEquals(result1, result3);
        }
    }

    int[] generateRandomArray(int length) {
        return new Random().ints(length).toArray();
    }
}
