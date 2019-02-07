package com.codev.scan_eat_api.entities.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Serving {
    @JsonIgnore
    private Recipe recipe;
    private List<RecipeContent> content;
    private int recipeId;
    private int peopleAmount;

    @JsonIgnore
    private Map<String, String> nutritionalInfo;

    public Serving(Recipe recipe, int personAmount) {
        this.recipe = recipe;
        this.recipeId = recipe.getId();
        this.peopleAmount = personAmount;
        int servingSizeKcal = 500;
        nutritionalInfo = new HashMap<>();
        List<RecipeContent> baseRcList = constructBaseUnitMeasures(recipe.getIngredients());
        double totalKcal = baseRcList.stream()
                .map(i -> i.getIngredient().getKcal100g()*(i.getQuantity()/100)) //Divided by 100 because kcal100g/ml and the base units are g or ml
                .reduce(0d, (i1,i2) -> i1+i2);

        Stream lol = baseRcList.stream()
                .map(i -> i.getIngredient().getKcal100g()*(i.getQuantity()/100));


        double servingPercentage = ((servingSizeKcal*recipe.getServingModifier())/totalKcal)*personAmount;

        content = new ArrayList<>();
        for(RecipeContent rc : recipe.getIngredients()) {
            RecipeContent newRc = new RecipeContent();
            newRc.setQuantity(rc.getQuantity()*servingPercentage);
            newRc.setIngredient(rc.getIngredient());
            newRc.setUnit(rc.getUnit());
            content.add(newRc);
        }

        updateNutritionalInfo();
    }

    public void updateNutritionalInfo() {
        List<RecipeContent> baseRcList = constructBaseUnitMeasures(recipe.getIngredients());
        nutritionalInfo.put(
                "kcal100g",
                String.format("%.2f", calculateProportionalNutriments(
                        stripImpossibleConversions(baseRcList).stream()
                                .map(o -> new Pair<>(o.getQuantity(), o.getIngredient().getKcal100g()))
                                .collect(Collectors.toList())
                )) + " kcal"
        );
        nutritionalInfo.put(
                "proteins100g",
                String.format("%.2f", calculateProportionalNutriments(
                        stripImpossibleConversions(baseRcList).stream()
                                .map(o -> new Pair<>(o.getQuantity(), o.getIngredient().getProteins100g()))
                                .collect(Collectors.toList())
                )) + " g"
        );
        nutritionalInfo.put(
                "sugars100g",
                String.format("%.2f", calculateProportionalNutriments(
                        stripImpossibleConversions(baseRcList).stream()
                                .map(o -> new Pair<>(o.getQuantity(), o.getIngredient().getSugars100g()))
                                .collect(Collectors.toList())
                )) + " g"
        );
        nutritionalInfo.put(
                "fat100g",
                String.format("%.2f", calculateProportionalNutriments(
                        stripImpossibleConversions(baseRcList).stream()
                                .map(o -> new Pair<>(o.getQuantity(), o.getIngredient().getFat100g()))
                                .collect(Collectors.toList())
                )) + " g"
        );
        nutritionalInfo.put(
                "salt100g",
                String.format("%.2f", calculateProportionalNutriments(
                        stripImpossibleConversions(baseRcList).stream()
                                .map(o -> new Pair<>(o.getQuantity(), o.getIngredient().getSalt100g()))
                                .collect(Collectors.toList())
                )) + " g"
        );
        nutritionalInfo.put(
                "fiber100g",
                String.format("%.2f", calculateProportionalNutriments(
                        stripImpossibleConversions(baseRcList).stream()
                                .map(o -> new Pair<>(o.getQuantity(), o.getIngredient().getFiber100g()))
                                .collect(Collectors.toList())
                )) + " g"
        );
    }

    private List<RecipeContent> constructBaseUnitMeasures(List<RecipeContent> rcList) {
        List<RecipeContent> newRcList = new ArrayList<>();
        for(RecipeContent rc : rcList)
        {
            if(rc.getUnit().getBaseUnit() == null) {
                newRcList.add(new RecipeContent(rc));
            } else {
                RecipeContent newRc = new RecipeContent();
                newRc.setRecipe(rc.getRecipe());
                newRc.setIngredient(rc.getIngredient());
                newRc.setQuantity(rc.getQuantity()*rc.getUnit().getBaseUnitConversion());
                newRc.setUnit(rc.getUnit().getBaseUnit());
                newRcList.add(newRc);
            }
        }
        return newRcList;
    }

    private List<RecipeContent> stripImpossibleConversions(List<RecipeContent> rcList) {
        return rcList.stream().filter(rc -> rc.getUnit().getId() != 3).collect(Collectors.toList());
    }

    private double calculateProportionalNutriments(List<Pair<Double, Double>> l) {
        double maxQuantity = l.stream().map(Pair::getKey).reduce(0d, (q1, q2) -> q1+q2);
        return l.stream().map(o -> ((o.getKey()/100)*o.getValue())*(o.getKey()/maxQuantity)).reduce(0d, (n1,n2) -> n1+n2)/l.size();
    }

    public List<RecipeContent> getContent() {
        return content;
    }

    public void setContent(List<RecipeContent> content) {
        this.content = content;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public Map<String, String> getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(Map<String, String> nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }
}
