public class Toy implements Comparable{
    int id;

    {
        id = 0;
    }

    String name = "";
    int chance = 0;
    Toy(int id, String name, int chance) {
        this.id = id;
        this.chance = chance;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return id;
    }
}
