package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mainmenu extends Application{

	private Button employInfo, employAvail, employRequest, employComplaint;
	
	@Override
	public void start(Stage primaryStage){	
		
		eInfoHandle infoHandle=new eInfoHandle();
		eAvailHandle availHandle=new eAvailHandle();
		eRequestHandle reqHandle=new eRequestHandle();
		eComplaintHandle compHandle=new eComplaintHandle();
		
		
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		
		
		employInfo=new Button("Employee Information");
		employAvail=new Button("Employee Availability");
		employRequest=new Button("Employee Request Off Forms");
		employComplaint=new Button("Employee Complaints/Reports");
		
		employInfo.setPrefSize(250, 50);
		employAvail.setPrefSize(250, 50);
		employRequest.setPrefSize(250, 50);
		employComplaint.setPrefSize(250, 50);
		
		
		employInfo.setOnAction(infoHandle);
		employAvail.setOnAction(availHandle);
		employRequest.setOnAction(reqHandle);
		employComplaint.setOnAction(compHandle);
		
		pane.add(employInfo, 0, 0);
		pane.add(employAvail, 0, 1);
		pane.add(employRequest, 1, 0);
		pane.add(employComplaint, 1, 1);
		
		Scene scene=new Scene(pane, 700, 200);
		primaryStage.setTitle("Main Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

class eInfoHandle implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage infoStage = new Stage();
		employeeInfo info = new employeeInfo();
		info.start(infoStage);
		infoStage.show();
		
	}
	
}

class eAvailHandle implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage availStage = new Stage();
		employeeAvail avail = new employeeAvail();
		avail.start(availStage);
		availStage.show();
		
	}
	
}

class eRequestHandle implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage reqStage = new Stage();
		employeeRequest req = new employeeRequest();
		req.start(reqStage);
		reqStage.show();
		
	}
	
}

class eComplaintHandle implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage compStage = new Stage();
		employeeComplaint comp = new employeeComplaint();
		comp.start(compStage);
		compStage.show();
		
	}
	
}
