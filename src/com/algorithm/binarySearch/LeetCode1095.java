package com.algorithm.binarySearch;

interface MountainArray {
    public int get(int index);

    public int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] arr;
    private int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    @Override
    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.size;
    }

}


public class LeetCode1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mountainTop = peekMountainTop(mountainArr);
        int res = findLeft(mountainArr, 0, mountainTop, target);
        if (res != -1) {
            return res;
        } else {
            return findRight(mountainArr, mountainTop, mountainArr.length() - 1, target);
        }
    }

    // 在做递增区间找target
    public int findLeft(MountainArray arr, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) == target) {
                return mid;
            }
            if (arr.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (arr.get(lo) == target) {
            return lo;
        } else { // 不在左区间
            return -1;
        }
    }

    public int findRight(MountainArray arr, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) == target) {
                return mid;
            }
            if (arr.get(mid) > target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (arr.get(lo) == target) {
            return lo;
        } else {
            return -1;
        }
    }

    // 找山顶坐标
    public int peekMountainTop(MountainArray arr) {
        int len = arr.length();
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,4,2,1};
        MountainArrayImpl mountain = new MountainArrayImpl(arr);
        LeetCode1095 lc = new LeetCode1095();
        int res = lc.findInMountainArray(4, mountain);
        System.out.println(res);
    }
}
