import java.util.HashMap;

public class MediaPlayer {

    public static void main(String [] args) {
        System.out.println("This is HashMap practice");
        Video videoFile = new Video("Food Wars", "Anime");
        //example polymorphism is
        //Media mediafile = new Video("Testing","Polymorphism");
        Music musicFile = new Music("Sorry", "FLAC");
        videoFile.setVideoSize(523.23);
        musicFile.setMusicSize(128);
        HashMap<String,Media> collections = new HashMap();
        //this is inheritance + generic
        collections.put("1337",videoFile);
        collections.put("7331",musicFile);

        Media var = collections.get("1337");
        System.out.println("Type of this file is: " + var.returnLabel() + " " + var.returnType());
    }
}

class Media {

    private String title;
    private String type;
    String label;
    Media() {
        this.title = "";
        this.type = "";
    }

    Media(String inputT, String inputType) {
        this.title = inputT;
        this.type = inputType;
    }

    String returnTitle() {
        return this.title;
    }

    String returnType() {
        return this.type;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setType(String type) {
        this.type = type;
    }
    void Play(){
        System.out.println("Currently playing: " + this.returnTitle());
    }
    String returnLabel()
    {
        return this.label;
    }

}
class Video extends Media {
    Double videoSize;
    String label = "Video File";
    Video(String inputT, String inputType) {
        setTitle(inputT);
        setType(inputType);
    }
    void setVideoSize(Double input){
        this.videoSize = input;
    }
    String returnLabel(){
        return this.label;
    }
    //this is overloading method

}

class Music extends Media {
    Integer musicSize;
    String label = "Music File";
    Music(String inputT, String inputType) {
        setTitle(inputT);
        setType(inputType);
    }
    void setMusicSize(Integer input){
        this.musicSize = input;
    }
    String returnLabel(){
        return this.label;
    }
    //this is overloading method
}

