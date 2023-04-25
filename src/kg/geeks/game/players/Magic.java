package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int boost = RPG_Game.random.nextInt(8) + 2;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this.getHealth() > 0)
            heroes[i].setDamage(heroes[i].getDamage() + boost);

        }
        System.out.println("Magic added damage: " + boost);
    }
}
