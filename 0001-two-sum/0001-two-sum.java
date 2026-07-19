class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> nummap = new HashMap<>();
        int n = nums.length;
        for(int i =0; i<n ;i++){
            int comp = target - nums[i];
            if(nummap.containsKey(comp)) {
                return new int[]{nummap.get(comp), i};
            }
            nummap.put(nums[i], i);
        }
        return new int[]{};
    }
}