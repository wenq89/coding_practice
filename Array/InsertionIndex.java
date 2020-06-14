//https://leetcode.com/problems/search-insert-position/
// logn solution. O(n) is trivial

class Solution {
    public int searchInsert(int[] nums, int target) {
        //sanity check
        if(nums == null || nums[0] >= target) return 0;
        if(nums[nums.length - 1] < target) return nums.length;
        
        int h = nums.length -1;
        int l = 0;
        int m = 0;
        
        //stop condition
        while(h - l > 1){
            m = (h+l)/2;
            if(nums[m] > target)
                h = m;
            else if(nums[m] < target)
                l = m;
            else
                return m;
        }
        
        return h;
    }
}


// 1 2 3 4 6 7 8 9 10 
    
//     1 2 3	1 2 3
//     0		4
    
//     5
    
//     low high mid val
//     0   8   4   6   > 5     midVal > target -> high = mid
//     0   4   2   3   < 5     midVal < target -> low = mid
//     2   4   3   4   < 5
//     3   4   4   6   > 5
    
    
    
    
    
    
    