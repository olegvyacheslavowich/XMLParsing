package karpenko.com.main;

/**
 * Created by Олег on 31.01.2017.
 */
public class Orchid extends Flower {

    private static final String NAME = "Orchid";


    public Orchid(int length, String color, int lifetime) {

        super(NAME, length, color, lifetime);

    }

    /**
     * Возвращает запах в зависимости от цвета орхидеи
     *
     * @return smell
     */
    @Override
    public String smell() {

        String smell = null;

        switch (getColor()) {
            case FlowersColor.BLACK:
                smell = "Горький";
                break;
            case FlowersColor.RED:
                smell = "Одурманивающий";
                break;
            case FlowersColor.WHITE:
                smell = "Светлый";
                break;
            case FlowersColor.YELLOW:
                smell = "Яблочный";
                break;
        }
        return smell;
    }

    @Override
    public String toString() {
        return "Orchid{" +
                "length=" + getLength() +
                ",color='" + getColor()  +
                ",lifetime=" + getLifetime() +
                ", имеет аромат: " + smell() +
                '}';
    }
}
