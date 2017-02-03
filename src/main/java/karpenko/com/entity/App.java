package karpenko.com.entity;


import karpenko.com.main.*;
import karpenko.com.service.BouquetInfo;

import java.util.ArrayList;

/**
 Цветочница. Определить иерархию цветов. Создать несколько объек-
 тов-цветов. Собрать букет (используя аксессуары) с определением его
 стоимости. Провести сортировку цветов в букете на основе уровня све-
 жести. Найти цветок в букете, соответствующий заданному диапазону
 длин стеблей
 */
public class App {
    public static void main(String[] args) {

        /**
         * Собираем цветы
         */
        ArrayList<Flower> flowers = new ArrayList<>();

        flowers.add(new Rose(30, FlowersColor.WHITE, 50));
        flowers.add(new Tulip(45, FlowersColor.YELLOW, 15));
        flowers.add(new Orchid(45, FlowersColor.WHITE, 28));
        flowers.add(new Rose(85, FlowersColor.RED, 17));

        System.out.println("Собранные цветы:");
        for (Flower flower : flowers) {
            System.out.println(flower.toString());
        }
        System.out.println();

        /**
         * Берем одну из упаковок
         */
        Packaging packaging = new Packaging(PackagingsColor.PINK, PackagingType.PAPER);

        /**
         * Заворачиваем цветы в упаковку и получаем букет
         */
        Bouquet bouquet = new Bouquet(flowers, packaging);

        BouquetInfo bi = new BouquetInfo(bouquet);

        /**
         * Сортируем по свежести цветов
         */

        bi.getBouquet().getFlowers().sort(new BouquetInfo.BouquetComparator());
        System.out.println("Сортируем по свежести: \n"  + bi.toString());

        System.out.println();

        /**
         * Выводим найденые цветы с длиной стебля в заданном диапазоне значений
         */
        System.out.println("Поиск цветка с подходящей длинной стебля:");
        for (Object flower :bi.find(45, 60)) {
            System.out.println(flower.toString());
        }

    }
}
