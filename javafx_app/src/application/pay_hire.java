package application;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class pay_hire extends Application
{

	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			/* main interface starts */
			
			primaryStage.setTitle("Machine Hire");
			//group the elements of main interface
			Group group = new Group(); 
			final Text text1 = new Text("Hire Start Date:");
			final Text text2 = new Text("Hire End Date:");
			final Text text3 = new Text("Total Hire Cost:");
			//set the position of text/labels
			text1.setFill(Color.BLACK);
	        text1.setX(30);
	        text1.setY(50);
	        text2.setFill(Color.BLACK);
	        text2.setX(30);
	        text2.setY(90);
	        text3.setFill(Color.BLACK);
	        text3.setX(30);
	        text3.setY(140);
	        //following 3 will show the result after calculation, initially don't store anything
	        Label Result1 = new Label("");
			Label Result2 = new Label("");
			Label Result3 = new Label("");
			//set their positions
			Result1.setLayoutX(130);
		    Result2.setLayoutX(130);
		    Result3.setLayoutX(130);
		    Result1.setLayoutY(38);
		    Result2.setLayoutY(78);
		    Result3.setLayoutY(128);
	        //this button opens the inner dialog
			Button submit=new Button ("New Hire Booking");  
		    //setting button position 
			submit.setLayoutX(30);
	        submit.setLayoutY(170);
	        submit.setId("submit");
	        
	        // prevent automatic exit of application when last window is closed
	        Platform.setImplicitExit(false);
			/* main interface ends */
			
			
		    /* now the main function which you want to perform on the inputs 
		    happens when the ok button is clicked in the inner dialog,remember that the event 
		    action must be present before it is triggered */
		   
	
			/* action event invoked by ok button inside inner dialog, the calling statement is after the event function ends */
		    
	       
	        /* to show the inner dialog, new hire button must be clicked */
	        
			 // action event 
	        EventHandler<ActionEvent> open_dialog = new EventHandler<ActionEvent>() 
	        { 
	            public void handle(ActionEvent e) 
	            {
	            	/* inner dialog part starts*/
	    			
	    			//create the inner dialog
	    			Dialog<Boolean> dialog = new Dialog<Boolean>();
	    		      //Setting the title
	    		    dialog.setTitle("Date picker");
	    		    //group the elements of inner dialog
	    		    Group g1 = new Group();
	    		    //start date
	    	        DatePicker d1 = new DatePicker();
	    	        //label the start date calendar
	    	        Label l1 = new Label("start date"); 
	    	        //end date
	    	        DatePicker d2 = new DatePicker();
	    	        //label the end date calendar
	    	        Label l2 = new Label("end date"); 
	    	        //field to enter the cost
	    	        TextField tf=new TextField("");  
	    	        //label the field as cost/day
	    	        Label l3 = new Label("cost/day"); 
	    	        //to confirm the chosen dates
	    	        Button read_date = new Button("Ok");
	    	        //dialog position
	    	        dialog.setHeight(250);
	    		    dialog.setWidth(250); 
	    		    dialog.setY(0);
	    		    dialog.setX(23);
	    		    //ok button position
	    	        read_date.setLayoutX(290);
	    	        read_date.setLayoutY(160);
	    	        //label position
	    	        l1.setLayoutX(10);
	    	        l1.setLayoutY(32);
	    	        l2.setLayoutX(10);
	    	        l2.setLayoutY(82);
	    	        l3.setLayoutX(10);
	    	        l3.setLayoutY(132);
	    	        //date and text field position
	    	        d1.setMinWidth(200);
	    	        d1.setLayoutX(64);
	    	        d1.setLayoutY(30);
	    	        d2.setMinWidth(200);
	    	        d2.setLayoutX(65);
	    	        d2.setLayoutY(80);
	    	        tf.setMinWidth(200);
	    	        tf.setLayoutX(65);
	    	        tf.setLayoutY(130);
	    	        //group together all the inner dialog elements
	    	        g1.getChildren().addAll(d1,d2,read_date,l1,l2,l3,tf);	
	    		    //add the group to dialog
	    	        dialog.getDialogPane().getChildren().add(g1);
	    	        Result1.setText("");
	    	        Result2.setText("");
	    	        Result3.setText("");
	    		    /* inner dialog part ends */
	    		    
	            	//shows the dialog
	            	
	    		    dialog.show(); 
	    		    //ok button clicked, fire the event
	    	        read_date.setOnAction(e1->{
	    	        
	    	        	//capture the date values 
		            	LocalDate value1 = d1.getValue();
		    	    	LocalDate value2 = d2.getValue();
		                //since the generic datatype of dialog is boolean, set it to true else the dialog will not close
		            	dialog.setResult(Boolean.TRUE);
		            	//closes the dialog
		            	dialog.close();
		            	
		            	//if the user has not selected any of the dates or start date is after end date then execute the else part
		                if((value1!=null)&&(value2!=null)&&(value1.compareTo(value2) < 0))
		                {
		                	//if no problem then calculate the difference in days
		                	long numOfDays = ChronoUnit.DAYS.between(value1,value2); 
		                	//in case user enters a string in the textfield instead of cost
		                	try
			            	{
		                	//since the number entered is always captured as a string, convert it to double, 
		                	//if it cannot convert that means user has entered a string, this executes the catch clause
		                    double input_cost = Double.parseDouble(tf.getText());
		                    //if it is negative number or zero, that is also vague so if condition executes
			                if(input_cost<=0)
			                {
			                //this will be the output on the main interface, Result2 , Result1 are still ""	
			                Result3.setText("Cost can't be negative");	
			                }
			                else
			                {
			                	//after everything is fine
			                	//main output
			                	Result1.setText(""+value1);
			                	Result2.setText(""+value2);
			                	Result3.setText("Days booked: "+numOfDays+". Total cost: "+input_cost*numOfDays);
			                	
			                }
			            	}
			            	catch(Exception e2)
			            	{
			            	//this will be the output on the main interface, Result2 , Result1 are still ""
			            	Result3.setText("Cost can't be a string");	
			            	}
		                	
		                }
		                else
		                {
		                 //this will be the output on the main interface, Result2 , Result3 are still ""
		                 Result1.setText("Either the dates are empty or incorrect order");	
		                }
		               
	    	        
	    	        });
	    		    
	            }
	        };
	        
	        //new hire button clicked, fire the event
	        
	    
	        submit.setOnAction(open_dialog);
	           
	        //group together main interface widgets
		    group.getChildren().addAll(submit,text1,text2,text3,Result1,Result2,Result3);
		    //create a scene
			Scene scene = new Scene(group,400,250); 
			//add the stylesheet
			scene.getStylesheets().add("NewFile.css");
			primaryStage.setScene(scene); 
			primaryStage.show(); 			
		}
	    //catch executes only when something is wrong with the appliction
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}
