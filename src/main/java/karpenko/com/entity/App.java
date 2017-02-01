package karpenko.com.entity;


import karpenko.com.main.*;
import karpenko.com.service.*;
import karpenko.com.service.PackagingsColor;

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

        ArrayList<Flower> flowers = new ArrayList<Flower>();

        flowers.add(new Rose(30, FlowersColor.BLACK, 50));
        flowers.add(new Tulip(45, FlowersColor.YELLOW, 15));
        flowers.add(new Orchid(45, FlowersColor.WHITE, 28));
        flowers.add(new Rose(85, FlowersColor.RED, 17));

        for (Flower flower : flowers) {
            System.out.println(flower.getColor() + " "
                    + flower.getClass().getSimpleName()
                    + " имеет " + flower.smell() +
                    " аромат");
        }
        System.out.println();

        Packaging packaging = new Packaging(PackagingsColor.PINK, PackagingType.PAPER);

        Bouquet bouquet = new Bouquet(flowers, packaging);

        BouquetInfo bi = new BouquetInfo(bouquet);
        bi.sort();
        System.out.println(bi.toString());

        System.out.println();

        System.out.println(bi.find(10, 30));

    }
}
