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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class changeClass extends Application{

	private int type;
	
	//employee info stuff
	private TextField nameTextEI, phoneTextEI, emailTextEI, addressTextEI;
	private Label nameLabelEI, phoneLabelEI, emailLabelEI, addressLabelEI;
	private Button EIsubmit;
	private CheckBox phoneCEI, emailCEI, addressCEI;
	
	//employee avail stuff
	private TextField nameTextEA, monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	private Label nameLabelEA, mLabelEA, tuLabelEA, wLabelEA, thLabelEA, fLabelEA, saLabelEA, suLabelEA;
	private Button EAsubmit;
	private CheckBox mondayCEA, tuesdayCEA, wednesdayCEA, thursdayCEA, fridayCEA, saturdayCEA, sundayCEA;
	
	public changeClass() {
		type=0;
	}
	
	public changeClass(int newType) {
		type=newType;
	}
	
	@Override
	public void start(Stage changeStage){
		
		if(type==1) {
			//do change for employeeInfo
			VBox pane= new VBox(10);
			HBox npane=new HBox(10);
			HBox ppane=new HBox(10);
			HBox epane=new HBox(10);
			HBox apane=new HBox(10);
			
			nameTextEI=new TextField();
			phoneTextEI=new TextField();
			emailTextEI=new TextField();
			addressTextEI=new TextField();
			
			nameLabelEI=new Label("Name (Required):");
			phoneLabelEI=new Label("Phone:");
			emailLabelEI=new Label("Email:");
			addressLabelEI=new Label("Address:");
			
			phoneLabelEI.setPrefSize(80, 7);
			emailLabelEI.setPrefSize(80, 7);
			addressLabelEI.setPrefSize(80, 7);
			
			
			phoneCEI=new CheckBox();
			emailCEI=new CheckBox();
			addressCEI=new CheckBox();
			
			
			EIsubmit=new Button("SUBMIT");
			tOneHandleC onehandle=new tOneHandleC();
			EIsubmit.setOnAction(onehandle);
			
			npane.getChildren().addAll( nameLabelEI, nameTextEI);
			ppane.getChildren().addAll(phoneCEI, phoneLabelEI, phoneTextEI);
			epane.getChildren().addAll(emailCEI, emailLabelEI, emailTextEI);
			apane.getChildren().addAll(addressCEI, addressLabelEI, addressTextEI);
			pane.getChildren().addAll(npane,ppane,epane,apane,EIsubmit);
			
			Scene sceneEI=new Scene(pane,500,300);
			changeStage.setTitle("Add Employee Info");
			changeStage.setScene(sceneEI);
			changeStage.show();
		}
		
		if(type==2) {
			//do change for employeeAvail
			VBox paneEA= new VBox(10);
			HBox npaneEA=new HBox(10);
			HBox mPaneEA=new HBox(10);
			HBox tuPaneEA=new HBox(10);
			HBox wPaneEA=new HBox(10);
			HBox thPaneEA=new HBox(10);
			HBox fPaneEA=new HBox(10);
			HBox saPaneEA=new HBox(10);
			HBox suPaneEA=new HBox(10);
			
			nameTextEA=new TextField();
			monday=new TextField();
			tuesday=new TextField();
			wednesday=new TextField();
			thursday=new TextField();
			friday=new TextField();
			saturday=new TextField();
			sunday=new TextField();
			
			nameLabelEA=new Label("Name (Required):");
			mLabelEA=new Label("Monday:");
			tuLabelEA=new Label("Tuesday:");
			wLabelEA=new Label("Wednesday:");
			thLabelEA=new Label("Thursday:");
			fLabelEA=new Label("Friday:");
			saLabelEA=new Label("Saturday:");
			suLabelEA=new Label("Sunday:");
			
			
			mLabelEA.setPrefSize(90, 7);
			tuLabelEA.setPrefSize(90, 7);
			wLabelEA.setPrefSize(90, 7);
			thLabelEA.setPrefSize(90, 7);
			fLabelEA.setPrefSize(90, 7);
			saLabelEA.setPrefSize(90, 7);
			suLabelEA.setPrefSize(90, 7);
			
			
			mondayCEA=new CheckBox();
			tuesdayCEA=new CheckBox();
			wednesdayCEA=new CheckBox();
			thursdayCEA=new CheckBox();
			fridayCEA=new CheckBox();
			saturdayCEA=new CheckBox();
			sundayCEA=new CheckBox();
			
			
			EAsubmit=new Button("SUBMIT");
			tTwoHandleC twohandleEA=new tTwoHandleC();
			EAsubmit.setOnAction(twohandleEA);
			
			npaneEA.getChildren().addAll( nameLabelEA, nameTextEA);
			mPaneEA.getChildren().addAll(mondayCEA, mLabelEA, monday);
			tuPaneEA.getChildren().addAll(tuesdayCEA, tuLabelEA, tuesday);
			wPaneEA.getChildren().addAll(wednesdayCEA, wLabelEA, wednesday);
			thPaneEA.getChildren().addAll(thursdayCEA, thLabelEA, thursday);
			fPaneEA.getChildren().addAll(fridayCEA, fLabelEA, friday);
			saPaneEA.getChildren().addAll(saturdayCEA, saLabelEA, saturday);
			suPaneEA.getChildren().addAll(sundayCEA, suLabelEA, sunday);
			paneEA.getChildren().addAll(npaneEA,mPaneEA,tuPaneEA,wPaneEA,thPaneEA,fPaneEA,saPaneEA,suPaneEA,EAsubmit);
			
			Scene sceneEA=new Scene(paneEA,600,600);
			changeStage.setTitle("Change Employee Availability");
			changeStage.setScene(sceneEA);
			changeStage.show();
		}
		
	}
	
	class tOneHandleC implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//add in check for previously added employee
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				
				//check for existing
				String checkStmt="SELECT employee_id, employee_name, phone_number, email, address FROM employee_info WHERE employee_name="+"'"+nameTextEI.getText()+"'"+";";
				ResultSet rs=stmt.executeQuery(checkStmt);			
				if(rs.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist, Cannot Update", "Error");
					return;
				}
				
				//change info
				String changeStmt="";
				
				if(phoneCEI.isSelected()) {
					changeStmt="UPDATE employee_info SET phone_number='"+phoneTextEI.getText()+"' WHERE employee_name='"+nameTextEI.getText()+"'";
					stmt.executeUpdate(changeStmt);
				}
				if(emailCEI.isSelected()) {
					changeStmt="UPDATE employee_info SET email='"+emailTextEI.getText()+"' WHERE employee_name='"+nameTextEI.getText()+"'";
					stmt.executeUpdate(changeStmt);
				}
				if(addressCEI.isSelected()) {
					changeStmt="UPDATE employee_info SET address='"+addressTextEI.getText()+"' WHERE employee_name='"+nameTextEI.getText()+"'";
					stmt.executeUpdate(changeStmt);
				}
				connection.close();
				message_time("Employee Info Updated","Employee Info");
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
	
	class tTwoHandleC implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				
				//check for existing
				String checkStmt1="SELECT employee_id FROM employee_availability WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextEA.getText()+"');";
				ResultSet rs=stmt.executeQuery(checkStmt1);			
				if(rs.next()==false) {
					connection.close();
					message_time("Employee Availability Doesn't Exist", "Error");
					return;
				}
				
				String checkStmt2="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextEA.getText()+"';";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist In System", "Error");
					return;
				}
				
				
				String selectID="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextEA.getText()+"';";
				ResultSet rsEA= stmt.executeQuery(selectID);
				rsEA.next();
				int empID=rsEA.getInt("employee_id");
						
				String mInsert="";
				String tuInsert="";
				String wInsert="";
				String thInsert="";
				String fInsert="";
				String saInsert="";
				String suInsert="";
				
				
				if(mondayCEA.isSelected()) {
					mInsert="UPDATE employee_availability SET monday='"+monday.getText()+"' WHERE employee_id='"+empID+"' ";
					stmt.executeUpdate(mInsert);
				}
				if(tuesdayCEA.isSelected()) {
					tuInsert="UPDATE employee_availability SET tuesday='"+tuesday.getText()+"' WHERE employee_id='"+empID+"' ";
					stmt.executeUpdate(tuInsert);
				}
				if(wednesdayCEA.isSelected()) {
					wInsert="UPDATE employee_availability SET wednesday='"+wednesday.getText()+"' WHERE employee_id='"+empID+"' ";
					stmt.executeUpdate(wInsert);
				}
				if(thursdayCEA.isSelected()) {
					thInsert="UPDATE employee_availability SET thursday='"+thursday.getText()+"' WHERE employee_id='"+empID+"' ";
					stmt.executeUpdate(thInsert);
				}
				if(fridayCEA.isSelected()) {
					fInsert="UPDATE employee_availability SET friday='"+friday.getText()+"' WHERE employee_id='"+empID+"' ";
					stmt.executeUpdate(fInsert);
				}
				if(saturdayCEA.isSelected()) {
					saInsert="UPDATE employee_availability SET saturday='"+saturday.getText()+"' WHERE employee_id='"+empID+"' ";
					stmt.executeUpdate(saInsert);
				}
				if(sundayCEA.isSelected()) {
					suInsert="UPDATE employee_availability SET sunday='"+sunday.getText()+"' WHERE employee_id='"+empID+"' ";
					stmt.executeUpdate(suInsert);
				}
				
				
				connection.close();
				message_time("Employee Availability Changed","Employee Availability");
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
