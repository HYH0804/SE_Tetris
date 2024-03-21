package com.example.fxtest;

import com.example.fxtest.database.DbOutput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
//
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Scene1 생성
        Scene scene1 = createScene1();

        // Scene2 생성
        Scene scene2 = createScene2();

        stage.setTitle("Hello!");
        stage.setScene(scene1);
        stage.show();
    }

    //scene1==시작페이지
    private Scene createScene1() {
        Button switchSceneButton = new Button("Switch to Scene2");
        switchSceneButton.setOnAction(event -> switchToScene2());

        StackPane scene1Layout = new StackPane(switchSceneButton);
        return new Scene(scene1Layout, 300, 200);
    }

    //scene2==스코어보드(랭킹)
    private Scene createScene2() {
        //데이터 베이스에서 데이터 가져올때 사용
        //List<String> data = DbOutput.getData();

        //더미 데이터 사용
        List<String> data = new ArrayList<>();
        data.add("Player1: 1000");
        data.add("Player2: 900");
        data.add("Player3: 800");
        data.add("Player4: 700");
        data.add("Player5: 600");
        data.add("Player6: 500");
        data.add("Player7: 400");
        data.add("Player8: 300");
        data.add("Player9: 200");
        data.add("Player10: 100");

        StringBuilder rankingText = new StringBuilder("Top 5 Rankings:\n");
        for (int i = 0; i < data.size(); i++) {
            rankingText.append((i + 1)).append(". ").append(data.get(i)).append("\n");
        }

        // Label에 랭킹 정보 표시
        Label rankingLabel = new Label(rankingText.toString());
        rankingLabel.setStyle("-fx-font-size: 30; -fx-alignment: center;");

        Button switchToScene1Button = new Button("Back to Scene 1");
        switchToScene1Button.setOnAction(event -> switchToScene1());

        BorderPane scene2Layout = new BorderPane();
        scene2Layout.setCenter(rankingLabel);
        scene2Layout.setBottom(switchToScene1Button);

        return new Scene(scene2Layout, 800, 500);
    }

    //데이터베이스에서 랭킹가져오는 함수


    private void switchToScene1() { stage.setScene(createScene1()); }
    //scene1에서 2로 버튼 누르면 변하는 함수
    private void switchToScene2() {
        stage.setScene(createScene2());
    }

    public static void main(String[] args) {
        launch();
    }
}.
