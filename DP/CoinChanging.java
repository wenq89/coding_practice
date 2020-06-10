// 2020 JUNE 9TH - 10PM
//https://www.hackerrank.com/challenges/coin-change/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
//dynamic programming explaination. We need to set a state to be a initial state.
//https://www.topcoder.com/community/competitive-programming/tutorials/dynamic-programming-from-novice-to-advanced/
public static long getWays(int n, List<Long> c) {
// Write your code here
	Collections.sort(c);
	//long ln = n;
	if(n < c.get(0))
		return 0;

	//i is the row, the number of coins we are going to use.
	//the col is ways of using only i coins.
	long[][] ways = new long[c.size()][n+1];
	
	//initialize the first line.(only use one coin)
	for(int i = 0; i<n+1; i++){
		if(i%c.get(0) == 0)
			ways[0][i] = 1;
	}

	for(int i = 1; i < c.size(); i++){
		for(int j = 0; j < n+1; j++){
			if(j < c.get(i)){
				// if the sum is less the value of the coin, then just the ways from the previous numbers of coins.
				ways[i][j] = ways[i-1][j];
			}else{
				// top + left.
				ways[i][j] = ways[i-1][j] + ways[i][j-c.get(i).intValue()];
			}
		}
	}

	return ways[c.size()-1][n];
}