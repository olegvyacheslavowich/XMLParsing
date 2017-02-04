package karpenko.com.service;

import karpenko.com.bouquet.Bouquet;
import karpenko.com.flowers.Flower;

import java.util.Collections;

/**
 * Created by Олег on 01.02.2017.
 */

/**
 * Сервис для работы над букетом (Bouquet)
 */
public class BouquetService {

     /**
     * @param bouquet
     * @return стоимость букета
     */
    public static int bouquetPrice(Bouquet bouquet) {

        int flowersPrice = 0;

        for (Flower flower : bouquet.getFlowers()) {
            flowersPrice += flower.price();
        }

        return flowersPrice + bouquet.getPackaging().price();
    }


    /**
     * @param bouquet
     * @param from    начальное начение
     * @param to      конечное значение
     * @return коллекцию найденных цветов
     */
    public static String find(Bouquet bouquet, int from, int to) {

        String out = "";

        for (Flower flower : bouquet.getFlowers()) {
            if (flower.getLength() >= from && flower.getLength() <= to) {
                out += flower.toString() + "\n";
            }
        }
        return out;
    }

    public static String sortByLifetime(Bouquet bouquet){
        Collections.sort(bouquet.getFlowers(),new BouquetComparator());
        return bouquet.toString();
    }

}
