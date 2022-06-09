package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies
class FindAllPossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> availableRecipes = new ArrayList<>();
        Set<String> availableIngredients = new HashSet<>();
        Collections.addAll(availableIngredients, supplies);
        Map<String, List<String>> recipesPerIngredient = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            int unavailableIngredients = 0;
            for (String ingredient : ingredients.get(i)) {
                if (!availableIngredients.contains(ingredient)) {
                    recipesPerIngredient.putIfAbsent(ingredient, new ArrayList<>());
                    recipesPerIngredient.get(ingredient).add(recipe);
                    unavailableIngredients++;
                }
            }
            if (unavailableIngredients == 0) {
                availableRecipes.add(recipe);
            } else {
                inDegree.put(recipe, unavailableIngredients);
            }
        }
        for (int i = 0; i < availableRecipes.size(); i++) {
            String availableIngredient = availableRecipes.get(i);
            if (recipesPerIngredient.containsKey(availableIngredient)) {
                List<String> recipesUsingThis = recipesPerIngredient.get(availableIngredient);
                for (String recipe : recipesUsingThis) {
                    inDegree.put(recipe, inDegree.get(recipe) - 1);
                    if (inDegree.get(recipe) == 0) {
                        availableRecipes.add(recipe);
                    }
                }
                recipesPerIngredient.remove(availableIngredient);
            }
        }
        return availableRecipes;
    }

    // Test
    public static void main(String[] args) {
        FindAllPossibleRecipes solution = new FindAllPossibleRecipes();

        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = List.of(List.of("yeast", "flour"), List.of("bread", "meat"));
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> expectedOutput = List.of("bread", "sandwich");
        List<String> actualOutput = solution.findAllRecipes(recipes, ingredients, supplies);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
