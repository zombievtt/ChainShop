package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class StartManager extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartManager frame = new StartManager();
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
	public StartManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("魔王連鎖店");
		setBounds(100, 100, 396, 232);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
		
		JButton btnBranchShop = new JButton("分店管理");
		btnBranchShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BranchShopManager m = new BranchShopManager();
				m.setVisible(true);
				dispose();
			}
		});
		btnBranchShop.setBounds(30, 50, 133, 46);
		btnBranchShop.setFont(new Font("新細明體", Font.BOLD, 18));
		contentPane.add(btnBranchShop);
		
		JLabel lblNewLabel = new JLabel("魔王連鎖店");
		lblNewLabel.setBounds(30, 10, 302, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnEmployee = new JButton("員工");
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeLoginManager elm = new EmployeeLoginManager();
				elm.setVisible(true);
				dispose();
			}
		});
		btnEmployee.setBounds(30, 123, 133, 46);
		btnEmployee.setFont(new Font("新細明體", Font.BOLD, 18));
		contentPane.add(btnEmployee);
		
		JButton btnMember = new JButton("會員");
		btnMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberLoginManager mlm = new MemberLoginManager();
				mlm.setVisible(true);
				dispose();
			}
		});
		btnMember.setBounds(199, 50, 133, 46);
		btnMember.setFont(new Font("新細明體", Font.BOLD, 18));
		contentPane.add(btnMember);
		
		JButton btnBuyOrder = new JButton("訂單查詢");
		btnBuyOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderLoginManager dlg = new OrderLoginManager();
				dlg.setVisible(true);
				dispose();
			}
		});
		btnBuyOrder.setBounds(198, 123, 133, 46);
		btnBuyOrder.setFont(new Font("新細明體", Font.BOLD, 19));
		contentPane.add(btnBuyOrder);
		
		
		
	}
}
