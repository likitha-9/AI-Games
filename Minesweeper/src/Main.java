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
 *         1. Ask user to indicate dimensions of board and number of mines.
 *
 *         2. Create the board according to the data given. (Otherwise, display
 *         error messages - ErrorMessages.java)
 *
 *         3. Enable event handling.
 *
 *         4. Enable extra features, such as timer, mine shape selection, and
 *         music. ☺
 *
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
	static boolean presetFlag = true, customFlag = false; // flags to check which of the options are true

	// prefixed controls
	Label l_tiles = new Label("Increase/decrease size of board."),
			l_mines = new Label("Increase/decrease the number of mines.");/*
			 * l_[a-z]+ -> l=label (underscores are used
			 * for Label identifiers ONLY)
			 */
	static Slider presetTiles = new Slider(10, 50, 10), presetMines = new Slider(0, 500, 100); // prefixed tiles, mines
	VBox presetVbox = new VBox();

	// custom controls
	Label c_l_tiles = new Label("Specify the number of tiles:\t"),
			c_l_mines = new Label("Specify the number of mines:\t"); // -> c_l_[a-z]+ -> c=custom, l=label
	static TextField customTiles = new TextField(), customMines = new TextField();
	VBox customVbox = new VBox();

	/*
	 * JavaFX Application
	 */
	@Override
	public void start(Stage mainStage) throws Exception {
		Scene scene = new Scene(border, 400, 300);
		border.setLeft(interact());

		// by default, set the first option to true
		presetVbox.setDisable(false);
		customVbox.setDisable(true);

		// when one option is selected, disable the others
		preset.setOnMouseClicked(e -> {
			presetVbox.setDisable(false);
			customVbox.setDisable(true);

			presetFlag = true;
			customFlag = false;
		});
		custom.setOnMouseClicked(e -> {
			customVbox.setDisable(false);
			presetVbox.setDisable(true);

			customFlag = true;
			presetFlag = false;
		});

		/*
		 * When START is clicked on, then pass the flags into one of the methods in
		 * MineField.java (depending on whether the user selected from preset entries or
		 * entered their own custom data.
		 */
		start.setOnAction(e -> {
			/*
			 * Generate the minefield board (IF condition), but make sure that if custom
			 * data is entered, it is within range.
			 */
			if (presetFlag) {
				MineField.generateBoard((int) presetTiles.getValue(), (int) presetMines.getValue());
			} else {
				/*
				 * Writing test cases for custom data: make sure that the dimensions are within
				 * range. The maximum dimensions that the screen could (conveniently) handle is
				 * 50x30. So, 50 columns is the max data that should be allowed. AND disregard
				 * any strings, special characters, etc.
				 */
				try {
					// Strings are parsed into ints and the above comment is implemented below.
					if (Integer.parseInt(customTiles.getText()) >= 10 && Integer.parseInt(customTiles.getText()) <= 50
							&& Integer.parseInt(customMines.getText()) >= 10
							&& Integer.parseInt(customMines.getText()) <= 2000) {
						MineField.generateBoard(Integer.parseInt(customTiles.getText()),
								Integer.parseInt(customMines.getText()));
					} else {
						ErrorMessages.displayErrorMessages(
								new Text("Please make sure the entered dimensions are within the prescribed range!\n"
										+ "Number of tiles should be within 9<x<51.\n"
										+ "Number of mines should be within 9<x<2001."));
					}
				} catch (NumberFormatException E) {
					// Strings, special chars aren't considered valid data.
					ErrorMessages.displayErrorMessages(new Text("Please make sure you input valid data!"));
				}
			}
		});

		mainStage.setTitle("Minesweeper");
		mainStage.setScene(scene);
		mainStage.show();
	}

	public VBox interact() {
		start.setCenterShape(true);

		// prefixed/preset controls
		presetVbox.setPadding(new Insets(0, 0, 0, 20));

		presetTiles.setCenterShape(true);
		presetTiles.setMajorTickUnit(10);
		presetTiles.setMinorTickCount(1);
		presetTiles.setShowTickMarks(true);
		presetTiles.setSnapToTicks(true);
		presetTiles.setShowTickLabels(true);

		presetMines.setCenterShape(true);
		presetMines.setMajorTickUnit(50);
		presetMines.setMinorTickCount(1);
		presetMines.setShowTickMarks(true);
		presetMines.setSnapToTicks(true);
		presetMines.setShowTickLabels(true);

		presetVbox.getChildren().addAll(l_tiles, presetTiles, l_mines, presetMines);

		// custom controls
		customVbox.setPadding(new Insets(0, 0, 0, 20));

		HBox hbox_tiles = new HBox(), hbox_mines = new HBox();
		hbox_tiles.getChildren().addAll(c_l_tiles, customTiles);
		hbox_mines.getChildren().addAll(c_l_mines, customMines);

		customVbox.getChildren().addAll(hbox_tiles, hbox_mines);

		// properties of radio buttons
		preset.setToggleGroup(group);
		preset.setSelected(true);
		custom.setToggleGroup(group);

		// adding both sets of controls into a VBox
		VBox both = new VBox();
		both.setPadding(new Insets(10, 0, 0, 20));
		both.getChildren().addAll(preset, presetVbox, new Text("\n"), custom, customVbox, new Text("\n"), start);

		// return statement
		return both;
	}

	// - main -
	public static void main(String args[]) {
		Application.launch();
	}

}
