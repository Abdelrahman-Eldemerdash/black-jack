
package blackjack;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Abdelrahman Eldemerdash
 */

public class Game {

    Player[] players=new Player[4];
    Card cards[]=new Card[52];
    public static int high_score;
    Card card1;
    
    public void fill_cards(){
        int next_suit=0;
        for(int card_suit=0;card_suit<4;card_suit++){
         int card_rank=0;
       for( int card_index=next_suit ;card_index<13*(card_suit+1);card_index++){
           if(card_rank>9){
        cards[card_index]=new Card(card_suit,card_rank,10);}
          else
            { cards[card_index]=new Card(card_suit,card_rank,card_rank+1);
          }
           card_rank++;
          
       }   
                next_suit+=13;
        }
    }
    
    public Card pick_card(){
    Random rand=new Random();
int choose_card=rand.nextInt(52);
while(cards[choose_card]==null){
choose_card=rand.nextInt(52);
}
 card1=new Card(cards[choose_card].getSuit(),cards[choose_card].getRank(),cards[choose_card].getValue());
    cards[choose_card]=null;
    return card1;
    }
    
    public void players_info(){
        Scanner input=new Scanner(System.in);
        for(int i=0;i<4;i++){
            if(i==3){
                players[i]=new Player();
                players[i].name="Deller";
            }
            else{
            System.out.println("enter player " +(i+1) + " name");
            players[i]=new Player();
            players[i].name=input.next();
            }
            for(int j=0;j<2;j++){
                players[i].player_cards[j]=pick_card();
                players[i].score+=players[i].player_cards[j].getValue();
            }
            if(i!=3)
            System.out.println("player "+ ( i+1) +" score is "+ players[i].score);
        }
    
    }
    
    
    public int maximum_score(){

int maximum_s=0;
for(int k=0;k<4;k++){
    if(players[k].score>21)
        continue;
    if(players[k].score>maximum_s){
    maximum_s=players[k].score;
    }
}   
Game.high_score=maximum_s;
    return high_score;
}

    
    
public void add_card(int i){
    
players[i].score+=card1.getValue();
System.out.println("player "+ ( i+1) +" score is "+ players[i].score);
maximum_score();


}
public int get_score(int y){
return players[y].score;

}
public String getname(int y){
return players[y].name;

}
    public Player get_player(int i){
 return players[i];   
    }

   
   

}

