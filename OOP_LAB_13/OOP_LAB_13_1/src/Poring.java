import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Poring{
    
    public String path = System.getProperty("user.dir");
    JFrame frame = new JFrame();
    JPanel content = new JPanel();
    public static int count = 0;  
    String imgPath = path + "/src/pic/poring.png";
    Random rand = new Random();

    public Poring() {
        try {
            File file = new File(imgPath);
            
            if (!file.exists()) {
                throw new FileNotFoundException("Img file not found!");
            }
            
            InputStream imgStream = new FileInputStream(imgPath);
            BufferedImage img = ImageIO.read(imgStream);
            imgStream.close();
     
            Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(scaledImg));
            imgLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    frame.dispose();
                }
            });
            content.add(imgLabel);

        } catch (IOException e) {
            e.printStackTrace();
        }

       

        JLabel numLabel = new JLabel();
        numLabel.setText(String.valueOf(count));
        content.add(numLabel);

        frame.add(content);
        frame.setSize(200, 200);
        frame.setResizable(false);
        frame.setLocation(rand.nextInt(1200),rand.nextInt(900));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);

    
        shakeshake();
        

    }

    public void shakeshake(){
        new Thread(()->{
            int originalX = frame.getX();
            int originalY = frame.getY();

            for(int i =0; i<Integer.MAX_VALUE; i++){
                int offsetX = (rand.nextInt(10)-5);
                int offsetY = (rand.nextInt(10)-5);
                frame.setLocation(originalX+offsetX, originalY+offsetY);

                try{
                    Thread.sleep(50);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            frame.setLocation(originalX, originalY);
        }).start();
    }

    public void updateCount(){
        count++;
    }


}
