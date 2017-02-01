package karpenko.com.main;

import karpenko.com.service.FlowersColor;

/**
 * Created by Олег on 31.01.2017.
 */
public class Rose extends Flower {

    private static final String NAME = "Rose";

    /**
     * сколько дней осталось до того, как цветы завянут
     */


    public Rose(int length, String color, int lifetime) {

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
            case FlowersColor.BLACK:
                smell = "Сладкий";
                break;
            case FlowersColor.RED:
                smell = "Фруктовый";
                break;
            case FlowersColor.WHITE:
                smell = "Медовый";
                break;
            case FlowersColor.YELLOW:
                smell = "Свежий";
                break;
        }
        return smell;
    }


    @Override
    public String toString() {
        return "Rose{" +
                "length=" + getLength() +
                ",color='" + getColor()  +
                ",lifetime=" + getLifetime() +
                '}';
    }
}
