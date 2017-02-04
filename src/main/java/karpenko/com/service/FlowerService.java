package karpenko.com.service;

import karpenko.com.flowers.Flower;
import karpenko.com.flowers.Orchid;
import karpenko.com.flowers.Rose;
import karpenko.com.flowers.Tulip;

import java.util.ArrayList;

/**
 * Created by Олег on 01.02.2017.
 * Класс - сервис для Flower
 */
public class FlowerService {

    /**
     *
     * @param flowers
     * @return собранные цветы
     */
    public static String collectedFlowers(ArrayList<Flower> flowers) {

        String out = "";
        for (Flower flower : flowers) {
            out += flower.toString() + "\n";
        }
        return out;
    }

}
