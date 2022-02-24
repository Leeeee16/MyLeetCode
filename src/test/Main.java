package test;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        MySingleton mySingleton1 = MySingleton.getInstance();
        MySingleton mySingleton2 = MySingleton.getInstance();
        System.out.println(mySingleton1 == mySingleton2);

        int[] nums = new int[]{4, 3, 2, 3, 4, 5, 6, 7, 1, 1, 1, 1};
        QuickSort qs = new QuickSort();
        qs.quick_sort(nums);
        System.out.println(Arrays.toString(nums));



        List<Integer> list = new ArrayList<>();
        list.add(1);
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(res));

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
    }


}

class QuickSort {

    private static final Random RANDOM = new Random();

    public void quick_sort(int[] nums) {
        quick_sort(nums, 0, nums.length - 1);
    }

    private void quick_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int idx = partition(nums, left, right);
        quick_sort(nums, left, idx);
        quick_sort(nums, idx + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIdx = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIdx);
        int pivot = nums[left];
        int lt = left;
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }
            while (gt > left && nums[gt] > pivot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}

class MySingleton {
    private static MySingleton mySingleton;
    private MySingleton(){}
    public static MySingleton getInstance() {
        if (mySingleton == null) {
            synchronized(MySingleton.class) {
                if (mySingleton == null) {
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }
}

