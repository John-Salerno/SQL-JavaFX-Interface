package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class employeeAvail extends Application{

private Button Eadd, Eremove, Echange, Esearch;
	
	@Override
	public void start(Stage availStage){
		
		addHandleEA addHandler=new addHandleEA();
		removeHandleEA removeHandler=new removeHandleEA();
		changeHandleEA changeHandler=new changeHandleEA();
		searchHandleEA searchHandler=new searchHandleEA();
		
		GridPane pane=new GridPane();
   		pane.setAlignment(Pos.CENTER);
   		
   		Eadd=new Button("Add Employee Availability");
   		Eremove=new Button("Remove Employee Availability");
	    Echange=new Button("Change Employee Availability");
	    Esearch=new Button("Search Employee Availability");
	    
	    Eadd.setPrefSize(250, 50);
		Eremove.setPrefSize(250, 50);
		Esearch.setPrefSize(250, 50);
		Echange.setPrefSize(250, 50);

	    //set on action here
	    Eadd.setOnAction(addHandler);
	    Eremove.setOnAction(removeHandler);
	    Echange.setOnAction(changeHandler);
	    Esearch.setOnAction(searchHandler);
	    
	    pane.add(Eadd, 0, 0);
   		pane.add(Eremove, 0, 1);
   		pane.add(Echange, 1, 0);
   		pane.add(Esearch, 1, 1);
	       		
 		Scene scene=new Scene(pane, 700, 200);
 		availStage.setTitle("Employee Availability");
 		availStage.setScene(scene);
 		availStage.show();
	          
		
		
	}

}

class addHandleEA implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage addStage = new Stage();
		//very important line below
		addClass add = new addClass(2);
		add.start(addStage);
		addStage.show();
		
	}
	
}

class removeHandleEA implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage removeStage = new Stage();
		//very important line below
		removeClass remove = new removeClass(2);
		remove.start(removeStage);
		removeStage.show();
		
	}
	
}

class changeHandleEA implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage changeStage = new Stage();
		//very important line below
		changeClass change = new changeClass(2);
		change.start(changeStage);
		changeStage.show();
		
	}
	
}

class searchHandleEA implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage searchStage = new Stage();
		//very important line below
		searchClass search = new searchClass(2);
		search.start(searchStage);
		searchStage.show();
		
	}
	
}
