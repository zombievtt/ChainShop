package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import model.BranchShop;
import model.Employee;
import model.Member;
import service.Impl.BranchShopServiceImpl;
import service.Impl.EmployeeServiceImpl;
import service.Impl.MemberServiceImpl;
import util.Cal;

import javax.swing.JComboBox;

public class EmployeeRegisterManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField account;
	private JTextField password;
	private JComboBox cbShopNameList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRegisterManager frame = new EmployeeRegisterManager();
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
	public EmployeeRegisterManager() {
		setTitle("員工註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
				
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("名");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 104, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 80, 104, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 154, 104, 38);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setFont(new Font("新細明體", Font.BOLD, 18));
		name.setBounds(130, 12, 207, 38);
		contentPane.add(name);
		name.setColumns(10);
		
		account = new JTextField();
		account.setFont(new Font("新細明體", Font.BOLD, 18));
		account.setBounds(130, 80, 207, 38);
		contentPane.add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("新細明體", Font.BOLD, 18));
		password.setBounds(130, 151, 207, 41);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnOK = new JButton("確定");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strName = name.getText().trim();
				String strAccount = account.getText().trim();
				String strPassword = password.getText().trim();
				if (strName.isEmpty() ||
					strAccount.isEmpty() ||
					strPassword.isEmpty()
				   )
				{
					JOptionPane.showMessageDialog(null,"欄位不可為空白","員工註冊",JOptionPane.WARNING_MESSAGE);
				    return;	
				}
				
				//註冊員工資訊
				String strShopName = cbShopNameList.getSelectedItem().toString().trim();
				List<Employee> l = new EmployeeServiceImpl().queryAllByAccount(strAccount);
				if (l.size() > 0)
				{
					JOptionPane.showMessageDialog(null,"此帳戶已存在, 註冊失敗.","員工註冊",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Employee employee = new Employee();
					employee.setName(strName);
					employee.setAccount(strAccount);
					employee.setPassword(strPassword);
					employee.setShopName(strShopName);
					new EmployeeServiceImpl().addEmployee(employee);
					JOptionPane.showMessageDialog(null,"註冊成功.","員工註冊",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnOK.setFont(new Font("新細明體", Font.BOLD, 18));
		btnOK.setBounds(424, 211, 139, 42);
		contentPane.add(btnOK);
		
		JButton btnCancel = new JButton("取消");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeLoginManager employeeDlg = new EmployeeLoginManager();
				employeeDlg.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("新細明體", Font.BOLD, 18));
		btnCancel.setBounds(258, 211, 139, 42);
		contentPane.add(btnCancel);
		
		cbShopNameList = new JComboBox();
		cbShopNameList.setFont(new Font("新細明體", Font.BOLD, 18));
		cbShopNameList.setBounds(366, 10, 197, 41);
		contentPane.add(cbShopNameList);
		
		// 載入分店名稱
		List<BranchShop> l = new BranchShopServiceImpl().queryAll();

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};

		//載入所有分店名稱
		if (l.size() > 0) {
			for (BranchShop b : l) {
				cbShopNameList.addItem(b.getShopName());
			}

			cbShopNameList.addActionListener(actionListener);
			cbShopNameList.setSelectedIndex(0);
		} else {
			JOptionPane.showMessageDialog(null, "沒有分店可以選擇", "員工註冊", JOptionPane.WARNING_MESSAGE);
		}
	}
	
//	void changeUIByShopName() {
//		// 獲取分店名稱
//		String strShopName = cbShopNameList.getSelectedItem().toString().trim();
//
//		// 查詢分店資訊
//		List<BranchShop> listBranchShop = new BranchShopServiceImpl().queryAllByShopName(strShopName);
//		BranchShop bs = listBranchShop.get(0);
//		Integer id = bs.getId();
//
//		Cal.saveFile("employeeShopName.txt", bs);
//	}
	
}
