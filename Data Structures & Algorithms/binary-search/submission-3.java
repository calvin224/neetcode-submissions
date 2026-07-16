class Solution {
    public int search(int[] nums, int target) {
        int median = nums[nums.length/2];
        System.out.println(median);
        if( median > target){
            for(int i = 0 ; i < nums.length/2; i ++){
                if( nums[i] == target){
                    return i;
                }
            }
        } else {
            for(int j = nums.length/2; j < nums.length; j++){
                if( nums[j] == target){
                    return j;
                }
            }
        }
        return -1;
    }
}
