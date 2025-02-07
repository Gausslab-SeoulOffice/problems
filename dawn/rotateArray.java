class Solution {
    public void rotate(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();

        for(int num: nums){
            queue.addLast(num);
        }

        for(int i = 0;i< k; i++){
            queue.addFirst(queue.removeLast());
        }

        int index =0;
        for(int num: queue){
            nums[index] = num;
            index++;
        }

        //int length = nums.length;
        //for(int i = 0; i<k; i++){
        //    int lastNum = nums[length-1];
        //    for(int j = length-1; j > 0; j--){
        //        nums[j] = nums[j-1];
        //    }
        //    nums[0] = lastNum;
        //}
    }
}