import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;

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

		//Keep track of where mines are being added.
		ArrayList<ArrayList<Integer>> coords=new ArrayList<>();
		for(int i=0;i<columns;i++)
			coords.add(new ArrayList<Integer>());

		int placedMines = 0; //initially zero

		Random rand = new Random();	//to place mines randomly

		while (placedMines < mines) {
			int randomCol = rand.nextInt(columns), randomRow = rand.nextInt(rows);

			if(coords.get(randomCol).contains(randomRow))
				continue;
			else
			{
				coords.get(randomCol).add(randomRow);
				placedMines+=1;
			}
		}
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {

			}
		}
		return pane;

	}

}
