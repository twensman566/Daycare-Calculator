package objects;

public class License {

    public License() {

    }

    public License(String licenseKey, String licenseType, String maxNumberOfChildren, String state, String year) {
        this.licenseType = licenseType;
        this.licenseKey = licenseKey;
        this.maxNumberOfChildren = maxNumberOfChildren;
        this.state = state;
        this.year = year;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public String getMaxNumberOfChildren() {
        return maxNumberOfChildren;
    }

    public void setMaxNumberOfChildren(String maxNumberOfChildren) {
        this.maxNumberOfChildren = maxNumberOfChildren;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String licenseType;
    private String licenseKey;
    private String maxNumberOfChildren;
    private String state;
    private String year;


}
