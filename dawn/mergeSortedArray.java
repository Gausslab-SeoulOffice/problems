class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> allList = new ArrayList();
        if (m != 0) {
            for (int i = 0; i < m; i++) {
                allList.add(nums1[i]);
            }
        }
        if (n != 0) {
            for (int j = 0; j < n; j++) {
                allList.add(nums2[j]);
            }
        }
        Collections.sort(allList);
        for(int k = 0; k < nums1.length; k++){
            nums1[k]=allList.get(k);
        }
    }
}