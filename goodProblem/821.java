'''
[문제요약]
문자열하고, 캐릭터 하나 주어지고
문자열 각 원소 하나하나당 주어진 캐릭터랑 얼마나 가까운지?(여러개중에 제일 가까운거랑 얼마나 떨어져있는지)

[해결방법]
일단 주어진 캐릭터에 해당하는 원소 다 알아낸 다음에,
그 맨 뒤에 엄청 큰 값으로 보초를 달아놓는다.
그 해당 원소가 담긴 리스트에 대해, 문자열의 각 원소는 해당 인덱스보다 작은거, 큰거 둘과 비교를 한다.
그러므로, 리스트에서 지금 어느정도를 탐색하고 있는지 기록할 변수가 하나 필요하고, 그 변수를 기준으로
그 변수와, 그 다음 변수를 비교하며 얼마나 차이나는지 비교해본다.

Time complexity : O(N);
Space complexity : O(N);

[추가]
!!!좋은 방법!!!!
일단 앞에서부터 탐색해가는데, C가 발견되면 그 장소를 저장해놓는다. 그래서 점점 뒤로가며 앞에 나온거와
얼마만큼 차이나는지 기록.

그 다음엔 뒤에서부터 탐색하는데, C가 발견되면 그 장소를 저장하고 앞으로 가며 뒤에 나온거와 얼마나 차이나는지 비교한다.
이 때, 그 차이가 앞에서 구해놓은 차이(앞에서부터 구한거)와 비교해서 더 작은거를 저장해야 한다.

'''
class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> list = new ArrayList<Integer>();
        char[] arr = S.toCharArray();
        int i, length = S.length();
        int[] result = new int[length];
        for (i=0 ; i<length ; i++)
        {
            if (arr[i]==C)
                list.add(i);
        }
        list.add(50000);
        int listSize= list.size();
        int beforeindex = 0;
        int candi1, candi2, temp;
        for( i=0 ; i<length ; i++)
        {
            if (arr[i]==C)
                result[i] = 0;
            else
            {
                temp = list.get(beforeindex);
                candi1 = temp-i>=0 ? temp-i : i-temp;
                temp = list.get(beforeindex+1);
                candi2 = temp-i>=0 ? temp-i : i-temp;
                candi1 = candi1<=candi2 ? candi1 : candi2;
                result[i]=candi1;
            }
            if (list.get(beforeindex+1) < i)
                beforeindex++;
        }
        return result;
    }
}
