package karpenko.com.parsersfactory;

import karpenko.com.xmlparsing.BouquetBuilder;

/**
 * Created by Олег on 26.02.2017.
 */
public interface ParsersFactory {

    BouquetBuilder viewBouquet(String path);

}
