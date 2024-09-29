import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 给你一个由无重复正整数组成的集合 nums，请你找出并返回其中最大的整除子集 answer，
 * 子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0，或 answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 10^9
 * nums 中的所有整数互不相同
 */
class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList<>(); // 处理空数组情况

        Arrays.sort(nums);

        // 第 1 步：动态规划找出最大子集的个数
        int[] dp = new int[len];
        int[] prevIndex = new int[len]; // 记录前一个元素的索引
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndex, -1); // 初始化为-1，表示没有前驱
        int maxSize = 1;
        int maxValIndex = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prevIndex[i] = j; // 记录前一个元素的索引
                    }
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValIndex = i; // 更新最大子集的最后一个元素的索引
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<>();
        for (int i = maxValIndex; i >= 0; i = prevIndex[i]) {
            res.add(nums[i]);
            if (prevIndex[i] == -1) break; // 如果没有前驱，结束
        }
        return res;
    }
}


