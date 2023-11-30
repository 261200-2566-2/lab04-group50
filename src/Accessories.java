public interface Accessories {
    double upstate();
    double Specialeffect( double max_hp);
    String getClassName();

    String getName();
}

class Rings implements Accessories{
    private double atk;
    private String name;

    public Rings(String name , double atk){
        this.name = name;
        this.atk = atk;

    }
    public String getClassName() {
        return "Rings";
    }

    public String getName(){
        return  name;
    }

    public double upstate(){
        return atk;
    }
    public double Specialeffect(double max_hp){
        return (max_hp/100)*20;
    }
}

class Necklaces implements Accessories{
    private double s;
    private String name;

    public Necklaces(String name , double s){
        this.name = name;
        this.s = s;
    }


    public double upstate(){
        return s;
    }
    public double Specialeffect( double max_hp){
        return (max_hp/100)*5;
    }
    public String getClassName() {
        return "Necklaces";
    }

    public String getName(){
        return  name;
    }
}


