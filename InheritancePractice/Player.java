class Player
{
    int score;
    int health;
    boolean alive;
    String username;
 
    public Player(String username)
    {
        score = 0;
        health = 100;
        alive = true;x
        this.username = username;
    }
 
    public Player(int score, int health, String username)
    {
        this.score = score;
        this.health = health;
        alive = true;
        this.username = username;
    }
 
    public void damage(int damage)
    {
        health -= damage;
        updatePlayerStatus();
    }
 
    public void updatePlayerStatus()
    {
        if(score <= 0)
        {
            alive = false;
            health = 0;
        }
        else
        {
            alive = true;
        }
    }
 
    public void healthBoost(int boost)
    {
        health += boost;
        updatePlayerStatus();
    }
 
    public void updateScore(int score)
    {
        this.score += score;
    }
    
    public boolean getPlayerStatus(){return alive;}
    public int getPlayerScore(){return score;}
    public int getPlayerHealth(){return health;}
 
    public String toString()
    {
        return username + ": \n" + "health: " + health + "\nscore: " +
  score; 
    }
 
}
 
 
public class Knight extends Player
{
    private int shield;
 
    public Knight(String username)
    {
        super(username);
        shield = 100;
    }
 
    public Knight(int score, int health, String username, int shield)
    {
        super(score, health, username);
        this.shield = shield;
    }
 
    public void damage(int damage)
    {
        health = (getPlayerHealth() - (damage - (damage * shield)));
    }
 
    public void updateShield()
    {
        this.shield = shield - ((int)(Math.random()*20));
    }
 
    public int getShield()
    { return shield; }
 
    public String toString()
    {
        return ("username: "+username+"\nhealth: "+ health +"\nscore: "+ score +"\nshield: "+shield);
    }
}
