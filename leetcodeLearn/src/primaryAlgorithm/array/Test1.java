package primaryAlgorithm.array;

/**
 * 删除排序数组中的重复项
 */
public class Test1 {
	public static void main(String[] args) {
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		int i;
		for (i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					continue;
				} else {
					nums[i] = nums[j];
				}
			}
		}
		return i;
	}

}
