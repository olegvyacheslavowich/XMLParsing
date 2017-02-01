package karpenko.com.service;

import karpenko.com.main.Bouquet;
import karpenko.com.main.Flower;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Олег on 01.02.2017.
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
    public void sort() {
        bouquet.getFlowers().sort(compareByLifetime);
    }

    @Override
    public String find(int fromNum, int toNum) {

        String answer = "";

        for (Flower flower : bouquet.getFlowers()) {
            if (flower.getLength() >= fromNum && flower.getLength() <=toNum){
                answer += flower.toString() + "\n";
            }
        }
        return answer;
    }

    private Comparator<Flower> compareByLifetime = new Comparator<Flower>() {
        @Override
        public int compare(Flower flwr1, Flower flwr2) {
            return flwr1.getLifetime() - flwr2.getLifetime();
        }
    };

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
}
