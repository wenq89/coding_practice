//https://www.youtube.com/watch?v=86CQq3pKSUw
//optimal solution to Maximum Subarray Problem (Kadane's Algorithm)
public class Maximum_subarray {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        int[] result = new int[2];
        int globalMax = arr[0];
        int currMax = arr[0];
        result[1] = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > 0){
                if(result[1] < 0)
                    result[1] = arr[i];
                else
                    result[1] += arr[i];
            }else{
                if(result[1] < arr[i])
                    result[1] = arr[i];
            }
                

            currMax = Math.max(arr[i], currMax+arr[i]);
            if(currMax > globalMax)
                globalMax = currMax;
        }

        result[0] = globalMax;

        return result;

    }
	
/*
Input (stdin)
Download
2
4
1 2 3 4
6
2 -1 2 3 4 -5
Expected Output
Download
10 10
10 11
*/