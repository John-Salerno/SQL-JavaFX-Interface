package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class employeeInfo extends Application {

	private Button Eadd, Eremove, Echange, Esearch;
	
	@Override
	public void start(Stage infoStage){
		
		addHandleEI addHandler=new addHandleEI();
		removeHandleEI removeHandler=new removeHandleEI();
		changeHandleEI changeHandler=new changeHandleEI();
		searchHandleEI searchHandler=new searchHandleEI();
		
		GridPane pane=new GridPane();
   		pane.setAlignment(Pos.CENTER);
   		
   		Eadd=new Button("Add Employee");
   		Eremove=new Button("Remove Employee");
	    Echange=new Button("Change Employee");
	    Esearch=new Button("Search Employee");

	    Eadd.setPrefSize(250, 50);
		Eremove.setPrefSize(250, 50);
		Esearch.setPrefSize(250, 50);
		Echange.setPrefSize(250, 50);
	    
	    Eadd.setOnAction(addHandler);
	    Eremove.setOnAction(removeHandler);
	    Echange.setOnAction(changeHandler);
	    Esearch.setOnAction(searchHandler);

	    pane.add(Eadd, 0, 0);
   		pane.add(Eremove, 0, 1);
   		pane.add(Echange, 1, 0);
   		pane.add(Esearch, 1, 1);
	       		
 		Scene scene=new Scene(pane, 700, 200);
 		
 		infoStage.setTitle("Employee Information");
 		infoStage.setScene(scene);
 		infoStage.show();
	          
		
		
	}

	
}

class addHandleEI implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage addStage = new Stage();
		//very important line below
		addClass add = new addClass(1);
		add.start(addStage);
		addStage.show();
		
	}
	
}

class removeHandleEI implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage removeStage = new Stage();
		//very important line below
		removeClass remove = new removeClass(1);
		remove.start(removeStage);
		removeStage.show();
		
	}
	
}

class changeHandleEI implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage changeStage = new Stage();
		//very important line below
		changeClass change = new changeClass(1);
		change.start(changeStage);
		changeStage.show();
		
	}
	
}

class searchHandleEI implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Stage searchStage = new Stage();
		//very important line below
		searchClass search = new searchClass(1);
		search.start(searchStage);
		searchStage.show();
		
	}
	
}



