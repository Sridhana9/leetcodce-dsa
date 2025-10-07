import java.util.*;

class Solution {
    private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        backtrack(res, digits, "", 0);
        return res;
    }

    private void backtrack(List<String> res, String digits, String path, int index) {
        if (index == digits.length()) {
            res.add(path);
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            backtrack(res, digits, path + c, index + 1);
        }
    }
}
