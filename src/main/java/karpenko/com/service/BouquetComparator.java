package karpenko.com.service;

import karpenko.com.flowers.Flower;

import java.util.Comparator;

/**
 * Created by Олег on 04.02.2017.
 */
public class BouquetComparator implements Comparator<Flower> {

    @Override
    public int compare(Flower o1, Flower o2) {
        return o1.getLifetime() - o2.getLifetime();
    }
}
