package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Employee;
import service.Impl.EmployeeServiceImpl;
import util.Cal;
import java.awt.Color;

public class OrderLoginManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderLoginManager frame = new OrderLoginManager();
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
	public OrderLoginManager() {
		setTitle("訂單管理登入");
		getContentPane().setLayout(null);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 252);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 22, 117, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 92, 117, 40);
		contentPane.add(lblNewLabel_1);
		
		JTextField account = new JTextField();
		account.setFont(new Font("新細明體", Font.BOLD, 18));
		account.setBounds(151, 22, 130, 40);
		contentPane.add(account);
		account.setColumns(10);
		
		JTextField password = new JTextField();
		password.setFont(new Font("新細明體", Font.BOLD, 18));
		password.setBounds(151, 92, 130, 40);
		contentPane.add(password);
		password.setColumns(10);
		
		//
		
		
		//
		JButton btnLogin = new JButton();
		btnLogin.setText("登入");
		btnLogin.setFont(new Font("新細明體", Font.BOLD, 18));
		btnLogin.setBounds(314, 163, 110, 45);
		contentPane.add(btnLogin);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strAccount = account.getText();
				String strPassword = password.getText();
				if (strAccount.isEmpty() ||
					strPassword.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"欄位不可為空白","訂單管理登入",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (strAccount.equals("root") && 
					strPassword.equals("root")
				   )
				{
					
					OrderListDlg dlg = new OrderListDlg();
					dlg.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"帳號或密碼錯誤","訂單管理登入",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton btnReturn = new JButton("返回");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartManager s = new StartManager();
				s.setVisible(true);
				dispose();
			}
		});
		btnReturn.setFont(new Font("新細明體", Font.BOLD, 18));
		btnReturn.setBounds(194, 163, 110, 45);
		contentPane.add(btnReturn);
		
		JLabel lblNewLabel_2 = new JLabel("root");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_2.setBounds(291, 22, 133, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("root");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_3.setBounds(291, 92, 133, 40);
		contentPane.add(lblNewLabel_3);
	}

}
