package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

/* 設問3 インタフェースの実装クラスの作成
 * DataHandlerインタフェースを実装
 * ：CSV形式・JSON形式の2クラス
 */
// CSV形式に対応したクラス
public class CSVDataHandler implements DataHandler { // インターフェースを実装

    // フィールド　ファイルパス
    private String filePath;
        // レシピデータを格納するCSV
    

    // コンストラクタ
    public CSVDataHandler() {
        // フィールドfilePathに値を代入
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    // コンストラクタ(引数あり) ※ オーバーロード
    public CSVDataHandler(String filePath) {
        // フィールドfilePathに引数を代入する
        this.filePath = filePath;
    }

    // メソッド　getMode ※オーバーライド
    @Override
    public String getMode() {
        return "CSV"; // 文字列CSVを返す
    }

    // メソッド　readData ※オーバーライド
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        //return null; //nullをreturnする

        /* 設問5 レシピ一覧表示機能 */
        // recipes.csvからレシピデータを読み込み、リスト形式で返す
        ArrayList<Recipe> recipeDatas = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                //System.out.println(line);
                String[] datas = line.split(",", 2);
                String name = datas[0]; // レシピ名
                String[] arrays = datas[1].split(", ");
                for (String i : arrays) {
                    Ingredient temp = new Ingredient(i);
                    ingredients.add(temp);
                }

                Recipe recipe = new Recipe(name, ingredients);
                recipeDatas.add(recipe);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return recipeDatas;

    }

    // メソッド　writeData ※オーバーライド
    @Override
    public void writeData(Recipe recipe) throws IOException {
    /* 設問6 新規登録機能 */
        // 新しいレシピをrecipes.csvに追加
        String filename = this.filePath; // ファイル名
        
        String recipeName = recipe.getName(); // (1)レシピ名

        // Ingredient型のリスト形式から、String型に修正する
        ArrayList<Ingredient> lists = recipe.getIngredients();
        ArrayList<String> text = new ArrayList<>(); // 修正後の値を格納
        for (Ingredient i : lists) {
            if (!i.getName().equals("done")) {
                // 入力終了を表す'done'を省く
                text.add(i.getName());
            }
        }
        // (2)材料
        String ingredients = String.join(", ", text);

        // レシピ名・材料名をカンマ(,)で文字列結合：(1)+(2)
        String contentToWrite = recipeName + "," + ingredients;

        // 既存のレシピに追加で書き込む
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // 書き込み実行
            writer.write(contentToWrite);
            writer.newLine(); // 書き込み後に改行
            // 書き込み完了後のメッセージを出力
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // メソッド　searchData ※オーバーライド
    // 以降の設問で処理を実装する
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; //nullをreturnする
    }
}
