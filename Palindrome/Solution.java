// Logic: Reverse half the number

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        
        if(x>=0 && x<=9) return true;
        
        int xcopy=x,size = 0;
        while(xcopy>0){
            size++;
            xcopy/=10;
        }
        
        int rev = 0;
        xcopy = x;
        for(int i=1;i<=size/2;i++){
            int a = xcopy%10;
            rev = rev*10 + a;
            xcopy /= 10;
        }
        
        if(size%2!=0){
            xcopy/=10;
        }
        
        if(xcopy == rev){
            return true;
        }
        return false;
    }
}
