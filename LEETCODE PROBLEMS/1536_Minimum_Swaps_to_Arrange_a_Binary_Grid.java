class Solution {
    public int minSwaps(int[][] g) {
        int n = g.length;  // size of grid
        List<Integer> l = new ArrayList<>();

        // count trailing zeros for each row
        for (int[] r : g) {
            int c = 0;
            for (int j = n - 1; j >= 0 && r[j] == 0; j--) {
                c++;
            }
            l.add(c);
        }

        int s = 0;  // total swaps

        // place rows one by one
        for (int i = 0; i < n; i++) {
            int j;

            // find a row that has enough trailing zeros
            for (j = 0; j < l.size(); j++) {
                if (l.get(j) >= n - 1 - i) break;
            }

            if (j == l.size()) return -1;  // not possible

            s += j;        // add swaps needed
            l.remove(j);   // remove used row
        }

        return s;
    }
}