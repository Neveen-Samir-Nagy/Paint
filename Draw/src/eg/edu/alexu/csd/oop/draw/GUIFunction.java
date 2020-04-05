package eg.edu.alexu.csd.oop.draw;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GUIFunction {

	public Shape drawLine(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Line");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Point1X");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("Point1Y");
		TextField Point2X = new TextField();
		Point2X.setPromptText("Point2X");
		TextField Point2Y = new TextField();
		Point2Y.setPromptText("Point2Y");
		ColorPicker color = new ColorPicker();
		color.setPromptText("Color");
		ColorPicker Fillcolor = new ColorPicker();
		Fillcolor.setPromptText("Fill Color");

		grid.add(new Label("Point1 X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Point1 Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		grid.add(new Label("Point2 X:"), 0, 2);
		grid.add(Point2X, 1, 2);
		grid.add(new Label("Point2 Y:"), 0, 3);
		grid.add(Point2Y, 1, 3);
		grid.add(new Label("Color :"), 0, 4);
		grid.add(color, 1, 4);
		grid.add(new Label("Fill Color :"), 0, 5);
		grid.add(Fillcolor, 1, 5);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Point position = new Point();
				Double x = Double.parseDouble(Point1X.getText());
				position.x = x.intValue();
				x = Double.parseDouble(Point1Y.getText());
				position.y = x.intValue();
				object.setPosition(position);
				
				
				object.setColor(color.getValue());
				
				object.setFillColor(Fillcolor.getValue());
				Map<String, Double> mapline = new HashMap<String, Double>();
				mapline.put("PointX", Double.parseDouble(Point2X.getText()));
				mapline.put("PointY", Double.parseDouble(Point2Y.getText()));
				object.setProperties(mapline);
			}
			return null;
		});

		Optional<ArrayList<String>> result = dialog.showAndWait();
        return object;
	}
	public Shape drawCircle(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Circle");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("PositionX");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("PositionY");
		TextField Point2X = new TextField();
		Point2X.setPromptText("Radius");
		ColorPicker color = new ColorPicker();
		color.setPromptText("Color");
		ColorPicker fillcolor = new ColorPicker();
		fillcolor.setPromptText("FillColor");

		grid.add(new Label("Position X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Position Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		grid.add(new Label("Radius:"), 0, 2);
		grid.add(Point2X, 1, 2);
		grid.add(new Label("Color :"), 0, 4);
		grid.add(color, 1, 4);
		grid.add(new Label("Fill Color :"), 0, 5);
		grid.add(fillcolor, 1, 5);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Point position = new Point();
				Double x = Double.parseDouble(Point1X.getText());
				position.x = x.intValue();
				x = Double.parseDouble(Point1Y.getText());
				position.y = x.intValue();
				object.setPosition(position);
				object.setColor(color.getValue());
				object.setFillColor(fillcolor.getValue());
				Map<String, Double> mapline = new HashMap<String, Double>();
				mapline.put("Radius", Double.parseDouble(Point2X.getText()));
				object.setProperties(mapline);
			}
			return null;
		});

		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}
	public Shape drawEllipse(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Ellipse");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("PositionX");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("PositionY");
		TextField Point2X = new TextField();
		Point2X.setPromptText("Major Axis");
		TextField Point2Y = new TextField();
		Point2Y.setPromptText("Minor Axis");
		ColorPicker color = new ColorPicker();
		color.setPromptText("Color");
		ColorPicker Fillcolor = new ColorPicker();
		Fillcolor.setPromptText("Fill Color");

		grid.add(new Label("Position X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Position Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		grid.add(new Label("Major Axis:"), 0, 2);
		grid.add(Point2X, 1, 2);
		grid.add(new Label("Minor Axis:"), 0, 3);
		grid.add(Point2Y, 1, 3);
		grid.add(new Label("Color :"), 0, 4);
		grid.add(color, 1, 4);
		grid.add(new Label("Fill Color :"), 0, 5);
		grid.add(Fillcolor, 1, 5);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Point position = new Point();
				Double x = Double.parseDouble(Point1X.getText());
				position.x = x.intValue();
				x = Double.parseDouble(Point1Y.getText());
				position.y = x.intValue();
				object.setPosition(position);
				object.setColor(color.getValue());
				object.setFillColor(Fillcolor.getValue());
				Map<String, Double> mapline = new HashMap<String, Double>();
				mapline.put("Major Axis", Double.parseDouble(Point2X.getText()));
				mapline.put("Minor Axis", Double.parseDouble(Point2Y.getText()));
				object.setProperties(mapline);
			}
			return null;
		});

		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}
	public Shape drawTriangle(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Triangle");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Point1X");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("Point1Y");
		TextField Point2X = new TextField();
		Point2X.setPromptText("Point2X");
		TextField Point2Y = new TextField();
		Point2Y.setPromptText("Point2Y");
		TextField Point3X = new TextField();
		Point3X.setPromptText("Point3X");
		TextField Point3Y = new TextField();
		Point3Y.setPromptText("Point3Y");
		ColorPicker color = new ColorPicker();
		color.setPromptText("Color");
		ColorPicker Fillcolor = new ColorPicker();
		Fillcolor.setPromptText("Fill Color");

		grid.add(new Label("Point1 X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Point1 Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		grid.add(new Label("Point2 X:"), 0, 2);
		grid.add(Point2X, 1, 2);
		grid.add(new Label("Point2 Y:"), 0, 3);
		grid.add(Point2Y, 1, 3);
		grid.add(new Label("Point3 X:"), 0, 4);
		grid.add(Point3X, 1, 4);
		grid.add(new Label("Point3 Y:"), 0, 5);
		grid.add(Point3Y, 1, 5);
		grid.add(new Label("Color :"), 0, 6);
		grid.add(color, 1, 6);
		grid.add(new Label("Fill Color :"), 0, 7);
		grid.add(Fillcolor, 1, 7);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Point position = new Point();
				Double x = Double.parseDouble(Point1X.getText());
				position.x = x.intValue();
				x = Double.parseDouble(Point1Y.getText());
				position.y = x.intValue();
				object.setPosition(position);
				object.setColor(color.getValue());
				object.setFillColor(Fillcolor.getValue());
				Map<String, Double> mapline = new HashMap<String, Double>();
				mapline.put("Point1X", Double.parseDouble(Point1X.getText()));
				mapline.put("Point1Y", Double.parseDouble(Point1Y.getText()));
				mapline.put("Point2X", Double.parseDouble(Point2X.getText()));
				mapline.put("Point2Y", Double.parseDouble(Point2Y.getText()));
				mapline.put("Point3X", Double.parseDouble(Point3X.getText()));
				mapline.put("Point3Y", Double.parseDouble(Point3Y.getText()));
				object.setProperties(mapline);
			}
			return null;
		});

		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}
	public Shape drawSquare(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Square");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("PositionX");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("PositionY");
		TextField Point2X = new TextField();
		Point2X.setPromptText("Length");
		ColorPicker color = new ColorPicker();
		color.setPromptText("Color");
		ColorPicker Fillcolor = new ColorPicker();
		Fillcolor.setPromptText("Fill Color");

		grid.add(new Label("Position X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Position Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		grid.add(new Label("Length:"), 0, 2);
		grid.add(Point2X, 1, 2);
		grid.add(new Label("Color :"), 0, 4);
		grid.add(color, 1, 4);
		grid.add(new Label("Fill Color :"), 0, 5);
		grid.add(Fillcolor, 1, 5);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Point position = new Point();
				Double x = Double.parseDouble(Point1X.getText());
				position.x = x.intValue();
				x = Double.parseDouble(Point1Y.getText());
				position.y = x.intValue();
				object.setPosition(position);
				object.setColor(color.getValue());
				object.setFillColor(Fillcolor.getValue());
				Map<String, Double> mapline = new HashMap<String, Double>();
				mapline.put("Length", Double.parseDouble(Point2X.getText()));
				object.setProperties(mapline);
			}
			return null;
		});

		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}
	public Shape drawRectangle(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Rectangle");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("PositionX");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("PositionY");
		TextField Point2X = new TextField();
		Point2X.setPromptText("Height");
		TextField Point2Y = new TextField();
		Point2Y.setPromptText("Width");
		ColorPicker color = new ColorPicker();
		color.setPromptText("Color");
		ColorPicker Fillcolor = new ColorPicker();
		Fillcolor.setPromptText("Fill Color");

		grid.add(new Label("Position X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Position Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		grid.add(new Label("Height:"), 0, 2);
		grid.add(Point2X, 1, 2);
		grid.add(new Label("Width:"), 0, 3);
		grid.add(Point2Y, 1, 3);
		grid.add(new Label("Color :"), 0, 4);
		grid.add(color, 1, 4);
		grid.add(new Label("Fill Color :"), 0, 5);
		grid.add(Fillcolor, 1, 5);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Point position = new Point();
				Double x = Double.parseDouble(Point1X.getText());
				position.x = x.intValue();
				x = Double.parseDouble(Point1Y.getText());
				position.y = x.intValue();
				object.setPosition(position);
				object.setColor(color.getValue());
				object.setFillColor(Fillcolor.getValue());
				Map<String, Double> mapline = new HashMap<String, Double>();
				mapline.put("Height", Double.parseDouble(Point2X.getText()));
				mapline.put("Width", Double.parseDouble(Point2Y.getText()));
				object.setProperties(mapline);
			}
			return null;
		});

		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}
	public Shape resizecircle(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Resize");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Radius");
		grid.add(new Label("Radius:"), 0, 0);
		grid.add(Point1X, 1, 0);
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Map<String, Double> map = new HashMap<String, Double>();
				map.put("Radius", Double.parseDouble(Point1X.getText()));
				object.setProperties(map);
			}
			return null;
		});
		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}
	public Shape resizeellipse(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Resize");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Major Axis");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("Minor Axis");
		grid.add(new Label("Major Axis:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Minor Axis:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Map<String, Double> map = new HashMap<String, Double>();
				map.put("Major Axis", Double.parseDouble(Point1X.getText()));
				map.put("Minor Axis", Double.parseDouble(Point1Y.getText()));
				object.setProperties(map);
			}
			return null;
		});
		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}

	public Shape resizeline(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Resize");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Point2X");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("Point2Y");
		grid.add(new Label("Point2X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Point2Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Map<String, Double> map = new HashMap<String, Double>();
				map.put("Point2X", Double.parseDouble(Point1X.getText()));
				map.put("Point2Y", Double.parseDouble(Point1Y.getText()));
				object.setProperties(map);
			}
			return null;
		});
		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}

	public Shape resizetriangle(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Resize");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Point1X");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("Point1Y");
		TextField Point2X = new TextField();
		Point2X.setPromptText("Point2X");
		TextField Point2Y = new TextField();
		Point2Y.setPromptText("Point2Y");
		TextField Point3X = new TextField();
		Point3X.setPromptText("Point3X");
		TextField Point3Y = new TextField();
		Point3Y.setPromptText("Point3Y");
		grid.add(new Label("Point1 X:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Point1 Y:"), 0, 1);
		grid.add(Point1Y, 1, 1);
		grid.add(new Label("Point2 X:"), 0, 2);
		grid.add(Point2X, 1, 2);
		grid.add(new Label("Point2 Y:"), 0, 3);
		grid.add(Point2Y, 1, 3);
		grid.add(new Label("Point3 X:"), 0, 4);
		grid.add(Point3X, 1, 4);
		grid.add(new Label("Point3 Y:"), 0, 5);
		grid.add(Point3Y, 1, 5);
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Map<String, Double> map = new HashMap<String, Double>();
				map.put("Point1X", Double.parseDouble(Point1X.getText()));
				map.put("Point1Y", Double.parseDouble(Point1Y.getText()));
				map.put("Point2X", Double.parseDouble(Point2X.getText()));
				map.put("Point2Y", Double.parseDouble(Point2Y.getText()));
				map.put("Point3X", Double.parseDouble(Point3X.getText()));
				map.put("Point3Y", Double.parseDouble(Point3Y.getText()));
				object.setProperties(map);
			}
			return null;
		});
		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}

	public Shape resizesquare(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Resize");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Length");
		grid.add(new Label("Length:"), 0, 0);
		grid.add(Point1X, 1, 0);
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Map<String, Double> map = new HashMap<String, Double>();
				map.put("Length", Double.parseDouble(Point1X.getText()));
				object.setProperties(map);
			}
			return null;
		});
		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}

	public Shape resizerectangle(Shape object) {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Resize");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField Point1X = new TextField();
		Point1X.setPromptText("Height");
		TextField Point1Y = new TextField();
		Point1Y.setPromptText("Width");
		grid.add(new Label("Height:"), 0, 0);
		grid.add(Point1X, 1, 0);
		grid.add(new Label("Width:"), 0, 1);
		grid.add(Point1Y, 1, 1);

		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				Map<String, Double> map = new HashMap<String, Double>();
				map.put("Height", Double.parseDouble(Point1X.getText()));
				map.put("Width", Double.parseDouble(Point1Y.getText()));
				object.setProperties(map);
		       
			}
			return null;
		});
		Optional<ArrayList<String>> result = dialog.showAndWait();
		return object;
	}
	private String format(Color color) {
		String s = "java.awt.Color[r=" + color.getRed()*255 + ",g=" + color.getGreen()*255  +",b=" + color.getBlue()*255  + "]";
		return s;
	}
	
}
