package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

/* 設問3 インタフェースの実装クラスの作成
 * DataHandlerインタフェースを実装
 * ：CSV形式・JSON形式の2クラス
 */
// JSON形式に対応したクラス
public class JSONDataHandler implements DataHandler { // インターフェースを実装
    // メソッド　getMode ※オーバーライド
    @Override
    public String getMode() {
        return "JSON"; // 文字列JSONを返す
    }
    
    // メソッド　readData ※オーバーライド
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        return null; //nullをreturnする
    }

    // メソッド　writeData ※オーバーライド
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 定義のみ
    }

    // メソッド　searchData ※オーバーライド
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; //nullをreturnする
    }
}
