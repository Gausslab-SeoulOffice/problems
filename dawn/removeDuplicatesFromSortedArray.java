class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        ArrayList<Integer> newList = new ArrayList<>(numSet);
        Collections.sort(newList);
        for (int j = 0; j < numSet.size(); j++) {
            nums[j] = newList.get(j);
        }
        return numSet.size();
    }
}