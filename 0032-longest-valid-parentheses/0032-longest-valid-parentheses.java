import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
        // Stack stores indices of characters
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Base index to serve as the boundary for valid substrings
        stack.push(-1);
        
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                
                if (stack.isEmpty()) {
                    // Current ')' has no matching '(', set new boundary index
                    stack.push(i);
                } else {
                    // Valid substring length = current index - last unmatched boundary index
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}