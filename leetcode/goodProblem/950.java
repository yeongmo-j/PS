'''
[문제요약]
카드가 배열로 주어지는데,
카드를 뽑는 순서는, 맨위꺼를 뽑고 그다음껀 덱 맨아래로 옮기고 그다음꺼 뽑고 그다음거 바닥으로옮기고
이런식이다.
입력의 카드에서
어떻게 해야 오름차순으로 카드가 뽑힐지
다시 정렬해줘야함.

[해결방법]
역순으로 생각하자.
결과적으로 정렬된게 나와야 하고,
다시 집어넣을 땐 바닥에 있는걸 맨위로 올리고 뽑은걸 다시 그 위에 올려놓으면 된다.
즉 -> 정렬 한 뒤에 마지막부터(제일 큰 수부터)하나씩 다시 집어넣어주면 되는데, 그 순서는
원래 있던거중에 젤 마지막껄 맨앞으로 올리고 새걸 맨위에 올려놓으면 된다.
그래서 원래 배열을 퀵솔트로 정렬 하고,
맨뒤에서부터 linkedList로 추가를 해 준다.
리스트 맨뒤에있는걸 맨앞으로 옮겨주고 제일 큰 수를 맨앞으로 옮겨준다.

Time complexity : O(NlgN) 퀵정렬 + 원소 하나하나 다시 탐색 2번
Space complexity : O(N)? 연결리스트를 위해?

[추가]
일단 방법이 너무 너저분하다.
linkedList에서 맨 뒤에꺼 반환 후 삭제 : pollLast
맨앞에 추가  :addFirst
그리고 정렬할때 그냥
Arrays.sort(deck); 써도 되는데, 연습을 위해 퀵솔트 쓰자

!!!!!좋은방법!!!!
역으로 시뮬레이션 하면 된다.
일단 리스트에 0~N-1(사이즈-1) 의 정수를 저장한다. (이 순서대로 나와야 함)
그다음 배열을 정렬한다.
그대로 저 리스트로 시뮬레이션을 한다.
0번을 뽑음. -> 정답[0]에 제일 작은 숫자 추가
그다음 리스트 맨앞껄 맨뒤로 옮긴다.
리스트에서 그다음껄 뽑는다 : 이게 두번째로 나올 꺼 x
정답[x] = 두번째로 작은 숫자
이런식으로 하나하나 해나가면 됨.

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }
}
'''
class Solution {
    int partition(int[] A, int p, int q){
        int x=A[p];
        int i=p;
        int j;
        int size= A.length;
        int temp;
        for (j=i+1 ; j<size ; j++)
        {
            if (A[j]<=x)
            {
                temp = A[++i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        A[p] = A[i];
        A[i] = x;
        return i;
    }
    void quickSort(int[]A, int p, int q)
    {
        if (p<q)
        {
            int r = partition(A,p,q);
            quickSort(A,p,r-1);
            quickSort(A,r+1,q);
        }
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Integer temp;
        int i;
        int size = deck.length;
        quickSort(deck,0,size-1);
        list.add(deck[size-1]);
        for (i=size-2 ; i>=0 ; i--)
        {
            temp = list.pollLast();
            list.addFirst(temp);
            list.addFirst(deck[i]);
        }
        i=0;
        while(!list.isEmpty())
        {
            deck[i++] = list.pollFirst();
        }
        return deck;
    }
}
