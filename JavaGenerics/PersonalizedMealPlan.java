import java.util.*;

interface MealPlan {
    String getMealName();
    void displayMeal();
}

class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }

    public void displayMeal() {
        System.out.println("Vegetarian Meal: " + mealName);
    }
}

class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }

    public void displayMeal() {
        System.out.println("Vegan Meal: " + mealName);
    }
}

class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }

    public void displayMeal() {
        System.out.println("Keto Meal: " + mealName);
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }

    public void displayMeal() {
        System.out.println("High-Protein Meal: " + mealName);
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void showMeal() {
        meal.displayMeal();
    }

    public T getMeal() {
        return meal;
    }
}

class MealGenerator {
    public static <T extends MealPlan> Meal<T> generateMeal(T meal) {
        return new Meal<>(meal);
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        VegetarianMeal vegMeal = new VegetarianMeal("Grilled Paneer");
        VeganMeal veganMeal = new VeganMeal("Tofu Stir Fry");
        KetoMeal ketoMeal = new KetoMeal("Avocado Salad");
        HighProteinMeal proteinMeal = new HighProteinMeal("Chicken Breast");

        Meal<VegetarianMeal> veg = MealGenerator.generateMeal(vegMeal);
        Meal<VeganMeal> vegan = MealGenerator.generateMeal(veganMeal);
        Meal<KetoMeal> keto = MealGenerator.generateMeal(ketoMeal);
        Meal<HighProteinMeal> protein = MealGenerator.generateMeal(proteinMeal);

        veg.showMeal();
        vegan.showMeal();
        keto.showMeal();
        protein.showMeal();

        List<MealPlan> mealPlans = Arrays.asList(vegMeal, veganMeal, ketoMeal, proteinMeal);

        for (MealPlan meal : mealPlans) {
            meal.displayMeal();
        }
    }
}

