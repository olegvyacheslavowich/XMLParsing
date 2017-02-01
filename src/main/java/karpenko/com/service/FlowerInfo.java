package karpenko.com.service;

import karpenko.com.main.Flower;
import karpenko.com.main.Orchid;
import karpenko.com.main.Rose;
import karpenko.com.main.Tulip;

/**
 * Created by Олег on 01.02.2017.
 */
public class FlowerInfo implements Present {

    private Flower flower;

    public FlowerInfo(Flower flower)  {
        this.flower = flower;
    }

    public int price(){
        int price = 0;

        if (flower instanceof Rose){
            if (flower.getLength() > 20 && flower.getLength() < 40){
                price = 500;
            } else if (flower.getLength() > 40 && flower.getLength() < 80)
                price = 800;
        }

        if (flower instanceof Tulip){
            if (flower.getLength() > 20 && flower.getLength() < 35){
                price = 480;
            } else if (flower.getLength() > 35 && flower.getLength() < 50)
                price = 550;
        }

        if (flower instanceof Orchid){
            if (flower.getLength() > 30 && flower.getLength() < 50){
                price = 600;
            } else if (flower.getLength() > 50 && flower.getLength() < 70)
                price = 700;
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
