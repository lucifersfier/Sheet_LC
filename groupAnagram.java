/*
 * given an array of Strings strs, group the anagrams together.
*/

import java.util.*;

public class groupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    //Demo
    public static void main(String[] args) {
        String[] array = {"eat","tea","nat","tan","bat"};   
        System.out.println(groupAnagrams(array));
    
    }
}
