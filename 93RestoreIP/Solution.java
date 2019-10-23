// Constraints -
// 0 to 255
// no part should have leading 0s
// len = 4 to 12
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if(len<4 && len>16)
            return null;
        int ul = 3;
        
        List<String> res = new ArrayList<>();
        
        int start,end;
        String si,sj,sk,sl;
        for(int i = 1; i <= ul; i++){
            start=0;end=i;
            if(end>len) continue;
            
            si = s.substring(start,end);
            if(si.length() > 1 && si.charAt(0)=='0')
                continue;
            // System.out.println("si = "+si);
            int num = Integer.parseInt(si);
            if(num<0 || num>255)
                continue;
                
            ul = 3;
            for(int j = 1; j <= ul; j++){
                start=i;end=i+j;
                if(end>len) continue;
                
                sj = s.substring(start,end);
                if(sj.length() > 1 && sj.charAt(0)=='0')
                continue;
                // System.out.println("sj = "+sj);
                num = Integer.parseInt(sj);
                if(num<0 || num>255)
                     continue;
                
                for(int k = 1; k <= ul; k++){
                    start=i+j;end=i+j+k;
                    if(end>len) continue;
                    
                    sk = s.substring(start,end);
                    if(sk.length() > 1 && sk.charAt(0)=='0')
                    continue;
                    // System.out.println("sk = "+sk);
                    num = Integer.parseInt(sk);
                    if(num<0 || num>255)
                     continue;
                    for(int l = 1; l <= ul; l++){
                        start=i+j+k;end=i+j+k+l;
                        if(end>len) continue;
                        
                        sl = s.substring(start,end);
                        if(sl.length() > 1 && sl.charAt(0)=='0')
                        continue;
                         // System.out.println("sl = "+sl);
                        num = Integer.parseInt(sl);
                        if(num<0 || num>255)
                            continue;
                        String ss = si+"."+sj+"."+sk+"."+sl;
                        if(ss.length() == len+3){
                            res.add(ss);
                        // System.out.println("\n"+si+"."+sj+"."+sk+"."+sl);
                            
                        }
                    }
                }
            }
        }
     return res;   
    }
   
    
}
