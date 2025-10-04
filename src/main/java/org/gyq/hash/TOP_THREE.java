package org.gyq.hash;

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
     * 用hash解法
     *
     * @param nums 入参
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int result = 0;
        //把所有的值存入到hash表中
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int index = 1;
            int curr = i;
            while (set.contains(curr + 1)) {
                index++;
                curr++;
            }
            result = Math.max(result, index);
        }
        return result;

    }


    public static void main(String[] args) {
       int[] nums = {100, 4, 200, 1, 3, 2};
        TOP_THREE topThree = new TOP_THREE();

        int i = topThree.longestConsecutive(nums);
        System.out.println(i);
    }
}
