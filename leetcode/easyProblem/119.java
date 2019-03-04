"
[문제요약]
파스탈의 삼각형 만들기
      1
    1   1
  1   2   1
1   3   3   1
이런식으로 몇번째 줄에 있는거 리스트로 반환.

space complexity 는 O(k)여야 한다.

[해결방법]
배열 두개 만들어서, (전의 정보, 지금의 정보)
for (j=1 ; j<=i-1 ; j++){
    to[j] = from[j-1] + from[j];
}
로 해 줌.
다음 줄에 있는 원소는 전 줄에 있는 원소 두개를 더한 것과 같으므로.


시간 복잡도는 1+2+3+4+...+k+1이다.
왜냐면 각 원소를 한번씩 계산하는데, 각 레벨의 원소의 개수는 그 레벨과 같으므로.

Time complexity : O(N^2)
Space complexity : O(N);

[추가]

"

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<Integer>();

        if (rowIndex<=1){
            result.add(1);
            if (rowIndex==0)
                return result;
            result.add(1);
            return result;
        }

        int[] even = new int[34];
        even[0] = 1;
        int[] odd = new int[34];
        odd[0] = 1;
        odd[1] = 1;
        int[] from = odd;
        int[] to = even;
        int i, j;
        for (i=2; i<=rowIndex ; i++){
            if (i%2==0){
                from = odd;
                to = even;
            }
            else {
                from = even;
                to = odd;
            }
            for (j=1 ; j<=i-1 ; j++){
                to[j] = from[j-1] + from[j];
            }
            to[j] = 1;
        }
        for (i=0 ; i<=rowIndex ; i++){
            result.add(to[i]);
        }
        return result;
    }
}
