package entity.image;


import entity.EntityView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class ImageEntityView implements EntityView {
   private final String filePath;
   private final TextField textField;

    public ImageEntityView(String filePath) {
        this.filePath = filePath;
        this.textField = new TextField(filePath);
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        ImageView imageView = new ImageView("file://" + filePath);
        Button fileChooseButton = new Button("выбрать фотографию");
        fileChooseButton.setOnAction(ae -> {
            try {
                String path = new FileChooser().showOpenDialog(gridPane.getScene().getWindow()).getAbsolutePath();
                textField.setText(path);
                imageView.setImage(new Image(path));
            } catch (Exception ignored) {
            }
        });
        gridPane.add(imageView, 0, rowNumber);
        gridPane.add(fileChooseButton, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "image = " + "'" + this.textField.getText() + "'";
    }

    @Override
    public String insertRequestValue() {
        return this.textField.getText();
    }

    @Override
    public String column() {
        return "image";
    }
}
