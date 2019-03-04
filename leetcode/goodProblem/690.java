'''
[문제요약]
자료구조가 하나 주어지는데
그건 id, 중요도, 부하들리스트
이렇게 구성이 되어 있다.
이것들의 리스트와, id 하나가 입력으로 들어오는데,
id 아래에 있는 모든 부하들(부하의 부하들 포함)의 중요도의 합을 구해라.

[해결방법]
일단  리스트를 id:자료구조로 매핑되는 map을 하나 만들어준 다음에,
꼬리에 꼬리를 물고 계속 더해주었다. (큐를 이용해서 dfs를 해주었다.)
(중간에 이게 확인했던건지 확인하는 리스트를 하나 만들었는데 어차피 이건 위아래로 가는게 아니라
수직적으로 이동하는 것이므로, 그럴 필요는 없었을듯?)

Time complexity : O(N)
Space complexity : O(N)

[추가]
같은 개념이여도 코드를 더 깔끔하게 쓸 수 있다.. 연습!!

'''
//좋은 솔루션
class Solution {
    Map<Integer, Employee> map;

    int dfs(int id){
        Employee now = map.get(id);
        int sum=now.importance;
        for (Integer sub : now.subordinates){
            sum+=dfs(map.get(sub).id);
        }
        return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<Integer, Employee>();
        for (Employee e : employees)
            map.put(e.id, e);
        return dfs(id);
    }
}
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        List<Integer> list = new LinkedList<Integer>();
        Iterator<Employee> it = employees.iterator();
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        Queue<Employee> queue = new LinkedList<Employee>();
        int sum=0, i;
        while(it.hasNext()){
            Employee temp = it.next();
            if (!map.containsKey(temp.id)){
                map.put(temp.id, temp);
            }
        }
        queue.offer(map.get(id));
        do{
            Employee now = queue.poll();
            sum+=now.importance;
            List<Integer> temp = now.subordinates;
            for (i=0 ; i<temp.size() ; i++){
                if (!list.contains(temp.get(i)))
                {
                    list.add(temp.get(i));
                    queue.offer(map.get(temp.get(i)));
                }
            }
        } while(!queue.isEmpty());
        return sum;
    }
}
