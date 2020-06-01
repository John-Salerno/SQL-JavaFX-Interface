package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class employeeRequest extends Application{

private Button Eadd, Eremove, Esearch;
	
	@Override
	public void start(Stage reqStage){
		
		addHandleER addHandler=new addHandleER();
		removeHandleER removeHandler=new removeHandleER();
		searchHandleER searchHandler=new searchHandleER();
		printRequest printer=new printRequest();
		
		GridPane pane=new GridPane();
   		pane.setAlignment(Pos.CENTER);
   		
   		Eadd=new Button("Add Employee Request");
   		Eremove=new Button("Remove Employee Request");
	    Esearch=new Button("Search Employee Request");
	    
	    Button printReport=new Button("Print All Request Off Sheets");
	    printReport.setPrefSize(250, 50);
	    printReport.setOnAction(printer);
	    

	    Eadd.setPrefSize(250, 50);
		Eremove.setPrefSize(250, 50);
		Esearch.setPrefSize(250, 50);
	    //set on action here
	    Eadd.setOnAction(addHandler);
	    Eremove.setOnAction(removeHandler);
	    Esearch.setOnAction(searchHandler);

	    pane.add(Eadd, 0, 0);
   		pane.add(Eremove, 0, 1);
   		pane.add(Esearch, 1, 1);
   		pane.add(printReport, 1, 0);
	       		
 		Scene scene=new Scene(pane, 700, 200);
 		reqStage.setTitle("Employee Requests");
 		reqStage.setScene(scene);
 		reqStage.show();
	          
		
		
	}

}

class printRequest implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
			System.out.println("Database connected");
			
			Statement stmt = connection.createStatement();
		
			String insertStmt="SELECT * FROM employee_data.request_off;";
			String info="";
			ResultSet rs=stmt.executeQuery(insertStmt);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			if(rs.next()==false) {
				connection.close();
				message_time_fail("No employee request off sheets", "Error");
				return;
			}
			
			rs.previous();
			
			while (rs.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1)info=info+"\n";
			        else info=info+"\n \n"; 
			        String columnValue = rs.getString(i);
			        info=info+ rsmd.getColumnName(i)+":: "+columnValue;
			    }
			}
			
			message_time_success(info, "Employee Request Off Info Recieved");
			
		}
		catch (ClassNotFoundException ex)
		{
			message_time_fail("Class not found", "Error inserting order");
		}
		catch(SQLException ex)
		{
			message_time_fail("SQL Exception", "Error inserting order");
		}
	}
	public void message_time_fail(String message, String title) {
		Stage mess_stage=new Stage();
		mess_stage.setTitle(title);
		Label mess_label=new Label(message);
		mess_label.setFont(Font.font("Times New Roman",FontWeight.BOLD, 18));
		mess_stage.setScene(new Scene(mess_label, 400, 50));
		mess_stage.show();
	}
	public void message_time_success(String message, String title) {
		Stage mess_stage=new Stage();
		mess_stage.setTitle(title);
		Label mess_label=new Label(message);
		mess_label.setFont(Font.font("Times New Roman",FontWeight.BOLD, 18));
		mess_stage.setScene(new Scene(mess_label, 500, 400));
		mess_stage.show();
	}
}

class addHandleER implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage addStage = new Stage();
		//very important line below
		addClass add = new addClass(3);
		add.start(addStage);
		addStage.show();
		
	}
	
}

class removeHandleER implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage removeStage = new Stage();
		//very important line below
		removeClass remove = new removeClass(3);
		remove.start(removeStage);
		removeStage.show();
		
	}
	
}

class searchHandleER implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage searchStage = new Stage();
		//very important line below
		searchClass search = new searchClass(3);
		search.start(searchStage);
		searchStage.show();
		
	}
	
}
