class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int index, int dots,
                           StringBuilder path, List<String> res) {

        if (dots == 4 && index == s.length()) {
            res.add(path.substring(0, path.length() - 1)); // remove last dot
            return;
        }

        if (dots > 4) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            if ((part.startsWith("0") && part.length() > 1)
                    || Integer.parseInt(part) > 255)
                continue;

            int prevLen = path.length();
            path.append(part).append(".");
            backtrack(s, index + len, dots + 1, path, res);
            path.setLength(prevLen);
        }
    }
}
