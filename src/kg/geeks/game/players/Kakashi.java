package kg.geeks.game.players;
import kg.geeks.game.general.RPG_Game;
import java.util.Random;

public class Kakashi extends Hero{
    private SuperAbility copyAbility;
    public SuperAbility getCopyAbility() {
        return copyAbility;    }

    static Random random=new Random();
    public Kakashi(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.COPU_ABILITY);
    }
    public void CopyAbility(Hero[] heroes){
        int index= RPG_Game.random.nextInt(heroes.length);
        this.copyAbility=heroes[index].getAbility();}

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        CopyAbility(heroes);
        if (getCopyAbility()==SuperAbility.COPU_ABILITY){
            return;        }
        int coeff = RPG_Game.random.nextInt(10) + 2;
        if (getCopyAbility()==SuperAbility.CRITICAL_DAMAGE){
        boss.setHealth(boss.getHealth()-this.getDamage()*coeff);
        System.out.println("Какаши скопировал способность "+getCopyAbility());
        System.out.println("kakashi crit:"+this.getDamage()*coeff);
        }
        for (int i = 0; i < heroes.length; i++) {
        int addDamage= RPG_Game.random.nextInt(5,10);
        if (getCopyAbility()==SuperAbility.BOOST&&heroes[i].getHealth() > 0){
            heroes[i].setDamage(heroes[i].getDamage() + addDamage);
            System.out.println("Какаши скопировал способность "+getCopyAbility());
            System.out.println("kakashi AddDamage:"+addDamage);
        }
        else if (getCopyAbility()==SuperAbility.HEAL&&heroes[i].getHealth() > 0){
            heroes[i].setHealth(heroes[i].getHealth() + 5);
            System.out.println("Какаши скопировал способность "+getCopyAbility());
            System.out.println("kakashi AddHealth:"+5);
        }
        else if (getCopyAbility()==SuperAbility.BLOCK_DAMAGE_AND_REVERT&&heroes[i].getHealth() > 0){
            heroes[4].setDamage(heroes[4].getDamage()+(boss.getDamage()/2));
            System.out.println("Какаши скопировал способность "+getCopyAbility());
            System.out.println("kakashi dop damag:"+boss.getDamage()/2);
        }
        break;        }

    }
}


