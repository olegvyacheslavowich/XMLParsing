package karpenko.com.bouquet;

import karpenko.com.flowers.Flower;
import karpenko.com.packaging.Packaging;

import java.util.ArrayList;

/**
 * Created by Олег on 31.01.2017.
 */
public final class Bouquet {

    private ArrayList<Flower> flowers;
    private Packaging packaging;

    public Bouquet() {
    }

    public Bouquet(ArrayList<Flower> flowers, Packaging packaging){

        this.flowers = flowers;
        this.packaging = packaging;
    }

    public Bouquet(ArrayList<Flower> flowers){
        this.flowers = flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    @Override
    public String toString() {
        return "Bouquet{\n" +
                "flowers=" + flowers +
                ", \nPackaging= {" + packaging +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bouquet bouquet = (Bouquet) o;

        if (flowers != null ? !flowers.equals(bouquet.flowers) : bouquet.flowers != null) return false;
        return packaging != null ? packaging.equals(bouquet.packaging) : bouquet.packaging == null;

    }

    @Override
    public int hashCode() {
        int result = flowers != null ? flowers.hashCode() : 0;
        result = 31 * result + (packaging != null ? packaging.hashCode() : 0);
        return result;
    }
}
