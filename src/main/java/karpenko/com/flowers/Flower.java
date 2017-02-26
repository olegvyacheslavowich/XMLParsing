package karpenko.com.flowers;

/**
 * Created by Олег on 31.01.2017.
 */
public abstract class Flower {

    /**
     * название
     */
    private String name;

    /**
     * цвет
     */
    private FlowersColor color;

    /**
     * время жизни цветка
     */
    private int lifetime;

    /**
     * длина стебля
     */
    private int length;

    public Flower() {
    }

    public Flower(String name, int length, FlowersColor color, int lifetime) {

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

    /**
     * цена цветка в зависимости от вида и цвета
     *
     * @return цена
     */
    public abstract int price();


    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public FlowersColor getColor() {
        return color;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(FlowersColor color) {
        this.color = color;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (lifetime != flower.lifetime) return false;
        if (length != flower.length) return false;
        if (name != null ? !name.equals(flower.name) : flower.name != null) return false;
        return color == flower.color;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + lifetime;
        result = 31 * result + length;
        return result;
    }
}
