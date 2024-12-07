package monsters;

import main.GameManager;

public abstract class Monster {

    protected GameManager gm;
    public int currentLife;
    protected int maxLife;
    protected String monster;
    protected int attackDamage;

    // TODO: Consider making currentLife private and providing a getter method
    // TODO: Consider using final for fields that don't change after initialization

    public Monster(GameManager gm,int currentLife,int maxLife, String monster, int attackDamage) {
        // TODO: Add parameter validation (e.g., check for null gm, non-negative life and damage)
        this.gm = gm;
        this.currentLife = currentLife;
        this.maxLife = maxLife;
        this.attackDamage = attackDamage;
        this.monster = monster;
    }

    public abstract void reset();

    // TODO: Consider grouping related methods (e.g., all Hondaur methods together)
    // TODO: Consider using an enum or interface to define different monster types
    public abstract void lookHondaur();
    public abstract void talkHondaur();
    public abstract void attackHondaur();
    public abstract void lookSponge();
    public abstract void talkSponge();
    public abstract void followSponge();
    public abstract void lookAnthony();
    public abstract void talkAnthony();
    public abstract void touchAnthony();
    public abstract void lookTheodoor();
    public abstract void talkTheodoor();
    public abstract void attackTheodoor();
    public abstract void lookWheeler();
    public abstract void talkWheeler();
    public abstract void attackWheeler();

    // Consider adding a generic interaction method to reduce the number of abstract methods
    // e.g., public abstract void interact(MonsterType type, InteractionType interaction);
    // Consider adding common monster behaviors (e.g., takeDamage, isAlive)
    // Consider adding a method to get monster stats (e.g., getStats())
    // Consider adding a method to update monster state (e.g., updateState())
    // Add JavaDoc comments for the class and methods
    // Consider implementing a builder pattern for complex monster creation
    // Consider adding unit tests for common monster behaviors




}
