package ch7;

public class DeckTest {
    public static void main(String args[]){
        Deck d = new Deck();
        Card c = d.pick();
        System.out.println(c);
        d.shuffle();
        c = d.pick(0);
        System.out.println(c);
    }
}
class Deck{
    final int CARD_NUMBER = 52;
    Card cardArr[] = new Card[CARD_NUMBER];
    Deck(){
        int i = 0;
        for(int j = Card.KIND_MAX; j > 0; j--){
            for(int k = 1; k <= Card.NUM_MAX; k++){
                cardArr[i++] = new Card(j, k);
            }
        }
    }
    Card pick(int index){
        return cardArr[index];
    }
    Card pick(){
        int index = (int)(Math.random() * CARD_NUMBER);
        return cardArr[index];
    }
    void shuffle(){
        for(int i = 0; i < CARD_NUMBER; i++){
            int r = (int)(Math.random() * CARD_NUMBER);
            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}
class Card{
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;
    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    int kind;
    int num;
    Card(){
        this(SPADE, 1);
    }
    Card(int kind, int num){
        this.kind = kind;
        this.num =num;
    }
    public String toString(){
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "123456789XJQK";
        return "kinds: " + kinds[this.kind] + ", numbers: " + numbers.charAt(this.num);        
    }
}


