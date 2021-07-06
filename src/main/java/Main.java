import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;
    private static Scene mainScene;

    int numero01;

    double valorComPonto = 1278.987;
    char letra = 'Z';
    boolean opcao = true;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent fxmlMain = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Parent fxmlContent = FXMLLoader.load(getClass().getResource("/fxml/content.fxml"));
        mainScene = new Scene(fxmlMain);
        primaryStage.setScene(mainScene);
        //primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        //primaryStage.setFullScreenExitHint("");
        primaryStage.show();

        Image image = new Image("/fxml/img/tree.png");

        stage.getIcons().add(image);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
