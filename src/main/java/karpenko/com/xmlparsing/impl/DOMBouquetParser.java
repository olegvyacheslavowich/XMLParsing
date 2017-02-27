package karpenko.com.xmlparsing.impl;

import karpenko.com.bouquet.Bouquet;
import karpenko.com.flowers.*;
import karpenko.com.packaging.Packaging;
import karpenko.com.packaging.PackagingsColor;
import karpenko.com.packaging.PackagingsType;
import karpenko.com.xmlparsing.BouquetBuilder;
import karpenko.com.xmlparsing.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Олег on 25.02.2017.
 */
public class DOMBouquetParser implements BouquetBuilder {

    private DocumentBuilder docBuilder;
    private Element element;
    private String path;

    public DOMBouquetParser(String path) {

        this.path = path;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Bouquet buildBouquet() {

        Document document;
        Bouquet bouquet = new Bouquet();
        ArrayList<Flower> flowers = new ArrayList<>();
        Flower flower;
        Packaging packaging;

        try {
            document = docBuilder.parse(new File(path));
            element = document.getDocumentElement();
            NodeList elements = element.getElementsByTagName(Elements.FLOWERS.getElement());

            NodeList flowersChildNList = elements.item(0).getChildNodes(); // получили детей flowers!
            for (int i = 0; i < flowersChildNList.getLength(); i++) {
                String flwrsChild = flowersChildNList.item(i).getNodeName(); // проходимся по каждому ребенку
                Node flwrsChildNode = flowersChildNList.item(i);
                if (Elements.getElements(flwrsChild) != null) {
                    switch (Elements.getElements(flwrsChild)) {
                        case ROSE:
                            flower = new Rose();
                            flower = flowerBuilder(flwrsChildNode, flower);
                            flowers.add(flower);
                            break;
                        case TULIP:
                            flower = new Tulip();
                            flower = flowerBuilder(flwrsChildNode, flower);
                            flowers.add(flower);
                            break;
                        case ORCHID:
                            flower = new Orchid();
                            flower = flowerBuilder(flwrsChildNode, flower);
                            flowers.add(flower);
                            break;
                    }
                }
            }

            NodeList packChildrn = null;
            NodeList packList = element.getElementsByTagName(Elements.PACKAGING.getElement());
            for (int i = 0; i < packList.getLength(); i++) {
                packChildrn = packList.item(i).getChildNodes(); // получаем детей packaging
            }
            packaging = packBuilder(packChildrn);

            bouquet.setPackaging(packaging);
            bouquet.setFlowers(flowers);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return bouquet;
    }

    private Flower flowerBuilder(Node child, Flower flower) {

        NodeList flowersChildNList = child.getChildNodes();
        for (int i = 0; i < flowersChildNList.getLength(); i++) {
            Node specificFlwrsChEl = flowersChildNList.item(i);
            String specificFlwrsChild = flowersChildNList.item(i).getNodeName();

            if (Elements.getElements(specificFlwrsChild) != null) {
                switch (Elements.getElements(specificFlwrsChild)) {
                    case NAME:
                        flower.setName(getTextFromXML(specificFlwrsChEl));
                        break;
                    case COLOR:
                        flower.setColor(FlowersColor.valueOf(
                                getTextFromXML(specificFlwrsChEl).toUpperCase()));
                        break;
                    case LENGTH:
                        flower.setLength(Integer.parseInt(
                                getTextFromXML(specificFlwrsChEl)));
                        break;
                    case LIFETIME:
                        flower.setLifetime(Integer.parseInt(
                                getTextFromXML(specificFlwrsChEl)));
                        break;
                }
            }
        }

        return flower;
    }

    private Packaging packBuilder(NodeList packChildrn) {

        Packaging packaging = new Packaging();
        for (int i = 0; i < packChildrn.getLength(); i++) {
            String packChildStr = packChildrn.item(i).getNodeName();
            Node packChild = packChildrn.item(i);
            if (Elements.getElements(packChildStr) != null) {
                switch (Elements.getElements(packChildStr)) {
                    case PACKTYPE:
                        packaging.setType(PackagingsType.valueOf(
                                getTextFromXML(packChild).toUpperCase()));
                        break;
                    case PACKCOLOR:
                        packaging.setColor(PackagingsColor.valueOf(
                                getTextFromXML(packChild).toUpperCase()));
                        break;
                }
            }
        }
        return packaging;
    }

    private String getTextFromXML(Node node) {
        return node.getTextContent();
    }
}
