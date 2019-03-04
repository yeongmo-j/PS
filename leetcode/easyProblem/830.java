"
[문제요약]
문자열 들어오고,
같은문자 3개 이상 붙어있는것들의 처음인덱스,마지막인덱스 쌍을 전부 리스트로 리턴.
각 쌍도 리스트임.

[해결방법]
문자열의 첫원소부터 탐색해가며, 첫, 마지막인덱스 갱신해가며 3넘으면 리스트에 추가하는식으로.

Time complexity : O(N);
Space complexity : O(N)

[추가]
일단 j로 0부터 n-1까지 탐색한뒤에,
0으로 초기화된 i를 시작으로 하면 된다.
만약 j가 마지막에 다다랐거나, j와 j+1이 다를 때, 끝난거이므로,
개수 세주고 리스트에 추가해주면 된다.
이런시긍로 짧아짐.

for (int j = 0; j < N; ++j) {
    if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
        // Here, [i, j] represents a group.
        if (j-i+1 >= 3)
            ans.add(Arrays.asList(new Integer[]{i, j}));
        i = j + 1;
    }
}

"

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int i, start=0, end=0;
        int len = S.length();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        char now='0';
        char[] str = S.toCharArray();
        for (i=0 ; i<len ; i++){
            if (str[i]!=now){
                if (end-start>=2){
                    List<Integer> temp = new LinkedList<Integer>();
                    temp.add(start);
                    temp.add(end);
                    result.add(temp);
                }
                now = str[i];
                start = i;
            }
            end = i;
        }
        if (end-start>=2){
            List<Integer> temp = new LinkedList<Integer>();
            temp.add(start);
            temp.add(end);
            result.add(temp);
        }
        return result;
    }
}
