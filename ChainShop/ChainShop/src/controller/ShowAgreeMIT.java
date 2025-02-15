package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowAgreeMIT extends JFrame {

	String strMIT = "<html>Copyright (C) 2024/06/24 <br/>"
            + "Permission is hereby granted, free of charge, to any person <br/>" 
			+ "obtaining a copy <br/>of this software and associated <br/>"
            + "documentation files (the \\\"Software\\\"), to deal in the <br/>"
			+ "Software without restriction, including without limitation <br/>"
            + "the rights to use, copy, modify, merge, publish, distribute,<br/>"
			+ "sublicense, and/or sell copies of the Software, and to permit <br/>"
			+ "persons to whom the Software is furnished to do so, subject to <br/>"
			+ "the following conditions:<br/>"
            + "<br/>"
			+ "THE SOFTWARE IS PROVIDED \\\"AS IS\\\", WITHOUT WARRANTY OF ANY <br/>"
            + "KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE <br/>"
			+ "WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE <br/>"
            + "AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT <br/>"
			+ "HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, <br/>"
            + "WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, <br/>"
			+ "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER <br/>"
            + "DEALINGS IN THE SOFTWARE.";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAgreeMIT frame = new ShowAgreeMIT();
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
	public ShowAgreeMIT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MIT許可證");
		setBounds(100, 100, 450, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 529);
		contentPane.add(scrollPane);
		
		//將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
		
		JButton btnUseIt = new JButton("開始使用");
		btnUseIt.setVisible(false);
		btnUseIt.setFont(new Font("新細明體", Font.BOLD, 18));
		btnUseIt.setBounds(248, 607, 178, 41);
		btnUseIt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartManager s = new StartManager();
				s.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnUseIt);
		
		JLabel lbShowMIT = new JLabel("");
		lbShowMIT.setFont(new Font("新細明體", Font.BOLD, 15));
		lbShowMIT.setVerticalAlignment(SwingConstants.TOP);
		lbShowMIT.setText(strMIT);
		scrollPane.setViewportView(lbShowMIT);
		
		JCheckBox checkBoxIAgree = new JCheckBox("我同意");
		checkBoxIAgree.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBoxIAgree.setBounds(248, 556, 178, 39);
		checkBoxIAgree.addItemListener(new ItemListener() {

			
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	btnUseIt.setVisible(true);
					
                } else {
                	btnUseIt.setVisible(false);
                }
            }
			
        });
		contentPane.add(checkBoxIAgree);
		
		
	}

}
