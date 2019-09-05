// Logic: Always reverse uptill 9 digits, the 10th digit is to be compared with the 10th of max digit

class Solution {
    public int reverse(int x) {
        int rev = 0, res = 0;
        boolean neg = x < 0? true:false;
        if(neg){
            x = x*-1;
        }
        
        int xcopy = x, remMSB = 0;

//If the num is 10 digit, extract the MSB which becomes the LSB for the reversed num
        if(x >= 1000000000) { 
            remMSB = xcopy/1000000000;
            xcopy%=1000000000;
        }
        
        while(xcopy>0){
          int a = xcopy%10;
          rev = rev * 10 + a;
          xcopy=xcopy/10;
        }
        res = rev;
        
        if(x >= 1000000000) {
            int max = 0;
            
            if(neg) {
                max = (int) Math.pow(2,31);
            } else {
                max = (int) Math.pow(2,31) - 1;
            }
              
               if(rev < max/10) {
                   rev = rev * 10 + remMSB;
                   res = rev;
               } else if(rev == max/10) {
                   if(remMSB > max%10){
                       res = 0;
                   } else {
                       rev = rev * 10 + remMSB;
                       res = rev;
                   }
               } else if(rev > max/10){
                   res = 0;
               }
            }
        
        if(neg)
            res *= -1;
        
        return res;
    }
}
