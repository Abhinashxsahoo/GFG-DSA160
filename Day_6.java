/*Majority Element II
Difficulty: MediumAccuracy: 48.1%Submissions: 166K+Points: 4Average Time: 15m
You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

Note: The answer should be returned in an increasing format.

Examples:

Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.
Input: arr[] = [1, 2, 3, 4, 5]
Output: []
Explanation: o candidate occur more than n/3 times.
Constraint:
1 <= arr.size() <= 106
-109 <= arr[i] <= 109

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)*/

class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        int n= nums.length;
        int ele1= -1, ele2= -1;
        int cnt1=0, cnt2=0;
        for (int ele: nums){
            
            if (ele1== ele){
                cnt1++;
            }else if(ele2==ele){
                cnt2++;
            }else if(cnt1==0){
                ele1=ele;
                cnt1++;
            }else if(cnt2==0){
                ele2=ele;
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
            List<Integer> res = new ArrayList<>();
            cnt1=0;
            cnt2=0;
            
            for(int i: nums){
                if(ele1==i) cnt1++;
                if(ele2==i) cnt2++;
                
            }
            
            if(cnt1> n/3) res.add(ele1);
            if(cnt2> n/3 && ele1!=ele2) res.add(ele2);
            
            if(res.size()==2 && res.get(0)> res.get(1)){
                int temp= res.get(0);
                res.set(0,res.get(1));
                res.set(1,temp);
            }
            
            return res;
        
    }
}
