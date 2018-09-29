import org.junit.Assert;

/**
 *  Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,1]
 Output: 1
 Example 2:

 Input: [4,1,2,1,2]
 Output: 4
 *
 */

public class SingleNumber {
    public int findSingleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            throw new IllegalStateException("Input is null or empty");
        int single = 0;
        for(int e : nums) {
            single ^= e;
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] single_test = {1, 2, -3, -3, 2, 1, 9};
        Assert.assertEquals(singleNumber.findSingleNumber(single_test), 9);
    }
}
