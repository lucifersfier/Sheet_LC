/*
 * Given an integer array num, return true if any value appears atleast twice in the array
 * and return false if every element is distinct.
 */

import java.util.HashSet;

public class containsDuplicate {
    public static boolean checkDuplicate(int[] nums){
        HashSet <Integer> seen = new HashSet<>();
        for(int num : nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        boolean res = checkDuplicate(nums);
        System.out.println(res);
    }
}
