package gui_rhythm_game;

import javax.swing.*;
import java.awt.*;

public class Game extends Thread {

    // game Image //
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/game/noteBasic.png")).getImage();
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/game/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/game/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/game/gameInfo.png")).getImage();

    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();

    //

    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);

        g.drawImage(noteRouteLineImage, 224, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 432, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);

        g.drawImage(noteBasicImage, 228, 120, null);
        g.drawImage(noteBasicImage, 332, 580, null);

        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgementLineImage, 0, 600, null);

        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("YuYoon - Drive with my Friend", 20, 702);
        g.drawString("Easy", 1190, 702);

        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.setColor(Color.darkGray);
        g.drawString("S",270,629);
        g.drawString("D",374,629);
        g.drawString("F",478,629);
        g.drawString("Space Bar",580,629);
        g.drawString("J",784,629);
        g.drawString("K",889,629);
        g.drawString("L",993,629);

        g.setColor(Color.lightGray);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565, 702);


    }
    // S event
    public void pressS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    }
    // D event
    public void pressD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        new Music("drumSmall2.mp3", false).start();
    }
    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    }
    // F event
    public void pressF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    }
    // space bar event
    public void pressSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        new Music("drumBig1.mp3", false).start();
    }
    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    }
    // J event
    public void pressJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    }
    // K event
    public void pressK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        new Music("drumSmall2.mp3", false).start();
    }
    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    }
    // L event
    public void pressL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/game/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
    }
    //


    @Override
    public void run() {

    }
}
