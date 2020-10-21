/*
    面试题 17.10. 主要元素
        数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

        示例 1：

        输入：[1,2,5,9,5,9,5,5,5]
        输出：5


        示例 2：

        输入：[3,2]
        输出：-1


        示例 3：

        输入：[2,2,1,1,1,2,2]
        输出：2
*/


public class LeeCodeMS17_10 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int taotal = 1;
        int people = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (people != nums[i]) {
                taotal--;
            } else {
                taotal++;
            }
            if (taotal < 0) {
                people = nums[i];
                taotal = 1;
            }
        }

        System.out.println(taotal > 0 ? people : -1);


    }
}
