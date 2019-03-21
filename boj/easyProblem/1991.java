"
[문제요약]
트리 preorder inorder postorder

[해결방법]

Time complexity : O(N)
Space complexity : O(N)

[추가]
이렇게 클래스를 만들지 말고 크기 2짜리 배열로 0은 왼쪽자식, 1은 오른쪽자식의 키를 가르키게 할 수 있다
(물론 알파벳을 0부터 시작하는 키로 바꿔서)
void preorder(int x) {
    if (x == -1) return;
    cout << (char)(x+'A');
    preorder(a[x][0]);
    preorder(a[x][1]);
}
이렇게 프리오더가 나올 수 있고
시작할땐 0번으로 호출 해주면 된다.

"

import java.util.Scanner;

class Node{
    char key;
    Node left;
    Node right;
    Node(char key){
        this.key = key;
    }
    void preorder(){
        System.out.print(key);
        if (left!=null)
            left.preorder();
        if (right!=null)
            right.preorder();
    }
    void inorder(){
        if (left!=null)
            left.inorder();
        System.out.print(key);
        if (right!=null)
            right.inorder();
    }
    void postorder(){
        if (left!=null)
            left.postorder();
        if (right!=null)
            right.postorder();
        System.out.print(key);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        Node[] arr = new Node[N];
        int i;
        for (i=0 ; i<N ; i++)
            arr[i] = new Node((char)(i+'A'));
        while (--N>=0){
            char a = scin.next().charAt(0);
            char b = scin.next().charAt(0);
            char c = scin.next().charAt(0);
            if (b!='.')
                arr[(int)(a-'A')].left = arr[(int)(b-'A')];
            if (c!='.')
                arr[(int)(a-'A')].right = arr[(int)(c-'A')];
        }
        arr[0].preorder();
        System.out.println();
        arr[0].inorder();
        System.out.println();
        arr[0].postorder();
        System.out.println();
        scin.close();
    }
}
