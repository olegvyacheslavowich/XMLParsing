package karpenko.com.service;

import karpenko.com.main.Bouquet;
import karpenko.com.main.Flower;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Олег on 01.02.2017.
 */

/**
 * Сервис для работы над букетом (Bouquet)
 */
public class BouquetInfo implements Present {

    private Bouquet bouquet;

    public BouquetInfo(Bouquet bouquet) {

        this.bouquet = bouquet;
    }


    /**
     * @return цену всего букета
     */
    @Override
    public int price() {

        PackagingInfo pi = new PackagingInfo(bouquet.getPackaging());
        int flowersPrice = 0;

        for (Flower flower : bouquet.getFlowers()) {
            flowersPrice += new FlowerInfo(flower).price();
        }

        return flowersPrice + pi.price();
    }


    @Override
    public ArrayList find(int fromNum, int toNum) {

        ArrayList resultFlower = new ArrayList<>();
        for (Flower flower : bouquet.getFlowers()) {
            if (flower.getLength() >= fromNum && flower.getLength() <= toNum) {
                resultFlower.add(flower);
            }
        }
        return resultFlower;
    }

    public Bouquet getBouquet() {
        return bouquet;
    }

    @Override
    public String toString() {

        String info = "";
        for (Flower flower : bouquet.getFlowers()) {
            info += " " + flower.getName() +
                    ", цвет: " + flower.getColor() +
                    ", длина: " + flower.getLength() +
                    ", не завянет еще " + flower.getLifetime() + " дней" + "\n";
        }

        return "Ваш букет: \n" + info +
                " Упаковка: " + bouquet.getPackaging().getType() + "\n" +
                " Цена букета = " + price();
    }

    /**
     * класс переопределяющий метод compare для сортировки по времени жизни цветка
     */
    static public class BouquetComparator implements Comparator<Flower> {

        @Override
        public int compare(Flower o1, Flower o2) {
            return o1.getLifetime() - o2.getLifetime();
        }
    }
}
