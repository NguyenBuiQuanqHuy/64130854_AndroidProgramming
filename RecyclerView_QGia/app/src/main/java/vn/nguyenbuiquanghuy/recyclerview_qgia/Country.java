package vn.nguyenbuiquanghuy.recyclerview_qgia;

public class Country {
    String imageFileName;
    String CountryName;
    String CountryDS;

    public Country(String imageFileName, String countryName, String countryDS) {
        this.imageFileName = imageFileName;
        CountryName = countryName;
        CountryDS = countryDS;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCountryDS() {
        return CountryDS;
    }

    public void setCountryDS(String countryDS) {
        CountryDS = countryDS;
    }
}
