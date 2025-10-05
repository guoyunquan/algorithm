package org.gyq.doublePointer;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class Top_Five {
    /**
     * 最大面积的公式 i的长度和指针对应长度的最小值 x （指针下标-i的下标）
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;
        //定义一个指针，用于快速遍历

        for (int i = 0; i < height.length; i++) {
            int index = i + 1;
            while (index < height.length) {
                int value = Math.min(height[i], height[index]) * (index - i);
                result = Math.max(result, value);
                index++;
            }

        }
        return result;

    }

    /**
     * 双指针 数组两边 每次谁短就移动谁
     *
     * @param height 高度数组
     * @return 面积最大值
     */
    public int maxAreaTwo(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currArea,maxArea);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] num = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Top_Five topFive = new Top_Five();
        int i = topFive.maxAreaTwo(num);
        System.out.println(i);
    }


}
