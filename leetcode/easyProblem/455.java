"
[문제요약]
아이 배열이 들어오고 , 쿠키 배열이 들어온다.
아이 배열의 원손느 각 아이가 원하는 쿠키 개수가 들어있고,
쿠키 배열은, 각 나눠줄 수 있는 쿠키의 개수가 들어있다.
아이<=쿠키 가 되야 나눠 줄 수 있고, (쿠키 묶음으로 나눠줌.)
최대 만족시킬 수 있는 아이의 수를 구하여라.


[해결방법]
둘다 정렬 한 뒤에,
앞에서부터 같이 탐색한다.
아이i<=쿠키j면 만족시킨거이므로, 둘다 1씩 증가한뒤에 하나를 세고,
아니면, 더 큰 쿠키가 필요하므로 j만 증가한다.
둘중에 하나라도 끝에 다다라면 종료하고, count 반ㅇ환.

Time complexity : O(nlgn+mlgm) n은 아이배열의 크기, m은 쿠키배열의 크기.
Space complexity : O(1)

[추가]

"
class Solution {
    int partition(int[] arr, int p, int q){
        int i=p;
        int k =arr[p];
        int j, temp;
        for (j=p+1 ; j<=q ; j++){
            if (arr[j]<=k){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[p];
        arr[p] = arr[i];
        arr[i] = temp;
        return i;
    }
    void quickSort(int[] arr, int p, int q){
        if (p<q){
            int r = partition(arr, p, q);
            quickSort(arr,p,r-1);
            quickSort(arr,r+1,q);
        }
    }
    public int findContentChildren(int[] g, int[] s) {
        int child = g.length;
        int cookie = s.length;
        quickSort(g, 0, child-1);
        quickSort(s, 0, cookie-1);
        int i=0, j=0;
        int count=0;
        while (i<child && j<cookie){
            if (g[i]<=s[j]){
                count++;
                i++;
                j++;
            }
            else
                j++;
        }
        return count;
    }
}
