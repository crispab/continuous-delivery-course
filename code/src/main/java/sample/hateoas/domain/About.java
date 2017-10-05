package sample.hateoas.domain;

public class About {
    private final String version;

    public About(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
