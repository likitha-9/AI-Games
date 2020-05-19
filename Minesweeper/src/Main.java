import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author likitha-9
 *
 */

public class Main extends Application {

	static BorderPane border = new BorderPane();
	static BorderPane left = new BorderPane(); // BorderPane's left component

	/*
	 * Elements for interactability in the UI
	 */
	static Button start = new Button("Generate");

	// toggle b/n preset and custom controls
	final ToggleGroup group = new ToggleGroup();
	static RadioButton preset = new RadioButton("Use the sliders."), custom = new RadioButton("Enter custom data.");

	// prefixed controls
	Label l_tiles = new Label("Increase/decrease size of board."),
			l_mines = new Label("Increase/decrease the number of mines.");// l_[a-z]+ -> l=label
	static Slider tiles = new Slider(10, 100, 10), mines = new Slider(10, 150, 10); // prefixed tiles, mines
	VBox preset_vbox = new VBox();

	// custom controls
	Label c_l_tiles = new Label("Specify the number of tiles:\t"),
			c_l_mines = new Label("Specify the number of mines:\t"); // -> c_l_[a-z]+ -> c=custom, l=label
	static TextField c_t_tiles = new TextField(), c_t_mines = new TextField(); // -> c_t_[a-z]+ -> c=custom, t=TextField
	VBox custom_vbox = new VBox();

	/*
	 * JavaFX Application
	 */
	@Override
	public void start(Stage mainStage) throws Exception {
		Scene scene = new Scene(border, 400, 300);
		border.setLeft(interact());

		// by default, set the first option to true
		preset_vbox.setDisable(false);
		custom_vbox.setDisable(true);

		// when one option is selected, disable the others
		preset.setOnMouseClicked(e -> {
			preset_vbox.setDisable(false);
			custom_vbox.setDisable(true);
		});
		custom.setOnMouseClicked(e -> {
			custom_vbox.setDisable(false);
			preset_vbox.setDisable(true);
		});

		mainStage.setTitle("Minesweeper");
		mainStage.setScene(scene);
		mainStage.show();

	}

	public VBox interact() {

		start.setCenterShape(true);

		// prefixed/preset controls
		preset_vbox.setPadding(new Insets(0, 0, 0, 20));

		tiles.setCenterShape(true);
		tiles.setMajorTickUnit(10);
		tiles.setMinorTickCount(1);
		tiles.setShowTickMarks(true);
		tiles.setSnapToTicks(true);
		tiles.setShowTickLabels(true);

		mines.setCenterShape(true);
		mines.setMajorTickUnit(10);
		mines.setMinorTickCount(1);
		mines.setShowTickMarks(true);
		mines.setSnapToTicks(true);
		mines.setShowTickLabels(true);

		preset_vbox.getChildren().addAll(l_tiles, tiles, l_mines, mines);

		// custom controls
		custom_vbox.setPadding(new Insets(0, 0, 0, 20));

		HBox hbox_tiles = new HBox(), hbox_mines = new HBox();
		hbox_tiles.getChildren().addAll(c_l_tiles, c_t_tiles);
		hbox_mines.getChildren().addAll(c_l_mines, c_t_mines);

		custom_vbox.getChildren().addAll(hbox_tiles, hbox_mines);

		// properties of radio buttons
		preset.setToggleGroup(group);
		preset.setSelected(true);
		custom.setToggleGroup(group);

		// both sets of controls
		VBox both = new VBox();
		both.setPadding(new Insets(10, 0, 0, 20));
		both.getChildren().addAll(preset, preset_vbox, new Text("\n"), custom, custom_vbox, new Text("\n"), start);

		// return statement
		return both;

	}

	// - main -
	public static void main(String args[]) {
		Application.launch();
	}

}
