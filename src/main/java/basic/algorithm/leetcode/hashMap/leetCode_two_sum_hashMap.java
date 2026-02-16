package basic.algorithm.leetcode.hashMap;

import java.util.*;

public class leetCode_two_sum_hashMap {

    //https://leetcode.com/problems/two-sum/description/

    public int[] twoSum(int[] nums, int target) {

        //(target - 현재 요소) 인 숫자가 hashMap에 존재하는지 검사

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int need = 0;
        int[] answer = new int[2];

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            need = target - num;

            if(map.containsKey(need)) {
                if(map.get(need) > 0){
                    answer[0] = i;
                    break;
                }
            }
        }

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == need) {
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}
