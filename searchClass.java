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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class searchClass extends Application{

	private int type;
	
	//stuff for employee info
	private Label nameLabel;
	private TextField nameText;
	private Button submitE;
	
	public searchClass() {
		type=0;
	}
	
	public searchClass(int newType) {
		type=newType;
	}
	
	@Override
	public void start(Stage searchStage){
		
		if(type==1) {
			//do search for employeeInfo
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tOneHandleS onehandle=new tOneHandleS();
			submitE.setOnAction(onehandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			searchStage.setTitle("Search Employee Info");
			searchStage.setScene(sceneEI);
			searchStage.show();
		}
		
		if(type==2) {
			//do search for employeeAvail
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tTwoHandleS twohandle=new tTwoHandleS();
			submitE.setOnAction(twohandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			searchStage.setTitle("Search Employee Availability");
			searchStage.setScene(sceneEI);
			searchStage.show();
		}
		
		if(type==3) {
			//do search for employeeRequest
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tThreeHandleS threehandle=new tThreeHandleS();
			submitE.setOnAction(threehandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			searchStage.setTitle("Search Employee Request Off Info");
			searchStage.setScene(sceneEI);
			searchStage.show();
		}
		
		if(type==4) {
			//do search for employeeComplaint
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			
			nameText=new TextField();
			
			nameLabel=new Label("Name (not case sensitive):");
			
			submitE=new Button("SUBMIT");
			tFourHandleS fourhandle=new tFourHandleS();
			submitE.setOnAction(fourhandle);
			
			npane.getChildren().addAll(nameLabel, nameText);
			pane.getChildren().addAll(npane,submitE);
			
			Scene sceneEI=new Scene(pane,500,150);
			searchStage.setTitle("Search Employee Complaint Info");
			searchStage.setScene(sceneEI);
			searchStage.show();
		}
		
	}
	
	class tOneHandleS implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				String insertStmt="SELECT employee_id, employee_name, phone_number, email, address FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"'"+";";
				
				String info="";
				ResultSet rs=stmt.executeQuery(insertStmt);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				
				if(rs.next()==false) {
					connection.close();
					message_time_fail("Employee Does Not Exist", "Error");
					return;
				}
				
				rs.previous();
				
				while (rs.next()) {
				    for (int i = 1; i <= columnsNumber; i++) {
				        if (i > 1)info=info+"\n";
				        String columnValue = rs.getString(i);
				        info=info+ rsmd.getColumnName(i)+":: "+columnValue;
				    }
				}
				
				message_time_success(info, "Employee Information Recieved");
				
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
			mess_stage.setScene(new Scene(mess_label, 500, 115));
			mess_stage.show();
		}
	}
	
	class tTwoHandleS implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
				
				Statement stmt = connection.createStatement();
				
				String checkStmt2="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"';";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time_fail("Employee Does Not Exist In System \n Cannot Print Availability", "Error");
					return;
				}
			
				String insertStmt="SELECT availability_id, employee_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday "
						+ "FROM employee_availability WHERE employee_id=" + "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				
				String info="";
				ResultSet rs=stmt.executeQuery(insertStmt);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				
				if(rs.next()==false) {
					connection.close();
					message_time_fail("Employee Availability Does Not Exist", "Error");
					return;
				}
				
				rs.previous();
				
				while (rs.next()) {
				    for (int i = 1; i <= columnsNumber; i++) {
				        if (i > 1)info=info+"\n";
				        String columnValue = rs.getString(i);
				        info=info+ rsmd.getColumnName(i)+":: "+columnValue;
				    }
				}
				
				message_time_success(info, "Employee Information Recieved");
				
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
	
	class tThreeHandleS implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
				
				Statement stmt = connection.createStatement();
				
				String checkStmt2="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"';";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time_fail("Employee Does Not Exist In System \n Cannot Print Request Off", "Error");
					return;
				}
			
				String insertStmt="SELECT request_id, employee_id, request_dates "
						+ "FROM request_off WHERE employee_id=" + "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				
				String info="";
				ResultSet rs=stmt.executeQuery(insertStmt);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				
				if(rs.next()==false) {
					connection.close();
					message_time_fail("Employee Request Off Does Not Exist", "Error");
					return;
				}
				
				rs.previous();
				
				while (rs.next()) {
				    for (int i = 1; i <= columnsNumber; i++) {
				        if (i > 1)info=info+"\n";
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
	
	class tFourHandleS implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
				
				Statement stmt = connection.createStatement();
				
				String checkStmt2="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"';";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time_fail("Employee Does Not Exist In System \n Cannot Print Complaint", "Error");
					return;
				}
			
				String insertStmt="SELECT form_id, employee_id, form_date, form_info "
						+ "FROM incident_complaints WHERE employee_id=" + "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameText.getText()+"');";
				
				String info="";
				ResultSet rs=stmt.executeQuery(insertStmt);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				
				if(rs.next()==false) {
					connection.close();
					message_time_fail("Employee Request Off Does Not Exist", "Error");
					return;
				}
				
				rs.previous();
				
				while (rs.next()) {
				    for (int i = 1; i <= columnsNumber; i++) {
				        if (i > 1)info=info+"\n";
				        String columnValue = rs.getString(i);
				        info=info+ rsmd.getColumnName(i)+":: "+columnValue;
				    }
				}
				
				message_time_success(info, "Employee Complaint Info Recieved");
				
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
}
