package ru.dadata.rest;

public enum Version {
    VERSION_1("v1", "/v1/clean") {
        public String toString() {
            return bref;
        }
    };

    private Version(String bref, String queryPath) {
        this.bref = bref;
        this.queryPath = queryPath;
    }

    public static Version fromBref(String bref) {
        for (Version v : values()) {
            if (v.bref.equalsIgnoreCase(bref))
                return v;
        }
        throw new IllegalArgumentException("Illegal version bref");
    }

    public final String bref;
    public final String queryPath;
}
