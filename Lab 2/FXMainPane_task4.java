


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Label feedbackLabel;
	TextField textfield; 
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dm;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		button6 = new Button("Wassap");
		feedbackLabel = new Label("Feedback: ");
		textfield = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dm = new DataManager();
		// Create ButtonHandlers
		button1.setOnAction(hello);
		button2.setOnAction(howdy);
		button3.setOnAction(chinese);
		button4.setOnAction(clear);
		button5.setOnAction(exit);
		button6.setOnAction(wassap);
		//  set margins and set alignment of the components
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().add(feedbackLabel);
		hbox1.getChildren().add(textfield);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	EventHandler<ActionEvent> hello = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			textfield.setText(dm.getHello());
		}
	};
	EventHandler<ActionEvent> howdy = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			textfield.setText(dm.getHowdy());
		}
	};
	EventHandler<ActionEvent> chinese = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			textfield.setText(dm.getChinese());
		}
	};
	EventHandler<ActionEvent> clear = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			textfield.setText("");
		}
	};
	EventHandler<ActionEvent> exit = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			Platform.exit();
			System.exit(0);
		}
	};
	EventHandler<ActionEvent> wassap = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			textfield.setText(dm.getWassap);
		}
	};
		
}
	
