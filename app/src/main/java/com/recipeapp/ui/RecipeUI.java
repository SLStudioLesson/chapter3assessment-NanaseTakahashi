package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler; // RecipeUIメソッドの引数で使用
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                    /* 設問5 レシピ一覧表示機能 */
                        // displayRecipesメソッドを読み込む
                        displayRecipes();
                        break;
                    case "2":
                    /* 設問6 新規登録機能 */
                        // addNewRecipeメソッドを読み込む
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
    /* 設問5 レシピ一覧表示機能 */
    // displayRecipesメソッドを作成
    public void displayRecipes() {
        try {
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");

            CSVDataHandler display = new CSVDataHandler(); // インスタンス生成
            ArrayList<Recipe> recipeData = new ArrayList<>();
            display.readData();

            System.out.println("-----------------------------------");
        } catch (IOException ex) {
        // 例外：IOExceptionを受け取った場合
            // Error reading file: 例外のメッセージとコンソールに表示
            System.out.println("Error reading file: " + ex.getMessage());
        }

    }
    /* 設問5 レシピ一覧表示機能 */
    // addNewRecipeメソッドを作成
    private void addNewRecipe() {
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 入力を受け付ける
            // レシピ名の入力
            System.out.print("Enter recipe name: ");
            String name = reader.readLine();
            
            // 材料の入力
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            System.out.println("Enter ingredients (type 'done' when finished):");

            // 繰り返し
            while (true) {
                System.out.print("Ingredient: ");
                String inputList = reader.readLine();
                // Ingredientクラス型のインスタンスを生成
                Ingredient list = new Ingredient(inputList);
                // ArrayListに追加
                ingredients.add(list);

                // 'done' と入力されたらループ終了
                if (inputList.equals("done")) {
                    break;
                }
            }
            //Recipeクラス型のインスタンスを生成
            Recipe recipe = new Recipe(name, ingredients);
            // CSVDataHandler型のインスタンスを生成
            CSVDataHandler addition = new CSVDataHandler();
            // 引数をwriteDataメソッドに渡して実行
            addition.writeData(recipe);

        } catch (IOException ex) {
        // 例外：IOExceptionを受け取った場合
            // Failed to add new recipe: 例外のメッセージとコンソールに表示
            System.out.println("Failed to add new recipe: " + ex.getMessage());
        }
    }
}
