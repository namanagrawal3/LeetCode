/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> impMap = new HashMap<>();

        for (Employee e : employees) {
            int Id = e.id;
            int imp = e.importance; 

            impMap.put(Id, imp);
            map.put(Id, e.subordinates);            
        }

        return sumFun(id, map, impMap);
    }
    public int sumFun(int id, HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> impMap) {
        int sum = impMap.get(id);
        
        for (int nbr : map.get(id)) {
            sum += sumFun(nbr, map, impMap);
        }

        return sum;
    }
}