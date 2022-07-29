package nl.codecentric.declarationeventservice.domain.declaration;

public enum DeclarationType {
    FUEL("FUEL"), ITEM("ITEM");

    private String type;

    DeclarationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
