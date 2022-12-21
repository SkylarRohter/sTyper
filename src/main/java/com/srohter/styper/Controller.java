package com.srohter.styper;

import com.srohter.styper.Logic.HTMLParse;
import com.srohter.styper.Logic.ImageSaver;
import com.srohter.styper.Logic.ParseImage;
import com.srohter.styper.Logic.Typer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import javax.sound.midi.Soundbank;
import javax.swing.text.html.ImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private Pane basePane;
    @FXML
    private Button recButton;
    @FXML
    private Label recText;
    @FXML
    private Button StartRec;
    @FXML
    private Label StartText;
    @FXML
    private TextField dataPath;
    @FXML
    private Button resetButton;
    @FXML
    private TextArea uploadText;
    @FXML
    private ImageView closeButton;
    @FXML
    private Slider delaySlider;
    @FXML
    private Button delayButton;
    @FXML
    private Label delayLabel;

    public void setSliderValue(int sliderValue) {
        this.sliderValue = sliderValue;
    }

    private int sliderValue;

    @FXML
    protected void onUploadClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        File f = fileChooser.showOpenDialog(null);
        ImageSaver imageSaver = new ImageSaver(f.getPath(), StartRec);
        if (!imageSaver.save()) {
        }
    }

    @FXML
    protected void onStartClick() {
        if (uploadText.getText().isEmpty()) {
            ParseImage p = new ParseImage(dataPath.getCharacters().toString());
            char[] text = p.parse();
            type(text);
        } else if (uploadText.getText().contains("https://10fastfingers.com")) {
            try {
                HTMLParse p = new HTMLParse(new URL(uploadText.getText()));
                type(p.parse());
            }catch (MalformedURLException mue){
                System.out.println("MalformedURLException");
            }
        } else {
            char[] text = uploadText.getText().toCharArray();
            type(text);
        }
    }

    private void type(char[] text) {
        System.out.println(text);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (text != null) {
            Typer t = new Typer(text, sliderValue);
            t.type();
        }
    }

    @FXML
    protected void onResetButtonClick() {
        StartRec.setStyle("-fx-background-color: #8AA2A9");
        new File("src/main/resources/com/srohter/styper/text.png").delete();
        delayLabel.setText("0");
        delaySlider.setValue(0);
        uploadText.setText("");
    }

    @FXML
    protected void onCloseButtonClick() {
        Platform.exit();
    }

    @FXML
    protected void onSliderDrag() {
        setSliderValue((int) delaySlider.getValue());
        delayLabel.setText(Integer.toString(sliderValue));
    }
}