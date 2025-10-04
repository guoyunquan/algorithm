package org.gyq.doublePointer;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * <p>示例 1:</p>
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * </p>
 *
 *
 *
 * <p>示例 2:</p>
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * </p>
 */
public class Top_Four {
    //idea，开两个指针 curr当前指定位置指针快指针 和noZeroBoundary非0边界指针
    //快指针一直往前遍历 遇到非0的数就和noZeroBoundary进行交换 交换后共同+1 然后再往前走，继续交换
    public void moveZeroes(int[] nums) {
        int curr = 0;
        int noZeroBoundary = 0;

        while (curr < nums.length) {
            if (nums[curr] == 0) {
                curr++;
            } else {
                int temp = nums[curr];
                nums[curr] = nums[noZeroBoundary];
                nums[noZeroBoundary] = temp;
                curr++;
                noZeroBoundary++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Top_Four topFour = new Top_Four();
        topFour.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

}
