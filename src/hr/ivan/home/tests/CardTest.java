package hr.ivan.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hr.ivan.home.Card;
import hr.ivan.home.Color;
import hr.ivan.home.TurtlePart;

class CardTest {
	
	@Test
	void realIndexTestForRotateIndex0() {
		Card card = new Card(Color.RED, Color.YELLOW, Color.RED, Color.GREEN, 
				TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 0);
		
		card.setRotateIndex(0);
		Assertions.assertEquals(0, card.realIndex(0));
		Assertions.assertEquals(1, card.realIndex(1));
		Assertions.assertEquals(2, card.realIndex(2));
		Assertions.assertEquals(3, card.realIndex(3));
	}
	
	@Test
	void realIndexTestForRotateIndex1() {	
		Card card = new Card(Color.RED, Color.YELLOW, Color.RED, Color.GREEN, 
				TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 0);
		
		card.setRotateIndex(1);
		
		Assertions.assertEquals(3, card.realIndex(0));
		Assertions.assertEquals(0, card.realIndex(1));
		Assertions.assertEquals(1, card.realIndex(2));
		Assertions.assertEquals(2, card.realIndex(3));
	}
	
	@Test
	void realIndexTestForRotateIndex2() {	
		Card card = new Card(Color.RED, Color.YELLOW, Color.RED, Color.GREEN, 
				TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 0);
		
		card.setRotateIndex(2);
		
		Assertions.assertEquals(2, card.realIndex(0));
		Assertions.assertEquals(3, card.realIndex(1));
		Assertions.assertEquals(0, card.realIndex(2));
		Assertions.assertEquals(1, card.realIndex(3));
	}
	
	@Test
	void realIndexTestForRotateIndex3() {	
		Card card = new Card(Color.RED, Color.YELLOW, Color.RED, Color.GREEN, 
				TurtlePart.TAIL, TurtlePart.TAIL, TurtlePart.HEAD, TurtlePart.HEAD, 0);
		
		card.setRotateIndex(3);
		
		Assertions.assertEquals(1, card.realIndex(0));
		Assertions.assertEquals(2, card.realIndex(1));
		Assertions.assertEquals(3, card.realIndex(2));
		Assertions.assertEquals(0, card.realIndex(3));
	}

}
