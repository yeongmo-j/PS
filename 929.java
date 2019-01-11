'''
[문제요약]
이메일에서 아이디에 .이들어가면 무시하고 +가 들어가면 뒤에꺼 무시함.
그래서 결국 같은게 몇개 나오는지?

[해결방법]
문자열에서 @찾아내서 뒤에부분 도멘인으로 저장하고
앞부분을 처리해줘야하는데, .찾고 +찾아서 바꿔주면 되는 간단한 문제
여기서 중복을 찾아야 하는데,
똑같은 문자열을 찾는 거니까, 이 문자열을 키로 하는 해쉬맵으로 같은거인지를 판별해냈다.

[추가]
HashMap 대신에 그냥 HashSet으로 써도 됐다.
키만 필요하므로...
'''
import java.util.HashMap;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        String temp;
        String local;
        String domain;
        String result;
        int indexAt;
        int indexdot, indexplus;
        int count=0;
        for (int i=0 ; i<emails.length ; i++)
        {
            temp = emails[i];
            indexAt = temp.indexOf("@");
            domain = temp.substring(indexAt);
            local = temp.substring(0,indexAt);
            while (true)
            {
                indexdot = local.indexOf(".");
                if (indexdot==-1)
                    break;
                local = local.substring(0,indexdot) + local.substring(indexdot+1);
            }
            indexplus = local.indexOf("+");
            if (indexplus != -1)
            {
                local = local.substring(0,indexplus);
            }
            result = local + domain;

            if (!hashmap.containsKey(result))
            {
                hashmap.put(result,1);
                count++;
            }
        }
        return count;
    }
}
