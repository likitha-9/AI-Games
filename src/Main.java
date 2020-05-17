import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {

	static BorderPane border=new BorderPane();
	static TilePane left=new TilePane();	//BorderPane's left component
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Scene scene=new Scene(new Label("Welcome to Minesweeper!"), 400,200);
		
		border.getChildren().add(left);
		
		mainStage.setTitle("Minesweeper");
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	
	public static void main(String args[]) {
		Application.launch();
	}
	
	
}
