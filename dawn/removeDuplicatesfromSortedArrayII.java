class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int index = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                count =0;
                nums[index] = nums[i];
                index++;
            }else{
                count++;
                if(count <=1){
                    nums[index] = nums[i];
                    index++;
                }
            }
        }
        return index;
    }
}