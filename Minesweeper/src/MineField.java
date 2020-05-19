import javafx.scene.layout.Pane;

public class MineField {

	public static Pane preset_board(int size, int mines) {
		return EmptyField.createBoard(size, mines);

	}

	public static void custom_board() {

	}

}
