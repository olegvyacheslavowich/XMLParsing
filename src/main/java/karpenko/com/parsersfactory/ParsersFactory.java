package karpenko.com.parsersfactory;

import karpenko.com.xmlparsing.BouquetViewer;

/**
 * Created by Олег on 26.02.2017.
 */
public interface ParsersFactory {

    BouquetViewer viewBouquet(String path);

}
