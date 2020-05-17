import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author likitha-9
 *
 */

public class Main extends Application {

	static BorderPane border=new BorderPane();
	static BorderPane left=new BorderPane();	//BorderPane's left component

	/*
	 * Elements for interactability in the UI
	 */
	static Button start=new Button("Generate");
	
	static Slider tiles=new Slider(10,100,10), mines=new Slider(10,150,10);
	
	
	/*
	 * JavaFX Application
	 */
	@Override
	public void start(Stage mainStage) throws Exception {
		
		border.setLeft(interact());;
		//left.getChildren().add();
		Scene scene=new Scene(border, 400,200);
		
		mainStage.setTitle("Minesweeper");
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	
	public VBox interact()
	{
		VBox vbox=new VBox();
		vbox.setPadding(new Insets(10));
		
		start.setCenterShape(true);
		
		tiles.setCenterShape(true);
		tiles.setMajorTickUnit(10);
		tiles.setMinorTickCount(1);
		tiles.setSnapToTicks(true);
		tiles.setShowTickMarks(true);
		tiles.setShowTickLabels(true);
		
		mines.setCenterShape(true);
		mines.setMajorTickUnit(10);
		mines.setMinorTickCount(1);
		mines.setSnapToTicks(true);
		mines.setShowTickMarks(true);
		mines.setShowTickLabels(true);
		
		vbox.getChildren().addAll(start,new Text("\n\nIncrease/decrease size of board.\n"),tiles,new Text("\nIncrease/decrease number of mines."),mines);
		return vbox;
		
	}
	
	// 	- main -
	public static void main(String args[]) {
		Application.launch();
	}
	
	
}
