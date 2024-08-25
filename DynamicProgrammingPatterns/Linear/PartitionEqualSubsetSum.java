package DynamicProgrammingPatterns.Linear;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSumSolution solution = new PartitionEqualSubsetSumSolution();
        System.out.println(solution.canPartition(new int[]{1,2,3,5}));
    }

}

class PartitionEqualSubsetSumSolution {
    Integer[][] dp;
    public boolean canPartition(int[] nums) {
        return recur(nums, 0, nums.length-1, 0, 0, new boolean[nums.length], 0);
    }
    public boolean recur(int[] nums, int s, int e, int lSum, int rSum, boolean[] visited, int count) {
        if(s>=nums.length && e<0) {
            return (count==nums.length && lSum==rSum);
        }
        if(s<nums.length) {
            if(!visited[s]) {
                visited[s]=true;
                if(recur(nums, s+1, e, lSum+nums[s], rSum, visited, count+1)) {
                    return true;
                }
                visited[s]=false;
            }
            if(recur(nums, s+1, e, lSum, rSum, visited, count)) {
                return true;
            }
        }
        if(e>=0) {
            if(!visited[e]) {
                visited[e]=true;
                if(recur(nums, s, e-1, lSum, rSum+nums[e], visited, count+1)) {
                    return true;
                }
                visited[e]=false;
            }
            if(recur(nums, s, e-1, lSum, rSum, visited, count)) {
                return true;
            }
        }
        return false;
    }
}