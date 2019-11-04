public class HeapSort {
    public static void main(String[] args) {
        int ar[] = {9,2,3,4,10,12,45};

        for(int i=ar.length/2-1; i>=0;i--){
            heapify(ar,ar.length,i);
        }


        for (int i=ar.length - 1;i>=0; i--){
            int k =ar[0];
            ar[0] = ar[i];
            ar[i] = k;
            heapify(ar,i,0);
        }

        for(int s:ar){
            System.out.println(s);
        }

    }
    public static void heapify(int ar[], int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && ar[l] > ar[largest])
            largest = l;

        if(r<n && ar[r] > ar[largest])
            largest = r;

        if(largest != i){
            int k = ar[largest];
            ar[largest] = ar[i];
            ar[i] = k;
            heapify(ar,n,largest);
        }

    }
}

