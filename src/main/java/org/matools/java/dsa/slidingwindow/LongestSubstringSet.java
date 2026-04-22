package org.matools.java.dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringSet {

    public static void main(String[] args) {
        String input = "abcabcbb";

        int result = lengthOfLongestSubstring(input);

        System.out.println("Input: " + input);
        System.out.println("Longest Substring Length: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}