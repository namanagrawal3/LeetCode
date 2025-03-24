class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    // Clearly, dependency exists like recipe will be made only when you have ingredients
    // thus, simply 'Topological Sort' is used

        int n = recipes.length;
        HashSet<String> set = new HashSet<>();
        for (String recipe: recipes) {
            set.add(recipe);
        }

        HashMap<String , List<String>> adjMap = new HashMap<>();
        HashMap<String , Integer> inDeg = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String recipe = recipes[i];
            for (String ingrd: ingredients.get(i)) {
                inDeg.put(recipe, inDeg.getOrDefault(recipe, 0) + 1);

                if (!adjMap.containsKey(ingrd))
                    adjMap.put(ingrd, new ArrayList<>());
                adjMap.get(ingrd).add(recipe);
            }
        }

//        System.out.println(adjMap);
//        System.out.println(inDeg);

        List<String> ans = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        for (String supply: supplies) {
            q.add(supply);
        }

        while (!q.isEmpty()) {
            String rvIngr = q.poll();
            if (set.contains(rvIngr))
                ans.add(rvIngr);

            if (!adjMap.containsKey(rvIngr))
                continue;

            for (String recipe: adjMap.get(rvIngr)) {
                inDeg.put(recipe, inDeg.get(recipe) - 1);
                if (inDeg.get(recipe) == 0)
                    q.add(recipe);
            }
        }

        return ans;
    }
}