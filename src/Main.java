// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
        Warrior sparta  = new Warrior("leonidas",10,10,5,10);
        Wizard merlin = new Wizard("merlin",10,5,10,8);
        Rings ring = new Rings("The_Lord_Of_The_Ring",20);
        Necklaces necklaces = new Necklaces("Necklace_Of_MUSPELHEIM",20);

        sparta.showstate();
        merlin.showstate();

        sparta.equipAccessory(ring);
        sparta.showstate();

        sparta.attack(merlin);
        merlin.showstate();

        merlin.skill_Fireball(sparta);
        sparta.showstate();

        merlin.equipAccessory(necklaces);
        merlin.showstate();
        merlin.skill_Debuff(sparta);
        sparta.showstate();

    }
}