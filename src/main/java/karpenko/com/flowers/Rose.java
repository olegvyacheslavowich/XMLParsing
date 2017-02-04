package karpenko.com.flowers;

import karpenko.com.flowers.Flower;

/**
 * Created by Олег on 31.01.2017.
 */
public class Rose extends Flower {

    private static final String NAME = "Rose";

    private static final int LENGTH_TWENTY = 20;
    private static final int LENGTH_FORTY = 40;
    private static final int LENGTH_EIGHTY = 80;

    /**
     * сколько дней осталось до того, как цветы завянут
     */


    public Rose(int length, FlowersColor color, int lifetime) {

        super(NAME, length, color, lifetime);

    }

    /**
     * Возвращает запах в зависимости от цвета розы
     *
     * @return smell
     */
    public String smell() {

        String smell = null;
        switch (getColor()) {
            case BLACK:
                smell = "Сладкий";
                break;
            case RED:
                smell = "Фруктовый";
                break;
            case WHITE:
                smell = "Медовый";
                break;
            case YELLOW:
                smell = "Свежий";
                break;
        }
        return smell;
    }

    @Override
    public int price() {
        int price = 0;
        if (getLength() >= LENGTH_TWENTY && getLength() <= LENGTH_FORTY) {
            price = 500;
        } else if (getLength() > LENGTH_FORTY && getLength() < LENGTH_EIGHTY) {
            price = 800;
        }
        return price;
    }


    @Override
    public String toString() {
        return "\nRose{" +
                "length=" + getLength() +
                ",color='" + getColor() +
                ",lifetime=" + getLifetime() +
                ", имеет аромат: " + smell() +
                "}";
    }
}
