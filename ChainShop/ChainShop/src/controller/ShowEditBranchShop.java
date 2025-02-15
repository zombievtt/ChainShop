package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ShowAddBranchShop.JLabelTimerTask;
import model.BranchShop;
import service.Impl.BranchShopServiceImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComboBox;

public class ShowEditBranchShop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	private JTextField menu000Name;
	private JTextField menu000Price;
	private JTextField menu001Name;
	private JTextField menu001Price;
	private JTextField menu002Name;
	private JTextField menu002Price;
	private JLabel lbDateTime = null;
	private String DTF = "yyyy-MM-dd HH:mm:ss";
	private String strDateTime = "";
	private final int ONE_SECOND = 1000;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowEditBranchShop frame = new ShowEditBranchShop();
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
	public ShowEditBranchShop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("編輯分店");
		setBounds(100, 100, 913, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// 將視窗位置設置在正中央
		setLocationRelativeTo(contentPane);
		contentPane.setLayout(null);

		JPanel panelBackgroundColor = new JPanel();
		panelBackgroundColor.setBackground(new Color(255, 255, 255));
		panelBackgroundColor.setBounds(10, 10, 165, 65);
		contentPane.add(panelBackgroundColor);
		panelBackgroundColor.setLayout(null);

		JLabel lbForegroundColor = new JLabel("New label");
		lbForegroundColor.setBackground(new Color(0, 0, 0));
		lbForegroundColor.setFont(new Font("新細明體", Font.BOLD, 18));
		lbForegroundColor.setHorizontalAlignment(SwingConstants.CENTER);
		lbForegroundColor.setBounds(10, 10, 145, 45);
		panelBackgroundColor.add(lbForegroundColor);

		JLabel lblNewLabel = new JLabel("分店名:");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(199, 21, 82, 40);
		contentPane.add(lblNewLabel);

		lbDateTime = new JLabel("-------------------");
		lbDateTime.setForeground(new Color(0, 0, 255));
		lbDateTime.setFont(new Font("新細明體", Font.BOLD, 18));
		lbDateTime.setBackground(new Color(255, 255, 255));
		lbDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lbDateTime.setBounds(530, 21, 359, 40);
		contentPane.add(lbDateTime);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(530, 21, 359, 40);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 95, 370, 276);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("菜單背景色");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 10, 109, 35);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("R:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_3.setBounds(124, 55, 26, 35);
		panel_1.add(lblNewLabel_3);

		JLabel lbBackR = new JLabel("---");
		lbBackR.setFont(new Font("新細明體", Font.BOLD, 18));
		lbBackR.setBounds(160, 55, 98, 34);
		panel_1.add(lbBackR);

		JSlider sliderBackR = new JSlider();
		sliderBackR.setMaximum(255);
		sliderBackR.setBounds(29, 99, 310, 18);
		panel_1.add(sliderBackR);

		JLabel lblNewLabel_4 = new JLabel("G:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_4.setBounds(124, 127, 26, 35);
		panel_1.add(lblNewLabel_4);

		JLabel lbBackG = new JLabel("---");
		lbBackG.setFont(new Font("新細明體", Font.BOLD, 18));
		lbBackG.setBounds(160, 127, 98, 34);
		panel_1.add(lbBackG);

		JSlider sliderBackG = new JSlider();
		sliderBackG.setMaximum(255);
		sliderBackG.setBounds(29, 162, 310, 18);
		panel_1.add(sliderBackG);

		JLabel lblNewLabel_6 = new JLabel("B:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_6.setBounds(124, 190, 26, 35);
		panel_1.add(lblNewLabel_6);

		JLabel lbBackB = new JLabel("---");
		lbBackB.setFont(new Font("新細明體", Font.BOLD, 18));
		lbBackB.setBounds(160, 190, 98, 34);
		panel_1.add(lbBackB);

		JSlider sliderBackB = new JSlider();
		sliderBackB.setMaximum(255);
		sliderBackB.setBounds(29, 227, 310, 18);
		panel_1.add(sliderBackB);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 392, 370, 258);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("菜單文字色");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 10, 123, 36);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_5 = new JLabel("R:");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(124, 28, 26, 35);
		panel_2.add(lblNewLabel_5);

		JSlider sliderForeR = new JSlider();
		sliderForeR.setMaximum(255);
		sliderForeR.setBounds(29, 76, 310, 18);
		panel_2.add(sliderForeR);

		JSlider sliderForeG = new JSlider();
		sliderForeG.setMaximum(255);
		sliderForeG.setBounds(29, 149, 310, 18);
		panel_2.add(sliderForeG);

		JSlider sliderForeB = new JSlider();
		sliderForeB.setMaximum(255);
		sliderForeB.setBounds(29, 217, 310, 18);
		panel_2.add(sliderForeB);

		JLabel lblNewLabel_8 = new JLabel("G:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_8.setBounds(124, 104, 26, 35);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("B:");
		lblNewLabel_9.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_9.setBounds(124, 176, 26, 35);
		panel_2.add(lblNewLabel_9);

		JLabel lbForeR = new JLabel("---");
		lbForeR.setFont(new Font("新細明體", Font.BOLD, 18));
		lbForeR.setBounds(160, 29, 98, 34);
		panel_2.add(lbForeR);

		JLabel lbForeG = new JLabel("---");
		lbForeG.setFont(new Font("新細明體", Font.BOLD, 18));
		lbForeG.setBounds(160, 104, 98, 34);
		panel_2.add(lbForeG);

		JLabel lbForeB = new JLabel("---");
		lbForeB.setFont(new Font("新細明體", Font.BOLD, 18));
		lbForeB.setBounds(160, 177, 98, 34);
		panel_2.add(lbForeB);

		JLabel lblNewLabel_13 = new JLabel("菜單A");
		lblNewLabel_13.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_13.setBounds(394, 95, 82, 34);
		contentPane.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("菜單B");
		lblNewLabel_14.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_14.setBounds(394, 152, 82, 34);
		contentPane.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("菜單C");
		lblNewLabel_15.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_15.setBounds(394, 214, 82, 34);
		contentPane.add(lblNewLabel_15);

		menu000Name = new JTextField();
		menu000Name.setFont(new Font("新細明體", Font.BOLD, 18));
		menu000Name.setHorizontalAlignment(SwingConstants.CENTER);
		menu000Name.setBounds(486, 95, 240, 34);
		contentPane.add(menu000Name);
		menu000Name.setColumns(10);

		menu000Price = new JTextField();
		menu000Price.setFont(new Font("新細明體", Font.BOLD, 18));
		menu000Price.setHorizontalAlignment(SwingConstants.CENTER);
		menu000Price.setBounds(736, 95, 96, 34);
		contentPane.add(menu000Price);
		menu000Price.setColumns(10);

		menu001Name = new JTextField();
		menu001Name.setFont(new Font("新細明體", Font.BOLD, 18));
		menu001Name.setHorizontalAlignment(SwingConstants.CENTER);
		menu001Name.setBounds(487, 152, 239, 34);
		contentPane.add(menu001Name);
		menu001Name.setColumns(10);

		menu001Price = new JTextField();
		menu001Price.setFont(new Font("新細明體", Font.BOLD, 18));
		menu001Price.setHorizontalAlignment(SwingConstants.CENTER);
		menu001Price.setBounds(736, 152, 96, 34);
		contentPane.add(menu001Price);
		menu001Price.setColumns(10);

		menu002Name = new JTextField();
		menu002Name.setFont(new Font("新細明體", Font.BOLD, 18));
		menu002Name.setHorizontalAlignment(SwingConstants.CENTER);
		menu002Name.setBounds(486, 214, 240, 34);
		contentPane.add(menu002Name);
		menu002Name.setColumns(10);

		menu002Price = new JTextField();
		menu002Price.setFont(new Font("新細明體", Font.BOLD, 18));
		menu002Price.setHorizontalAlignment(SwingConstants.CENTER);
		menu002Price.setBounds(736, 214, 96, 34);
		contentPane.add(menu002Price);
		menu002Price.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("元");
		lblNewLabel_16.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_16.setBounds(843, 95, 46, 34);
		contentPane.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("元");
		lblNewLabel_17.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_17.setBounds(843, 152, 46, 34);
		contentPane.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("元");
		lblNewLabel_18.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_18.setBounds(843, 214, 46, 34);
		contentPane.add(lblNewLabel_18);

		JButton btnCancel = new JButton("取消");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BranchShopManager b = new BranchShopManager();
				b.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("新細明體", Font.BOLD, 18));
		btnCancel.setBounds(635, 607, 118, 43);
		contentPane.add(btnCancel);

//		lbBackR.setText("255");
//		lbBackG.setText("255");
//		lbBackB.setText("255");
//		sliderBackR.setValue(255);
//		sliderBackG.setValue(255);
//		sliderBackB.setValue(255);
		ChangeListener clBack = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Integer r = sliderBackR.getValue();
				Integer g = sliderBackG.getValue();
				Integer b = sliderBackB.getValue();

				lbBackR.setText(r.toString());
				lbBackG.setText(g.toString());
				lbBackB.setText(b.toString());

				Color c = new Color(r, g, b);
				panelBackgroundColor.setBackground(c);

			}
		};

		sliderBackR.addChangeListener(clBack);
		sliderBackG.addChangeListener(clBack);
		sliderBackB.addChangeListener(clBack);

		lbForeR.setText("0");
		lbForeG.setText("0");
		lbForeB.setText("0");
		sliderForeR.setValue(0);
		sliderForeG.setValue(0);
		sliderForeB.setValue(0);

		JComboBox cbShopNameList = new JComboBox();
		cbShopNameList.setFont(new Font("新細明體", Font.BOLD, 18));
		cbShopNameList.setBounds(291, 22, 202, 40);

		List<BranchShop> l = new BranchShopServiceImpl().queryAll();

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JComboBox) {

					String strShopName = cbShopNameList.getSelectedItem().toString();
					List<BranchShop> l = new BranchShopServiceImpl().queryAllByShopName(strShopName);
					BranchShop bs = l.get(0);
					sliderBackR.setValue(bs.getBackR());
					sliderBackG.setValue(bs.getBackG());
					sliderBackB.setValue(bs.getBackB());
					sliderForeR.setValue(bs.getForeR());
					sliderForeG.setValue(bs.getForeG());
					sliderForeB.setValue(bs.getForeB());
					lbBackR.setText(bs.getBackR().toString());
					lbBackG.setText(bs.getBackG().toString());
					lbBackB.setText(bs.getBackB().toString());
					lbForeR.setText(bs.getForeR().toString());
					lbForeG.setText(bs.getForeG().toString());
					lbForeB.setText(bs.getForeB().toString());
					menu000Name.setText(bs.getMenu000Name());
					menu001Name.setText(bs.getMenu001Name());
					menu002Name.setText(bs.getMenu002Name());
					menu000Price.setText(bs.getMenu000Price().toString());
					menu001Price.setText(bs.getMenu001Price().toString());
					menu002Price.setText(bs.getMenu002Price().toString());
					Color cBack = new Color(bs.getBackR(), bs.getBackG(), bs.getBackB());
					Color cFore = new Color(bs.getForeR(), bs.getForeG(), bs.getForeB());

					panelBackgroundColor.setBackground(cBack);
					lbForegroundColor.setForeground(cFore);

				}

			}
		};

		if (l.size() > 0) {
			for (BranchShop b : l) {
				cbShopNameList.addItem(b.getShopName());
			}

			cbShopNameList.addActionListener(actionListener);
			cbShopNameList.setSelectedIndex(0);
		}
		contentPane.add(cbShopNameList);

		ChangeListener clFore = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Integer r = sliderForeR.getValue();
				Integer g = sliderForeG.getValue();
				Integer b = sliderForeB.getValue();

				lbForeR.setText(r.toString());
				lbForeG.setText(g.toString());
				lbForeB.setText(b.toString());

				Color c = new Color(r, g, b);
				lbForegroundColor.setForeground(c);
			}
		};

		sliderForeR.addChangeListener(clFore);
		sliderForeG.addChangeListener(clFore);
		sliderForeB.addChangeListener(clFore);

		// 只能輸入數字
		KeyAdapter ka = new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
				} else {
					// 禁用鍵盤事件傳遞
					e.consume();
				}
			}
		};
		menu000Price.addKeyListener(ka);
		menu001Price.addKeyListener(ka);
		menu002Price.addKeyListener(ka);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);

		JButton btnOK = new JButton("確定");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer size = cbShopNameList.getItemCount();
				if (size.equals(0)) {
					JOptionPane.showMessageDialog(null, "沒有分店可以編輯.", "編輯分店", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String strShopName = cbShopNameList.getSelectedItem().toString().trim();

				List<BranchShop> l = new BranchShopServiceImpl().queryAllByShopName(strShopName);
				BranchShop bs = l.get(0);
				Integer id = bs.getId();

				// 取得編輯資訊
				bs.setBackR(Integer.parseInt(lbBackR.getText()));
				bs.setBackG(Integer.parseInt(lbBackG.getText()));
				bs.setBackB(Integer.parseInt(lbBackB.getText()));
				bs.setForeR(Integer.parseInt(lbForeR.getText()));
				bs.setForeG(Integer.parseInt(lbForeG.getText()));
				bs.setForeB(Integer.parseInt(lbForeB.getText()));
				bs.setMenu000Name(menu000Name.getText());
				bs.setMenu001Name(menu001Name.getText());
				bs.setMenu002Name(menu002Name.getText());
				bs.setMenu000Price(Integer.parseInt(menu000Price.getText()));
				bs.setMenu001Price(Integer.parseInt(menu001Price.getText()));
				bs.setMenu002Price(Integer.parseInt(menu002Price.getText()));

				new BranchShopServiceImpl().updateBranchShopById(bs, id);
				JOptionPane.showMessageDialog(null, "編輯資訊更新成功.", "編輯分店", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnOK.setFont(new Font("新細明體", Font.BOLD, 18));
		btnOK.setBounds(771, 607, 118, 43);
		contentPane.add(btnOK);
	}

	protected class JLabelTimerTask extends TimerTask {
		SimpleDateFormat sdf = new SimpleDateFormat(DTF);

		@Override
		public void run() {
			String strDateTime = sdf.format(Calendar.getInstance().getTime());
			lbDateTime.setText(strDateTime);
		}
	}
}
