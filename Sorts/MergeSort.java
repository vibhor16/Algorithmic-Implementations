public class MergeSort {
    public static void main(String[] args) {
        int ar[] = {18,17,19,21,3};
        mergeS(ar,0,ar.length-1);
        for(int s:ar){
            System.out.println(s);
        }
    }
    public static void mergeS(int ar[],int l,int r){
        if(l<r){
            int m = (l+r)/2;
//            System.out.println("l="+l+" m=" + m +"  r="+r);
            mergeS(ar,l,m);
            mergeS(ar,m+1,r);
            merge(ar,l,m,r);
        }
    }
    public static void merge(int ar[], int l, int m, int r){
        int s1 = m-l+1;
        int s2 = r-m;

        int a[] = new int[s1];
        int b[] = new int[s2];

        int i = 0, j = 0, k =l;

        for(i = 0;i<s1;i++){
            a[i] = ar[l+i];
        }


        for(i = 0;i<s2;i++){
            b[i] = ar[m+1+i];
        }

        i = 0; j = 0;

        while(true){
            if(i>=s1 || j>=s2)
                break;

            if(a[i] <= b[j]){
                ar[k] = a[i];
                i++;
            } else {
                ar[k] = b[j];
                j++;
            }
            k++;
        }

        while(i<s1) {
            ar[k++] = a[i++];
        }

        while(j<s2){
            ar[k++] = b[j++];
        }

    }
}

