package eg.edu.alexu.csd.oop.draw;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.DirectoryChooser;
import javafx.util.Pair;

public class Controller {
	
	@FXML
	Button line = new Button();
	@FXML
	Button circle = new Button();
	@FXML
	Button ellipse = new Button();
	@FXML
	Button triangle = new Button();
	@FXML
	Button rectangle = new Button();
	@FXML
	Button square = new Button();
	@FXML
	Button supported = new Button();
	@FXML
	Button clone = new Button();
	@FXML
	Button undo = new Button();
	@FXML
	Button redo = new Button();
	@FXML
	Button save = new Button();
	@FXML
	Button load = new Button();
	@FXML
	Button moveshape = new Button();
	@FXML
	Button resizeshape = new Button();
	@FXML
	Button removehspae = new Button();
	@FXML
	Button updateshape = new Button();
	@FXML
	Button refresh = new Button();
	@FXML
	ListView<String> List = new ListView<String>();
	@FXML
	Canvas canvas = new Canvas();
    ArrayList<String> str = new ArrayList<String>();
	Draw draw = new Draw();
	int size=0;
	String path = "";
	Shape object;
	GUIFunction gui = new GUIFunction();
	
    GraphicsContext g;
    
    
	public void shapes(ActionEvent event) {
		size++;
		if (((Button) event.getSource()).getText().equals("Line")) {
			
			object = new LineSegment();
			object = gui.drawLine(object);
			g=canvas.getGraphicsContext2D();
			object.draw(g);
			draw.addShape(object);
		}
		if (((Button) event.getSource()).getText().equals("Circle")) {
			object = new Circle();
			object = gui.drawCircle(object);
			g=canvas.getGraphicsContext2D();
			object.draw(g);
			draw.addShape(object);
		}
		if (((Button) event.getSource()).getText().equals("Ellipse")) {
			object = new Ellipse();
			object = gui.drawEllipse(object);
			g=canvas.getGraphicsContext2D();
			object.draw(g);
			draw.addShape(object);
		}
		if (((Button) event.getSource()).getText().equals("Triangle")) {
			object = new Triangle();
			object = gui.drawTriangle(object);
			g=canvas.getGraphicsContext2D();
			object.draw(g);
			draw.addShape(object);

		}
		if (((Button) event.getSource()).getText().equals("Square")) {
			object = new Square();
			object = gui.drawSquare(object);
			g=canvas.getGraphicsContext2D();
			object.draw(g);
			draw.addShape(object);

		}
		if (((Button) event.getSource()).getText().equals("Rectangle")) {
			object = new Rectangle();
			object = gui.drawRectangle(object);
			g=canvas.getGraphicsContext2D();
			object.draw(g);
			draw.addShape(object);

		}
		str = new ArrayList<>();
		for(int i= 0 ; i<draw.getShapes().length;i++) {
		str.add("Shape" +(i+1));}
		
		ObservableList<String> items = FXCollections.observableArrayList(
	    	str );
		List.setItems(items);

	}

	public void code(ActionEvent event) {
		
		if (((Button) event.getSource()).getText().equals("undo")) {
			draw.undo();
			
			g.clearRect(0, 0, 615.0, 445.0);
			draw.refresh(g);
		} else if (((Button) event.getSource()).getText().equals("redo")) {
			draw.redo();
			g.clearRect(0, 0, 615.0, 445.0);
			draw.refresh(g);
		}else if (((Button) event.getSource()).getText().equals("Refresh")) {
			draw.refresh(g);
		} 
		else if (((Button) event.getSource()).getText().equals("Clone")) {
			int index = List.getSelectionModel().getSelectedIndex();
			try {
				draw.addShape((Shape)draw.getShapes()[index].clone());
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else if (((Button) event.getSource()).getText().equals("save")) {
			saveAndload();
		} else if (((Button) event.getSource()).getText().equals("load")) {
			Dialog<ArrayList<String>> dialog = new Dialog<>();
			dialog.setTitle("Load");
			// Set the button types.
			ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

			// Create the username and password labels and fields.
			GridPane grid = new GridPane();
			grid.setHgap(20);
			grid.setVgap(20);
			grid.setPadding(new Insets(20, 150, 10, 10));

			TextField patht = new TextField();
			patht.setPromptText("Please enter the path");
	        DirectoryChooser d = new DirectoryChooser();
	       // File s = d.showDialog();
			grid.add(new Label("File Path"), 0, 0);
			grid.add(patht, 1, 0);
			Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
			loginButton.setDisable(true);

			dialog.getDialogPane().setContent(grid);
			patht.textProperty().addListener((observable, oldValue, newValue) -> {
				loginButton.setDisable(newValue.trim().isEmpty());
			});
			dialog.setResultConverter(dialogButton -> {
				if (dialogButton == loginButtonType) {
					draw.load(patht.getText());
					g=canvas.getGraphicsContext2D();
					g.clearRect(0, 0, 615.0, 445.0);
					draw.refresh(g);
				}
				return null;
			});
			
			Optional<ArrayList<String>> result = dialog.showAndWait();
		} 
			
			
		 else if (((Button) event.getSource()).getText().equals("Remove Shape")) {
			int index = List.getSelectionModel().getSelectedIndex();
			draw.removeShape(draw.getShapes()[index]);
			g.clearRect(0, 0, 615.0, 445.0);
			draw.refresh(g);
		}  else if (((Button) event.getSource()).getText().equals("Move Shape")) {
			Dialog<ArrayList<String>> dialog = new Dialog<>();
			int index = List.getSelectionModel().getSelectedIndex();
			Shape shape = draw.getShapes()[index];

			if(shape.getClass().getSimpleName().equals("Triangle")) {
				shape=gui.drawTriangle(shape);
				g=canvas.getGraphicsContext2D();
				draw.updateShape(draw.getShapes()[index], shape);
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);
			}else {
				Shape shape1 = draw.getShapes()[index];
			dialog.setTitle("Move");
            
			ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 150, 10, 10));

			TextField Point1X = new TextField();
			Point1X.setPromptText("PositionX");
			TextField Point1Y = new TextField();
			Point1Y.setPromptText("PositionY");
			grid.add(new Label("Position X:"), 0, 0);
			grid.add(Point1X, 1, 0);
			grid.add(new Label("Position Y:"), 0, 1);
			grid.add(Point1Y, 1, 1);
			Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
			loginButton.setDisable(true);

			dialog.getDialogPane().setContent(grid);
			Point1X.textProperty().addListener((observable, oldValue, newValue) -> {
				loginButton.setDisable(newValue.trim().isEmpty());
			});
			dialog.setResultConverter(dialogButton -> {
				if (dialogButton == loginButtonType) {
			Point newp = new Point();
			newp.x = Integer.parseInt(Point1X.getText());
			newp.y = Integer.parseInt(Point1Y.getText());
			shape1.setPosition(newp);
			g=canvas.getGraphicsContext2D();
			draw.updateShape(draw.getShapes()[index], shape1);
			g.clearRect(0, 0, 615.0, 445.0);;
			draw.refresh(g);
				}
				return null;
			});
			Optional<ArrayList<String>> result = dialog.showAndWait();
		}
		}else if (((Button) event.getSource()).getText().equals("Resize Shape")) {
			int index = List.getSelectionModel().getSelectedIndex();
			Shape shape = draw.getShapes()[index];
			if (shape.getClass().getSimpleName().equals("Circle")) {
				shape=gui.resizecircle(shape);
				g=canvas.getGraphicsContext2D();
				draw.updateShape(draw.getShapes()[index], shape);
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);
			} else if (shape.getClass().getSimpleName().equals("LineSegment")) {
				shape = gui.resizeline(shape);
				g=canvas.getGraphicsContext2D();
				draw.updateShape(draw.getShapes()[index], shape);
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);
			} else if (shape.getClass().getSimpleName().equals("Triangle")) {
				shape=gui.resizetriangle(shape);
				g=canvas.getGraphicsContext2D();
				draw.updateShape(draw.getShapes()[index], shape);
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);
				} else if (shape.getClass().getSimpleName().equals("Square")) {
				shape=gui.resizesquare(shape);
				g=canvas.getGraphicsContext2D();
				draw.updateShape(draw.getShapes()[index], shape);
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);
			} else if (shape.getClass().getSimpleName().equals("Rectangle")) {
				shape=gui.resizerectangle(shape);
				g=canvas.getGraphicsContext2D();
				draw.updateShape(draw.getShapes()[index], shape);
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);;
			} else if (shape.getClass().getSimpleName().equals("Ellipse")) {
				shape=gui.resizeellipse(shape);
				g=canvas.getGraphicsContext2D();
				draw.updateShape(draw.getShapes()[index], shape);
				g.clearRect(0, 0, 615.0, 445.0);
				draw.refresh(g);
			}
		}
		str = new ArrayList<>();
		for(int i= 0 ; i<draw.getShapes().length;i++) {
		str.add("Shape" +(i+1));}
		
		ObservableList<String> items = FXCollections.observableArrayList(
	    	str );
		List.setItems(items);
	}

	private void saveAndload() {
		Dialog<ArrayList<String>> dialog = new Dialog<>();
		dialog.setTitle("Save");
		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField patht = new TextField();
		patht.setPromptText("Please enter the path");
		TextField Type = new TextField();
		Type.setPromptText("Type");
		TextField Name = new TextField();
		Name.setPromptText("Name File");
        DirectoryChooser d = new DirectoryChooser();
       // File s = d.showDialog();
		grid.add(new Label("Path"), 0, 0);
		grid.add(patht, 1, 0);
		grid.add(new Label("Type"), 0, 1);
		grid.add(Type, 1, 1);
		grid.add(new Label("Name File"), 0, 2);
		grid.add(Name, 1, 2);
		//grid.add(d, 0, 2);
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		dialog.getDialogPane().setContent(grid);
		patht.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				path = patht.getText()+ "\\" + Name.getText() + "." + Type.getText();
				draw.save(path);
			}
			return null;
		});
		
		Optional<ArrayList<String>> result = dialog.showAndWait();
	}
}
