public interface Character {
    void showstate();

    void attack(character_ p);

    void level_up();

    void takedamage(double d);

    void reduceDefense(double b);
}

interface skill_warrior{
    void skill_Buffatk();
    void skill_Buffdef();

}

interface skill_wizard {
    void skill_Fireball(character_ p);
    void skill_Debuff(character_ p);
}

abstract class character_ implements Character{
    private String name;
    protected int level;
    protected double max_hp,hp,max_mana,mana,damage,defense,max_speed;

    protected double d,s,r;

    protected Accessories accessories;
    public character_(String name,int level,double d , double s, double r){
        this.name = name;
        this.level = level;
        this.d = d ;
        this.s = s ;
        accessories = null;


    }

    public void equipAccessory(Accessories accessory) {
        accessories = accessory;
    }
    public void level_up(){
        level++;
    }
    public void attack(character_ p){
        p.takedamage(damage);
    }

    public void takedamage(double d){
        double da = defense - d;
        if(da > 0){
            da = 0;
        }

        hp += da;
        if(hp  < 0){
            hp = 0;
        }
    }

    public void showstate(){
        update_state();
        System.out.println("|---------------------------------------|");
        System.out.println("    Name = " + name + " " + getClass());
        System.out.println("    Level = " + level);
        System.out.println("    Hp = " + hp + " / " + max_hp);
        System.out.println("    Max Mana = " + mana + " / " + max_mana);
        System.out.println("    Speed = " + max_speed);
        System.out.println("    Damage = " + damage);
        System.out.println("    Defense = " + defense);
        if(accessories != null) {
            System.out.println("    Accessory = " + accessories.getName());
        }
        System.out.println("|---------------------------------------|");
        System.out.println(" ");
    }

    public abstract void update_state();

    public void reduceDefense(double b){
        defense *= b;
    }
}
class Wizard extends character_ implements skill_wizard{

    public Wizard(String name, int level, double d, double s, double r) {
        super(name, level, d, s, r);
        hp = 100+10*(level-1);
        mana = 50+5*(level-1);
    }

    public void update_state(){
        max_hp = 100+10*(level-1);
        max_mana = 50+10*(level-1);
        max_speed =  r + (r * (0.1+0.03*(level-1)));
        damage = d * (1 + 0.1 * (level - 1));
        defense = s * (1 + 0.05 * (level - 1));
        if(accessories != null){
            if(accessories.getClassName().equals("Rings")) {
                damage += accessories.upstate();
                if (hp < (max_hp / 100) * 30) {
                    hp += accessories.Specialeffect(max_hp);
                }
            }
            if(accessories.getClassName().equals("Necklaces")){
                defense += accessories.upstate();
                if(hp < (max_hp/100)*20){
                    damage+=accessories.Specialeffect(max_hp);
                }
            }
        }

    }
    public void skill_Fireball(character_ p){
        mana -= 40;
        if(mana < 0){
            mana += 40;
            return ;
        }
        double da = max_mana * 1.5;
        p.takedamage(da);
    }
    public void skill_Debuff(character_ p){
        mana -= 20;
        if(mana < 0){
            mana += 20;
            return ;
        }
        p.reduceDefense(0.75);
    }

}
class Warrior extends character_ implements skill_warrior {
    public Warrior(String name, int level, double d, double s, double r) {
        super(name, level, d, s, r);
        hp = 100+20*(level-1);
        mana = 50+2*(level-1);
    }


    public void update_state(){
        max_hp = 100+20*(level-1);
        max_mana = 50+2*(level-1);
        max_speed =  r + (r * (0.1+0.05*(level-1)));
        damage = d * (1 + 0.2 * (level - 1));
        defense = s * (1 + 0.15 * (level - 1));
        if(accessories != null){
            if(accessories.getClassName().equals("Rings")) {
                damage += accessories.upstate();
                if (hp < (max_hp / 100) * 30) {
                    hp += accessories.Specialeffect(max_hp);
                }
            }
            if(accessories.getClassName().equals("Necklaces")){
                defense += accessories.upstate();
                if(hp < (max_hp/100)*20){
                    damage+=accessories.Specialeffect(max_hp);
                }
            }
        }
    }

    public void skill_Buffatk(){
        mana -= 20;
        if(mana < 0){
            mana += 20;
            return;
        }
        damage *= 1.5;
    }
    public void skill_Buffdef(){
        mana -= 15;
        if(mana < 0){
            mana += 15;
            return;
        }
        defense *= 1.5;
    }
}
