package karpenko.com.packaging;

/**
 * Created by Олег on 31.01.2017.
 */
public class Packaging {

    private PackagingsType type;

    private PackagingsColor color;

    public Packaging() {

    }

    public Packaging(PackagingsColor color, PackagingsType type) {

        this.color = color;
        this.type = type;
    }


    public int price() {

        int price = 0;

        switch (type) {
            case PAPER:
                price = 300;
                break;
            case ENVELOPE:
                price = 200;
                break;
        }
        return price;
    }

    public PackagingsType getType() {
        return type;
    }

    public void setType(PackagingsType type) {
        this.type = type;
    }

    public PackagingsColor getColor() {
        return color;
    }

    public void setColor(PackagingsColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  "type=" + type +
                ", color=" + color +
                "}\n";
    }
}

