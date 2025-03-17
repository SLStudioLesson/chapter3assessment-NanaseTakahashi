package com.recipeapp.model;

/* 設問1 クラスの実装
 * レシピ管理アプリのデータモデルとして
 * RecipeクラスとIngredientクラスを作成
 */
public class Ingredient {
    // フィールド　材料の名前
    private String name;

    // コンストラクタ
    public Ingredient(String name) {
        // nameフィールドに、同名の引数を代入する
        this.name = name;
    }

    // メソッド　nameフィールドを返す
    public String getName() {
        return this.name;
    }
    
}
