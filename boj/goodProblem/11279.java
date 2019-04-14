"
[문제요약]
최대 힙 구현

[해결방법]


Time complexity : O(m*lgm) 각 연산 O(lgm)
Space complexity : O(100000)

[추가]

static class Compare implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
        return two.compareTo(one);
    }
}
이렇게 역순으로 비교해주는 comparator 구현 해 준 다음에
Compare cmp = new Compare();
PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, cmp);
이렇게 컬렉션 이용도 가능


또!!! 최대 힙<->최소 힙 구현할때 빠르게 하기
최대 힙을 똑같이 이용 하면서
넣을 때, -붙여서 넣고,
빼고나서 다시 - 붙여주면 된다!!

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Heap{
	int lastIdx;
	int[] arr;
	Heap(){
		lastIdx = -1;
		arr = new int[100000];
	}

	void insert(int x) {
		lastIdx++;
		arr[lastIdx] = x;
		goUp(lastIdx);
	}

	void goUp(int idx) {
		if (idx<=0)
			return;
		int parent = idx/2;
		if (arr[parent]<arr[idx]) {
			int temp = arr[parent];
			arr[parent] = arr[idx];
			arr[idx] = temp;
			goUp(parent);
		}
	}

	int pop() {
		if (lastIdx<=-1)
			return 0;
		int result = arr[0];
		arr[0] = arr[lastIdx];
		lastIdx--;
		goDown(0);
		return result;
	}

	void goDown(int idx) {
		int choice=idx;
		if (idx*2>lastIdx)
			return;
		else if (idx*2+1<=lastIdx) {
			int left = idx*2;
			int right = idx*2+1;
			if (arr[left]>=arr[right])
				choice = left;
			else
				choice = right;
		}else if (idx*2<=lastIdx) {
			choice = idx*2;
		}
		if (arr[choice]>arr[idx]) {
			int temp = arr[choice];
			arr[choice] = arr[idx];
			arr[idx] = temp;
			goDown(choice);
		}
	}

}


public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		Heap heap = new Heap();
		while (--m>=0) {
			int x = Integer.valueOf(br.readLine());
			if (x==0)
				System.out.println(heap.pop());
			else
				heap.insert(x);
		}
	}
}
