package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.security.auth.x500.X500Principal;
import javax.xml.transform.Templates;

import files.DataStorage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import rr.*;
public class MainApp extends Application {
	ArrayList<Integer> DoTindex = new ArrayList<>();
	DataStorage storage=new DataStorage();
	static int DotCount = 0;
	TextField textField=new TextField();
	private static int realDot = 0;
	static 	boolean isoperator = false;
	Stack<String> Expression =new Stack<>();
	Button oneButton =new Button("1");
	Button threeButton =new Button("3");
	Button twoButton =new Button("2");
	Button fourButton =new Button("4");
	Button fiveButton =new Button("5");
	Button sixButton =new Button("6");
	Button sevenButton =new Button("7");
	Button dotButton =new Button(".");
	Button nineButton =new Button("9");
	Button spaceButton =new Button("S");
	Button eightButton =new Button("8");
	Button zeroButton =new Button("0");
	@Override
	public void start(Stage primaryStage) {
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("calculator-icon.png")));
		final int MaxHeight = 70;
		final int MaxWidth = 60;
		
		oneButton.setPrefHeight(MaxHeight);
		oneButton.setPrefWidth(MaxWidth);
		
		twoButton.setPrefHeight(MaxHeight);
		twoButton.setPrefWidth(MaxWidth);
		
		threeButton.setPrefWidth(MaxWidth);
		threeButton.setPrefHeight(MaxHeight);
		
		fourButton.setPrefHeight(MaxHeight);
		fourButton.setPrefWidth(MaxWidth);
		
	
		fiveButton.setPrefWidth(MaxWidth);
		fiveButton.setPrefHeight(MaxHeight);
		
		dotButton.setPrefWidth(MaxWidth);
		dotButton.setPrefHeight(40);
		
		sixButton.setPrefWidth(MaxWidth);
		sixButton.setPrefHeight(MaxHeight);
		
		sevenButton.setPrefWidth(MaxWidth);
		sevenButton.setPrefHeight(MaxHeight);
		
		spaceButton.setPrefWidth(MaxWidth);
		spaceButton.setPrefHeight(40);
		
		eightButton.setPrefWidth(MaxWidth);
		eightButton.setPrefHeight(MaxHeight);
		
		nineButton.setPrefWidth(MaxWidth);
		nineButton.setPrefHeight(MaxHeight);
		
		zeroButton.setPrefWidth(MaxWidth);
		zeroButton.setPrefHeight(MaxHeight);
		Button expButton =new Button("EXP");
		expButton.setPrefWidth(MaxWidth);
		expButton.setPrefHeight(MaxHeight);
		
		Button EqualButton =new Button("=");
		EqualButton.setPrefWidth(MaxWidth);
		EqualButton.setPrefHeight(50);
		
		Button MButton =new Button("M");
		MButton.setPrefWidth(MaxWidth);
		MButton.setPrefHeight(MaxHeight);
		
		Button FButton =new Button("F");
		 FButton.setPrefWidth(MaxWidth);
		 FButton.setPrefHeight(MaxHeight);
		 
		 Button backspaceButton =new Button("B");
		 backspaceButton.setPrefWidth(MaxWidth);
		 backspaceButton.setPrefHeight(MaxHeight);
		 
		 Button ExitButton =new Button("X");
		 ExitButton.setPrefWidth(MaxWidth);
		 ExitButton.setPrefHeight(MaxHeight);
		 
		 Button ClearMemoryButton =new Button("C");
		 ClearMemoryButton.setPrefWidth(MaxWidth);
		 ClearMemoryButton.setPrefHeight(MaxHeight);
		
		////////////////////////////////
		
		
		
		Button MultiplyButton =new Button("*");
		MultiplyButton.setPrefWidth(MaxWidth);
		MultiplyButton.setPrefHeight(MaxHeight);
		
		Button plusButton =new Button("+");
		plusButton.setPrefWidth(MaxWidth);
		plusButton.setPrefHeight(MaxHeight);
		
		Button divideButton =new Button("/");
		divideButton.setPrefWidth(MaxWidth);
		divideButton.setPrefHeight(MaxHeight);
		
		Button minusButton =new Button("-");
		minusButton.setPrefWidth(MaxWidth);
		minusButton.setPrefHeight(MaxHeight);
		
		
		
		
		
		////////////////////////////
		
		primaryStage.setTitle("Fx Calculator");
		GridPane root = new GridPane();
		Scene scene = new Scene(root);
		primaryStage.setHeight(390);
		primaryStage.setWidth(360);
		
		root.setHgap(10);
		root.setVgap(7);
		//root.setGridLinesVisible(true);
		root.setPadding(new Insets(12));
		
		
		
		
		
		root.add(sevenButton, 0, 1);
		
		root.add(sixButton, 1, 1);
		
		root.add(fiveButton, 2, 1);
		
		root.add(plusButton, 3, 1);
		root.add(MultiplyButton, 4, 1);
		root.add(minusButton, 4, 2);
		root.add(divideButton, 3, 2);
		root.add(fourButton, 0, 2);
		root.add(threeButton, 1, 2);
		root.add(twoButton, 2, 2);
		
		root.add(oneButton, 0, 3);
		root.add(zeroButton, 1, 3);
		root.add(nineButton, 2, 3);
		
		root.add(MButton, 3, 3);
		root.add(FButton, 4, 3);
		
		root.add(expButton, 0, 4);
		root.add(EqualButton, 1, 4 );
		
		root.add(ClearMemoryButton, 2, 4 );
		root.add(backspaceButton, 3, 4 );
		root.add(ExitButton, 4, 4 );
	
		
		textField.setDisable(true);
		textField.setText("0");
		textField.setPrefWidth(100);
		textField.setPrefHeight(43);
	
		textField.setAlignment(Pos.BOTTOM_RIGHT);
		GridPane.setColumnSpan(textField, 3);
		textField.setFont(Font.font("Verdana",  FontWeight.BOLD,17));
		
		root.add(textField, 0, 0);
		root.add(dotButton,4, 0);
		root.add(spaceButton, 3, 0);
		GridPane.setHalignment(textField, HPos.CENTER);
		
		spaceButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				String Builder=new String();
				
				
				if(textField.getText().equals("0"))
					Builder=null;
				else{
					Builder+=" ";
					textField.appendText(Builder);
				}
				
			}
			
			
		});
		
		oneButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(oneButton);
				
			}
		});
		
		twoButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(twoButton);
				
			}
		});
		threeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(threeButton);
				
			}
		});
		
		fourButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(fourButton);
				
			}
		});
		fiveButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				ActionEvent_ButtonClick(fiveButton);
				
			}
		});
		sixButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				ActionEvent_ButtonClick(sixButton);
				
			}
		});
		sevenButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			
				ActionEvent_ButtonClick(sevenButton);
				
			}
		});
		
		nineButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				ActionEvent_ButtonClick(nineButton);
				
			}
		});
		nineButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.SECONDARY)){
					ActionEvent_ButtonClick(eightButton);
				}
				
			}
		});
		zeroButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(zeroButton);
				
			}
		});
		
		plusButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(plusButton);
				
			}
		});
		MultiplyButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(MultiplyButton);
				
			}
		});
		divideButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(divideButton);
				
			}
		});
		minusButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ActionEvent_ButtonClick(minusButton);
				
			}
		});
		dotButton.setOnAction(new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent event) {
				
				if(textField.getText().equals("0")&& realDot <= 1){
					textField.clear();
					ActionEvent_ButtonClick(dotButton);
					isoperator=true;
					realDot+=1;
					DotCount =DotProcedure(textField.getText());
					DoTindex.add(DotCount);
				}else{
					realDot+=1;
				}

				 if(realDot >= 1 && isoperator==false)
				{
					DotCount =DotProcedure(textField.getText());
					
					if(Foundoperator(DotCount)==false){
						ActionEvent_ButtonClick(dotButton);
						realDot+=1;
						isoperator=true;
						DoTindex.add(DotCount);
					}
					
				}
				else if(realDot> 1 && isoperator ==true){
					DotCount =DotProcedure(textField.getText());
					if(Foundoperator(DotCount)==true){
						isoperator=true;
					}else{
						ActionEvent_ButtonClick(dotButton);
					realDot+=1;
					DoTindex.add(DotCount);
					}
				}
				
			
			}
			
		});
		ClearMemoryButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				textField.clear();
				textField.appendText("0");
				DoTindex.clear();
				realDot=0;
				isoperator=false;
				
			}
		});
		ExitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				
			}
		});
		EqualButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Rverse rev = new Rverse();
				//Double string = rev.Katya(textField.getText());
				Double string =rev.Run_Operation(textField.getText());
				textField.clear();
				if(String.valueOf(string).length() >12)
				textField.appendText(String.format("%.10f", string));
				else {
					textField.appendText(String.valueOf(string));
				}
				
			}
			
		});
		expButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if(!textField.getText().equals("0"))
				{
					textField.appendText("^");
				}
				
			}
		});
		backspaceButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				
				
				 if(textField.getLength() >=1 && !textField.getText().equals("0")){
					 textField.deleteText(textField.getLength()-1,textField.getLength());		
				 }
				
				
				 if(textField.getLength()==0)
					textField.appendText("0");
			}
		});
MButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				System.out.println(Expression.lastElement());
				if(Expression.size()>=1)
					textField.clear();
					textField.appendText(Expression.lastElement());
				
			}
		});
FButton.setOnAction(new EventHandler<ActionEvent>() {

	@Override
	public void handle(ActionEvent event) {
		String xString=textField.getText();
		storage.DataWriter(xString);
				
		
	}
});
spaceButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

	@Override
	public void handle(MouseEvent event) {
		if(event.getButton().equals(MouseButton.SECONDARY)){
			if(event.getClickCount()==2){
				StringBuilder stringBuilder=new StringBuilder();
				
				String Temp=new String();
				
				
				int SpaceIndex=Determine_LastSpace_Input(textField.getText(),textField.getLength()-1);//dertermine last space inputted
				
				if(SpaceIndex<0){
					if(textField.getLength()>=1&&!textField.getText().equals("0")&&!textField.getText().equals("+")&&!textField.getText().equals("-")&&!textField.getText().equals("/")&&!textField.getText().equals("*")&&!textField.getText().equals(" ")&&!textField.getText().equals("."))	{
					if(!textField.getText().startsWith("+")&&!textField.getText().startsWith("-")){
						String nink=(String) textField.getText();
						stringBuilder.append(nink);
						stringBuilder.insert(0, "-");
						Temp=stringBuilder.toString();
						textField.replaceText(0, textField.getLength(), Temp);
					}else if (textField.getText().startsWith("+")) {
						textField.replaceText(0, 1, "-");
					}else if (textField.getText().startsWith("-")) {
						textField.deleteText(0, 1);
					
					}
				}
				}
				else{
				if(textField.getLength()>=1&&!textField.getText().equals("0")&&!textField.getText().equals("+")&&!textField.getText().equals("-")&&!textField.getText().equals("/")&&!textField.getText().equals("*")&&!textField.getText().equals(" ")&&!textField.getText().equals("."))
				{
					 if(textField.getText().substring(SpaceIndex+1, textField.getLength()-1).startsWith("+") ) {
						textField.replaceText(SpaceIndex+1, SpaceIndex+2, "-");
					}
					 else if(!textField.getText().substring(SpaceIndex+1, textField.getLength()).startsWith("-")&&!textField.getText().substring(SpaceIndex+1, textField.getLength()).startsWith("+"))
					{
						String nink=(String) textField.getText().substring(SpaceIndex+1,textField.getLength());
						stringBuilder.append(nink);
						stringBuilder.insert(0, "-");
						Temp=stringBuilder.toString();
						
						textField.replaceText(SpaceIndex+1, textField.getLength(), Temp);
					}
				
				else if(textField.getText().substring(SpaceIndex+1, textField.getLength()-1).startsWith("-"))
				{
					textField.deleteText(SpaceIndex+1, SpaceIndex+2);
					
				}
				
				}
				}
				
				
			}
			
		}
		
	}
	
});
		
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	@SuppressWarnings("unused")
	private void ActionEvent_ButtonClick(Object ButtonPressed){
	
		Button pressButton =(Button)ButtonPressed;
		if(textField.getText().equals("0")){
			textField.clear();
			
		}
			
		
		textField.appendText(pressButton.getText());
		Expression.push(pressButton.getText());
		
	}
	int Determine_LastSpace_Input(String textString,int size){
		for (int i = size; i>=0;i-=1) {
			if(i>=0)
			if(textString.charAt(i)== ' ')
			return i;
		}
		return -1;
		
	}
	boolean Foundoperator(Integer index){
		boolean state = false;
	//	if(DoTindex.isEmpty()){return true;}
		for(Integer in:DoTindex){
			if(index==in){
				return !state;
			}
		}
		return state;
	}
	int DotProcedure(String dotThis){
		
		for (int i = dotThis.length()-1; i>=0;i-=1) {
			if(i>=0)
			if(dotThis.charAt(i)== '+'||dotThis.charAt(i)== '-'||dotThis.charAt(i)== '*'||dotThis.charAt(i)== '/'){
				return i;
			}
		}
		return -1;
	
	}
	
}
