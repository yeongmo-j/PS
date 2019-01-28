"
[문제요약]
배열이 들어오는데, 각 배열의 원소는 인덱스에 해당하는 사람의 점수이다.
1등은 금메달, 2등은 은메달, 3등은 동메달, 나머지는 등수에 해당하는 string 배열을 리턴해라.
기준은 입력 배열의 인덱스에 대항하는 사람에 대하여이다.
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
1등 2등 3등 4등 5등이라
금 은 동 4 5로 출력

[해결방법]
일단 입력배열을 하나 복사해서,
그걸 정렬해준다.
그리고서, map을 이용해, 점수->등수 로 매핑되는 맵을 만든다.
for (i=0 ; i<rank.length ; i++)
    map.put(rank[i], len-i);
그 후, 원래 배열을 통해 값을 찾고,
해당하는 string을 입력한다.

Time complexity : O(N)
Space complexity : O(N)

[추가]
원래 점수-인덱스로 이루어진 2차원 배열을 그대로 정렬하는 방법도 있다!!@@@@@@@@@@@@
Example:

nums[i]    : [10, 3, 8, 9, 4]
pair[i][0] : [10, 3, 8, 9, 4]
pair[i][1] : [ 0, 1, 2, 3, 4]

After sort:
pair[i][0] : [10, 9, 8, 4, 3]
pair[i][1] : [ 0, 3, 2, 4, 1]

pari[i][1]는 결과의 인덱스가 되고, i+1이 등수가 된다.!!!!!!!!!!

이런식으로 인덱스, 값의 쌍 그대로 정렬하는 방법잘 알아두기.
Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
이렇게 하면 됨. 아직 람다 잘 몰라서

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }


        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }
}




"
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len= nums.length, i, n, ranking;
        int[] rank = new int[len];
        String[] result = new String[len];
        for (i=0 ; i<len ; i++)
            rank[i]=nums[i];
        Arrays.sort(rank);
        for (i=0 ; i<rank.length ; i++)
            map.put(rank[i], len-i);
        for (i=0 ; i<len ; i++){
            n = nums[i];
            ranking = map.get(n);
            if (ranking==1)
                result[i] = "Gold Medal";
            else if (ranking==2)
                result[i] = "Silver Medal";
            else if (ranking==3)
                result[i] = "Bronze Medal";
            else
                result[i] = ""+ranking;
        }
        return result;
    }
}
