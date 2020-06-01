package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class removeClass extends Application{

	private int type;
	
	//employee info stuff
	private TextField nameText;
	private Label nameLabel;
	private Button submitE;
	
	public removeClass() {
		type=0;
	}
	
	public removeClass(int newType) {
		type=newType;
	}
	
	@Override
	public void start(Stage removeStage){
		
		if(type==1) {
			//do remove for employeeInfo
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tOneHandleR onehandle=new tOneHandleR();
			submitE.setOnAction(onehandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			removeStage.setTitle("Remove Employee Info");
			removeStage.setScene(sceneEI);
			removeStage.show();
			
		}
		
		if(type==2) {
			//do remove for employeeAvail
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tTwoHandleR twohandle=new tTwoHandleR();
			submitE.setOnAction(twohandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			removeStage.setTitle("Remove Employee Availability");
			removeStage.setScene(sceneEI);
			removeStage.show();
		}
		
		if(type==3) {
			//do remove for employeeRequest
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tThreeHandleR twohandle=new tThreeHandleR();
			submitE.setOnAction(twohandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			removeStage.setTitle("Remove Employee Request Off");
			removeStage.setScene(sceneEI);
			removeStage.show();
		}
		
		if(type==4) {
			//do remove for employeeComplaint
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tFourHandleR fourhandle=new tFourHandleR();
			submitE.setOnAction(fourhandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			removeStage.setTitle("Remove Employee Complaint");
			removeStage.setScene(sceneEI);
			removeStage.show();
		}
		
	}
	
	class tOneHandleR implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			//add in check for already removed employee
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				String checkStmt="SELECT employee_id, employee_name, phone_number, email, address FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"'"+";";
				ResultSet rs=stmt.executeQuery(checkStmt);			
				if(rs.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist, Cannot Delete", "Error");
					return;
				}
				
				String insertStmt="DELETE FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"'"+";";
				String insertStmt2="DELETE FROM employee_availability WHERE employee_id=" + 
						"(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				String insertStmt3="DELETE FROM request_off WHERE employee_id=" + 
						"(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";;
				String insertStmt4="DELETE FROM incident_complaints WHERE employee_id=" + 
						"(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";;
				
				
				String checkStmt2="SELECT employee_id FROM employee_availability WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==true) {
					stmt.executeUpdate(insertStmt2);
				}
				
				String checkStmt3="SELECT employee_id FROM request_off WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				ResultSet rs3=stmt.executeQuery(checkStmt3);			
				if(rs3.next()==true) {
					stmt.executeUpdate(insertStmt3);
				}
				String checkStmt4="SELECT employee_id FROM incident_complaints WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				ResultSet rs4=stmt.executeQuery(checkStmt4);			
				if(rs4.next()==true) {
					stmt.executeUpdate(insertStmt4);
				}
				
				
				stmt.executeUpdate(insertStmt);
				connection.close();
				message_time("Employee Removed","Employee Info");
			}
			catch (ClassNotFoundException ex)
			{
				message_time("Class not found", "Error inserting order");
			}
			catch(SQLException ex)
			{
				message_time("SQL Exception", "Error inserting order");
			}
		}
		public void message_time(String message, String title) {
			Stage mess_stage=new Stage();
			mess_stage.setTitle(title);
			Label mess_label=new Label(message);
			mess_label.setFont(Font.font("Times New Roman",FontWeight.BOLD, 18));
			mess_stage.setScene(new Scene(mess_label, 400, 50));
			mess_stage.show();
		}
	
	}
	
	class tTwoHandleR implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//add in check for already removed employee
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				
				String checkStmt="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"';";
				ResultSet rs=stmt.executeQuery(checkStmt);			
				if(rs.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist In System", "Error");
					return;
				}
				
				String checkStmt2="SELECT employee_id FROM employee_availability WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time("No Availability Exists To Delete", "Error");
					return;
				}
				
				String insertStmt="DELETE FROM employee_availability WHERE employee_id=" + 
						"(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				
				stmt.executeUpdate(insertStmt);
				connection.close();
				message_time("Employee Availability Removed","Employee Availability");
			}
			catch (ClassNotFoundException ex)
			{
				message_time("Class not found", "Error inserting order");
			}
			catch(SQLException ex)
			{
				message_time("SQL Exception", "Error inserting order");
			}
		}
		public void message_time(String message, String title) {
			Stage mess_stage=new Stage();
			mess_stage.setTitle(title);
			Label mess_label=new Label(message);
			mess_label.setFont(Font.font("Times New Roman",FontWeight.BOLD, 18));
			mess_stage.setScene(new Scene(mess_label, 400, 50));
			mess_stage.show();
		}
	
	}
	
	class tThreeHandleR implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//add in check for already removed employee
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				
				String checkStmt="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"';";
				ResultSet rs=stmt.executeQuery(checkStmt);			
				if(rs.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist In System", "Error");
					return;
				}
				
				String checkStmt2="SELECT employee_id FROM request_off WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time("Employee Request Off Does Not Exist", "Error");
					return;
				}
				
				String insertStmt="DELETE FROM request_off WHERE employee_id=" + 
						"(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				
				stmt.executeUpdate(insertStmt);
				connection.close();
				message_time("Employee Request Off Removed","Employee Request Off");
			}
			catch (ClassNotFoundException ex)
			{
				message_time("Class not found", "Error inserting order");
			}
			catch(SQLException ex)
			{
				message_time("SQL Exception", "Error inserting order");
			}
		}
		public void message_time(String message, String title) {
			Stage mess_stage=new Stage();
			mess_stage.setTitle(title);
			Label mess_label=new Label(message);
			mess_label.setFont(Font.font("Times New Roman",FontWeight.BOLD, 18));
			mess_stage.setScene(new Scene(mess_label, 400, 50));
			mess_stage.show();
		}
	
	}
	
	class tFourHandleR implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//add in check for already removed employee
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				
				String checkStmt="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"';";
				ResultSet rs=stmt.executeQuery(checkStmt);			
				if(rs.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist In System", "Error");
					return;
				}
				
				String checkStmt2="SELECT employee_id FROM incident_complaints WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time("Employee Complaint Does Not Exist", "Error");
					return;
				}
				
				String insertStmt="DELETE FROM incident_complaints WHERE employee_id=" + 
						"(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				
				stmt.executeUpdate(insertStmt);
				connection.close();
				message_time("Employee Complaint Removed","Employee Complaints");
			}
			catch (ClassNotFoundException ex)
			{
				message_time("Class not found", "Error inserting order");
			}
			catch(SQLException ex)
			{
				message_time("SQL Exception", "Error inserting order");
			}
		}
		public void message_time(String message, String title) {
			Stage mess_stage=new Stage();
			mess_stage.setTitle(title);
			Label mess_label=new Label(message);
			mess_label.setFont(Font.font("Times New Roman",FontWeight.BOLD, 18));
			mess_stage.setScene(new Scene(mess_label, 400, 50));
			mess_stage.show();
		}
	
	}
}
