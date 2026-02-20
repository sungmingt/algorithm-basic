package basic.algorithm.leetcode;

import java.util.*;

public class leetCode_217_containsDuplicate_set {

    //https://leetcode.com/problems/contains-duplicate/description/

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];

            if(set.contains(num)) return true;

            set.add(num);
        }

        return false;
    }
}
