import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
    	if (nums.length == 1) {
    		return nums[0];
    	}

        int majorityNum = nums.length / 2;
        
        Hashtable<Integer, Integer> counters = new Hashtable();
        for (int i = 0 ; i < nums.length ; ++i) {
            if (counters.containsKey(nums[i])) {
                int counter = counters.get(nums[i]);
                counters.put(nums[i], ++counter);
                if (counter > majorityNum) {
                	return nums[i];
                }
            } else {
                counters.put(nums[i], 1);
            }
        }

        return -1;
    }
}