import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EmptyField {

	static final int sizeOfTileWidth = 20, sizeOfTileHeight = 20; // standard size of each tile

	// Number of tiles = determined by preset/custom data
	static int fieldWidth, fieldHeight;

	static int cellsX,cellsY;
	static Board[][] grid = new Board[cellsX][cellsY];

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
			border.setFill(Color.WHITE);
			border.setStroke(Color.BLACK);
		}
	}

	public Pane createBoard(int size, int mines) {

		Pane pane = new Pane();
		pane.setPadding(new Insets(10));

		fieldWidth=sizeOfTileWidth*size;
		fieldHeight=sizeOfTileHeight*size;

		cellsX = fieldWidth / sizeOfTileWidth;
		cellsY = fieldHeight / sizeOfTileHeight;

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
		return pane;

	}
}