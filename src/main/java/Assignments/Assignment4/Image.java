package Assignments.Assignment4;

public class Image extends Media implements IImageStandard{
    private String imageCodec;

    public Image(String name, String imageCodec) {
        super(name);
        this.imageCodec = imageCodec;
    }

    @Override
    public String getMediaInfo() {
        return "Image ID: " + getId() +
                "Image name: " + getFileName() +
                "Image codec: " + getImageCodec();
    }

    @Override
    public String getImageCodec() {
        return "Image codec: " + getImageCodec();
    }
}
