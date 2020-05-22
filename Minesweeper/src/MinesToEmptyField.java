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

	static Shadow shadowEffect = changeShadow(new Rectangle());

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
			int randomCol = rand.nextInt(columns), randomRow = rand.nextInt(rows); // generate random column/row numbers
			if (coords.get(randomCol).contains(randomRow)) // check if mine is already present: location [col][row]
				continue; // if present, continue; placedMines+=0
			else {
				coords.get(randomCol).add(randomRow); // if mine isn't present, add location into list
				placedMines += 1;

				// Visibly see where the mines are located:
				EmptyField.grid[randomCol][randomRow].border
				.setEffect(changeShadow(EmptyField.grid[randomCol][randomRow].border));
				EmptyField.grid[randomCol][randomRow].border.setStroke(Color.WHITE);

			}
		}
		pane = addDigits(pane, coords);
		return pane;

	}

	static Pane addDigits(Pane pane, ArrayList<ArrayList<Integer>> coords) {

		for (int i = 0; i < coords.size(); i++) {
			for (int j = 0; j < coords.get(i).size(); j++) {
				/*
				 * There are 8 cases. Each tile around a MINE is checked and assigned a digit,
				 * rather than having to iterate from (0,0) to (N,N). This saves a significant
				 * amount of time.
				 */

				// top-left corner of a mine
				try {
					if (EmptyField.grid[i - 1][j - 1].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i - 1, j - 1);
					}
				} catch (Exception E) {
					// ignore
				}

				// top-middle tile
				try {
					if (EmptyField.grid[i][j - 1].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i, j - 1);
					}
				} catch (Exception E) {
					// ignore
				}

				// top-right corner
				try {
					if (EmptyField.grid[i + 1][j - 1].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i + 1, j - 1);
					}
				} catch (Exception E) {
					// ignore
				}

				// middle-left tile
				try {
					if (EmptyField.grid[i - 1][j].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i - 1, j);
					}
				} catch (Exception E) {
					// ignore
				}

				// middle-right tile
				try {
					if (EmptyField.grid[i + 1][j - 1].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i + 1, j - 1);
					}
				} catch (Exception E) {
					// ignore
				}

				// bottom-left corner
				try {
					if (EmptyField.grid[i - 1][j + 1].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i - 1, j + 1);
					}
				} catch (Exception E) {
					// ignore
				}

				// bottom-middle tile
				try {
					if (EmptyField.grid[i][j + 1].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i, j + 1);
					}
				} catch (Exception E) {
					// ignore
				}

				// bottom-right corner
				try {
					if (EmptyField.grid[i + 1][j + 1].border.getEffect() != shadowEffect) {
						int digit = assignDigit(i + 1, j + 1);
					}
				} catch (Exception E) {
					// ignore
				}
			}
		}
		return pane;

	}

	static Shadow changeShadow(Rectangle border) {
		/*
		 * Mines are randomly placed. To distinguish a mine from a normal tile, a
		 * "shadow" effect is added. Blue tiles are normal ones while red tiles are
		 * mines.
		 */
		Shadow shadow = new Shadow();
		shadow.setBlurType(BlurType.GAUSSIAN);
		shadow.setColor(Color.RED);
		shadow.setRadius(2);
		// border.setEffect(shadow);
		return shadow;
	}

	static int assignDigit(int x, int y) {
		/*
		 * This method is called by addDigits(). addDigits() passes the address
		 * (coordinates; not literal address) of a TILE, and this method counts the
		 * number of mines surrounding THAT tile. The code looks somewhat similar, but
		 * addDigits() and assignDigit() are checking for separate things.
		 */
		int count = 0;
		try {
			if (EmptyField.grid[x - 1][y - 1].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		try {
			if (EmptyField.grid[x][y - 1].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		try {
			if (EmptyField.grid[x + 1][y - 1].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		try {
			if (EmptyField.grid[x - 1][y].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		try {
			if (EmptyField.grid[x + 1][y].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		try {
			if (EmptyField.grid[x - 1][y + 1].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		try {
			if (EmptyField.grid[x][y + 1].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		try {
			if (EmptyField.grid[x + 1][y + 1].border.getStroke() == Color.WHITE)
				count++;
		} catch (Exception E) {
			// ignore
		}

		return count;
	}

}
