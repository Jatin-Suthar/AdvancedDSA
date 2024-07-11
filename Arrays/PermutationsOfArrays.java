package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArrays {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        recur(nums, new ArrayList<>(), 0, visited);
        return res;
    }

    private void recur(int[] nums, List<Integer> list, int i, boolean[] visited) {
        if(i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(!visited[i]) {
            visited[i] = true;
            list.add(nums[i]);
            recur(nums, new ArrayList<>(list), i + 1, visited);
            list.remove(list.size() - 1);
        }
        recur(nums, new ArrayList<>(list), i + 1, visited);
    }

}
