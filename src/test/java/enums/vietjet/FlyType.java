package enums.vietjet;

public enum FlyType {
    RETURN("return"),
    ONEWAY("oneway");

    private String name;

    FlyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
