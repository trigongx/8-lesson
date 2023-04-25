package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

import java.util.Random;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence(Hero[] heroes) {
        int randomIndex = RPG_Game.random.nextInt(heroes.length);
        this.defence = heroes[randomIndex].getAbility();
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence +
                "\n\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80";

    }
}
