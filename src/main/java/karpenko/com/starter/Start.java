package karpenko.com.starter;

import karpenko.com.bouquet.Bouquet;
import karpenko.com.parsersfactory.ParsersFactory;
import karpenko.com.parsersfactory.impl.DOMFactory;
import karpenko.com.parsersfactory.impl.SAXFactory;
import karpenko.com.parsersfactory.impl.StAXFactory;
import karpenko.com.xmlparsing.BouquetViewer;

/**
 * Created by Олег on 26.02.2017.
 */
public class Start {

    private static final String path = "src/resources/xml/bouquet.xml";

    public static void compare() {

        BouquetViewer viewSTAX = new StAXFactory().viewBouquet(path);
        BouquetViewer viewSAX = new SAXFactory().viewBouquet(path);
        BouquetViewer viewDOM = new DOMFactory().viewBouquet(path);

        if (viewSAX.bouquetBuilder().equals(viewSTAX.bouquetBuilder())) {
            System.out.println("SAXBouquet = STAXBouquet");
        }

        if (viewSAX.bouquetBuilder().equals(viewDOM.bouquetBuilder())){
            System.out.println("SAX_Bouquet = DOM_Bouquet");
        }

        if (viewDOM.bouquetBuilder().equals(viewSTAX.bouquetBuilder())){
            System.out.println("DOM_Bouquet = STAX_Bouquet");

        }
    }
}
