package view;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Objects;

public class View extends JFrame implements ActionListener{
    private ImageIcon SorryImage;
    private ImageIcon image;
    private ImageIcon RPawn1,RPawn2,YPawn1,YPawn2,yslide_end,yslide_start,yslide_mid,backImage;
    private ImageIcon rslide_end,rslide_start,rslide_mid,gslide_end,gslide_start,gslide_mid,bslide_end,bslide_start,bslide_mid;
    private JLabel sorryLabel,label,colors,RHome,Yhome,RStart,YStart;
    private JLabel[] RedHome,YHome;
    private JLabel[][] squares;
    private JButton FoldButton,RedPawn1,RedPawn2,YellowPawn1,YellowPawn2,LeftDeck,RightDeck;
    private JTextField Info;


    /**
     * Constructor:Creates a new window and initializes some buttons
     * Post-Condition:A window and buttons have been created
     */
    public View(){
        backImage=new ImageIcon("backCard.png");
         SorryImage=new ImageIcon("sorryImage.png");
         sorryLabel=new JLabel(SorryImage);
         image=new ImageIcon("background.png");
         label=new JLabel(image);
        FoldButton=new JButton();
        colors=new JLabel();
         squares=new JLabel[15][4];
         RedHome=new JLabel[5];
         RHome= new JLabel();
         Yhome=new JLabel();
         YHome=new JLabel[5];
         RStart=new JLabel();
         YStart=new JLabel();
         RPawn1=new ImageIcon("redPawn1.png");
         RPawn2=new ImageIcon("redPawn2.png");
         RedPawn1=new JButton(RPawn1);
         RedPawn2=new JButton(RPawn2);
         YPawn1=new ImageIcon("yellowPawn1.png");
         YPawn2=new ImageIcon("yellowPawn2.png");
         YellowPawn1=new JButton(YPawn1);
         YellowPawn2=new JButton(YPawn2);
         LeftDeck=new JButton(backImage);
         RightDeck=new JButton();
         Info=new JTextField();
         yslide_end=new ImageIcon("yellowSlideEnd.png");
         yslide_mid=new ImageIcon("yellowSlideMedium.png");
         yslide_start=new ImageIcon("yellowSlideStart.png");
         rslide_end=new ImageIcon("redSlideEnd.png");
         rslide_mid=new ImageIcon("redSlideMedium.png");
         rslide_start=new ImageIcon("redSlideStart.png");
         gslide_end=new ImageIcon("greenSlideEnd.png");
         gslide_mid=new ImageIcon("greenSlideMedium.png");
         gslide_start=new ImageIcon("greenSlideStart.png");
         bslide_end=new ImageIcon("blueSlideEnd.png");
         bslide_mid=new ImageIcon("blueSlideMedium.png");
         bslide_start=new ImageIcon("blueSlideStart.png");
         initComp();
    }

    /**
     * Transformer:Sets more buttons and labels
     * Post-Condition:More of them have been set
     */
    public void initComp(){
        this.setLayout(new BorderLayout());
        this.setTitle("SORRY GAME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sorryLabel.setBounds(150,300,417,121);

        label.setSize(1080,1080);

        FoldButton.setBounds(775,425,235,60);
        FoldButton.addActionListener(this);
        FoldButton.setBackground(Color.red);
        FoldButton.setText("FOLD BUTTON");
        FoldButton.setFont(new Font("Comic Sans",Font.BOLD,16));
        FoldButton.setForeground(Color.CYAN);
        FoldButton.setFocusable(false);


        colors.setBounds(0,0,736,1088);
        colors.setOpaque(true);
        colors.setBackground(Color.CYAN);

        Border globalBorder=BorderFactory.createLineBorder(Color.BLACK,3);


        int Ysum=0;
        for(int j=0;j<4;j++) {
            int Xsum=0;
            for (int i = 0; i < 15; i++) {
                squares[i][j] = new JLabel();
                if(j==0) {
                    squares[i][j].setBounds(0, Ysum, 46, 48);
                    Ysum = Ysum + 48;
                }else if(j==1){
                    Xsum=Xsum+46;
                    squares[i][j].setBounds(Xsum,0,46,48);

                }
                else if(j==3){
                    squares[i][j].setBounds(690,Ysum,46,48);
                    Ysum=Ysum-48;
                }
                else {
                    squares[i][j].setBounds(Xsum,720,46,48);
                    Xsum+=46;
                }
                squares[i][j].setBackground(Color.white);
                squares[i][j].setBorder(globalBorder);
                squares[i][j].setOpaque(true);
            }
        }


        Border rborder=BorderFactory.createLineBorder(Color.red,5);

        RHome.setBounds(69,288,100,100);
        RHome.setText("Home");
        RHome.setBackground(Color.white);
        RHome.setHorizontalAlignment(JLabel.CENTER);
        RHome.setVerticalAlignment(JLabel.BOTTOM);
        RHome.setFont(new Font("MV Bola",Font.BOLD,24));
        RHome.setBorder(rborder);
        RHome.setOpaque(true);

        Ysum=48;
        for(int i =0;i<5;i++){
            RedHome[i]=new JLabel();
            RedHome[i].setBounds(92,Ysum,46,48);
            Ysum+=48;
            RedHome[i].setBackground(Color.RED);
            RedHome[i].setBorder(globalBorder);
            RedHome[i].setOpaque(true);
        }


        Border yborder=BorderFactory.createLineBorder(Color.YELLOW,5);
        Yhome.setBounds(575,384,100,100);
        Yhome.setBackground(Color.WHITE);
        Yhome.setText("Home");
        Yhome.setHorizontalAlignment(JLabel.CENTER);
        Yhome.setVerticalAlignment(JLabel.TOP);
        Yhome.setFont(new Font("MV Bola",Font.BOLD,24));
        Yhome.setBorder(yborder);
        Yhome.setOpaque(true);


        Ysum=672;
        for(int i=0;i<5;i++){
            YHome[i]=new JLabel();
            YHome[i].setBounds(598,Ysum,46,48);
            Ysum-=48;
            YHome[i].setBackground(Color.YELLOW);
            YHome[i].setOpaque(true);
            YHome[i].setBorder(globalBorder);
        }



        RStart.setText("Start");
        RStart.setVerticalAlignment(JLabel.BOTTOM);
        RStart.setHorizontalAlignment(JLabel.CENTER);
        RStart.setBackground(Color.WHITE);
        RStart.setBorder(rborder);
        RStart.setBounds(161,48,100,100);
        RStart.setFont(new Font("MV Bola",Font.BOLD,24));
        RStart.setOpaque(true);


        YStart.setText("Start");
        YStart.setVerticalAlignment(JLabel.TOP);
        YStart.setHorizontalAlignment(JLabel.CENTER);
        YStart.setBackground(Color.WHITE);
        YStart.setBorder(yborder);
        YStart.setBounds(483,620,100,100);
        YStart.setFont(new Font("MV Bola",Font.BOLD,24));
        YStart.setOpaque(true);




        RedPawn1.setBounds(170,64,40,40);

        RedPawn2.setBounds(215,64,40,40);



        YellowPawn1.setBounds(493,660,40,40);

        YellowPawn2.setBounds(538,660,40,40);

        RedPawn1.addActionListener(this);
        RedPawn2.addActionListener(this);
        YellowPawn1.addActionListener(this);
        YellowPawn2.addActionListener(this);

        Info.setPreferredSize(new Dimension(200,150));
        Info.setBounds(775,500,235,150);
        Info.setBackground(Color.white);
        Info.setText("Info Box");
        Info.setFont(new Font("MV Bola",Font.BOLD,24));
        Info.setHorizontalAlignment(JTextField.CENTER);
        Info.setBorder(globalBorder);
        Info.setOpaque(true);

        LeftDeck.setBounds(775,200,110,200);
        LeftDeck.setText("Receive Card");
        LeftDeck.setHorizontalAlignment(JButton.CENTER);
        LeftDeck.setVerticalAlignment(JButton.BOTTOM);
        LeftDeck.setOpaque(true);

        RightDeck.setBounds(900,200,110,200);
        RightDeck.setText("Current Card");
        RightDeck.setHorizontalAlignment(JButton.CENTER);
        RightDeck.setVerticalAlignment(JButton.BOTTOM);
        RightDeck.setOpaque(true);



        slides(squares);
        setResizable(false);

        this.add(YellowPawn1);
        this.add(YellowPawn2);
        this.add(RedPawn2);
        this.add(RedPawn1);
        for(int j=0;j<4;j++) {
            for (int i = 0; i < 15; i++) {
                this.add(squares[i][j]);
            }
        }
        for(int i=0;i<5;i++){
            this.add(RedHome[i]);
            this.add(YHome[i]);
        }
        this.add(RightDeck);
        this.add(LeftDeck);
        this.add(Info);

        this.add(YStart);
        this.add(RStart);
        this.add(Yhome);
        this.add(RHome);
        this.add(FoldButton);
        this.add(sorryLabel);
        this.add(colors);
        this.add(label);
        this.pack();
        this.setVisible(true);

    }

    /**
     * Transformer:sets some buttons after the options of the player
     * Post-Condition:Buttons have been set
     */

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * takes the table as a parameter and applies the proper images for each slide
     * in the proper position and in the proper way color etc.
     * @param sq
     */
    void slides(JLabel[][] sq){

        sq[2][2].setIcon(yslide_end);
        sq[6][2].setIcon(yslide_start);
        sq[3][2].setIcon(yslide_mid);
        sq[4][2].setIcon(yslide_mid);
        sq[5][2].setIcon(yslide_mid);


        sq[11][2].setIcon(yslide_end);
        sq[14][2].setIcon(yslide_start);
        sq[12][2].setIcon(yslide_mid);
        sq[13][2].setIcon(yslide_mid);




        sq[3][1].setIcon(rslide_end);
        sq[0][1].setIcon(rslide_start);
        sq[2][1].setIcon(rslide_mid);
        sq[1][1].setIcon(rslide_mid);


        sq[8][1].setIcon(rslide_start);
        sq[12][1].setIcon(rslide_end);
        sq[9][1].setIcon(rslide_mid);
        sq[10][1].setIcon(rslide_mid);
        sq[11][1].setIcon(rslide_mid);




        sq[2][0].setIcon(gslide_end);
        sq[6][0].setIcon(gslide_start);
        sq[3][0].setIcon(gslide_mid);
        sq[4][0].setIcon(gslide_mid);
        sq[5][0].setIcon(gslide_mid);

        sq[11][0].setIcon(gslide_end);
        sq[14][0].setIcon(gslide_start);
        sq[13][0].setIcon(gslide_mid);
        sq[12][0].setIcon(gslide_mid);




        sq[2][3].setIcon(bslide_end);
        sq[6][3].setIcon(bslide_start);
        sq[3][3].setIcon(bslide_mid);
        sq[4][3].setIcon(bslide_mid);
        sq[5][3].setIcon(bslide_mid);


        sq[11][3].setIcon(bslide_end);
        sq[14][3].setIcon(bslide_start);
        sq[12][3].setIcon(bslide_mid);
        sq[13][3].setIcon(bslide_mid);

    }

    public JButton getRedPawn1(){return RedPawn1;}
    public JButton getYellowPawn1(){return YellowPawn1;}
    public JButton getYellowPawn2(){return YellowPawn2;}
    public JButton getRedPawn2() {
        return RedPawn2;
    }
    public JButton getRightDeck(){return RightDeck;}
    public JButton getLeftDeck(){return LeftDeck;}
    public JTextField getinfo(){return Info;}
}

