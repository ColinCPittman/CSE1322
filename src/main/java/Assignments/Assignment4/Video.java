package Assignments.Assignment4;

public class Video extends Media implements IImageStandard,IAudioStandard{
    private String imageCodec;
    private String audioCodec;

    @Override
    public String getAudioCodec() {
        return "Audio codec: " + getAudioCodec();
    }

    @Override
    public String getImageCodec() {
        return "Image codec: " + getImageCodec();
    }

    @Override
    public String getMediaInfo() {
        return "Video ID: " + getId() +
                "Video name: " + getFileName() +
                "Image codec: " + getImageCodec() +
                "Audio codec: " + getAudioCodec();
    }

    public Video(String imageCodec, String audioCodec) {
        this.imageCodec = imageCodec;
        this.audioCodec = audioCodec;
    }

    public Video(String name, String imageCodec, String audioCodec) {
        super(name);
        this.imageCodec = imageCodec;
        this.audioCodec = audioCodec;
    }
}
