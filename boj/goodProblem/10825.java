"
[문제요약]
이름, 국,영,수 점수가 들어오는데,
국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
이렇게 정렬하라.


[해결방법]
implements Comparable<Student>
한 뒤에
public int compareTo(Student)를 구현해준 뒤,
Arrays.sort() 해준다.

Time complexity : O(NlgN)
Space complexity : O(N)

[추가]
일단 코드는 머지솔트 직접 구현까지 짜봤는데,
안돌아간다.. 그래서 그냥 Arrays.sort로 제출했음

"
import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
	String name;
	int korean;
	int english;
	int math;
	Student(String name, int korean, int english, int math){
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	public int compareTo(Student another) {
		if (this.korean > another.korean)
			return -1;
		if (this.korean < another.korean)
			return 1;
		if (this.english > another.english)
			return 1;
		if (this.english < another.english)
			return -1;
		if (this.math > another.math)
			return -1;
		if (this.math < another.math)
			return 1;
		return name.compareTo(another.name);
	}
}

public class Main {

	static void mergeSort(Student[] arr, int p, int q) {
		if (p>=q)
			return;
		int r = (p+q)/2;
		mergeSort(arr, p, r);
		mergeSort(arr, r+1, q);
		merging(arr, p, r, q);
	}

	static void merging(Student[] arr, int p, int r, int q) {
		int firstNum = (r-p)+1;
		int secondNum = (q-(r+1))+1;
		Student[] first = new Student[firstNum+1];
		Student[] second = new Student[secondNum+1];
		int i;
		for (i=0 ; i<firstNum ; i++) {
			first[i] = arr[p+i];
		}
		first[firstNum] = new Student("zzzzzzzzzzzzz", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);
		for (i=0 ; i<secondNum ; i++) {
			second[i] = arr[r+1+i];
		}
		second[secondNum] = new Student("zzzzzzzzzzzzz", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);
		int idx = p;
		int firstIdx = 0;
		int secondIdx = 0;
		for (i=0 ; i<firstNum+secondNum ; i++) {
			int compare = arr[firstIdx].compareTo(arr[secondIdx]);
			if (compare<=0) {
				arr[idx] = first[firstIdx];
				firstIdx++;
			}
			else {
				arr[idx] = second[secondIdx];
				secondIdx++;
			}
			idx++;
		}
	}

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int N = scin.nextInt();
		Student[] arr = new Student[N];
		int i;
		for (i=0 ; i<N ; i++) {
			String name = scin.next();
			int korean = scin.nextInt();
			int english = scin.nextInt();
			int math = scin.nextInt();
			arr[i] = new Student(name, korean, english, math);
		}
		Arrays.sort(arr);
		for (Student m : arr) {
			System.out.println(m.name);
		}

		scin.close();
	}
}
