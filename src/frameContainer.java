

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.KeyAdapter;
    import java.awt.event.KeyEvent;
    import java.util.Random;
    import java.util.TimerTask;

    public class frameContainer extends JFrame {

    private int maxScreamWhidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int maxScreamHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    private JPanel panelContainer = null;

    public frameContainer() {
        this.setUndecorated(true);
        this.setSize(new Dimension(this.maxScreamWhidth,maxScreamHeight));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(new Color(0,0,0,0.0f));
        this.addKillSwitch();
        this.setPanelContainer();
        this.setAlwaysOnTop(false);
        this.setVisible(true);
        this.addScreamItems();
    }

    private void setPanelContainer(){
        panelContainer = new JPanel();
        panelContainer.setLayout(null);
        panelContainer.setOpaque(false);
        //panelContainer.setBackground(new Color(0, 0, 1));
        this.add(panelContainer,BorderLayout.NORTH);
    }

    private void addKillSwitch() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == 88) {
                    System.exit(1);
                }
            }
        });
    }

    private void addScreamItems(){

        Runnable runaRunnable = new Runnable() {
            @Override
            public void run() {
                try{
                    int position = 0;
                    for (int x =0;x<=500;x++){
                        if(position <= 10) {
                            Thread.sleep(1200);
                        } else if(position <= 20){
                            Thread.sleep(1000);
                        } else if (position <= 25){
                            Thread.sleep(600);
                        }
                        screamItems item = new screamItems(maxScreamHeight,maxScreamWhidth);
                        item.disable();
                        item.setVisible(true);
                        System.out.println("Iteracion -> " + position);
                        position ++;
                    }
                } catch (Exception e){
                    System.out.println("A ocurrido un error :(");
                    System.out.println(e.getMessage());
                }
            }
        };
        runaRunnable.run();
    }

}
