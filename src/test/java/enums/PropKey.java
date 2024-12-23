package enums;

public enum PropKey {
    RETRY("retry");

    private String key;

    PropKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
