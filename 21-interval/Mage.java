import java.util.*;
import java.io.*;

public class Mage extends BaseChar implements Comparable {

    Random thing = new Random();
    
    public Mage(int h, int m, int a, int d, int s, int ac, int c, String n, String w){
	 super(h,m,a,d,s,ac,c,n,w);
    }

    public int compareTo(Object other) {
	Mage m = (Mage)other;
	return this.toString().length() - m.toString().length();
    }
    
    public String spell(Monster other, String userInput){
	if(userInput.equals( "1") && thing.nextInt(this.getACC()) > 20 ) {
	    if ((this.getMP() - 20) < 0) {
		return("Not enough mana!");
	    } else {
		int damage = 15 + thing.nextInt(11);
		other.setHP(other.getHP() -  damage);
		this.setMP(this.getMP() - 20);
		return(this + " shot a fireball at " + other + ". " + other + " lost " + damage + "  HP." );
	    }
	}else if(userInput.equals("2") && thing.nextInt(this.getACC()) > 0) {
	    if ((this.getMP() - 30) < 0) {
		return("Not enough mana!");
	    } else {
	        int damage = 15 + thing.nextInt(11);
		other.setHP(other.getHP() - damage);
		this.setMP(this.getMP() - 30);
		return(this + " electrified " + other + ". " + other + " lost " + damage + "  HP.");
	    }
	}else if(userInput.equals("3") && thing.nextInt(this.getACC()) > 20) {
	    if ((this.getMP() - 40) < 0) {
		return("Not enough mana!");
	    } else {
		int damage = 25 + thing.nextInt(11);
		other.setHP(other.getHP() - damage);
	    this.setMP(this.getMP() - 40);
	    return(this + " froze " + other + ". " + other + " lost " + damage + " HP.");
	    }
	} else {
	    if (userInput.equals("1")) {
		this.setMP(this.getMP()-20);
		return "The spell fizzled and died";
	    }
	    if (userInput.equals("2")) {
	        this.setMP(this.getMP()-30);
		return "The spell fizzled and died";
	    }
	    if (userInput.equals("3")) {
		this.setMP(this.getMP()-40);
		return "The spell fizzled and died";
	    }
	    if (userInput.equals("")) {
		return this.toString() + " did nothing.";
	    }
	    if (this.getMP() < 0) {
		this.setMP(0); 
	    }
	    return "";
	}
    }
    
    public static void main(String[] args) {
	Mage m1 = new Mage(1,1,1,1,1,1,1,"Will","sword");
	Mage m2 = new Mage(1,1,1,1,1,1,1,"Steven","sword");
	Mage[] ma = {m2, m1};
	System.out.println(Arrays.toString(ma));
	Arrays.sort(ma);
	System.out.println(Arrays.toString(ma));
    }

}