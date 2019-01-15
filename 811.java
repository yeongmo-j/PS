'''
[문제요약]
문자열 가지고 놀기

[해결방법]

Time complexity : O(N);
Space complexity : O(N);

[추가]

'''
class Solution {
    public List<String> subdomainVisits(String[] cpdomains)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new LinkedList<String>();
        String count, subdomain, str;
        int num;
        int temp;
        for (String domain : cpdomains)
        {
            temp = domain.indexOf(" ");
            count = domain.substring(0,temp);
            num = Integer.parseInt(count);
            subdomain = domain.substring(temp+1);
            while (true)
            {
                if (map.containsKey(subdomain))
                    map.replace(subdomain,map.get(subdomain)+num);
                else
                    map.put(subdomain, num);
                if (!subdomain.contains("."))
                    break;
                temp = subdomain.indexOf(".");
                subdomain = subdomain.substring(temp+1);
            }
        }
        for (String key : map.keySet())
        {
            str = String.valueOf(map.get(key));
            str = str + " " + key;
            list.add(str);
        }
        return list;
    }
}
