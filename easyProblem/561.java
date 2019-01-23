'''
[문제요약]
2n개의 원소로 이루어진 배열이 들어오고,
2개씩 짝지어서 그 둘중에 작은 값들로 합을 구한다.
이 합의 최대값을 구하라.

[해결방법]
2개씩 짝지었을 때, 둘중에 작은게 커야 한다?
두개씩 짝 지을 때, 인접한 두개씩 짝지으면, 최대한 큰수의 낭비를 안하면서 작은값을 구할 수 있다.
그래서 퀵솔트로 정렬 하고
인덱스 0, 2, 4, 6 ... n-1/2까지의 합을 구해줬다.
시간은 퀵솔트nlgn + 배열 탐색 n = nlgn

Time complexity : O(nlgn)
Space complexity : O(n^2) 퀵솔트 스택;

[추가]

'''
class Solution {
    void quickSort(int[] nums, int p, int q)
    {
        if (p<q)
        {
            int r = partition(nums, p, q);
            quickSort(nums,p,r-1);
            quickSort(nums,r+1,q);
        }
    }
    int partition(int[] nums, int p, int q)
    {
        int i=p, j;
        int x= nums[p];
        int temp;
        for (j=i+1 ; j<=q ; j++)
        {
            if (nums[j]<=x)
            {
                i++;
                temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        temp = nums[p];
        nums[p]=nums[i];
        nums[i]=temp;
        return i;
    }
    public int arrayPairSum(int[] nums)
    {
        int len = nums.length;
        int sum=0;
        quickSort(nums,0,len-1);
        for (int i=0 ; i<=(len-1)/2 ; i++)
            sum+=nums[2*i];
        return sum;
    }
}
