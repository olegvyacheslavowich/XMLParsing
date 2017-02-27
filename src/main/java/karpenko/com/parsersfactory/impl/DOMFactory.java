package karpenko.com.parsersfactory.impl;

import karpenko.com.parsersfactory.ParsersFactory;
import karpenko.com.xmlparsing.BouquetBuilder;
import karpenko.com.xmlparsing.impl.DOMBouquetParser;

/**
 * Created by Олег on 26.02.2017.
 */
public class DOMFactory implements ParsersFactory {

    @Override
    public BouquetBuilder viewBouquet(String path) {
        return new DOMBouquetParser(path);
    }
}
