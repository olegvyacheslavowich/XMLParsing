package karpenko.com.flowers;

import karpenko.com.flowers.Flower;

import static java.lang.String.valueOf;

/**
 * Created by Олег on 31.01.2017.
 */
public class Tulip extends Flower {

    private static final String NAME = "Tulip";

    private static final int LENGTH_TWENTY = 20;
    private static final int LENGTH_THIRTY_FIVE = 35;
    private static final int LENGTH_FIFTY = 50;


    public Tulip(int length, FlowersColor color, int lifetime) {

        super(NAME, length, color, lifetime);

    }

    /**
     * Возвращает запах в зависимости от цвета тюльпана
     *
     * @return smell
     */
    @Override
    public String smell() {

        String smell = null;

        switch (getColor()) {
            case BLACK:
                smell = "Яркий";
                break;
            case RED:
                smell = "Медово-сладкий";
                break;
            case WHITE:
                smell = "Теплый";
                break;
            case YELLOW:
                smell = "Экзотический";
                break;
        }
        return smell;
    }

    @Override
    public int price() {
        int price = 0;
        if (getLength() >= LENGTH_TWENTY && getLength() <= LENGTH_THIRTY_FIVE) {
            price = 480;
        } else if (getLength() > LENGTH_THIRTY_FIVE && getLength() < LENGTH_FIFTY) {
            price = 550;
        }
        return price;
    }

    @Override
    public String toString() {
        return "\nTulip{" +
                "length=" + getLength() +
                ",color='" + getColor() +
                ",lifetime=" + getLifetime() +
                ", имеет аромат: " + smell() +
                "}";
    }
}
