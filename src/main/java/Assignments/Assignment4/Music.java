package Assignments.Assignment4;

public class Music extends Media implements IAudioStandard{
    private String audioCodec;

    @Override
    public String getAudioCodec() {
        return "Audio codec: " + getAudioCodec();
    }

    @Override
    public String getMediaInfo() {
        return "Music ID: " + getId() +
                "Music name: " + getFileName() +
                "Audio codec: " + getAudioCodec();
    }

    public Music(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    public Music(String name, String audioCodec) {
        super(name);
        this.audioCodec = audioCodec;
    }
}
