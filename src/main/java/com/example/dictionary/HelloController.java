package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class HelloController {
    public TextField textField = new TextField();
    public ListView listView = new ListView<>();
    public ListView listView1 = new ListView<>();
    public Label label;
    private Map<String, String> dictionary = new TreeMap<>();


    public void close(ActionEvent actionEvent)
    {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
    public void add(ActionEvent actionEvent) throws IOException {
        if (!Objects.equals(textField.getText(), null))
        {
            String[] temp = textField.getText().split("-",2);
            dictionary.put(temp[0],temp[1]);
            FileWriter file = new FileWriter("words.txt");
            file.write(dictionary + "\n");

            textField.clear();
            //listView.getItems().add(dictionary.keySet());
            //listView1.getItems().add(dictionary.values());
            dictionary.forEach((key, value) -> {
                listView.getItems().add(key);
                listView1.getItems().add(value);
            });
            file.close();
        }
    }
    public void delete(ActionEvent actionEvent)
    {
        int selectedID = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(selectedID);
        listView1.getItems().remove(selectedID);

    }
}