import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        /* 設問4 データハンドラーの選択と初期化
        * ユーザーがファイル形式を選択できるように実装する
        */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            

            // 1 または 1/2以外 を入力した場合
            if (!choice.equals("2")) {
                // CSVDataHandlerインスタンスを生成する
                CSVDataHandler csv = new CSVDataHandler();
                // DataHandler型にアップキャスト
                DataHandler dataHandler = (DataHandler) csv;
                // インスタンス化
                RecipeUI ui = new RecipeUI(dataHandler);
                // displayMenuメソッドを呼び出してメインメニューを表示
                ui.displayMenu();

            // 2を入力した場合
            } else {
                // JSONDataHandlerインスタンスを生成する
                JSONDataHandler json = new JSONDataHandler();
                // DataHandler型にアップキャスト
                DataHandler dataHandler = (DataHandler) json;
                // インスタンス化
                RecipeUI ui = new RecipeUI(dataHandler);
                // displayMenuメソッドを呼び出してメインメニューを表示
                ui.displayMenu();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}