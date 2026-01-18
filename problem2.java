
// Time Complexity : O(4^n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
we use backstack to solve this one, with inital check we determine if the a square is possible or not
then reverse sort the array and start DFS with backtracking ( a seprate reverse funciton is written as custom comparator for this problem is
not working in LC)

idea here is to itterate over all 4 side of square and try to put in the match
if it does not fill one try next

in the end if idx is equal to length of matchstick array and all 4 sides of square is equal to the calcauted
side we return true;

*/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }
        if (sum % 4 != 0)
            return false;
        int side = sum / 4;
        int[] square = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks, 0, matchsticks.length - 1);
        return backtracking(matchsticks, 0, square, side);

    }

    private boolean backtracking(int[] matchsticks, int idx, int[] square, int side) {
        // base
        if (idx == matchsticks.length) {
            if (square[0] == side && square[1] == side && square[2] == side && square[3] == side)
                return true;
            return false;
        }

        // logic
        for (int i = 0; i < 4; i++) {
            int curSide = square[i];
            if (curSide + matchsticks[idx] <= side) {
                // action
                square[i] += matchsticks[idx];
                // recurse
                if (backtracking(matchsticks, idx + 1, square, side))
                    return true;
                // backtrack
                square[i] -= matchsticks[idx];
            }
        }
        return false;
    }

    private void reverse(int[] matchsticks, int low, int high) {
        while (low < high) {
            int temp = matchsticks[low];
            matchsticks[low] = matchsticks[high];
            matchsticks[high] = temp;
            low++;
            high--;
        }

    }
}