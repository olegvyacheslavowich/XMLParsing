package karpenko.com.xmlparsing;

/**
 * Created by Олег on 23.02.2017.
 */
public enum BouquetConst {
    ROSE("rose"),
    TULIP("tulip"),
    ORCHID("orchid"),
    PACKAGING("packaging");

    private String name;

    BouquetConst(String name) {
        this.name = name;
    }

    public static BouquetConst getName(String name){

        BouquetConst flower = null;
        for (BouquetConst flowerConst: BouquetConst.values()){
            if (flowerConst.getName().equals(name)){
                flower = flowerConst;
            }
        }
        return flower;
    }

    public String getName() {
        return name;
    }
}
