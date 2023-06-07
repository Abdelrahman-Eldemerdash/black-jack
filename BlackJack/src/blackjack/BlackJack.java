
package blackjack;
import java.util.Scanner;
/**
 *
 * @author  Abdelrahman Eldemerdash
 */

public class BlackJack {
 
static BlackJack bj=new BlackJack();
   static Game game=new Game();
   static Player player=new Player();
    public static void main(String[] args) {
        GUI gui=new GUI();
        
       game.fill_cards();
       game.players_info();
       gui.runGUI( game.cards, game.players[0].player_cards, game.players[1].player_cards, game.players[2].player_cards, game.players[3].player_cards );
       
        Scanner input=new Scanner(System.in);
       game.maximum_score();
       bj.players_turn();
       bj.dealer_turn();
       bj.get_winner();
    }
    
   
    
    public void players_turn(){
        Scanner input=new Scanner(System.in);
            for(int playerIndex=0;playerIndex<3;playerIndex++){ 
            int choice;
            System.out.println("press 1 to HIT or 2 to STAND player "+(playerIndex+1)+" turn");
            choice=input.nextInt();
       while(choice==1){

        GUI gui=new GUI();
        gui.updatePlayerHand(game.pick_card(),playerIndex);
   game.add_card(playerIndex);
   bj.checkScore(playerIndex);
   if(game.get_score(playerIndex)>=21){
   break;
   }
   
   System.out.println("press 1 to HIT or 2 to STAND player "+(playerIndex+1)+" turn");
   choice=input.nextInt();
     
       } 
        }
    }
    
    public void dealer_turn(){

    while(true){
        if(game.get_score(3)==game.maximum_score()&&numberOfwinners()==1){
        break;
        }
        else if(game.get_score(3)==21){
            break;
        
        }
        
        else if(game.get_score(3)<=game.maximum_score()){
 
    GUI gui=new GUI();
    gui.updateDealerHand(game.pick_card(),game.cards);
    game.add_card(3);
    bj.checkScore(3);

        }
    else{break;
    
    }
  }
  }
    
    public void get_winner(){
        int winners=0;
        String s = null;
    for(int count=0;count<4;count++){
    if(game.get_score(count)==game.maximum_score()){
    winners++;
  s=game.getname(count);
    }
    
    }
    if(winners==1){
System.out.println(s+" WON!");
    }
    else
        System.out.println("PUSH!");
   
    }
    
     public void checkScore(int i){

       if(game.get_score(i)>21){
        
        System.out.println(game.getname(i)+" BUSTED!");
        
       }
       else if(game.get_score(i)==21){
       System.out.println(game.getname(i)+" GOT BLACKJACK!");
       }
    }
     
public int numberOfwinners(){
        int winners=0;
     
    for(int l=0;l<4;l++){
    if(game.get_score(l)==game.maximum_score()){
    winners++;}

}
    return winners;
}
}