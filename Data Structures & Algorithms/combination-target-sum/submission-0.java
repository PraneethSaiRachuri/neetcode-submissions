class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        backtracking(nums, target, 0, current, result);

        return result;

    }

    public void backtracking(int[] nums, int remaining, int start, List<Integer> current, List<List<Integer>> result){

        if(remaining == 0){

            result.add(new ArrayList<>(current));

            return;

        }

        if(remaining < 0 ){

            return;

        }

        for(int i = start; i < nums.length; i++){

            current.add(nums[i]);

            backtracking(nums, remaining - nums[i], i, current, result);

            current.remove(current.size() - 1);

        }
    }


}
