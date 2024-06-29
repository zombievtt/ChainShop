package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.Impl.BuyState;
import model.BuyOrder;
import model.Employee;
import service.Impl.BuyOrderServiceImpl;
import util.Cal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class EmployeeDlg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cbMemberOrderStateList;
	private JScrollPane jScroll = null;
	private DefaultTableModel model = null;
	private JTable tableHistory = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDlg frame = new EmployeeDlg();
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
	public EmployeeDlg() {
		Employee employee = (Employee)Cal.readFile("employee.txt");
		setTitle("員工處理訂單狀態");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbShopName = new JLabel("------");
		lbShopName.setHorizontalAlignment(SwingConstants.CENTER);
		lbShopName.setFont(new Font("新細明體", Font.BOLD, 18));
		lbShopName.setForeground(new Color(0, 0, 0));
		lbShopName.setBounds(10, 10, 160, 38);
		lbShopName.setText(employee.getShopName());
		contentPane.add(lbShopName);
		
		JLabel lbEmployeeName = new JLabel("------");
		lbEmployeeName.setHorizontalAlignment(SwingConstants.CENTER);
		lbEmployeeName.setFont(new Font("新細明體", Font.BOLD, 18));
		lbEmployeeName.setBounds(175, 10, 160, 38);
		lbEmployeeName.setText("員工:" + employee.getName());
		contentPane.add(lbEmployeeName);
		
		cbMemberOrderStateList = new JComboBox();
		cbMemberOrderStateList.setFont(new Font("新細明體", Font.BOLD, 18));
		cbMemberOrderStateList.setBounds(1066, 10, 191, 38);
		contentPane.add(cbMemberOrderStateList);
		
		cbMemberOrderStateList.addItem(BuyState.strUnread);
		cbMemberOrderStateList.addItem(BuyState.strPreparing);
		cbMemberOrderStateList.addItem(BuyState.strPickUp);
		cbMemberOrderStateList.addItem(BuyState.strPickUped);
		cbMemberOrderStateList.addItem(BuyState.strCallOff);
		
		JButton btnRefresh = new JButton("重新整理");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RefreshHistoryOrder();
			}
		});
		btnRefresh.setFont(new Font("新細明體", Font.BOLD, 18));
		btnRefresh.setBounds(362, 10, 133, 38);
		contentPane.add(btnRefresh);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "\u540D", "\u5E33\u865F", "\u5BC6\u78BC", "\u5206\u5E97\u540D", "\u83DCA\u540D", "\u83DCA\u6578\u91CF", "\u83DCA\u50F9\u683C", "\u83DCB\u540D", "\u83DCB\u50F9\u683C", "\u83DCB\u6578\u91CF", "\u83DCC\u540D", "\u83DCC\u50F9\u683C", "\u83DCC\u6578\u91CF", "\u5C0F\u8A08", "\u65E5\u671F", "\u6642\u9593", "\u8A02\u55AE\u72C0\u614B"
				}
			);
		//使用精靈新增一列表格 與資料表order_buy相對應
		tableHistory = new JTable(model);
		tableHistory.setFont(new Font("新細明體", Font.BOLD, 12));
		tableHistory.setShowVerticalLines(false);
		tableHistory.setShowHorizontalLines(false);
		tableHistory.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableHistory.setBounds(0, 0, 881, 379);
		tableHistory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			}
			
		});
		jScroll = new JScrollPane(tableHistory, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScroll.setBounds(10, 106, 1247, 421);
		contentPane.add(jScroll);
		
		JButton btnBack = new JButton("返回");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeLoginManager em = new EmployeeLoginManager();
				em.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("新細明體", Font.BOLD, 18));
		btnBack.setBounds(362, 58, 133, 38);
		contentPane.add(btnBack);
		
		JLabel lbPlease = new JLabel("請選擇訂單狀態:");
		lbPlease.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlease.setFont(new Font("新細明體", Font.BOLD, 18));
		lbPlease.setBounds(871, 10, 185, 38);
		contentPane.add(lbPlease);
		
		JLabel lbFirstSelect = new JLabel("請先選擇訂單列:");
		lbFirstSelect.setFont(new Font("新細明體", Font.BOLD, 18));
		lbFirstSelect.setBounds(10, 57, 251, 39);
		contentPane.add(lbFirstSelect);
		
		JButton btnUpdateState = new JButton("該訂單狀態更新");
		btnUpdateState.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Employee employee = (Employee)Cal.readFile("employee.txt");
				List<BuyOrder> listBuyOrder = new BuyOrderServiceImpl().queryAllByShopName(employee.getShopName());
				
				String strState = cbMemberOrderStateList.getSelectedItem().toString().trim();
				int[] rows = tableHistory.getSelectedRows();
				for (BuyOrder bo:listBuyOrder)
				{
					
				}
				for (int i:rows)
				{
					tableHistory.setValueAt(strState, i, 17);
					String id = tableHistory.getValueAt(i, 0).toString();
					new BuyOrderServiceImpl().updateBuyOrderShopById(strState, Integer.parseInt(id));
					System.out.println("id:"+id+" state:"+strState);
				}
				
			}
		});
		btnUpdateState.setFont(new Font("新細明體", Font.BOLD, 18));
		btnUpdateState.setBounds(1066, 58, 191, 38);
		contentPane.add(btnUpdateState);
		
		// 獲取分店名稱
		cbMemberOrderStateList.setSelectedIndex(0);
		
		RefreshHistoryOrder();
		
		
		       
		
	}
	
	private void RefreshHistoryOrder()
	{
		//列出歷史訂單
		for (int i = model.getRowCount()-1; i >= 0; i--)
		{
			model.removeRow(i);
		}
		
		Employee employee = (Employee)Cal.readFile("employee.txt");
		List<BuyOrder> listBuyOrder = new BuyOrderServiceImpl().queryAllByShopName(employee.getShopName());
		
		for (BuyOrder bo: listBuyOrder)
		{
			Vector<String> row = new Vector<String>();
        	row.add(bo.getId().toString());
        	row.add(bo.getMemberName());
        	row.add(bo.getMemberAccount());
        	row.add(bo.getMemberPassword());
        	row.add(bo.getShopName());
        	row.add(bo.getMenu000Name());
        	row.add(bo.getMenu000Price().toString() + "元");
        	row.add(bo.getMenu000Count().toString() + "份");
        	row.add(bo.getMenu001Name());
        	row.add(bo.getMenu001Price().toString() + "元");
        	row.add(bo.getMenu001Count().toString() + "份");
        	row.add(bo.getMenu002Name());
        	row.add(bo.getMenu002Price().toString() + "元");
        	row.add(bo.getMenu002Count().toString() + "份");
        	row.add(bo.getBuySum().toString() + "元");
        	row.add(bo.getBuyDate());
        	row.add(bo.getBuyTime());
        	row.add(bo.getBuyState());
        	
        	model.addRow(row);
		}
	
			
		//Table 欄位內容置中
		for (int i = model.getColumnCount()-1; i >= 0; i--)
		{
			TableColumn column = tableHistory.getColumnModel().getColumn(i);
			DefaultTableCellRenderer render = new DefaultTableCellRenderer();
			render.setHorizontalAlignment(SwingConstants.CENTER);
			column.setCellRenderer(render);
		}
	}
}
