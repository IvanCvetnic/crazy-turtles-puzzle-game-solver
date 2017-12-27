package hr.ivan.home;

import java.util.Arrays;
import java.util.List;

public class TurtlesSimulator {
	
	public static void main(String[] args) {
		
		Card[] cards = new Card[9];
		
		//Cards source: turtles.png (grafika-grafoprint: "Šašave kornjače")
		//http://www.grafika-grafoprint.hr/kategorija/362-edukativne-igre/stranica-2
		
		cards[0] = new Card(Color.RED, Color.YELLOW, Color.RED, Color.GREEN, 
					TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 0);	
		cards[1] = new Card(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
					TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 1);	
		cards[2] = new Card(Color.BLUE, Color.YELLOW, Color.BLUE, Color.GREEN,
					TurtlePart.HEAD, TurtlePart.HEAD, TurtlePart.TAIL, TurtlePart.TAIL, 2);
		cards[3] = new Card(Color.YELLOW, Color.GREEN, Color.RED, Color.BLUE,
					TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 3);
		cards[4] = new Card(Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, 
					TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 4);
		cards[5] = new Card(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
					TurtlePart.HEAD, TurtlePart.HEAD, TurtlePart.TAIL, TurtlePart.TAIL, 5);
		cards[6] = new Card(Color.GREEN, Color.BLUE, Color.RED, Color.BLUE, 
					TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 6);
		cards[7] = new Card(Color.RED, Color.GREEN, Color.BLUE, Color.BLUE, 
					TurtlePart.HEAD, TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, 7);
		cards[8] = new Card(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW,
					TurtlePart.HEAD, TurtlePart.HEAD, TurtlePart.TAIL, TurtlePart.TAIL, 8);
		
		
		List<Card> cardList = Arrays.asList(cards);
		
		Board board = new Board();
		board.combine(cardList, 0);	
		System.out.println("\nNumber of combinations:" + board.getNumOfcombination());
	}
}
