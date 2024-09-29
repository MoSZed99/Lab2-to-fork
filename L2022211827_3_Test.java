import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class test {
    Solution3 solution = new Solution3();

    /**
     * 测试目的：测试基本功能，输入一个简单的数组
     * 用到的测试用例：nums = [1, 2, 3]
     */
    @Test
    public void testBasicFunctionality() {
        int[] nums = {1, 2, 3};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertFalse(result.contains(3)); // 3不能与1和2构成整除关系
    }

    /**
     * 测试目的：测试所有元素均可构成整除关系的情况
     * 用到的测试用例：nums = [1, 2, 4, 8]
     */
    @Test
    public void testAllDivisible() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertEquals(4, result.size()); // 期望返回完整的子集
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(4));
        assertTrue(result.contains(8));
    }

    /**
     * 测试目的：测试没有可构成整除关系的情况
     * 用到的测试用例：nums = [3, 5, 7]
     */
    @Test
    public void testNoDivisibleSubset() {
        int[] nums = {3, 5, 7};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertEquals(1, result.size()); // 每个元素都是独立的
    }

    /**
     * 测试目的：测试包含一个元素的情况
     * 用到的测试用例：nums = [10]
     */
    @Test
    public void testSingleElement() {
        int[] nums = {10};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertEquals(1, result.size());
        assertTrue(result.contains(10));
    }

    /**
     * 测试目的：测试空数组的情况
     * 用到的测试用例：nums = []
     */
    @Test
    public void testEmptyArray() {
        int[] nums = {};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertTrue(result.isEmpty()); // 期望返回空列表
    }
}