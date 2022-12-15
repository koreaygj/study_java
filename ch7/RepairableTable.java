package ch7;

public class RepairableTable {
    public static void main(String args[]){
        Tank tank = new Tank();
        Dropship dropship = new Dropship();
        Marin marin = new Marin();
        SCV scv = new SCV();
        scv.repair(dropship);
        scv.repair(tank);
    }
}
interface Repairable{}
class GroundUnit extends Unit{
    GroundUnit(int hp){
        super(hp);
    }
}
class AirUnit extends Unit{
    AirUnit(int hp){
        super(hp);
    }
}
class Unit{
    int hitPoint;
    final int MAX_HP;
    Unit(int hp){
        MAX_HP = hp;
    }
}
class Tank extends GroundUnit implements Repairable{
    Tank(){
        super(150);
        hitPoint = MAX_HP;
    }
    public String toString(){
        return "Tank";
    }
}
class Dropship extends AirUnit implements Repairable{
    Dropship(){
        super(125);
        hitPoint = MAX_HP;
    }
    public String toString(){
        return "Dropship";
    }
}
class Marin extends GroundUnit{
    Marin(){
        super(40);
        hitPoint = MAX_HP;
    }
}
class SCV extends GroundUnit implements Repairable{
    SCV(){
        super(60);
        hitPoint = MAX_HP;
    }
    void repair(Repairable r){
        if(r instanceof Unit){
            Unit u = (Unit) r;
            while(u.hitPoint != u.MAX_HP){
                u.hitPoint++;
            }
            System.out.println(u.toString() + "의 수리가 끝났습니다.");
        }
    }
}

