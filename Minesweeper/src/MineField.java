import javafx.scene.layout.Pane;

public class MineField {

	public static Pane generateBoard(int size, int mines) {
		Pane pane = EmptyField.createBoard(size, mines); // create empty board
		pane = MinesToEmptyField.addMines(pane, mines); // add mines randomly to empty board
		return pane; // return board
	}

}
