package karpenko.com.main;

import java.util.ArrayList;

/**
 * Created by Олег on 31.01.2017.
 */
public final class Bouquet {

    private ArrayList<Flower> flowers;
    private Packaging packaging;

    public Bouquet(ArrayList<Flower> flowers, Packaging packaging){

        this.flowers = flowers;
        this.packaging = packaging;
    }

    public Bouquet(ArrayList<Flower> flowers){
        this.flowers = flowers;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public Packaging getPackaging() {
        return packaging;
    }
}
