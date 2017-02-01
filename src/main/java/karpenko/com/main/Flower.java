package karpenko.com.main;

/**
 * Created by Олег on 31.01.2017.
 */
public abstract class Flower {

    private String name;

    private String color;

    private int lifetime;

    /**
     * длина стебля
     */
    private int length;

    public Flower(String name, int length, String color, int lifetime) {

        this.name = name;
        this.length = length;
        this.color = color;
        this.lifetime = lifetime;

    }

    /**
     * метод описыват аромат цветка
     *
     * @return
     */
    public abstract String smell();

  
    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    public int getLifetime() {
        return lifetime;
    }
}
