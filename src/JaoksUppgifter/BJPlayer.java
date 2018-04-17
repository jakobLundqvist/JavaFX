package JaoksUppgifter;

import java.util.ArrayList;
import javafx.scene.Group;

public class BJPlayer extends Group{
	
	static CardDeck deck = new CardDeck();
	
	ArrayList<BJCard> hand = new ArrayList<BJCard>();
	boolean hasStopped = false;
	
	public BJPlayer(){
		
		hit();
		hit();
			
	}
	
	public int getHandValue(){
		int sum = 0;
		
		//for(BJCard c : hand){
		for(int i = 0 ; i < hand.size() ; i++){
			BJCard c = hand.get(i);
			sum += c.getValue();
		}
		return sum;
	}
	
	public void hit(){
		if(!hasStopped && getHandValue() < 21){
			
			BJCard c = deck.Draw();
			c.setTranslateX(hand.size()*(BJCard.WIDTH+10));
			hand.add(c);
			this.getChildren().add(c);
			
		}
		else if(getHandValue() >= 21){
			
			System.out.println("YOU LOSE");
			
		}
	}
	
	public void stand(){
		hasStopped = true;
	}
	

}
