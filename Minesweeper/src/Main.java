import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * 
 * @author likitha-9
 *
 */

public class Main extends Application {

	static BorderPane border=new BorderPane();
	static TilePane left=new TilePane();	//BorderPane's left component
	
	@Override
	public void start(Stage mainStage) throws Exception {
		
		border.setLeft(left);;
		left.getChildren().add(new Button());
		Scene scene=new Scene(border, 400,200);
		
		mainStage.setTitle("Minesweeper");
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	
	public static void main(String args[]) {
		Application.launch();
	}
	
	
}
