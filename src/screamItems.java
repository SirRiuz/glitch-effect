import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class screamItems extends JDialog {

    private int maxWidth;
    private int maxHeigth;

    public screamItems(int maxHeigth , int maxWidth){

        this.maxHeigth=maxHeigth;
        this.maxWidth=maxWidth;
        
        //this.setSize(new Dimension(100,100));
        this.setRandomSize();
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        //this.setBackground(colirList.get(new Random().nextInt(colirList.size())));
        this.setRandomPositionItem();
        this.addImage();
    }

    private void setRandomSize(){

        int heigth = new Random().nextInt(this.maxHeigth);
        int width = new Random().nextInt(this.maxWidth)/2-100;
        if (heigth >= 500) {
            heigth=300;
        }


        System.out.println("width -> " + width);
        System.out.println("heigth -> "+ heigth);

        this.setSize(new Dimension(
                new Random().nextInt(this.maxWidth) - 100,
                heigth
        ));
    }

    private void setRandomPositionItem(){
        int width = new Random().nextInt(this.maxWidth);
        int heigth = new Random().nextInt(this.maxHeigth);
        this.setLocation(width,heigth);
    }

    private String captureScreamShot(){
        int randomName = new Random().nextInt(10000);
        String newName = randomName + ".png";

        try {
            new screamManager().captureScreen(newName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newName;
    }

    private void addImage() {
        JLabel labelImage = new JLabel();
        labelImage.setIcon(new ImageIcon(this.captureScreamShot()));
        labelImage.setSize(new Dimension(this.maxWidth,this.maxHeigth));
        this.add(labelImage);
    }

}
