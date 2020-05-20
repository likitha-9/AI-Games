import java.util.ArrayList;
import java.util.Random;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author likit
 *
 *         Given an empty mine field, add mines randomly. Extract this number
 *         from either preset data or custom data.
 *
 */
public class MinesToEmptyField extends EmptyField {

	// static int layout[][]=new int[][]
	public static Pane addMines(Pane pane, int mines) {

		// The board reads in grid[column_number][row_number] format.
		int columns = EmptyField.grid.length, rows = EmptyField.grid[0].length;

		// Keep track of where mines are being added.
		ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
		for (int i = 0; i < columns; i++)
			coords.add(new ArrayList<Integer>());

		int placedMines = 0; // initially zero

		Random rand = new Random(); // to place mines randomly

		while (placedMines < mines) {
			int randomCol = rand.nextInt(columns), randomRow = rand.nextInt(rows);// generate random column/row numbers
			if (coords.get(randomCol).contains(randomRow)) // check if mine is already present: location [col][row]
				continue; // if present, continue; placedMines+=0
			else {
				coords.get(randomCol).add(randomRow); // if mine isn't present, add location into list
				placedMines += 1;
				EmptyField.grid[randomCol][randomRow].border.setEffect(changeShadow(EmptyField.grid[randomCol][randomRow].border));
			}
		}
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {

			}
		}
		return pane;

	}

	static Shadow changeShadow(Rectangle border) {
		Shadow shadow = new Shadow();
		shadow.setBlurType(BlurType.GAUSSIAN);
		shadow.setColor(Color.RED);
		shadow.setRadius(4);
		border.setEffect(shadow);
		return shadow;
	}

}
