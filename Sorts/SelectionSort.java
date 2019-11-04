public class SelectionSort {
    public static void main(String[] args) {
        int ar[] = {18,17,19,21,3};

         selSort(ar);
        for(int s:ar){
            System.out.println(s);
        }
    }

    public static void selSort(int ar[]){

        for(int i=0;i<ar.length;i++){
            int max = ar[0];
            int ind = 0;
            for(int j=0;j<ar.length-i;j++){
                if(ar[j] > max){
                    max = ar[j];
                    ind = j;
                }
            }
            int k = ar[ar.length-1-i];
            ar[ar.length-1-i] = ar[ind];
            ar[ind] = k;

        }
    }
}

