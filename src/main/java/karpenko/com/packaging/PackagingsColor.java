package karpenko.com.packaging;

/**
 * Created by Олег on 04.02.2017.
 */
public enum PackagingsColor {

    BLUE("Blue"),
    WHITE("White"),
    PINK("Pink"),
    RED("Red"),
    YELLOW("Yellow"),
    BROWN("Brown");

    private String color;

    PackagingsColor(String color) {

        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
