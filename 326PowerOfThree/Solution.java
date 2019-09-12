// Logic: Convert n to base 3 and check if 1 is followed by all 0s. 
// 3 in base 3 is 10, 9 is 100, 27 is 1000
class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n,3).matches("^10*$");
    }
}
