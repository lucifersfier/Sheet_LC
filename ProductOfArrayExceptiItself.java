/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]
 */

public class ProductOfArrayExceptiItself {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        
        int left = 1;
        for(int i=0;i<n;i++){
            answer[i]=left;
            left*=nums[i];
        }
        int right = 1;
        for (int i=n-1;i>=0;i--){
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }     
}


/**
 * Left pass -> each answer[i] stores the product of all elements before i.
 * Right pass -> Multiply answer[i] with product of all elements after i.
 */