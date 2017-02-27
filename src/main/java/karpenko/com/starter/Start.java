package karpenko.com.starter;

import karpenko.com.parsersfactory.impl.DOMFactory;
import karpenko.com.parsersfactory.impl.SAXFactory;
import karpenko.com.parsersfactory.impl.StAXFactory;
import karpenko.com.xmlparsing.BouquetBuilder;

/**
 * Created by Олег on 26.02.2017.
 */
public class Start {

    private static final String path = "src/resources/xml/bouquet.xml";
    private static final String saxEquallyStax = "SAXBouquet = STAXBouquet";
    private static final String saxEquallyDom = "SAX_Bouquet = DOM_Bouquet";
    private static final String domEquallyStax = "DOM_Bouquet = STAX_Bouquet";

    public static void compare() {

        BouquetBuilder viewSTAX = new StAXFactory().viewBouquet(path);
        BouquetBuilder viewSAX = new SAXFactory().viewBouquet(path);
        BouquetBuilder viewDOM = new DOMFactory().viewBouquet(path);

        if (viewSAX.buildBouquet().equals(viewSTAX.buildBouquet())) {
            System.out.println(saxEquallyStax);
        }

        if (viewSAX.buildBouquet().equals(viewDOM.buildBouquet())){
            System.out.println(saxEquallyDom);
        }

        if (viewDOM.buildBouquet().equals(viewSTAX.buildBouquet())){
            System.out.println(domEquallyStax);

        }
    }
}
