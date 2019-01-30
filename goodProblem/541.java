"
[문제요약]
문자열과 k가 주어지면,
매 2k의 부분당 앞 k를 문자열을 뒤집어라.
즉 k뒤집고, k안뒤집고, k뒤집고 반복
마지막에 k보다 덜남으면 남은거만 다뒤집고, k보단 큰데 2k보다 작으면 앞 k개만 뒤집어라.

[해결방법]
다 해봄.

Time complexity : O(N);
Space complexity : O(N);

[추가]
class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
이렇게 아예 메소드 안빼고도 할 수 있다.
int i = start, j = Math.min(start + k - 1, a.length - 1);
이걸로 마지막 인덱스를 구할 수 있음.
또한,
while (i < j) {
    char tmp = a[i];
    a[i++] = a[j];
    a[j--] = tmp;
}
이걸로 다 바꾸기가 가능 함.
"
class Solution {
    char[] arr;

    void reverse(int p, int q){
        int k = (q-p)%2==0 ? (q-p)/2 : (q-p)/2+1;
        char temp;
        for (int i=0 ; i<k ; i++){
            temp = arr[p+i];
            arr[p+i]= arr[q-i];
            arr[q-i] = temp;
        }
    }

    public String reverseStr(String s, int k) {
        arr = s.toCharArray();
        for (int i=0 ; i<arr.length; i+=2*k){
            if (i+k-1>=arr.length)
                reverse(i, arr.length-1);
            else
                reverse(i, i+k-1);
        }
        return new String(arr);
    }
}
