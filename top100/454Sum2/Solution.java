// Logic:   Sum in n2 for A and B, check for -ve sum of C and D  
class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            HashMap<Integer, Integer> map1 = new HashMap<>();

            int sum, val=0;
            for(int i=0;i<A.length;i++){
                for(int j=0;j<B.length;j++){
                    sum = A[i] + B[j];
                    val = map1.getOrDefault(sum,0) + 1;
                    map1.put(sum,val);         
                }            
            }

            int count = 0;
            for(int i=0;i<C.length;i++){
                for(int j=0;j<D.length;j++){
                    count += map1.getOrDefault(-(C[i]+D[j]),0);  
                }            
            }

            return count;

        }
    }
