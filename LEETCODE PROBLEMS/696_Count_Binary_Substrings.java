class Solution {
    public int countBinarySubstrings(String s) {
        int r = 0, p = 0, c = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                c++;
            } else {
                p = c;
                c = 1;
            }
            if (c <= p) {
                r++;
            }
        }
        return r;
    }
}
