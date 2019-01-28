"
[문제요약]
정수 배열이 들어오고, 그 배열에서 한 원소가 가장 많이 등장하는 회수가 degree이다.
배열의 부분배열중에서 degree가 동일한 최소 길이를 찾아라.
부분배열이란, 원래 배열에서 부분적으로 있는 배열인데 원소의 순서가 똑같아야 한다(슬라이싱만 가능)

[해결방법]
일단 새로운 클래스 하나 만든다.
이 클래스는 해당 숫자가 처음 등장한 인덱스 ,마지막으로 등장한 인덱스, 나온 회수
를 멤버로 갖고 있음.
그래서 Map<Integer, Info>를 만들어 주어 key로는 배열의 원소를 갖고 값에는 그 원소의 정보가
담겨있는 해쉬맵을 만들어 준다.
배열 탐색 하며 map 업데이트 해주고, 등장회수의 최대값을 저장해준다.(degree)
그 degree에 해당하는 map을 찾아서,
마지막인덱스-처음인덱스+1을 계산해서 이의 최소값을 찾는다(부분배열의 길이)

Time complexity : O(N);
Space complexity : O(N)

[추가]
최소값 찾을 때 Math.min( , )
로 찾아보자.
"

class Info{
    int first;
    int last;
    int count;
    Info(int first, int last, int count){
        this.first= first;
        this.last = last;
        this.count = count;
    }
}

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Info> map = new HashMap<Integer, Info>();
        int i, num;
        Info temp;
        int max = 1;
        for (i=0 ; i<nums.length ; i++){
            num = nums[i];
            if (map.containsKey(num)){
                temp = map.get(num);
                temp.last = i;
                temp.count++;
                if (temp.count>max)
                    max = temp.count;
            }
            else
                map.put(num, new Info(i, i, 1));
        }
        int minLength = nums.length;
        for (Integer key : map.keySet()){
            temp = map.get(key);
            if (temp.count==max){
                if (temp.last-temp.first+1 < minLength)
                    minLength = temp.last-temp.first+1;
            }
        }
        return minLength;
    }
}
