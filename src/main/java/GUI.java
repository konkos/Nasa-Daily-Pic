import javafx.scene.media.MediaPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JLabel label;
    private JButton sendRequestBtn;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private BufferedImage image = null;
    private ImageJson data;

    public GUI() {
        APIRequest request = new APIRequest();
        try {
            data = request.getData();
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TITLE: ").append(data.getTitle()).append("\n").append(data.getExplanation()).append("\n")
                .append("DATE: ").append(data.getDate()).append("\n").append("COPYRIGHT").append(data.getCopyright());

        textArea.setLineWrap(true);
        textArea.setColumns(80);

        try {
            image = ImageIO.read(new File("C:\\Users\\kon_k\\IdeaProjects\\NASA DAILY PIC\\src\\main\\resources\\Images\\NASA_Logo.png"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        label.setIcon(new ImageIcon(image));


       /* label.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(label.);
            }
        });*/

        sendRequestBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(data.getMedia_type().equals("image")){
                    try {
                        image = ImageIO.read(new URL(data.getUrl()));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    label.setIcon(new ImageIcon(image));
                    textArea.setText(stringBuilder.toString());
                }else if(data.getMedia_type().equals("video")){
                    textArea.setText("OOPS ERROR!\nUnsupported Media Type");
                }else{
                    textArea.setText("OOPS ERROR!\nUnsupported Media Type");
                }
            }
        });

        //MediaPlayer mediaPanel = new MediaPlayer();

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1980,1080);

    }
}
