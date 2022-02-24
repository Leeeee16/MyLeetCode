package com.algorithm.binarySearch;

/**
 * @author: lqy
 * @create: 2020/11/2
 * @description: LeetCode33
 * 给你一个升序排列的整数数组 nums ，和一个整数 target 。
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 *
 * !!!把比较好些的判断（target 落在有序的那部分）放在 if 的开头考虑，把剩下的情况放在 else 里面。!!!
  */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
//            int mid = left + (right - left) / 2;
            // 采用向上取整，[left, mid - 1], [mid, right]
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            }
//            if (nums[mid] > target) {
//                // 左区间为有序区间
//                if (nums[left] <= nums[mid]) {
//                    if (nums[left] > target) {  // 左区间所有元素都大于target，target肯定在右区间
//                        left = mid + 1;
//                    } else { // target在左区间
//                        right = mid - 1;
//                    }
//                } else { // 右区间为有序区间，右边元素肯定都大于target
//                    right = mid - 1;
//                }
//            } else { // mid值小于target
//                // 左区间为有序区间,说明左区间所有元素均小于target,target肯定在右区间
//                if (nums[left] <= nums[mid]) {
//                    left = mid + 1;
//                } else { // 右区间为有序区间
//                    if (nums[right] < target) { // 右区间元素均小于target,target在左区间
//                        right = mid - 1;
//                    } else { // target在右区间
//                        left = mid + 1;
//                    }
//                }
//            }
            if(nums[mid] < nums[right]) {  // 右区间有序
                // target在有序区间内
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                }else {
                    right = mid - 1;
                }
            }else { // 左区间有序
                // [left, mid] 有序，但是为了和上一个 if 有同样的收缩行为，
                // 我们故意只认为 [left, mid - 1] 有序
                // 当区间只有 2 个元素的时候 int mid = (left + right + 1) >>> 1; 一定会取到右边
                // 此时 mid - 1 不会越界，就是这么刚刚好
                // target在有序区间内
                if(nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                }else {
                    left = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        LeetCode33 lc = new LeetCode33();
        int[] nums = {5,1};
        int target = 5;
        int res = lc.search(nums, target);
        System.out.println(res);
    }
}
