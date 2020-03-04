// "static void main" must be defined in a public class.
public class Main {
    //heap sort
    // build heap n/2 -> 0 inclusive and swap to end then heapify
    // implement heapify
    public static void heapSort(int[] arr){
        //build
        int len = arr.length;
        for(int i = len/2; i>=0; i--)
            heapify(arr, len, i);
        
        //swap max in the heap to last index, then heapify rest items
        for(int i = len - 1; i >= 0 ; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int[] arr, int len, int parent){
        // two childrens indices
        int lChild = parent * 2 + 1;
        int rChild = parent * 2 + 2;
        int temp = parent;
        
        if( lChild < len && arr[lChild] > arr[parent])
            parent = lChild;
        if( rChild < len && arr[rChild] > arr[parent])
            parent = rChild;
        
        if( parent != temp){
            int dummy = arr[temp];
            arr[temp] = arr[parent];
            arr[parent] = dummy;
            
            heapify(arr, len, parent);
        }
    
    }
    
    public static void main(String[] args) {
        int[] arr= {7,2,5,4,1,8,9,6,3};
        //mergeSort(arr, 0 , arr.length - 1);
        heapSort(arr);
        for(int x: arr)
            System.out.println(x);
    }
    
    public static void mergeSort(int[] arr, int start, int end){
        
        if(start < end){
            int mid = start + (end - start)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            
            merge(arr, start, mid, end);
        }
    }
    
    public static void merge(int[] arr, int l, int mid, int r){
        int lSize = mid - l + 1;
        int rSize = r - mid;
        
        int[] lArr = new int[lSize];
        int[] rArr = new int[rSize];
        
        //copy
        for(int i = 0; i < lSize; i++)
            lArr[i] = arr[l+i];
        for(int i = 0; i < rSize; i++)
            rArr[i] = arr[mid+1+i];
        
        int i = 0; int j = 0;
        int k = l;
        
        while( i < lSize && j < rSize){
            if(lArr[i] >= rArr[j]){
                arr[k] = rArr[j];
                j++;
            }else{
                arr[k] = lArr[i];
                i++;
            }
            k++;
        }
        
        while( i < lSize ){
            arr[k] = lArr[i];
            i++;
            k++;
        }
        
        while( j < rSize ){
            arr[k] = rArr[j];
            j++;
            k++;
        }
        
    }
}
