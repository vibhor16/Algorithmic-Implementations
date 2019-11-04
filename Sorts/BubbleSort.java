public class BubbleSort {
    public static void main(String[] args) {
        int ar[] = {18,17,19,21,3};

        bubble(ar);
        for(int s:ar){
            System.out.println(s);
        }
    }
    public static void bubble(int ar[]){
        for(int i=1;i<=ar.length;i++){
            for(int j=0;j<ar.length-i-1;j++){
                if(ar[j+1]<ar[j]){
                    int k = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] =k;
                }
            }
        }

    }
}

