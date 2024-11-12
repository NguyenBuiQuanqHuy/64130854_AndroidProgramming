package vn.nguyenbuiquanghuy.apps.recyclerview;

public class Country {
    String ImageFile;
    String Name;
    String Caption;

    public Country(String imageFile, String name, String caption) {
        ImageFile = imageFile;
        Name = name;
        Caption = caption;
    }

    public String getImageFile() {
        return ImageFile;
    }

    public void setImageFile(String imageFile) {
        ImageFile = imageFile;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }
}
