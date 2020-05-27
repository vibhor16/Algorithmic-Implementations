
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int mid = 1;
        boolean res = false;
        while(left<=right){
            mid = (right - (right - left)/2);
            
           
            res = isBadVersion(mid);
                
            if(res){
                right = mid-1;
            } else {
                left = mid + 1;
            } 
        }
        
        if(res == false){
            mid = mid + 1;
        }
        return mid;
    }
}
