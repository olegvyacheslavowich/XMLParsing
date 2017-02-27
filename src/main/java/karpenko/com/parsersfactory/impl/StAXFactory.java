package karpenko.com.parsersfactory.impl;

import karpenko.com.parsersfactory.ParsersFactory;
import karpenko.com.xmlparsing.BouquetBuilder;
import karpenko.com.xmlparsing.impl.StAXBouquetParser;

/**
 * Created by Олег on 26.02.2017.
 */
public class StAXFactory implements ParsersFactory {

    @Override
    public BouquetBuilder viewBouquet(String path) {
        return new StAXBouquetParser(path);
    }
}
