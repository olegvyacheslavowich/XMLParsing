package karpenko.com.xmlparsing;

/**
 * Created by Олег on 23.02.2017.
 */
public enum Elements {
    NAME("name"),
    COLOR("color"),
    LIFETIME("lifetime"),
    LENGTH("length"),
    PACKCOLOR("pack:color"),
    PACKTYPE("pack:type");

    String element;

    Elements(String element) {
        this.element = element;
    }

    public static Elements getElements(String str) {

        Elements element = null;
        for (Elements elements : Elements.values()) {
            if (elements.getElement().equals(str)) {
                element = elements;
            }
        }
        return element;
    }

    public String getElement() {
        return element;
    }
}
