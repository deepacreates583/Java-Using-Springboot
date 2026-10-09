private class stringToInteger {
        static class Solution {
            public int myAtoi(String s) {
                // 1. Initialize missing variables
                int i = 0;
                int n = s.length();
                int sign = 1;
                int result = 0;

                // 2. Discard leading whitespaces
                while (i < n && s.charAt(i) == ' ') {
                    i++;
                }

                // 3. Check for sign character
                if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                    sign = (s.charAt(i) == '-') ? -1 : 1;
                    i++;
                }

                // 4. Process digits
                while (i < n) {
                    char ch = s.charAt(i);

                    if (ch < '0' || ch > '9') {
                        break;
                    }

                    int digit = ch - '0';

                    // Check for 32-bit signed integer overflow/underflow
                    if (result > Integer.MAX_VALUE / 10 ||
                            (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }

                    result = result * 10 + digit;
                    i++;
                }

                return result * sign;
            }
        }
    }

public class stringToIntegerImpl extends stringToInteger { }

public static void main(String[] args) {
        stringToInteger.Solution solution = new stringToInteger.Solution();

        // Test case
        String testInput = "   -42";
        int output = solution.myAtoi(testInput);

        System.out.println("Input: " + testInput);
        System.out.println("Output: " + output);
    }



