package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BranchShop;
import service.Impl.BranchShopServiceImpl;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;

public class BranchShopManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BranchShopManager frame = new BranchShopManager();
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
	public BranchShopManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 226, 323);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("返回");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartManager s = new StartManager();
				s.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("新細明體", Font.BOLD, 18));
		btnBack.setBounds(25, 220, 166, 48);
		contentPane.add(btnBack);
		
		JButton btnAdd = new JButton("新增分店");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowAddBranchShop s = new ShowAddBranchShop();
				s.setVisible(true);
				dispose();
			}
		});
		btnAdd.setFont(new Font("新細明體", Font.BOLD, 18));
		btnAdd.setBounds(25, 10, 166, 48);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("編輯分店");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<BranchShop> l = new BranchShopServiceImpl().queryAll();
				if (l.size() > 0)
				{
					ShowEditBranchShop s = new ShowEditBranchShop();
					s.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"您沒有分店可以編輯.","編輯分店",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnEdit.setFont(new Font("新細明體", Font.BOLD, 18));
		btnEdit.setBounds(25, 80, 166, 48);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("刪除分店");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowDeleteBranchShop s = new ShowDeleteBranchShop();
				s.setVisible(true);
				dispose();
				
			}
		});
		btnDelete.setFont(new Font("新細明體", Font.BOLD, 18));
		btnDelete.setBounds(25, 150, 166, 48);
		contentPane.add(btnDelete);
	}

}
