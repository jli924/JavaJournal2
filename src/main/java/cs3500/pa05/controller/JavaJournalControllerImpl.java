package cs3500.pa05.controller;

import cs3500.pa05.model.JavaJournal;
import java.io.File;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The implementation of the JavaJournalController interface
 */
public class JavaJournalControllerImpl implements JavaJournalController {

  @FXML
  Button addEvent;

  @FXML
  Button addTask;

  JavaJournal journal;

  public void run() {
    initButtons();
  }

  @Override
  public void saveToFile(File file) {

  }

  @Override
  public void openFile(File file) {

  }

  public void initButtons() {
    addEvent.setOnAction(event -> {
      eventScene();
    });
    addTask.setOnAction(event -> {
      taskScene();
    });
  }

  private void eventScene() {
    GridPane pane = new GridPane();
    Scene eventScene = new Scene(pane, 400, 600);
    Image image = new Image("https://www.iconsdb.com/icons/preview/pink/calendar-3-xxl.png");
    ImageView imageView = new ImageView(image);
    imageView.setFitHeight(64);
    imageView.setFitWidth(64);
    Stage eventStage = new Stage();
    TextField[] fields = {new TextField(), new TextField(),
        new TextField(), new TextField(), new TextField()};
    Label[] labels = {new Label("Event Name: "), new Label("Description: "),
        new Label("Weekday: "),
        new Label("Start Time: "), new Label("Duration: ")};
    for (int row = 1; row < 6; row++) {
      System.out.println(row);
      pane.add(labels[row - 1], 0, row);
      pane.add(fields[row - 1], 1, row);
    }
    pane.add(imageView, 1, 0);
    pane.add(new Label("New Event"), 0, 0);
    GridPane.setHalignment(imageView, HPos.RIGHT);
    eventStage.setScene(eventScene);
    pane.setPadding(new Insets(50));
    pane.setHgap(50);
    pane.setVgap(50);
    eventStage.setResizable(false);
    eventStage.show();
    Button save = new Button("Save");

  }

  private void taskScene() {
    GridPane pane = new GridPane();
    Scene eventScene = new Scene(pane, 400, 450);
    Image image = new Image("https://www.iconsdb.com/icons/preview/pink/notepad-xxl.png");
    ImageView imageView = new ImageView(image);
    imageView.setFitHeight(64);
    imageView.setFitWidth(64);
    Stage eventStage = new Stage();
    TextField[] fields = {new TextField(), new TextField(), new TextField() };
    Label[] labels = {new Label("Task Name: "), new Label("Description: "),
        new Label("Weekday: ")};
    Button save = new Button("Save");
    save.setPrefHeight(35);
    save.setPrefWidth(50);
    save.setStyle("-fx-background-color: pink");

    for (int row = 1; row < 4; row++) {
      pane.add(labels[row - 1], 0, row);
      pane.add(fields[row - 1], 1, row);
    }
    pane.add(imageView, 1, 0);
    Label newTask = new Label("New Task");

    newTask.setStyle("-fx-font-size: 24; -fx-font: bold");
    pane.add(newTask, 0, 0);
    pane.add(save, 1, 4);

    GridPane.setHalignment(save, HPos.RIGHT);
    GridPane.setHalignment(imageView, HPos.RIGHT);

    pane.setPadding(new Insets(50));
    pane.setHgap(50);
    pane.setVgap(50);
    eventStage.setResizable(false);

    eventStage.setScene(eventScene);
    eventStage.show();
  }
}
