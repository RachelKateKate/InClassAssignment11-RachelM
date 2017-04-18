package rachelmiller.inclassassignment11_rachelm;

/**
 * Created by rachelmiller on 4/17/17.
 */

public class Planet {

    public String id;
    public String name;
    public int distance;
    public boolean hasWater;

    public Planet() {
    }

    public Planet(String id, String name, int distance, boolean hasWater) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.hasWater = hasWater;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=' " + id + '\'' +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", hasWater=" + hasWater +
                '}';
    }
}
