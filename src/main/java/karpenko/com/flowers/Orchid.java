package karpenko.com.flowers;

import karpenko.com.flowers.Flower;

/**
 * Created by Олег on 31.01.2017.
 */
public class Orchid extends Flower {

    private static final String NAME = "Orchid";

    private static final int LENGTH_THIRTY = 30;
    private static final int LENGTH_FIFTY = 50;
    private static final int LENGTH_SEVENTY = 70;


    public Orchid() {
    }

    public Orchid(int length, FlowersColor color, int lifetime) {

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
            case BLACK:
                smell = "Горький";
                break;
            case RED:
                smell = "Одурманивающий";
                break;
            case WHITE:
                smell = "Светлый";
                break;
            case YELLOW:
                smell = "Яблочный";
                break;
        }
        return smell;
    }

    @Override
    public int price() {
        int price = 0;
        if (getLength() >= LENGTH_THIRTY && getLength() <= LENGTH_FIFTY) {
            price = 600;
        } else if (getLength() > LENGTH_FIFTY && getLength() <= LENGTH_SEVENTY) {
            price = 700;
        }
        return price;
    }


    @Override
    public String toString() {
        return "\nFlower{" +
                "name=" + getName() +
                "length=" + getLength() +
                ",color='" + getColor() +
                ",lifetime=" + getLifetime() +
//                ", имеет аромат: " + smell() +
                "}";
    }
}
