import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) 
            return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) return result;

        // Frequency map for the words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // Try each possible starting point within one word length
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            // Move the right pointer in steps of word length
            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // If word appears too many times, move left pointer
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words matched
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    // Reset if invalid word
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}
