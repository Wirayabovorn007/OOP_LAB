import java.awt.BorderLayout;
import javax.swing.*;


public class PoringConstructor{
    JFrame frame = new JFrame();
    JPanel btnPanel = new JPanel();
    JButton btn = new JButton("Add");
    JPanel spacel = new JPanel();
    JPanel spacer = new JPanel();
    
    public PoringConstructor(){
        btnPanel.setLayout(new BorderLayout());
        btnPanel.add(btn, BorderLayout.CENTER);
        btnPanel.add(spacel, BorderLayout.EAST);
        btnPanel.add(spacer, BorderLayout.WEST);
        frame.add(btnPanel);

        btn.addActionListener(e ->{ 
            Poring newPoring = new Poring();
            newPoring.updateCount();
    
        });

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        new PoringConstructor();
    }
}
