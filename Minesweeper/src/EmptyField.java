import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author likitha-9
 *
 *         Generate an empty board (game stage) based on given dimensions.
 *
 */

public class EmptyField {

	static final int sizeOfTileWidth = 20, sizeOfTileHeight = 20; // standard size of each tile

	// Number of tiles = determined by preset/custom data
	static int fieldWidth, fieldHeight;

	static int cellsX, cellsY;
	static Board[][] grid;

	static class Board extends StackPane {
		// Each rectangle is defined as a square. A square = 1 cell in the blank canvas
		Rectangle border = new Rectangle(sizeOfTileWidth, sizeOfTileHeight);

		// This constructor is called each time a new cell has to be defined
		public Board(int x, int y) {
			// Add each cell as the pane's children
			getChildren().add(border);

			// Each cell's dimensions are of sizeOfCellWidth and sizeOfCellHeight
			setTranslateX(x * sizeOfTileWidth);
			setTranslateY(y * sizeOfTileHeight);

			// Each cell is initially white in color.
			border.setStroke(Color.BLACK);
			border.setEffect(addShadow(border));
		}

		Shadow addShadow(Rectangle border) {
			Shadow shadow = new Shadow();
			shadow.setBlurType(BlurType.GAUSSIAN);
			shadow.setColor(Color.DARKBLUE);
			shadow.setRadius(4);
			border.setEffect(shadow);
			return shadow;
		}
	}

	public static Pane createBoard(int size, int mines) {
		Pane pane = new Pane();
		pane.setPadding(new Insets(10));

		fieldWidth = sizeOfTileWidth * size;
		fieldHeight = sizeOfTileHeight * size;

		// Max number of cells able to fit vertically was 35. Horizontally. it's 50.
		cellsX = size;

		if (size <= 30)
			cellsY = size;
		else
			cellsY = 30;

		grid = new Board[cellsX][cellsY];

		// Define board's dimensions
		pane.setPrefSize(fieldWidth, fieldHeight);

		// Fill the board with cells
		for (int i = 0; i < cellsX; i++) {
			for (int j = 0; j < cellsY; j++) {
				grid[i][j] = new Board(i, j);
				pane.getChildren().add(grid[i][j]);
			}
		}

		// Return pane filled with children
		Stage gameStage = new Stage();
		Scene gameScene = new Scene(pane, fieldWidth, fieldHeight);
		gameStage.setScene(gameScene);
		gameStage.setMaximized(true);
		gameStage.show();

		return pane;
	}
}