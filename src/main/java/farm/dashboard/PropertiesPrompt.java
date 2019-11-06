package farm.dashboard;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Optional;

public class PropertiesPrompt extends TextInputDialog {
    FarmComponent component;

    public PropertiesPrompt(FarmComponent c, String title, String header) {
        super();
        this.component = c;

        //String type is for the menu checking type
        //as of right now I am not sure why its here but i put it here
        //If we are running it as a check then we just need to modify the menu section (down below) with ifs
        String type = "cow";

        Dialog<ArrayList<String>> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(header);


        ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();

        TextField name = new TextField(component.getName());
        TextField price = new TextField(String.valueOf(component.getPrice()));
        TextField x = new TextField(String.valueOf(component.getLocationX()));
        TextField y = new TextField(String.valueOf(component.getLocationY()));
        TextField length = new TextField(String.valueOf(component.getLength()));
        TextField width = new TextField(String.valueOf(component.getWidth()));
        TextField height = new TextField(String.valueOf(component.getHeight()));
        TextField market_value = new TextField(String.valueOf(component.getMarketValue()));

        gridPane.add(name, 1, 0);
        gridPane.add(new Label("Name: "), 0, 0);
        gridPane.add(price, 1, 1);
        gridPane.add(new Label("Price ($): "), 0, 1);
        gridPane.add(x, 1, 2);
        gridPane.add(new Label("X: "), 0, 2);
        gridPane.add(y, 1, 3);
        gridPane.add(new Label("Y: "), 0, 3);
        gridPane.add(length, 1, 4);
        gridPane.add(new Label("Length: "), 0, 4);
        gridPane.add(width, 1, 5);
        gridPane.add(new Label("Width: "), 0, 5);
        gridPane.add(height, 1, 6);
        gridPane.add(new Label("Height: "), 0, 6);
        gridPane.add(market_value, 1, 7);
        gridPane.add(new Label("Market Value: "), 0, 7);

        dialog.getDialogPane().setContent(gridPane);

        // Request focus on the name field by default.
        Platform.runLater(() -> name.requestFocus());

        // Adds all values to array when OK button clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                ArrayList<String> properties = new ArrayList<>();
                properties.add(name.getText());
                properties.add(price.getText());
                properties.add(x.getText());
                properties.add(y.getText());
                properties.add(length.getText());
                properties.add(width.getText());
                properties.add(height.getText());
                properties.add(market_value.getText());

                //Todo: Error handling for values

                return properties;
            }
            return null;
        });

        Optional<ArrayList<String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            System.out.println(pair.toString());
            c.setName(pair.get(0));
            c.setPrice(Double.parseDouble(pair.get(1)));
            c.setLocationX(Double.parseDouble(pair.get(2)));
            c.setLocationY(Double.parseDouble(pair.get(3)));
            c.setLength(Integer.parseInt(pair.get(4)));
            c.setWidth(Integer.parseInt(pair.get(5)));
            c.setHeight(Integer.parseInt(pair.get(6)));
            c.setMarketValue(Double.parseDouble(pair.get(7)));
        });
    }

}
