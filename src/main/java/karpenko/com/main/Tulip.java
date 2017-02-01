package karpenko.com.main;

import karpenko.com.service.FlowersColor;

/**
 * Created by Олег on 31.01.2017.
 */
public class Tulip extends Flower {

    private static final String NAME = "Tulip";


    public Tulip(int length, String color, int lifetime) {

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
            case FlowersColor.BLACK:
                smell = "Яркий";
                break;
            case FlowersColor.RED:
                smell = "Медово-сладкий";
                break;
            case FlowersColor.WHITE:
                smell = "Теплый";
                break;
            case FlowersColor.YELLOW:
                smell = "Экзотический";
                break;
        }
        return smell;
    }

    @Override
    public String toString() {
        return "Tulip{" +
                "length=" + getLength() +
                ",color='" + getColor()  +
                ",lifetime=" + getLifetime() +
                '}';
    }
}
