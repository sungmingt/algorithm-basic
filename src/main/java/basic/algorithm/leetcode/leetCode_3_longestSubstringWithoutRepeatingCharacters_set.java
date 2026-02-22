package basic.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class leetCode_3_longestSubstringWithoutRepeatingCharacters_set {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

    public int lengthOfLongestSubstring(String s) {

        //투포인터로 탐색
        //right 증가하면서 maxLength 갱신
        //동일 문자열 나오면 -> left를 하나씩 오른쪽으로 움직이면서, hashSet의 요소를 하나씩 빼준다.

        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right < s.length()) {
            char c = s.charAt(right);

            if(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }else {
                maxLength = Math.max(maxLength, right - left + 1);
                set.add(c);
                right++;
            }
        }

        return maxLength;
    }
}
