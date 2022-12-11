package ch7;
import java.util.*;
class Product{
    int price;
    int bonusPoint;
    Product(int price){
        this.price = price;
        bonusPoint = (int)(price / 10);
    }
}
class Tv extends Product{
    Tv(){
        super(100);
    }
    public String toString(){
        return "TV";
    }
}
class Computer extends Product{
    Computer(){
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}
class Audio extends Product{
    Audio(){
        super(50);
    }
    public String toString(){
        return "Audio";
    }
}
class Buyer{
    int money = 1000;
    int bonusPoint = 0;
    Vector item = new Vector();
    int i = 0;
    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액이 부족합니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        item.add(p);
        System.out.println(p + "을 구매하였습니다.");
    }
    void refund(Product p){
        if(item.remove(p)){
            money += p.price;
            bonusPoint -= p.bonusPoint;
            System.out.println(p + "을/를 반품하였습니다.");
        }
        else{
            System.out.println("구입하신 물품중에 해당하는 물품이 없습니다.");
        }
    }
    void summary(){
        int sum = 0;
        String itemList = "";
        for(int i = 0; i < item.size(); i++){
            Product p = (Product)item.get(i);
            sum += p.price;
            itemList += (i==0) ? "" + p : ", " + p;
        }
        System.out.println("사용한 총 금액 " + sum + "만원");
        System.out.println("구입한 제품" + itemList + "입니다");
    }
}
class PolyArgumentTest{
    public static void main(String args[]){
        Buyer b = new Buyer();
        Tv tv = new Tv();
        Computer com = new Computer();
        Audio audio = new Audio();
        b.buy(tv);
        b.buy(com);
        b.buy(audio);
        b.summary();
        System.out.println();
        b.refund(com);
        b.summary();
    }
}