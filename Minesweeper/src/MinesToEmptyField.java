import java.util.ArrayList;
import java.util.Random;

//import com.sun.prism.paint.ImagePattern;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
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
 *         Then, figure out how many mines are around a particular tile. Number
 *         of mines will range from 0-8. 0 will be indicated by emptiness, while
 *         1-8 will have a certain digit.
 *
 */
public class MinesToEmptyField extends EmptyField {

	static Shadow shadowEffect = changeShadow(new Rectangle());

	// static int layout[][]=new int[][]
	public static Pane addMines(Pane pane, int mines) {

		// The board reads in grid[column_numbe r][row_number] format.
		int columns = EmptyField.grid.length, rows = EmptyField.grid[0].length;

		// Keep track of where mines are being added.
		ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
		ArrayList<Integer> listOfRandomCols = new ArrayList<Integer>();

		for (int i = 0; i < columns; i++)
			coords.add(new ArrayList<Integer>());

		int placedMines = 0; // initially zero

		Random rand = new Random(); // to place mines randomly

		while (placedMines < mines) {
			int randomCol = rand.nextInt(columns), randomRow = rand.nextInt(rows); // generate random column/row numbers
			listOfRandomCols.add(randomCol);
			if (coords.get(randomCol).contains(randomRow)) // check if mine is already present: location [col][row]
				continue; // if present, continue; placedMines+=0
			else {
				coords.get(randomCol).add(randomRow); // if mine isn't present, add location into list
				placedMines += 1;

				// Visibly see where the mines are located:
				EmptyField.grid[randomCol][randomRow].border
				.setEffect(changeShadow(EmptyField.grid[randomCol][randomRow].border));
				EmptyField.grid[randomCol][randomRow].border.setStroke(Color.WHITE);

				/*
				 * Image img=new Image("1.png"); ImagePattern imagePattern = new
				 * ImagePattern(img); ImageView imagePattern2 = new ImageView(img);
				 * EmptyField.grid[10][0].border.setFill(imagePattern);
				 * System.out.println(EmptyField.grid[0][0].border.getFill());
				 */
			}
		}
		pane = addDigits(pane, coords, listOfRandomCols);
		return pane;

	}

	static Pane addDigits(Pane pane, ArrayList<ArrayList<Integer>> coords, ArrayList<Integer> randomCols) {

		for (int i = 0; i < randomCols.size(); i++) {
			System.out.println("\n");
			for (int j = 0; j < coords.get(randomCols.get(i)).size(); j++) {
				/*
				 * There are 8 cases. Each tile around a MINE is checked and assigned a digit,
				 * rather than having to iterate from (0,0) to (N,N). This saves a significant
				 * amount of time.
				 */


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

	/*
	 * static int assignDigit(int x, int y) {
	 *
	 * This method is called by addDigits(). addDigits() passes the address
	 * (coordinates; not literal address) of a TILE, and this method counts the
	 * number of mines surrounding THAT tile. The code looks somewhat similar, but
	 * addDigits() and assignDigit() are checking for separate things.
	 *
	 * int count = 0; try { if (EmptyField.grid[x - 1][y - 1].border.getStroke() ==
	 * Color.WHITE) count++; } catch (Exception E) { // ignore }
	 *
	 * try { if (EmptyField.grid[x][y - 1].border.getStroke() == Color.WHITE)
	 * count++; } catch (Exception E) { // ignore }
	 *
	 * try { if (EmptyField.grid[x + 1][y - 1].border.getStroke() == Color.WHITE)
	 * count++; } catch (Exception E) { // ignore }
	 *
	 * try { if (EmptyField.grid[x - 1][y].border.getStroke() == Color.WHITE)
	 * count++; } catch (Exception E) { // ignore }
	 *
	 * try { if (EmptyField.grid[x + 1][y].border.getStroke() == Color.WHITE)
	 * count++; } catch (Exception E) { // ignore }
	 *
	 * try { if (EmptyField.grid[x - 1][y + 1].border.getStroke() == Color.WHITE)
	 * count++; } catch (Exception E) { // ignore }
	 *
	 * try { if (EmptyField.grid[x][y + 1].border.getStroke() == Color.WHITE)
	 * count++; } catch (Exception E) { // ignore }
	 *
	 * try { if (EmptyField.grid[x + 1][y + 1].border.getStroke() == Color.WHITE)
	 * count++; } catch (Exception E) { // ignore }
	 *
	 * return count; }
	 */
	static ImageView digitToImage(int digit) {
		/*
		 * This method returns the appropriate image for each digit. Values of digit
		 * range from 1-8.
		 */
		assert digit >= 1 && digit <= 8;

		ImageView img = null;
		switch (digit) {
		case 1:
			img = new ImageView("/digits/1.png");
			break;
		case 2:
			img = new ImageView("/digits/2.png");
			break;
		case 3:
			img = new ImageView("/digits/3.png");
			break;
		case 4:
			img = new ImageView("/digits/4.png");
			break;
		case 5:
			img = new ImageView("/digits/5.png");
			break;
		case 6:
			img = new ImageView("/digits/6.png");
			break;
		case 7:
			img = new ImageView("/digits/7.png");
			break;
		case 8:
			img = new ImageView("/digits/8.png");
			break;
		default:
			break;
		}

		return img;
	}
}

/**/
