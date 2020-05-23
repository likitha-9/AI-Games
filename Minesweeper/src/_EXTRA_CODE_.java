
public class _EXTRA_CODE_ {
	/**				System.out.println(randomCols.get(i) + " " + coords.get(randomCols.get(i)).get(j));

	// top-left corner of a mine

	try {
		if (EmptyField.grid[randomCols.get(i) - 1][coords.get(randomCols.get(i)).get(j) - 1].border
				.getEffect() != shadowEffect) {

			// System.out.println("FALSE");

			int digit = assignDigit(randomCols.get(i) - 1, coords.get(randomCols.get(i)).get(j) - 1);

			Image img = new Image(Integer.valueOf(digit).toString() + ".png");
			ImagePattern imagePattern = new ImagePattern(img);
			EmptyField.grid[randomCols.get(i) - 1][coords.get(randomCols.get(i)).get(j) - 1].border
			.setFill(imagePattern);

			// System.out.println(EmptyField.grid[randomCols.get(i) -
			// 1][coords.get(randomCols.get(i)).get(j) - 1].border.getFill().getClass() ==
			// ImagePattern.class);

		}
	} catch (Exception E) {
		// ignore
	}

	// top-middle tile
	try {
		if (EmptyField.grid[i][j - 1].border.getEffect() != shadowEffect) {
			if (EmptyField.grid[randomCols.get(i)][coords.get(randomCols.get(i)).get(j) - 1].border
					.getEffect() != shadowEffect) {

				int digit = assignDigit(randomCols.get(i), coords.get(randomCols.get(i)).get(j) - 1);

				Image img = new Image(Integer.valueOf(digit).toString() + ".png");
				ImagePattern imagePattern = new ImagePattern(img);
				EmptyField.grid[randomCols.get(i)][coords.get(randomCols.get(i)).get(j) - 1].border
				.setFill(imagePattern);

			}

		}
	} catch (Exception E) {
		// ignore
	}

	// top-right corner
	try {
		if (EmptyField.grid[i + 1][j - 1].border.getEffect() != shadowEffect) {
			if (EmptyField.grid[i + 1][j - 1].border.getEffect() != shadowEffect) {
				if (EmptyField.grid[randomCols.get(i)][coords.get(randomCols.get(i)).get(j) - 1].border
						.getEffect() != shadowEffect) {

					int digit = assignDigit(randomCols.get(i) + 1,
							coords.get(randomCols.get(i)).get(j) - 1);

					Image img = new Image(Integer.valueOf(digit).toString() + ".png");
					ImagePattern imagePattern = new ImagePattern(img);
					EmptyField.grid[randomCols.get(i) + 1][coords.get(randomCols.get(i)).get(j) - 1].border
					.setFill(imagePattern);

				}

			}
		}
	} catch (Exception E) {
		// ignore
	}

	// middle-left tile
	try {
		if (EmptyField.grid[i - 1][j].border.getEffect() != shadowEffect) {
			if (EmptyField.grid[i - 1][j].border.getEffect() != shadowEffect) {
				if (EmptyField.grid[randomCols.get(i) - 1][coords.get(randomCols.get(i)).get(j)].border
						.getEffect() != shadowEffect) {

					int digit = assignDigit(randomCols.get(i) - 1, coords.get(randomCols.get(i)).get(j));

					Image img = new Image(Integer.valueOf(digit).toString() + ".png");
					ImagePattern imagePattern = new ImagePattern(img);
					EmptyField.grid[randomCols.get(i) - 1][coords.get(randomCols.get(i)).get(j)].border
					.setFill(imagePattern);

				}

			}
		}
	} catch (Exception E) {
		// ignore
	}

	// middle-right tile
	try {
		if (EmptyField.grid[i + 1][j ].border.getEffect() != shadowEffect) {
			if (EmptyField.grid[i + 1][j ].border.getEffect() != shadowEffect) {
				if (EmptyField.grid[randomCols.get(i) + 1][coords.get(randomCols.get(i)).get(j) ].border
						.getEffect() != shadowEffect) {

					int digit = assignDigit(randomCols.get(i) + 1,
							coords.get(randomCols.get(i)).get(j) );

					Image img = new Image(Integer.valueOf(digit).toString() + ".png");
					ImagePattern imagePattern = new ImagePattern(img);
					EmptyField.grid[randomCols.get(i) + 1][coords.get(randomCols.get(i)).get(j) ].border
					.setFill(imagePattern);

				}

			}
		}
	} catch (Exception E) {
		// ignore
	}

	// bottom-left corner
	try {
		if (EmptyField.grid[i - 1][j + 1].border.getEffect() != shadowEffect) {
			if (EmptyField.grid[i - 1][j + 1].border.getEffect() != shadowEffect) {
				if (EmptyField.grid[randomCols.get(i) - 1][coords.get(randomCols.get(i)).get(j) + 1].border
						.getEffect() != shadowEffect) {

					int digit = assignDigit(randomCols.get(i) - 1,
							coords.get(randomCols.get(i)).get(j) + 1);

					Image img = new Image(Integer.valueOf(digit).toString() + ".png");
					ImagePattern imagePattern = new ImagePattern(img);
					EmptyField.grid[randomCols.get(i) - 1][coords.get(randomCols.get(i)).get(j) + 1].border
					.setFill(imagePattern);

				}

			}
		}
	} catch (Exception E) {
		// ignore
	}

	// bottom-middle tile
	try {
		if (EmptyField.grid[i][j + 1].border.getEffect() != shadowEffect) {
			if (EmptyField.grid[i][j + 1].border.getEffect() != shadowEffect) {
				if (EmptyField.grid[randomCols.get(i)][coords.get(randomCols.get(i)).get(j) + 1].border
						.getEffect() != shadowEffect) {

					int digit = assignDigit(randomCols.get(i), coords.get(randomCols.get(i)).get(j) + 1);

					Image img = new Image(Integer.valueOf(digit).toString() + ".png");
					ImagePattern imagePattern = new ImagePattern(img);
					EmptyField.grid[randomCols.get(i)][coords.get(randomCols.get(i)).get(j) + 1].border
					.setFill(imagePattern);

				}

			}
		}
	} catch (Exception E) {
		// ignore
	}

	// bottom-right corner
	try {
		if (EmptyField.grid[i + 1][j + 1].border.getEffect() != shadowEffect) {
			if (EmptyField.grid[i + 1][j + 1].border.getEffect() != shadowEffect) {
				if (EmptyField.grid[randomCols.get(i) + 1][coords.get(randomCols.get(i)).get(j) + 1].border
						.getEffect() != shadowEffect) {

					int digit = assignDigit(randomCols.get(i) + 1,
							coords.get(randomCols.get(i)).get(j) + 1);

					Image img = new Image(Integer.valueOf(digit).toString() + ".png");
					ImagePattern imagePattern = new ImagePattern(img);
					EmptyField.grid[randomCols.get(i) + 1][coords.get(randomCols.get(i)).get(j) + 1].border
					.setFill(imagePattern);

				}

			}
		}
	} catch (Exception E) {
		// ignore
	}

	 */
}
