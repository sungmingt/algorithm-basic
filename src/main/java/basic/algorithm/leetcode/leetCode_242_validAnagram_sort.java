package basic.algorithm.leetcode;

public class leetCode_242_validAnagram_sort {

    //https://leetcode.com/problems/valid-anagram/description/

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] alphabets = new int[26];

        for(int i=0; i<s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<alphabets.length; i++) {
            if(alphabets[i] != 0) return false;
        }

        return true;
    }
}
