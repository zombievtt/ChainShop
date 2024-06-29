package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BranchShop;
import model.BuyOrder;
import model.Employee;
import service.Impl.BranchShopServiceImpl;
import service.Impl.BuyOrderServiceImpl;
import service.Impl.EmployeeServiceImpl;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ShowDeleteBranchShop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cbShopNameList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDeleteBranchShop frame = new ShowDeleteBranchShop();
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
	public ShowDeleteBranchShop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("刪除分店");
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
				
		cbShopNameList = new JComboBox();
		cbShopNameList.setFont(new Font("新細明體", Font.BOLD, 18));
		cbShopNameList.setBounds(10, 10, 168, 34);
		contentPane.add(cbShopNameList);
		
		JButton btnCancel = new JButton("取消");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BranchShopManager bsm = new BranchShopManager();
				bsm.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("新細明體", Font.BOLD, 18));
		btnCancel.setBounds(187, 180, 113, 34);
		contentPane.add(btnCancel);
		
//		cbShopNameList
		List<BranchShop> l = new BranchShopServiceImpl().queryAll();
		Integer size = l.size();
		if (size.equals(0))
		{
			JOptionPane.showMessageDialog(null,"沒有分店可以刪除","刪除分店",JOptionPane.WARNING_MESSAGE);
	
		}
		else
		{
			addCbList();
				
		}
		
		
		JButton btnOK = new JButton("確定");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<BranchShop> l = null;
				boolean b = checkOwnBranchShop();
				if (b)
				{
					String strShopName = cbShopNameList.getSelectedItem().toString().trim();
					System.out.println(strShopName);

					List<BranchShop> listBs = new BranchShopServiceImpl().queryAllByShopName(strShopName);
					BranchShop bs = listBs.get(0);
					Integer id = bs.getId();
					new BranchShopServiceImpl().deleteBranchShopById(id);
					Integer indexSelected = cbShopNameList.getSelectedIndex();
					cbShopNameList.removeItem(strShopName);
					cbShopNameList.invalidate();
					
					List<Employee> listEmployee = new EmployeeServiceImpl().queryAllByShopName(strShopName);
					for (Employee em:listEmployee)
					{
						new EmployeeServiceImpl().deleteEmployeeById(em.getId());
					}
					
					List<BuyOrder> listBuyOrder = new BuyOrderServiceImpl().queryAllByShopName(strShopName);
					for (BuyOrder bo:listBuyOrder)
					{
						new BuyOrderServiceImpl().deleteBuyOrderById(bo.getId());
					}
					
					JOptionPane.showMessageDialog(null,"刪除分店成功","刪除分店",JOptionPane.WARNING_MESSAGE);
					repaint();
				}
			}
		});
		btnOK.setFont(new Font("新細明體", Font.BOLD, 18));
		btnOK.setBounds(311, 180, 113, 34);
		contentPane.add(btnOK);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 73, 414, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbDeleteToo = new JLabel("刪除分店該分店員工也會被刪除");
		lbDeleteToo.setBounds(0, 0, 414, 46);
		panel.add(lbDeleteToo);
		lbDeleteToo.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeleteToo.setForeground(new Color(0, 0, 255));
		lbDeleteToo.setBackground(new Color(0, 255, 255));
		lbDeleteToo.setFont(new Font("新細明體", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(10, 129, 414, 41);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("該分店的訂單也會被刪除");
		lblNewLabel.setBounds(0, 0, 414, 41);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void addCbList()
	{
		List<BranchShop> list = new BranchShopServiceImpl().queryAll();
		for (BranchShop o:list)
		{
			cbShopNameList.addItem(o.getShopName());
		}	
	}
	
	private boolean checkOwnBranchShop()
	{
		List<BranchShop> l = new BranchShopServiceImpl().queryAll();
		Integer size = l.size();
		if (size.equals(0))
		{
			JOptionPane.showMessageDialog(null,"沒有分店可以刪除","刪除分店",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
