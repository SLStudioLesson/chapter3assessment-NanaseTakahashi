package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

/* 設問2
 * DataHandlerインターフェースの定義
 */
public interface DataHandler {
    // メソッド　現在のモードを返す
    public String getMode();

    // メソッド　読み込んだRecipeオブジェクトのリストを返す
    public ArrayList<Recipe> readData() throws IOException;

    // メソッド　指定のRecipeオブジェクトを追加
    public void writeData(Recipe recipe) throws IOException;

    // メソッド　検索キーワードに一致するRecipeオブジェクトのリストを返す
    public ArrayList<Recipe> searchData(String keyword) throws IOException;
    
}
