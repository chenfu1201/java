package chenfu;

import org.junit.Test;

import java.util.Arrays;

import static chenfu.util.Print.*;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/18 12:16
 */
public class SortTest {

    /**
     * 冒泡排序:从小到大
     */
    @Test
    public void run1() {
        Integer[] numbers = new Integer[]{43, 45, 12, 23, 546, 45, 634, 123, 34, 2};
        print(numbers);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        print("sort:", numbers);
    }

    /**
     * 选择排序：从小到大
     */
    @Test
    public void run2() {
        Integer[] numbers = new Integer[]{43, 45, 12, 23, 546, 45, 634, 123, 34, 2};
        print(numbers);
        for (int x = 0; x < numbers.length; x++) {
            for (int y = x + 1; y < numbers.length; y++) {
                if (numbers[x] > numbers[y]) {
                    int temp = numbers[y];
                    numbers[y] = numbers[x];
                    numbers[x] = temp;
                }
            }
        }
        print("sort:", numbers);
    }

    @Test
    public void run3() {
        Integer[] numbers = new Integer[]{43, 45, 12, 23, 546, 45, 634, 123, 34, 2};
        print(numbers);
        Arrays.sort(numbers);
        print("sort", numbers);
    }
}
