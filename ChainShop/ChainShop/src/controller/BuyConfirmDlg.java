package controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BranchShop;
import model.BuyOrder;
import model.Member;
import service.Impl.BranchShopServiceImpl;
import service.Impl.BuyOrderServiceImpl;
import util.Cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BuyConfirmDlg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyConfirmDlg frame = new BuyConfirmDlg();
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
	public BuyConfirmDlg() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("確認訂單");
		setBounds(100, 100, 485, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// 將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
				
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		BuyOrder bo = (BuyOrder)Cal.readFile("buyOrder.txt");
		Member m = (Member)Cal.readFile("member.txt");
		String strShow = (String)Cal.readFile("totalMoney.txt");
		JLabel lbName = new JLabel("------");
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setFont(new Font("新細明體", Font.BOLD, 18));
		lbName.setBounds(10, 10, 83, 40);
		lbName.setText(m.getName());
		contentPane.add(lbName);
		
		JLabel lbYour = new JLabel(", 您的訂單資訊如下");
		lbYour.setFont(new Font("新細明體", Font.BOLD, 18));
		lbYour.setBounds(108, 10, 353, 40);
		contentPane.add(lbYour);
		
		JLabel lbDateTime = new JLabel("");
		lbDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lbDateTime.setFont(new Font("新細明體", Font.BOLD, 18));
		lbDateTime.setBounds(10, 74, 451, 40);
		lbDateTime.setText("------");
		contentPane.add(lbDateTime);
		
		JButton btnOK = new JButton("確定");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BuyOrderServiceImpl().addBuyOrder(bo);
				JOptionPane.showMessageDialog(null, "新增訂單成功", "確認訂單", JOptionPane.WARNING_MESSAGE);
				BuyDlg bdBuy = new BuyDlg();
				bdBuy.setVisible(true);
				dispose();
			}
		});
		btnOK.setFont(new Font("新細明體", Font.BOLD, 18));
		btnOK.setBounds(301, 434, 160, 50);
		contentPane.add(btnOK);
		
		JButton btnCancel = new JButton("取消");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyDlg bd = new BuyDlg();
				bd.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("新細明體", Font.BOLD, 18));
		btnCancel.setBounds(114, 435, 160, 48);
		contentPane.add(btnCancel);
		
		JLabel lbShopName = new JLabel("------");
		lbShopName.setFont(new Font("新細明體", Font.BOLD, 18));
		lbShopName.setBounds(10, 124, 451, 40);
		contentPane.add(lbShopName);
		
		JLabel lbMenu000Name = new JLabel("------");
		lbMenu000Name.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu000Name.setBounds(10, 174, 156, 40);
		contentPane.add(lbMenu000Name);
		
		JLabel lbMenu000Price = new JLabel("------");
		lbMenu000Price.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu000Price.setBounds(176, 174, 148, 40);
		contentPane.add(lbMenu000Price);
		
		JLabel lbMenu000Count = new JLabel("------");
		lbMenu000Count.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu000Count.setBounds(333, 174, 46, 40);
		contentPane.add(lbMenu000Count);
		
		JLabel lbMenu000Unit = new JLabel("份");
		lbMenu000Unit.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu000Unit.setBounds(389, 174, 46, 40);
		contentPane.add(lbMenu000Unit);
		
		JLabel lbMenu001Name = new JLabel("------");
		lbMenu001Name.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu001Name.setBounds(10, 224, 156, 40);
		contentPane.add(lbMenu001Name);
		
		JLabel lbMenu001Price = new JLabel("------");
		lbMenu001Price.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu001Price.setBounds(176, 224, 148, 40);
		contentPane.add(lbMenu001Price);
		
		JLabel lbMenu001Count = new JLabel("------");
		lbMenu001Count.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu001Count.setBounds(333, 224, 46, 40);
		contentPane.add(lbMenu001Count);
		
		JLabel lbMenu001Unit = new JLabel("份");
		lbMenu001Unit.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu001Unit.setBounds(389, 224, 46, 40);
		contentPane.add(lbMenu001Unit);
		
		JLabel lbMenu002Name = new JLabel("------");
		lbMenu002Name.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu002Name.setBounds(10, 274, 156, 40);
		contentPane.add(lbMenu002Name);
		
		JLabel lbMenu002Price = new JLabel("------");
		lbMenu002Price.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu002Price.setBounds(176, 274, 148, 40);
		contentPane.add(lbMenu002Price);
		
		JLabel lbMenu002Count = new JLabel("------");
		lbMenu002Count.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu002Count.setBounds(333, 274, 46, 40);
		contentPane.add(lbMenu002Count);
		
		JLabel lbMenu002Unit = new JLabel("份");
		lbMenu002Unit.setFont(new Font("新細明體", Font.BOLD, 18));
		lbMenu002Unit.setBounds(389, 274, 46, 40);
		contentPane.add(lbMenu002Unit);
		
		JLabel lbTotal = new JLabel("------");
		lbTotal.setFont(new Font("新細明體", Font.BOLD, 18));
		lbTotal.setBounds(10, 331, 241, 40);
		contentPane.add(lbTotal);
		
		List<BranchShop> l = new BranchShopServiceImpl().queryAllByShopName(bo.getShopName());
		if (l.size() <= 0)
		{
			JOptionPane.showMessageDialog(null, "這筆訂單缺少該分店名稱", "確認訂單", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		BranchShop bs = l.get(0);
		Color cBack = new Color(bs.getBackR(), bs.getBackG(), bs.getBackB());
		Color cFore = new Color(bs.getForeR(), bs.getForeG(), bs.getForeB());
		contentPane.setBackground(cBack);
		lbName.setForeground(cFore);
		lbYour.setForeground(cFore);
		lbDateTime.setForeground(cFore);
		lbShopName.setForeground(cFore);
		lbMenu000Name.setForeground(cFore);
		lbMenu001Name.setForeground(cFore);
		lbMenu002Name.setForeground(cFore);
		lbMenu000Price.setForeground(cFore);
		lbMenu001Price.setForeground(cFore);
		lbMenu002Price.setForeground(cFore);
		lbMenu000Count.setForeground(cFore);
		lbMenu001Count.setForeground(cFore);
		lbMenu002Count.setForeground(cFore);
		lbMenu000Unit.setForeground(cFore);
		lbMenu001Unit.setForeground(cFore);
		lbMenu002Unit.setForeground(cFore);
		lbTotal.setForeground(cFore);
		
		lbName.setText(bo.getMemberName());
		lbDateTime.setText(bo.getBuyDate() + " " + bo.getBuyTime());
		lbShopName.setText(bo.getShopName());
		lbMenu000Name.setText(bo.getMenu000Name());
		lbMenu001Name.setText(bo.getMenu001Name());
		lbMenu002Name.setText(bo.getMenu002Name());
		lbMenu000Price.setText(bo.getMenu000Price().toString());
		lbMenu001Price.setText(bo.getMenu001Price().toString());
		lbMenu002Price.setText(bo.getMenu002Price().toString());
		lbMenu000Count.setText(bo.getMenu000Count().toString());
		lbMenu001Count.setText(bo.getMenu001Count().toString());
		lbMenu002Count.setText(bo.getMenu002Count().toString());
		
		lbTotal.setText("共: " + bo.getBuySum()+ "元");

//		         + "\n" + cbShopNameList.getSelectedItem().toString()
//		         + "\n" + strMenu000Name + "\t" + iMenu000Price + "元\t" + iMenu000Count + "個\t=\t" + iMenu000Price*iMenu000Count + "元"
//		         + "\n" + strMenu001Name + "\t" + iMenu001Price + "元\t" + iMenu001Count + "個\t=\t" + iMenu001Price*iMenu001Count + "元"
//		         + "\n" + strMenu002Name + "\t" + iMenu002Price + "元\t" + iMenu002Count + "個\t=\t" + iMenu001Price*iMenu001Count + "元"
//		         + "\n-----------------------------"
//		         + "\n共" + iSum + "元";
	}

}
