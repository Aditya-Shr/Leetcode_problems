import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class arrays {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp = target - nums[i];
            if (map.containsKey(comp)){
                return new int[]{map.get(comp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int maxProfit(int prices[]){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else if(prices[i]-min>max){
                max = prices[i] - min;
            }
        }
        return max;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x:nums){
            if(set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }

    public boolean containsDuplicate_2(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;++i){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

//    public HashSet<ArrayList<Integer>> threesum(int[] nums){
//        HashSet<ArrayList<Integer>> res = new HashSet<>();
//        if(nums.length==0){
//            return new ArrayList<>();
//        }
//
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length-2;i++){
//            int j = i+1;
//            int k = nums.length-1;
//
//            while(j<k){
//                int sum = nums[i]+nums[j]+nums[k];
//                if(sum==0){
//                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
//                }
//                else if(sum<0){
//                    j++;
//                }else{
//                    k--;
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }

    public int maxSubArray(int nums[]){
        int sum = nums[0];
        int max_sum = nums[0];
        for(int i=1;i<nums.length;i++){
            max_sum = Math.max(max_sum+nums[i],nums[i]);
            sum = Math.max(sum,max_sum);
        }
        return sum;
    }
}
