class Solution {
    public int rob(int[] nums) {

        int first = 0;

        int second = 0;

        for( int money : nums){

            int current = Math.max(second, first + money);

            first  = second;

            second = current;
        }

        return second;
        
    }
}
