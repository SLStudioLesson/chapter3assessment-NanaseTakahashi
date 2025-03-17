package com.recipeapp.model;

import java.util.ArrayList;

/* 設問1 クラスの実装
 * レシピ管理アプリのデータモデルとして
 * RecipeクラスとIngredientクラスを作成
 */
public class Recipe {
    // フィールド　レシピの名前
    private String name;
    // フィールド　レシピの材料リスト
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    // コンストラクタ
    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        // 引数の値を各フィールドに代入する
        this.name = name;
        this.ingredients = ingredients;
    }

    // メソッド　nameフィールドを返す
    public String getName() {
        return this.name;
    }
    // メソッド　ingredientsフィールドを返す
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }
    
}
