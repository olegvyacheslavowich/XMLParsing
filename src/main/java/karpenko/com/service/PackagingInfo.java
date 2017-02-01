package karpenko.com.service;

import karpenko.com.main.Packaging;

/**
 * Created by Олег on 01.02.2017.
 */
public class PackagingInfo implements Present {

    Packaging packaging;

    public PackagingInfo(Packaging packaging) {

        this.packaging = packaging;
    }


    /**
     * метод считает цену в зависимости от типа упаковки
     *
     * @return price
     */
    @Override
    public int price() {

        int price = 0;
        switch (packaging.getType()) {
            case PackagingType.PAPER:
                price = 200;
                break;

            case PackagingType.GRID:
                price = 300;
                break;
        }

        return price;
    }

    @Override
    public void sort() {

    }

    @Override
    public String find(int fromNum, int toNum) {
        return null;
    }

}


