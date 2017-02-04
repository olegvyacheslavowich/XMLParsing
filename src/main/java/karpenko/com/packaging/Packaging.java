package karpenko.com.packaging;

/**
 * Created by Олег on 31.01.2017.
 */
public class Packaging {

    private PackagingsType type;

    private PackagingsColor color;


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

    public PackagingsColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return  "type=" + type +
                ", color=" + color +
                "}\n";
    }
}

