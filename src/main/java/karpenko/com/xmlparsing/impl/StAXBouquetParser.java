package karpenko.com.xmlparsing.impl;

import karpenko.com.bouquet.Bouquet;
import karpenko.com.flowers.*;
import karpenko.com.packaging.Packaging;
import karpenko.com.packaging.PackagingsColor;
import karpenko.com.packaging.PackagingsType;
import karpenko.com.xmlparsing.BouquetViewer;
import karpenko.com.xmlparsing.Elements;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Олег on 24.02.2017.
 */
public class StAXBouquetParser  implements BouquetViewer {

    private XMLInputFactory inputFactory;
    private String path;

    public StAXBouquetParser(String path) {

        inputFactory = XMLInputFactory.newInstance();
        this.path = path;
    }

    public Bouquet bouquetBuilder() {

        ArrayList<Flower> flowers = new ArrayList<>();
        Bouquet bouquet = new Bouquet();
        Packaging packaging;
        String name;

        try (FileInputStream file = new FileInputStream(path)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(file);

            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        if (Elements.getElements(name) != null) {
                            switch (Elements.getElements(name)) {
                                case TULIP:
                                    Flower tulip = new Tulip();
                                    tulip = buildFlower(reader, tulip);
                                    flowers.add(tulip);
                                    break;
                                case ORCHID:
                                    Flower orchid = new Orchid();
                                    orchid = buildFlower(reader, orchid);
                                    flowers.add(orchid);
                                    break;
                                case ROSE:
                                    Flower rose = new Rose();
                                    rose = buildFlower(reader, rose);
                                    flowers.add(rose);
                                    break;
                                case PACKAGING:
                                    packaging = buildPackaging(reader);
                                    bouquet.setPackaging(packaging);
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (Elements.getElements(name) != null) {
                            switch (Elements.getElements(name)) {
                                case FLOWERS:
                                    bouquet.setFlowers(flowers);
                                    break;
                            }
                        }
                        break;
                }

            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

        return bouquet;
    }

    private Flower buildFlower(XMLStreamReader reader, Flower flower) throws XMLStreamException {

        String name;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = connectPrefix(reader.getLocalName(), reader.getPrefix());
                        if (Elements.getElements(name) != null) {
                            switch (Elements.getElements(name)) {
                                case NAME:
                                    flower.setName(getTextFromXML(reader));
                                    break;
                                case COLOR:
                                    flower.setColor(FlowersColor.valueOf(getTextFromXML(reader).toUpperCase()));
                                    break;
                                case LENGTH:
                                    flower.setLength(Integer.parseInt(getTextFromXML(reader)));
                                    break;
                                case LIFETIME:
                                    flower.setLifetime(Integer.parseInt(getTextFromXML(reader)));
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (Elements.getElements(name) != null) {
                            switch (Elements.getElements(name)) {
                                case TULIP:
                                    return flower;
                                case ORCHID:
                                    return flower;
                                case ROSE:
                                    return flower;
                            }
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        throw new XMLStreamException("I don't know this flower");
    }

    private String connectPrefix(String localName, String prefix) {

        String out = localName;
        if (!prefix.equals("")) {
            out = prefix + ":" + localName;
        }

        return out;
    }

    private Packaging buildPackaging(XMLStreamReader reader) {

        Packaging packaging = new Packaging();
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        String name = connectPrefix(reader.getLocalName(), reader.getPrefix());
                        if (Elements.getElements(name) != null) {
                            switch (Elements.getElements(name)) {
                                case PACKTYPE:
                                    packaging.setType(PackagingsType.valueOf(getTextFromXML(reader).toUpperCase()));
                                    break;
                                case PACKCOLOR:
                                    packaging.setColor(PackagingsColor.valueOf(getTextFromXML(reader).toUpperCase()));
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (Elements.getElements(name) != null) {
                            switch (Elements.getElements(name)) {
                                case PACKAGING:
                                    return packaging;
                            }
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return packaging;
    }

    private String getTextFromXML(XMLStreamReader reader) {
        String text = null;
        try {
            if (reader.hasNext()) {
                reader.next();
                text = reader.getText();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return text;
    }

}
