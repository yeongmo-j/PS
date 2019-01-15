'''
[문제요약]
문자 두개가 짝수번쨰 캐릭터는 짝수번끼리, 홀수번은 홀수번끼리 바꿨을 때 두개가 동일해지면 Special Equivalant
라고 한다.
문자열 집합이 주어졌을 때,
이의 부분집합 S이 있다 할 때,
S에 속하지 않는다는 뜻은 S의 모든것과 Special Equivalant하지 않는다는 뜻이다.
S의 개수를 구하라


[해결방법]
주먹구구.
하나하나 탐색해서 equi인지 아닌지 판별하고,
만약 equi이면 큐에 넣었다.
그담에 큐에서 꺼내서 다시 다 돌았다.
큐가 비면 새로운 스트링을 꺼냈고, 이 떄 부분집합은 완성되었으므로 1 추가.

Time complexity :
Space complexity :

[추가]
@@@@@@@@@@@@@@@@@@@@
문제를 구현은 했는데
완전 망했음. 속도 꼴찌
아예 잘못생각하고 있었다.
equi끼리 짝지어주면 되는거였음.
그러니까 각 even의 원소와 odd의 원소가 같으면 같은거였으므로 -> Hash를 이용하면 되었다.
일단 배열 26*2 크기의 배열을 만든 뒤에
앞에는 짝수의 개수, 뒤에는 홀수의 개수를 기록 -> 이걸 스트링으로 바꾸면 된다!!!!!!
이걸 해쉬로 넣으면 같은거끼리 판별가능.......
너무좋은문제!!!!!!!@@@@@@@@@@@@@
'''

class Solution {
    boolean isSpeEqui(String A, String B)
    {
        Map<Character, Integer> even = new HashMap<Character, Integer>();
        Map<Character, Integer> odd = new HashMap<Character, Integer>();
        int size = A.length();
        int i;
        char temp;
        for (i=0 ; i<size ; i++)
        {
            temp = A.charAt(i);
            if (i%2==0)
            {
                if (even.containsKey(temp))
                    even.replace(temp, even.get(temp)+1);
                else
                    even.put(temp,1);
            }
            else
            {
                if (odd.containsKey(temp))
                    odd.replace(temp, odd.get(temp)+1);
                else
                    odd.put(temp,1);
            }
        }
        for (i=0 ; i<size ; i++)
        {
            temp = B.charAt(i);
            if (i%2==0)
            {
                if (even.containsKey(temp))
                {
                    if (even.get(temp)==1)
                        even.remove(temp);
                    else
                        even.replace(temp, even.get(temp)-1);
                }
                else
                    return false;
            }
            else
            {
                if (odd.containsKey(temp))
                {
                    if (odd.get(temp)==1)
                        odd.remove(temp);
                    else
                        odd.replace(temp, odd.get(temp)-1);
                }
                else
                    return false;
            }
        }
        if (even.isEmpty() && odd.isEmpty())
            return true;
        else
            return false;
    }

    public int numSpecialEquivGroups(String[] A) {
        LinkedList<String> list = new LinkedList<String>();
        for (String a : A)
            list.add(a);
        Queue<String> queue = new LinkedList<String>();
        String str;
        int count=0;
        int i;
        while (!list.isEmpty())
        {
            if (!queue.isEmpty())
                str = queue.poll();
            else
            {
                str = list.pollFirst();
                count++;
            }
            //처음꺼 꺼냄. 이거랑 다 비교해봐야한다.
            if (!list.isEmpty())
            {
                for (i=list.size()-1 ; i>=0 ; i--)
                {
                    if (isSpeEqui(str,list.get(i)))
                    {
                        queue.add(list.get(i));
                        list.remove(i);
                    }
                }
            }

        }
        return count;
    }
}
