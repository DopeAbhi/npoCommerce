package Resources;

public class UrlResponsePair {

    private int responseCode;
    private String linkName;

    public UrlResponsePair(int responseCode, String linkName) {
        this.responseCode=responseCode;
        this.linkName=linkName;
    }

    public int getResponseCode()
    {
        return responseCode;
    }
    public String getLinkName()
    {
        return linkName;
    }

}
