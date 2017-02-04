package karpenko.com;


import karpenko.com.bouquet.Bouquet;
import karpenko.com.flowers.*;
import karpenko.com.packaging.Packaging;
import karpenko.com.packaging.PackagingsColor;
import karpenko.com.packaging.PackagingsType;
import karpenko.com.service.BouquetService;
import karpenko.com.service.FlowerService;

import java.util.ArrayList;

/**
 * Цветочница. Определить иерархию цветов. Создать несколько объек-
 * тов-цветов. Собрать букет (используя аксессуары) с определением его
 * стоимости. Провести сортировку цветов в букете на основе уровня све-
 * жести. Найти цветок в букете, соответствующий заданному диапазону
 * длин стеблей
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
        System.out.println(FlowerService.collectedFlowers(flowers));

        /**
         * Берем одну из упаковок
         */
        Packaging packaging = new Packaging(PackagingsColor.BROWN, PackagingsType.PAPER);

        /**
         * Заворачиваем цветы в упаковку и получаем букет
         */
        Bouquet bouquet = new Bouquet(flowers, packaging);

        /**
         * Поиск цветка в заданном диапазонее
         */
        System.out.println("Найденные цветы в заданном диапазоне\n" + BouquetService.find(bouquet, 30, 50));

        /**
         * Сортируем по свежести цветов
         */

         System.out.println("Сортируем по свежести: \n" + BouquetService.sortByLifetime(bouquet));
        System.out.println();

        /**
         * получаем цену букета
         */

        System.out.println("Цена букета:\n" + BouquetService.bouquetPrice(bouquet));


    }
}
