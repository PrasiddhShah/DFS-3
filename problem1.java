
// Time Complexity : O(n)
// Space Complexity :O(1)(limited confusing digits)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
We will use a map to store the number as key and its mirror conuterpart as value
we do DFS start from 0, can start creating the number, we call dfs on the new created number 
check its confusing mean reverse number is the same as the actual number if yes increase the count,
is cur number is bigger then n return
*/

class Solution {
    int count;
    HashMap<Integer, Integer> map;

    public int confusingNumberII(int n) {
        this.map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        dfs(0l, n);
        return count;
    }

    private void dfs(long cur, int n) {
        if (cur > n) {
            return;
        }
        // logic
        if (isConfusing(cur)) {
            count++;
        }
        for (int num : map.keySet()) {
            long newNum = cur * 10 + num;
            if (newNum != 0l) {
                dfs(newNum, n);
            }
        }
    }

    private boolean isConfusing(long cur) {
        long temp = cur;
        long res = 0l;
        while (cur > 0) {
            int digit = (int) cur % 10;
            res = res * 10 + map.get(digit);
            cur = cur / 10;
        }
        return res != temp;
    }
}