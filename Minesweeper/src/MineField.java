import javafx.scene.layout.Pane;

public class MineField {

	public static Pane generateBoard(int size, int mines) {
		return EmptyField.createBoard(size, mines);
	}

}


