package application;
import java.sql.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class addClass extends Application{

	private int type;
	
	//employee info stuff
	private TextField nameTextEI, phoneTextEI, emailTextEI, addressTextEI;
	private Label nameLabelEI, phoneLabelEI, emailLabelEI, addressLabelEI;
	private Button EIsubmit;
	
	//employee avail stuff
	private TextField nameTextEA, monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	private Label nameLabelEA, mLabelEA, tuLabelEA, wLabelEA, thLabelEA, fLabelEA, saLabelEA, suLabelEA;
	private Button EAsubmit;
	private CheckBox mondayCEA, tuesdayCEA, wednesdayCEA, thursdayCEA, fridayCEA, saturdayCEA, sundayCEA;
	
	//employee request stuff
	private TextField nameTextER;
	private TextArea textER;
	private Label nameLabelER, timeLabelER;
	private Button ERsubmit;
	
	//employee complaint stuff
	private TextField nameTextEC, dateTextEC;
	private TextArea textEC;		
	private Label nameLabelEC, timeLabelEC, dateLabelEC;
	private Button ECsubmit;
	
	public addClass() {
		type=0;
	}
	
	public addClass(int newType) {
		type=newType;
	}
	
	@Override
	public void start(Stage addStage){
		
		if(type==1) {
			//do add for employeeInfo
			VBox paneEI= new VBox(10);
			HBox npaneEI=new HBox(10);
			HBox ppaneEI=new HBox(10);
			HBox epaneEI=new HBox(10);
			HBox apaneEI=new HBox(10);
			
			nameTextEI=new TextField();
			phoneTextEI=new TextField();
			emailTextEI=new TextField();
			addressTextEI=new TextField();
			
			nameLabelEI=new Label("Name:");
			phoneLabelEI=new Label("Phone:");
			emailLabelEI=new Label("Email:");
			addressLabelEI=new Label("Address:");
			
			nameLabelEI.setPrefSize(80, 7);
			phoneLabelEI.setPrefSize(80, 7);
			emailLabelEI.setPrefSize(80, 7);
			addressLabelEI.setPrefSize(80, 7);
			
			EIsubmit=new Button("SUBMIT");
			tOneHandleA onehandleEI=new tOneHandleA();
			EIsubmit.setOnAction(onehandleEI);
			
			npaneEI.getChildren().addAll(nameLabelEI, nameTextEI);
			ppaneEI.getChildren().addAll(phoneLabelEI, phoneTextEI);
			epaneEI.getChildren().addAll(emailLabelEI, emailTextEI);
			apaneEI.getChildren().addAll(addressLabelEI, addressTextEI);
			paneEI.getChildren().addAll(npaneEI,ppaneEI,epaneEI,apaneEI,EIsubmit);
			
			Scene sceneEI=new Scene(paneEI,300,300);
			addStage.setTitle("Add Employee Info");
			addStage.setScene(sceneEI);
			addStage.show();
		}
		
		if(type==2) {
			//do add for employeeAvail
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
			tTwoHandleA twohandleEA=new tTwoHandleA();
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
			addStage.setTitle("Add Employee Availability");
			addStage.setScene(sceneEA);
			addStage.show();
		}
		
		if(type==3) {
			//do add for employeeRequest
			VBox paneER= new VBox(10);
			HBox npaneER=new HBox(10);
			HBox tpaneER=new HBox(10);
			
		    nameTextER = new TextField();
			textER=new TextArea();
			
			nameLabelER=new Label("Name:");
			timeLabelER=new Label("Dates Requested:");
			
			nameLabelER.setPrefSize(120, 7);
			timeLabelER.setPrefSize(120, 7);
			
			ERsubmit=new Button("SUBMIT");
			tThreeHandleA threehandleER=new tThreeHandleA();
			ERsubmit.setOnAction(threehandleER);
			
			npaneER.getChildren().addAll(nameLabelER, nameTextER);
			tpaneER.getChildren().addAll(timeLabelER, textER);
			paneER.getChildren().addAll(npaneER,tpaneER, ERsubmit);
			
			Scene sceneER=new Scene(paneER,750,500);
			addStage.setTitle("Add Employee Request");
			addStage.setScene(sceneER);
			addStage.show();
		}
		
		if(type==4) {
			//do add for employeeComplaint
			VBox paneEC= new VBox(10);
			HBox npaneEC=new HBox(10);
			HBox tpaneEC=new HBox(10);
			HBox dpaneEC=new HBox(10);
			
		    nameTextEC = new TextField();
		    dateTextEC = new TextField();
			textEC=new TextArea();
			
			nameLabelEC=new Label("Name:");
			dateLabelEC=new Label("Form Date:");
			timeLabelEC=new Label("Form Info:");
			
			nameLabelEC.setPrefSize(90, 7);
			dateLabelEC.setPrefSize(90, 7);
			timeLabelEC.setPrefSize(90, 7);
			
			ECsubmit=new Button("SUBMIT");
			tFourHandleA fourhandleEC=new tFourHandleA();
			ECsubmit.setOnAction(fourhandleEC);
			
			npaneEC.getChildren().addAll(nameLabelEC, nameTextEC);
			tpaneEC.getChildren().addAll(timeLabelEC, textEC);
			dpaneEC.getChildren().addAll(dateLabelEC, dateTextEC);
			paneEC.getChildren().addAll(npaneEC,dpaneEC, tpaneEC, ECsubmit);
			
			Scene sceneER=new Scene(paneEC,750,500);
			addStage.setTitle("Add Employee Complaint");
			addStage.setScene(sceneER);
			addStage.show();
		}
		
	}
	


	class tOneHandleA implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//add in check for previously added employee
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
				
				String checkStmt="SELECT employee_id, employee_name, phone_number, email, address FROM employee_info WHERE employee_name="+"'"+nameTextEI.getText()+"'"+";";
				ResultSet rs=stmt.executeQuery(checkStmt);			
				if(rs.next()==true) {
					message_time("Employee With The Same Name Already Exists \n Please add *Additional Marker* To The New Name \n Make Note Of This Change Somewhere", "Error");
					return;
				}
				
				
				String insertStmt="INSERT INTO employee_info(employee_name, phone_number, email, address) "
					+ "VALUES ('"+nameTextEI.getText()+"','"+phoneTextEI.getText()+"','"+emailTextEI.getText()+"','"+addressTextEI.getText()+"');";
				
				stmt.executeUpdate(insertStmt);
				connection.close();
				message_time("Employee Added","Employee Info");
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
	
	class tTwoHandleA implements EventHandler<ActionEvent>{

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
				String checkStmt1="SELECT employee_id FROM employee_availability WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextEA.getText()+"');";
				ResultSet rs=stmt.executeQuery(checkStmt1);			
				if(rs.next()==true) {
					connection.close();
					message_time("Employee Availability Exists Already", "Error");
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
				
				
				String insertStmt= "INSERT INTO employee_availability(employee_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday) "+
						"VALUES ("+empID+",'UNAVAILABILE',"+"'UNAVAILABILE',"+"'UNAVAILABILE',"
						+"'UNAVAILABILE',"+"'UNAVAILABILE',"+"'UNAVAILABILE',"+"'UNAVAILABILE');";
				stmt.executeUpdate(insertStmt);
						
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
				message_time("Employee Availability Updated","Employee Availability");
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
	
	class tThreeHandleA implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//add in check for previously added employee request
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
					
				String checkStmt1="SELECT employee_id FROM request_off WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextER.getText()+"');";
				ResultSet rs=stmt.executeQuery(checkStmt1);			
				if(rs.next()==true) {
					connection.close();
					message_time("Employee Request Off Exists Already", "Error");
					return;
				}
				
				String checkStmt2="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextER.getText()+"';";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist In System", "Error");
					return;
				}
				
				String selectID="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextER.getText()+"';";
				ResultSet rsEA= stmt.executeQuery(selectID);
				rsEA.next();
				int empID=rsEA.getInt("employee_id");
				
				String insertStmt="INSERT INTO request_off(employee_id, request_dates) "
					+ "VALUES ("+empID+",'"+textER.getText()+"');";
				
				stmt.executeUpdate(insertStmt);
				connection.close();
				message_time("Employee Request Off Added","Employee Requests");
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
	
	class tFourHandleA implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//add in check for previously added employee request
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
			
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/employee_data", "root", "");
				System.out.println("Database connected");
			
				Statement stmt = connection.createStatement();
					
				String checkStmt1="SELECT employee_id FROM incident_complaints WHERE employee_id="
						+ "(SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextEC.getText()+"');";
				ResultSet rs=stmt.executeQuery(checkStmt1);			
				if(rs.next()==true) {
					connection.close();
					message_time("Employee Complaint Exists Already", "Error");
					return;
				}
				
				String checkStmt2="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextEC.getText()+"';";
				ResultSet rs2=stmt.executeQuery(checkStmt2);			
				if(rs2.next()==false) {
					connection.close();
					message_time("Employee Does Not Exist In System", "Error");
					return;
				}
				
				String selectID="SELECT employee_id FROM employee_info WHERE employee_name="+"'"+nameTextEC.getText()+"';";
				ResultSet rsEA= stmt.executeQuery(selectID);
				rsEA.next();
				int empID=rsEA.getInt("employee_id");
				
				String insertStmt="INSERT INTO incident_complaints(employee_id, form_date, form_info) "
					+ "VALUES ("+empID+",'"+dateTextEC.getText()+"','"+textEC.getText()+"');";
				
				stmt.executeUpdate(insertStmt);
				connection.close();
				message_time("Employee Complaint Added","Employee Complaints");
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