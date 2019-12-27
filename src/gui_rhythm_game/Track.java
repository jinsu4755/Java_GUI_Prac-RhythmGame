package gui_rhythm_game;

public class Track {
    private String titleImage; // title image
    private String startImage; // select image
    private String gameImage; //play music -> show this image
    private String startMusic; //select music
    private String gameMusic; // when start game, play Music
    private String titleName; // music title

    public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String titleName) {
        super();
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
        this.titleName = titleName;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public String getStartImage() {
        return startImage;
    }

    public String getGameImage() {
        return gameImage;
    }

    public String getStartMusic() {
        return startMusic;
    }

    public String getGameMusic() {
        return gameMusic;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
