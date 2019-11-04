public class QuickS {
    public static void main(String[] args) {
        int ar[] = {4,3,7,8,9,12,24};

        QuickSort(ar,0,ar.length - 1);
        for(int s: ar){
            System.out.println(s);
        }
    }
    public static void QuickSort(int ar[], int l, int r){
        if(l<r){
            int p = partition(ar,l,r);

            QuickSort(ar,l,p-1);
            QuickSort(ar,p,r);
        }
    }

    public static int partition(int ar[],int l, int r){
        int i = -1;
        int pivot = ar[r];
        for(int j=l;j<=r;j++){
            if(ar[j] < pivot){
                i++;
                int k = ar[i];
                ar[i] = ar[j];
                ar[j] = k;
            }
        }
        int k  =ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = k;
        return r;

    }
}

