package kg.geeks.game.players;

public class Golem extends Hero{

    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.TAKE_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                int takenDamage = boss.getDamage() / 5;
                heroes[i].setHealth(heroes[i].getHealth() - takenDamage);
            }
            else {
                heroes[i].setHealth(boss.getDamage() - heroes[i].getHealth());
            }

        }
    }
}
