package JaoksUppgifter;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	private ArrayList <BJCard> cards = new ArrayList<BJCard>();
	
	
	public CardDeck(){
		
		for(int i = 1; i <= 4; i++){
			
			for(int j = 2; j <= 14; j++){
				
				BJCard c = new BJCard(i, j);
				cards.add(c);
				
			}
		}
		
	}
	public BJCard Draw(){
		
		BJCard card = cards.get(0);
		cards.remove(0);
		 
		return card;
		
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	

}
