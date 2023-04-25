package kg.geeks.game.players;

public class Berserk extends Hero {
    private int blockedDamage;



    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BLOCK_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && this.getHealth() > 0)
        this.blockedDamage = boss.getDamage();
        boss.setHealth(boss.getHealth() - (this.blockedDamage + this.getDamage()));
        System.out.println("Berserk revert damage: " + this.blockedDamage);
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }

    public int getBlockedDamage() {
        return blockedDamage;
    }
}
