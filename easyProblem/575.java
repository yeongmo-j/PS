'''
[문제요약]
각 배열의 원소는 사탕의 종류를 나타낸다.
1은 사과사탕 2는 딸기사탕 처럼
이렇게 짝수개의 사탕이 주어지고, 반은 누나 반은 형한테 나눠준다.
이 때 누나가 받을수 있는 최대 "종류"의 개수를 구하라

[해결방법]
사탕의 종류를을 set으로 입력받아서 몇개으 ㅣ종류가 있나 본 다음에
전체 개수의 절반(받게 될 사탕)보다 많으면 개수의 절반 리턴,
아니면 저 집합의 크기 리턴

Time complexity : O(N);
Space complexity : O(N);

[추가]

'''
class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candies)
            set.add(candy);
        int size = set.size();
        int len = candies.length;
        if(size>=len/2)
            return len/2;
        return size;
    }
}
