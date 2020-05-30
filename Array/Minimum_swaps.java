//https://www.youtube.com/watch?v=f7IIW0HVUcQ
//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
//minimum number of swaps necessary to put and unsorted array of CONSECUTIVE integers 
//into ascending order.
public class Minimum_swaps{
	static int minimumSwaps(int[] arr) {
        int swap = 0;
        boolean[] visited = new boolean[arr.length];
        //System.out.println(visited[0]);

        for(int i = 0; i < arr.length; i++){
            if(visited[i]){
                continue;
            }else{
                //visited[i] = true;
                int index = i;
                int count = 0;
                while(!visited[index]){
                    count++;
                    visited[index] = true;
                    index = arr[index] - 1;
                }
				//one cycle, x edges, x - 1 is the minimum swap.
                swap += count - 1;
            }
        }
        return swap;

    }
	
}