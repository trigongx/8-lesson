package kg.geeks.game.players;
import kg.geeks.game.general.RPG_Game;

public class Thor extends Hero {

    public Thor(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.STUN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean isBlind = RPG_Game.random.nextBoolean();
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && isBlind == true) {
                boss.setDamage(0);
                System.out.println("Boss in stan");
            } else {
                boss.setDamage(70);
                }
            break;
            }

        }


}
