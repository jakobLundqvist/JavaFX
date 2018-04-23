package JaoksUppgifter;

public class BJBot extends BJPlayer{
	
	BJBot(){
		
		super();
		
	}
	
	public boolean ShouldIHit(){
		
		if(getHandValue() < 17){
			
			return true;
			
		}
		else{
			return false;
		}
		
	}
	
	public void activate(){
		mainCard.players.remove(0);
		while(ShouldIHit()){
			hit();
		}
		
		if (mainCard.players.size() > 0) {
			mainCard.players.get(0).activate();
			
		}
	}
	
}

