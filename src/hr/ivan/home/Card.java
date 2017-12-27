package hr.ivan.home;

/**
 * Represents a paper square card with drawn turtles halves on each side.
 */
public class Card {

	private int rotateIndex;
	private Color[] colors;
	private TurtlePart[] turtleParts;
	private int number;

	/**
	 * Mark physical card with unique <tt>number</tt> before 
	 * you instance this class.
	 * @param upColor
	 * @param rightColor
	 * @param downColor
	 * @param leftColor
	 * @param upTurtle
	 * @param rightTurtle
	 * @param downTurtle
	 * @param leftTurtle
	 * @param number
	 */
	public Card(Color upColor, Color rightColor, Color downColor, Color leftColor, TurtlePart upTurtle,
			TurtlePart rightTurtle, TurtlePart downTurtle, TurtlePart leftTurtle, int number) {

		rotateIndex = 0;
		colors = new Color[4];
		colors[0] = upColor;
		colors[1] = rightColor;
		colors[2] = downColor;
		colors[3] = leftColor;

		turtleParts = new TurtlePart[4];
		turtleParts[0] = upTurtle;
		turtleParts[1] = rightTurtle;
		turtleParts[2] = downTurtle;
		turtleParts[3] = leftTurtle;

		this.number = number;
	}

	public int getRotateIndex() {
		return rotateIndex;
	}

	public void setRotateIndex(int rotateIndex) {
		this.rotateIndex = rotateIndex;
	}

	/**
	 * Each time this method is called, the card rotates for 90 degrees clockwise.
	 * 
	 * @return <tt>true</tt> if card is still rotated relative to the starting
	 *         position
	 */
	public boolean rotate() {
		rotateIndex++;
		if (rotateIndex > 3) {
			rotateIndex = 0;
			return false;
		}
		return true;
	}

	/**
	 * Finds the color for turtle on card side defined by <tt>index</tt>.
	 * <tt>index</tt> must be in range from <tt>0</tt> to <tt>3</tt>, otherwise it
	 * returns <tt>null</tt>.
	 * <p>
	 * 
	 * <table>
	 * <tr>
	 * <th><tt>index &nbsp</tt></th>
	 * <th><tt>card side</tt></th>
	 * </tr>
	 * <tr>
	 * <td>0</td>
	 * <td>UP</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>RGIHT</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>DOWN</td>
	 * </tr>
	 * <tr>
	 * <td>3</td>
	 * <td>LEFT</td>
	 * </tr>
	 * </table>
	 * 
	 * @param index
	 *            side of card
	 * @return turtle color on given side of card
	 */
	public Color getColor(int index) {
		if (index < 0 || index > 3)
			return null;
		return colors[realIndex(index)];
	}

	/**
	 * Finds the part for turtle on card side defined by <tt>index</tt>.
	 * <tt>index</tt> must be in range from <tt>0</tt> to <tt>3</tt>, otherwise it
	 * returns <tt>null</tt>.
	 * <p>
	 * 
	 * <table>
	 * <tr>
	 * <th><tt>index &nbsp</tt></th>
	 * <th><tt>card side</tt></th>
	 * </tr>
	 * <tr>
	 * <td>0</td>
	 * <td>UP</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>RGIHT</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>DOWN</td>
	 * </tr>
	 * <tr>
	 * <td>3</td>
	 * <td>LEFT</td>
	 * </tr>
	 * </table>
	 * 
	 * @param index
	 *            side of card
	 * @return turtle part on given side of card
	 */
	public TurtlePart getTurtlePart(int index) {
		if (index < 0 || index > 3)
			return null;
		return turtleParts[realIndex(index)];
	}

	public int realIndex(int index) {
		if (index - rotateIndex >= 0) {
			return index - rotateIndex;
		} else {
			int diff = index - rotateIndex;
			return 4 + diff;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[number = " + number + "; ");
		sb.append("rotate = " + rotateIndex + " ]\n");
		sb.append("[UP = " + getColor(0) + "-" + getTurtlePart(0) + " ]\n");
		sb.append("[RIGHT = " + getColor(1) + "-" + getTurtlePart(1) + " ]\n");
		sb.append("[DOWN = " + getColor(2) + "-" + getTurtlePart(2) + " ]\n");
		sb.append("[RIGHT = " + getColor(3) + "-" + getTurtlePart(3) + " ]\n");
		return sb.toString();
	}
}
