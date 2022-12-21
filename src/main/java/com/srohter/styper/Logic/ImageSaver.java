package com.srohter.styper.Logic;

import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageSaver {
    private String path;
    private Button starter;

    public ImageSaver(String path, Button rec2) {
        this.path = path;
        this.starter = rec2;
    }

    public boolean save() {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            ImageIO.write(image, "png", new File("src/main/resources/com/srohter/styper/text.png"));
            starter.setStyle("-fx-background-color: #FF6961");
            starter.setOnMouseEntered(event -> {
                starter.setStyle("-fx-background-color: #c74848");
            });

            starter.setOnMouseExited(event -> {
                starter.setStyle("-fx-background-color: #FF6961");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
