package hr.ivan.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents board with 9 positions
 */
public class Board {

	// +---+---+---+
	// | 0 | 1 | 2 |
	// +---+---+---+
	// | 3 | 4 | 5 |
	// +---+---+---+
	// | 6 | 7 | 8 |
	// +---+---+---+
	private Map<Integer, Card> board;
	private int numOfcombination;

	public Board() {
		this.board = new HashMap<>();
		numOfcombination = 0;
	}

	/**
	 * Recursive method that finds all possible valid combinations of cards on
	 * board.
	 * 
	 * @param cardList
	 *            List of remaining cards
	 * @param position
	 *            represents a place on the board for a new card and number of
	 *            recursive calls of this method
	 */
	public void combine(List<Card> cardList, int position) {

		switch (position) {
		case 2:
			if (checkFirstCodition())
				break;
			else
				return;
		case 3:
			if (checkSecondCodition())
				break;
			else
				return;
		case 4:
			if (checkThirdCodition())
				break;
			else
				return;
		case 5:
			if (checkFourthCodition())
				break;
			else
				return;
		case 6:
			if (checkFifthCodition())
				break;
			else
				return;
		case 7:
			if (checkSixthCodition())
				break;
			else
				return;
		case 8:
			if (checkSeventhCodition())
				break;
			else
				return;
		case 9:
			if (checkEighthCodition()) {
				numOfcombination++;
				newCombination();
				break;
			} else
				return;
		default:
			break;
		}

		for (Card card : cardList) {
			do {
				List<Card> newCardList = new ArrayList<>(cardList);
				newCardList.remove(card);
				board.put(position, card);
				int newPosition = position + 1;
				combine(newCardList, newPosition);
			} while (card.rotate());
		}
	}

	public int getNumOfcombination() {
		return numOfcombination;
	}

	// +---+---+
	// | 0 | 1 |
	// +---+---+
	private boolean checkFirstCodition() {
		return board.get(0).getColor(1) == board.get(1).getColor(3)
				&& board.get(0).getTurtlePart(1) != board.get(1).getTurtlePart(3);
	}

	// +---+---+
	// | 1 | 2 |
	// +---+---+
	private boolean checkSecondCodition() {
		return board.get(1).getColor(1) == board.get(2).getColor(3)
				&& board.get(1).getTurtlePart(1) != board.get(2).getTurtlePart(3);
	}

	// +---+
	// | 0 |
	// +---+
	// | 3 |
	// +---+
	private boolean checkThirdCodition() {
		return board.get(0).getColor(2) == board.get(3).getColor(0)
				&& board.get(0).getTurtlePart(2) != board.get(3).getTurtlePart(0);
	}

	// +---+
	// | 1 |
	// +---+---+
	// | 3 | 4 |
	// +---+---+
	private boolean checkFourthCodition() {
		return board.get(1).getColor(2) == board.get(4).getColor(0)
				&& board.get(1).getTurtlePart(2) != board.get(4).getTurtlePart(0)
				&& board.get(3).getColor(1) == board.get(4).getColor(3)
				&& board.get(3).getTurtlePart(1) != board.get(4).getTurtlePart(3);
	}

	// +---+
	// | 2 |
	// +---+---+
	// | 4 | 5 |
	// +---+---+
	private boolean checkFifthCodition() {
		return board.get(2).getColor(2) == board.get(5).getColor(0)
				&& board.get(2).getTurtlePart(2) != board.get(5).getTurtlePart(0)
				&& board.get(4).getColor(1) == board.get(5).getColor(3)
				&& board.get(4).getTurtlePart(1) != board.get(5).getTurtlePart(3);
	}

	// +---+
	// | 3 |
	// +---+
	// | 6 |
	// +---+
	private boolean checkSixthCodition() {
		return board.get(3).getColor(2) == board.get(6).getColor(0)
				&& board.get(3).getTurtlePart(2) != board.get(6).getTurtlePart(0);
	}

	// +---+
	// | 4 |
	// +---+---+
	// | 6 | 7 |
	// +---+---+
	private boolean checkSeventhCodition() {
		return board.get(4).getColor(2) == board.get(7).getColor(0)
				&& board.get(4).getTurtlePart(2) != board.get(7).getTurtlePart(0)
				&& board.get(6).getColor(1) == board.get(7).getColor(3)
				&& board.get(6).getTurtlePart(1) != board.get(7).getTurtlePart(3);
	}

	// +---+
	// | 5 |
	// +---+---+
	// | 7 | 8 |
	// +---+---+
	private boolean checkEighthCodition() {
		return board.get(5).getColor(2) == board.get(8).getColor(0)
				&& board.get(5).getTurtlePart(2) != board.get(8).getTurtlePart(0)
				&& board.get(7).getColor(1) == board.get(8).getColor(3)
				&& board.get(7).getTurtlePart(1) != board.get(8).getTurtlePart(3);
	}

	/**
	 * Print new combination.
	 */
	private void newCombination() {
		System.out.println("\n\nNew combiantion (" + numOfcombination + ".):");
		for (int i = 0; i < 9; ++i) {
			System.out.println("------ " + i + " ------\n" + board.get(i));
		}
	}
}
