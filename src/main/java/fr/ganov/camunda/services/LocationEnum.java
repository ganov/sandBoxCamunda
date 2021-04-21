package fr.ganov.camunda.services;
public enum LocationEnum {
    MTL("Montreal"),
    MRS("Marseille"),
    NYC("NewYork"),
    MXC("Mexico"),
    BZL("Brasilia"),
    SDY("Sydney"),
    SDS("Saint-denis"),
    BBY("Bombay"),
    ADE("Alexandrie"),
    RME("Rome"),
    MDD("Madrid"),
    LSB("Lisbonne"),
    TNS("Tunis"),
    MKH("Marrakech");

    public final String label;

    LocationEnum(String label) {
        this.label = label;
    }
}
