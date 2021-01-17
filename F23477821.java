import javafx.event.ActionEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class F23477821 extends Application{

	TextField textfield;
	TextField calcNum;


	String firstVal, secVal, operator = ""; // store the operators and operands
	int calculation;


	public static void main(String[] args) {
		launch(args);

	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();

		textfield = new TextField();
		calcNum = new TextField();
		root.setTop(textfield);

		Button button = new Button ();

		ButtonEventHandler btnEventHandler = new ButtonEventHandler();
		button.setOnAction(btnEventHandler);


		ButtonHandler opEventHandler = new ButtonHandler();
		button.setOnAction(opEventHandler);

		EqualButton EqualHandler = new EqualButton();
		button.setOnAction(EqualHandler);




		VBox leftVBox = new VBox();

		Button addBtn = new Button("+");
		addBtn.setOnAction(opEventHandler);
		leftVBox.getChildren().add(addBtn);

		Button subBtn = new Button("-");
		subBtn.setOnAction(opEventHandler);
		leftVBox.getChildren().add(subBtn);

		Button mulBtn = new Button("x");
		mulBtn.setOnAction(opEventHandler);
		leftVBox.getChildren().add(mulBtn);

		Button divBtn = new Button("/");
		divBtn.setOnAction(opEventHandler);
		leftVBox.getChildren().add(divBtn);
		root.setLeft(leftVBox);



		/*VBox rightVBox = new VBox();
		rightVBox.getChildren().add(new Button());
		root.setRight(rightVBox);*/

		GridPane gridPane = new GridPane();

		Button oneBtn = new Button("1");
		oneBtn.setOnAction(btnEventHandler);
		gridPane.add(oneBtn, 0, 0);


		Button secBtn = new Button("2");
		secBtn.setOnAction(btnEventHandler);
		gridPane.add(secBtn, 1, 0);

		Button thirBtn = new Button("3");
		thirBtn.setOnAction(btnEventHandler);
		gridPane.add(thirBtn, 2, 0);

		Button equaBtn = new Button("=");
		equaBtn.setOnAction(EqualHandler);
		gridPane.add(equaBtn, 3, 0);

		Button forBtn = new Button("4");
		forBtn.setOnAction(btnEventHandler);
		gridPane.add(forBtn, 0, 1);

		Button fivBtn = new Button("5");
		fivBtn.setOnAction(btnEventHandler);
		gridPane.add(fivBtn, 1, 1);

		Button sixBtn = new Button("6");
		sixBtn.setOnAction(btnEventHandler);
		gridPane.add(sixBtn, 2, 1);

		Button sevBtn = new Button("7");
		sevBtn.setOnAction(btnEventHandler);
		gridPane.add(sevBtn, 0, 2);

		Button eighBtn = new Button("8");
		eighBtn.setOnAction(btnEventHandler);
		gridPane.add(eighBtn, 1, 2);

		Button niBtn = new Button("9");
		niBtn.setOnAction(btnEventHandler);
		gridPane.add(niBtn, 2, 2);

		Button zeroBtn = new Button("0");
		zeroBtn.setOnAction(btnEventHandler);
		gridPane.add(zeroBtn, 1, 3);

		Button clearBtn = new Button("C");
		clearBtn.setOnAction(btnEventHandler);
		gridPane.add(clearBtn, 3, 3);


		root.setCenter(gridPane);


		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}




class ButtonEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {

			Button pressed = (Button) event.getTarget();
			String text = pressed.getText();

			//textfield.setText(text);

			if( text.equals("C")) {
	    		textfield.setText("");

			System.out.println(text);
			}


			if(Character.isDigit(text.charAt(0))) {
				firstVal = text;
			System.out.println(text);
				textfield.appendText(text);
			}











			//when a character and a operator button is pressed
			//indicates that it must save the first character into a
			//variable to then be used to do the arithmetic


	}




}

class ButtonHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Button pressed = (Button) event.getTarget();
		String optext = pressed.getText();
		System.out.println(optext);

		if ( optext.equals("+") ){
			secVal = textfield.getText();
			System.out.println(secVal);
			textfield.setText("");
			operator = optext;

		}
		if ( optext.equals("-") ){
			secVal = textfield.getText();
			System.out.println(secVal);
			textfield.setText("");
			operator = optext;

		}
		if ( optext.equals("/") ){
			secVal = textfield.getText();
			System.out.println(secVal);
			textfield.setText("");
			operator = optext;

		}
		if ( optext.equals("x") ){
			secVal = textfield.getText();
			textfield.setText("");
			System.out.println(secVal);
			operator = optext;

		}
	}


}

class EqualButton implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Button pressed = (Button) event.getTarget();
		String equaltext = pressed.getText();

			if ( equaltext.equals("=")) {
				firstVal = textfield.getText();
				System.out.println(firstVal);

				if( operator.equals("+")) {
				calculation = Integer.parseInt(firstVal) + Integer.parseInt(secVal);
				textfield.setText(Integer.toString(calculation));

			}}


			if ( equaltext.equals("=")) {
				firstVal = textfield.getText();
				System.out.println(firstVal);

				if( operator.equals("-")) {
				calculation = Integer.parseInt(secVal) - Integer.parseInt(firstVal);
				textfield.setText(Integer.toString(calculation));

			}}




			if ( equaltext.equals("=")) {
				firstVal = textfield.getText();
				System.out.println(firstVal);

				if( operator.equals("/")) {
				calculation = Integer.parseInt(secVal) / Integer.parseInt(firstVal);
				textfield.setText(Integer.toString(calculation));

				}}




			if ( equaltext.equals("=")) {
				firstVal = textfield.getText();
				System.out.println(firstVal);

				if( operator.equals("x")) {
				calculation = Integer.parseInt(firstVal) * Integer.parseInt(secVal);
				textfield.setText(Integer.toString(calculation));

				}}









	//calculation = Integer.parseInt(firstVal) + Integer.parseInt(secVal);
	//System.out.println(secVal + " " + operator + " " + firstVal );
	//System.out.println(calculation);
	}

}
}


// once the equal sign is pressed the same is done the value is moved over and stored in another value









































//Border Pane outer most layout
//Node is an ancestor class
//we can use elements to design other elements
//method chaining a method being call on another method
// VBox = Vertical Box
// HBox = Horizontal Box
// add the buttoneventhandler into the class within the outter most brackets make sure
//that it doesn't cross over into another method
