package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.TreeMap;

public class HelloController {

    public TextField textField = new TextField();
    public ListView listView = new ListView<>();
    public ListView listView1 = new ListView<>();
    private Map<String, String> dictionary = new TreeMap<>();

    public void close(ActionEvent actionEvent)
    {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }

    public void add(ActionEvent actionEvent)
    {
        if (!Objects.equals(textField.getText(), null))
        {
            String[] temp = textField.getText().split("-",2);
            dictionary.putIfAbsent(temp[0],temp[1]);
            listView.getItems().add(dictionary.keySet());
            listView1.getItems().add(dictionary.values());
            textField.clear();

        }
    }

    public void delete(ActionEvent actionEvent) {
    }
}