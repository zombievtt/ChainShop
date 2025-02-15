package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.Impl.MemberServiceImpl;
import util.Cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;

public class MemberLoginManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberLoginManager frame = new MemberLoginManager();
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
	public MemberLoginManager() {
		setTitle("會員登入");
		getContentPane().setLayout(null);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnRegister = new JButton("前往註冊");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberRegisterManager mrm = new MemberRegisterManager();
				mrm.setVisible(true);
				dispose();
			}
		});
		btnRegister.setFont(new Font("新細明體", Font.BOLD, 18));
		btnRegister.setBounds(297, 163, 110, 45);
		contentPane.add(btnRegister);
		
		JTextField account = new JTextField();
		account.setFont(new Font("新細明體", Font.BOLD, 18));
		account.setBounds(151, 22, 263, 40);
		contentPane.add(account);
		account.setColumns(10);
		
		JTextField password = new JTextField();
		password.setFont(new Font("新細明體", Font.BOLD, 18));
		password.setBounds(151, 92, 263, 40);
		contentPane.add(password);
		password.setColumns(10);
		
		//
		
		
		//
		JButton btnLogin = new JButton();
		btnLogin.setText("登入");
		btnLogin.setFont(new Font("新細明體", Font.BOLD, 18));
		btnLogin.setBounds(151, 163, 110, 45);
		contentPane.add(btnLogin);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strAccount = account.getText().trim();
				String strPassword = password.getText().trim();
				if (strAccount.isEmpty() ||
					strPassword.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"欄位不可為空","會員登入",JOptionPane.WARNING_MESSAGE);
					return;
				}
				List<Member> l = new MemberServiceImpl().queryAllByAccount(strAccount);
				if (l.size() > 0)
				{
					Member m = l.get(0);
					if (m.getPassword().equals(strPassword))
					{
						Cal.saveFile("member.txt" , m);
						
						BuyDlg bd = new BuyDlg();
						bd.setVisible(true);
						dispose();						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"帳號或密碼錯誤","會員登入",JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"帳號或密碼錯誤","會員登入",JOptionPane.WARNING_MESSAGE);
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
		btnReturn.setBounds(10, 163, 110, 45);
		contentPane.add(btnReturn);
		
		
	}
}
