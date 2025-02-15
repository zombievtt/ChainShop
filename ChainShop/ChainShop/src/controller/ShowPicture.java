package controller;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ShowPicture extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPicture frame = new ShowPicture();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowPicture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// 创建 JLabel 来显示图片
        JLabel imageLabel = new JLabel();
        
        ImageIcon imageIcon = new ImageIcon("pic/preVIewPic.jpg");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        
        // 将 JLabel 添加到 JFrame 的内容面板中
        contentPane.add(imageLabel);
        
		//將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
		
		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowAgreeMIT saMIT = new ShowAgreeMIT();
				saMIT.setVisible(true);
				dispose();
				
			}
        });
        timer.setRepeats(false); // 设置定时器只执行一次
        timer.start(); // 启动定时器
	}

}
