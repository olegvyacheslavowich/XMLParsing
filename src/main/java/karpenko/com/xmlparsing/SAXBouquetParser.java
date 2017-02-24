package karpenko.com.xmlparsing;

import karpenko.com.flowers.*;
import karpenko.com.packaging.Packaging;
import karpenko.com.packaging.PackagingsColor;
import karpenko.com.packaging.PackagingsType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by Олег on 23.02.2017.
 */
public class SAXBouquetParser extends DefaultHandler {

    private ArrayList<Flower> flowers = new ArrayList<>();
    private Flower flower = null;
    private Packaging packaging = null;
    private String tagName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes at) throws SAXException {
        tagName = qName;
        if (BouquetConst.getName(qName) != null) {
            switch (BouquetConst.getName(qName)) {
                case ORCHID:
                    flower = new Orchid();
                    break;
                case TULIP:
                    flower = new Tulip();
                    break;
                case ROSE:
                    flower = new Rose();
                    break;
                case PACKAGING:
                    packaging = new Packaging();
                    break;
            }
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {

        String str = new String(chars, start, length).trim();
        if (Elements.getElements(tagName) != null) {
            switch (Elements.getElements(tagName)) {
                case COLOR:
                    flower.setColor(FlowersColor.valueOf(str.toUpperCase()));
                    break;
                case LIFETIME:
                    flower.setLifetime(Integer.parseInt(str));
                    break;
                case LENGTH:
                    flower.setLength(Integer.parseInt(str));
                    break;
                case NAME:
                    flower.setName(str);
                    break;
                case PACKCOLOR:
                    packaging.setColor(PackagingsColor.valueOf(str.toUpperCase()));
                    break;
                case PACKTYPE:
                    packaging.setType(PackagingsType.valueOf(str.toUpperCase()));
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equals(BouquetConst.ORCHID.getName()) ||
                qName.equals(BouquetConst.ROSE.getName()) ||
                qName.equals(BouquetConst.TULIP.getName())) {
            flowers.add(flower);
        }
        tagName = null;
    }


    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public Packaging getPackaging() {
        return packaging;
    }
}
