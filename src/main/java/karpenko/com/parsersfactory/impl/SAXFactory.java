package karpenko.com.parsersfactory.impl;

import karpenko.com.xmlparsing.BouquetViewer;
import karpenko.com.parsersfactory.ParsersFactory;
import karpenko.com.xmlparsing.impl.StAXBouquetParser;

/**
 * Created by Олег on 26.02.2017.
 */
public class SAXFactory implements ParsersFactory {

    @Override
    public BouquetViewer viewBouquet(String path) {
        return new StAXBouquetParser(path);
    }
}
