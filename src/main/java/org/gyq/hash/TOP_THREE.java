package org.gyq.hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。
 * 它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 示例 3：
 * 输入：nums = [1,0,1,2]
 * 输出：3
 */
public class TOP_THREE {
    /**
     * 暴力解法 最low 时间复杂度最大
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int index = 1;
        HashSet<Integer> set = new HashSet<>();
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return 1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                index++;
                set.add(index);
            }else {
                index = 1;
                set.add(index);
            }
        }
        return Collections.max(set);
    }



    public static void main(String[] args) {
        TOP_THREE topThree = new TOP_THREE();
        int[] array = {1,0,1,2};
        int i = topThree.longestConsecutive(array);
        System.out.println(i);
    }
}
