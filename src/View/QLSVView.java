package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.QLTSController;
import Model.QLSVModel;
import Model.ThiSinh;
import Model.Tinh;

public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public QLSVModel model;
	public JComboBox jComboBox_QueQuan;
	public JTextField jTextField_TenThiSinh;
	public JTable table;
	public JTextField jTextField_MaThiSinh_TTTS;
	public JTextField jTextField_TenThiSinh_TTTS;
	public JComboBox jComboBox_QueQuan_TTTS;
	public JTextField jTextField_NgaySinh_TTTS;
	public JTextField jTextField_Diem1_TTTS;
	public JTextField jTextField_Diem2_TTTS;
	public JTextField jTextField_Diem3_TTTS;
	public ButtonGroup btnGroupSexTTTS;
	public JRadioButton radioBtn_Nam_TTTS;
	public JRadioButton radioBtn_Nu_TTTS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 688);

		ActionListener action = new QLTSController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu_File = new JMenu("File");
		menu_File.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menu_File);

		JMenuItem menuItem_Open = new JMenuItem("Open");
		menuItem_Open.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menuItem_Open);
		menuItem_Open.addActionListener(action);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(mntmSave);
		mntmSave.addActionListener(action);

		JSeparator separator = new JSeparator();
		menu_File.add(separator);

		JMenuItem menuItem_Exit = new JMenuItem("Exit");
		menuItem_Exit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menuItem_Exit);
		menuItem_Exit.addActionListener(action);

		JMenu menu_About = new JMenu("About");
		menu_About.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menu_About);

		JMenuItem menuItem_AboutMe = new JMenuItem("About me");
		menuItem_AboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_About.add(menuItem_AboutMe);
		menuItem_AboutMe.addActionListener(action);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_QueQuan = new JLabel("Quê quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_QueQuan.setBounds(42, 24, 79, 36);
		contentPane.add(label_QueQuan);

		JLabel lblTnThSinh = new JLabel("Tên thí sinh");
		lblTnThSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnThSinh.setBounds(285, 24, 95, 36);
		contentPane.add(lblTnThSinh);

		jComboBox_QueQuan = new JComboBox();
		jComboBox_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jComboBox_QueQuan.setBounds(131, 24, 144, 36);
		contentPane.add(jComboBox_QueQuan);

		jComboBox_QueQuan.addItem(new String(""));
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			jComboBox_QueQuan.addItem(tinh.getTenTinh());
		}

		jTextField_TenThiSinh = new JTextField();
		jTextField_TenThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_TenThiSinh.setColumns(10);
		jTextField_TenThiSinh.setBounds(396, 24, 144, 36);
		contentPane.add(jTextField_TenThiSinh);

		JButton btn_Tim = new JButton("Tìm");
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Tim.setBounds(568, 24, 72, 36);
		contentPane.add(btn_Tim);
		btn_Tim.addActionListener(action);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 76, 712, 2);
		contentPane.add(separator_1);

		JLabel label_QueQuan_1 = new JLabel("Danh sách thí sinh");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_QueQuan_1.setBounds(10, 88, 150, 37);
		contentPane.add(label_QueQuan_1);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã thí sinh", "Tên thí sinh",
				"Quê quán", "Ngày sinh", "Giới tính", "Điểm 1", "Điểm 2", "Điểm 3" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 132, 712, 175);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 317, 712, 2);
		contentPane.add(separator_1_1);

		JLabel label_ThongTinThiSinh = new JLabel("Thông tin thí sinh");
		label_ThongTinThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_ThongTinThiSinh.setBounds(10, 329, 150, 37);
		contentPane.add(label_ThongTinThiSinh);

		jTextField_MaThiSinh_TTTS = new JTextField();
		jTextField_MaThiSinh_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_MaThiSinh_TTTS.setColumns(10);
		jTextField_MaThiSinh_TTTS.setBounds(185, 376, 156, 28);
		contentPane.add(jTextField_MaThiSinh_TTTS);

		JLabel label_MaThiSinh_TTTS = new JLabel("Mã thí sinh");
		label_MaThiSinh_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_MaThiSinh_TTTS.setBounds(65, 376, 89, 28);
		contentPane.add(label_MaThiSinh_TTTS);

		jTextField_TenThiSinh_TTTS = new JTextField();
		jTextField_TenThiSinh_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_TenThiSinh_TTTS.setColumns(10);
		jTextField_TenThiSinh_TTTS.setBounds(185, 423, 156, 28);
		contentPane.add(jTextField_TenThiSinh_TTTS);

		JLabel label_TenThiSinh_TTTS = new JLabel("Tên thí sinh");
		label_TenThiSinh_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TenThiSinh_TTTS.setBounds(65, 423, 95, 28);
		contentPane.add(label_TenThiSinh_TTTS);

		jComboBox_QueQuan_TTTS = new JComboBox();
		jComboBox_QueQuan_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jComboBox_QueQuan_TTTS.setBounds(185, 470, 156, 30);
		contentPane.add(jComboBox_QueQuan_TTTS);
		jComboBox_QueQuan_TTTS.addItem("");
		for (Tinh tinh : listTinh) {
			jComboBox_QueQuan_TTTS.addItem(tinh.getTenTinh());
		}

		JLabel label_QueQuan_TTTS = new JLabel("Quê quán");
		label_QueQuan_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_QueQuan_TTTS.setBounds(65, 461, 111, 43);
		contentPane.add(label_QueQuan_TTTS);

		jTextField_NgaySinh_TTTS = new JTextField();
		jTextField_NgaySinh_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_NgaySinh_TTTS.setColumns(10);
		jTextField_NgaySinh_TTTS.setBounds(185, 517, 156, 28);
		contentPane.add(jTextField_NgaySinh_TTTS);

		JLabel label_NgaySinh_TTTS = new JLabel("Ngày sinh");
		label_NgaySinh_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_NgaySinh_TTTS.setBounds(65, 520, 79, 22);
		contentPane.add(label_NgaySinh_TTTS);

		JLabel label_GioiTinh_TTTS = new JLabel("Giới tính");
		label_GioiTinh_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_GioiTinh_TTTS.setBounds(383, 376, 89, 28);
		contentPane.add(label_GioiTinh_TTTS);

		btnGroupSexTTTS = new ButtonGroup();

		radioBtn_Nam_TTTS = new JRadioButton("Nam");
		radioBtn_Nam_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioBtn_Nam_TTTS.setBounds(503, 376, 59, 28);
		contentPane.add(radioBtn_Nam_TTTS);

		radioBtn_Nu_TTTS = new JRadioButton("Nữ");
		radioBtn_Nu_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioBtn_Nu_TTTS.setBounds(580, 376, 45, 28);
		contentPane.add(radioBtn_Nu_TTTS);

		btnGroupSexTTTS.add(radioBtn_Nam_TTTS);
		btnGroupSexTTTS.add(radioBtn_Nu_TTTS);

		JLabel label_Diem1_TTTS = new JLabel("Môn 1");
		label_Diem1_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Diem1_TTTS.setBounds(383, 423, 95, 28);
		contentPane.add(label_Diem1_TTTS);

		jTextField_Diem1_TTTS = new JTextField();
		jTextField_Diem1_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_Diem1_TTTS.setColumns(10);
		jTextField_Diem1_TTTS.setBounds(503, 423, 156, 28);
		contentPane.add(jTextField_Diem1_TTTS);

		JLabel label_Diem2_TTTS = new JLabel("Môn 2");
		label_Diem2_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Diem2_TTTS.setBounds(383, 470, 95, 28);
		contentPane.add(label_Diem2_TTTS);

		jTextField_Diem2_TTTS = new JTextField();
		jTextField_Diem2_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_Diem2_TTTS.setColumns(10);
		jTextField_Diem2_TTTS.setBounds(503, 470, 156, 28);
		contentPane.add(jTextField_Diem2_TTTS);

		JLabel label_Diem3_TTTS = new JLabel("Môn 3");
		label_Diem3_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Diem3_TTTS.setBounds(383, 517, 95, 28);
		contentPane.add(label_Diem3_TTTS);

		jTextField_Diem3_TTTS = new JTextField();
		jTextField_Diem3_TTTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_Diem3_TTTS.setColumns(10);
		jTextField_Diem3_TTTS.setBounds(503, 517, 156, 28);
		contentPane.add(jTextField_Diem3_TTTS);

		JButton btn_Them = new JButton("Thêm");
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Them.setBounds(10, 571, 111, 36);
		contentPane.add(btn_Them);
		btn_Them.addActionListener(action);

		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Xoa.setBounds(164, 571, 111, 36);
		contentPane.add(btn_Xoa);
		btn_Xoa.addActionListener(action);

		JButton btn_CapNhat = new JButton("Cập nhật");
		btn_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_CapNhat.setBounds(317, 571, 111, 36);
		contentPane.add(btn_CapNhat);
		btn_CapNhat.addActionListener(action);

		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Luu.setBounds(464, 571, 111, 36);
		contentPane.add(btn_Luu);
		btn_Luu.addActionListener(action);

		JButton btn_HuyBo = new JButton("Hủy bỏ");
		btn_HuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_HuyBo.setBounds(611, 571, 111, 36);
		contentPane.add(btn_HuyBo);
		btn_HuyBo.addActionListener(action);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 559, 712, 2);
		contentPane.add(separator_1_1_1);

		JButton btn_HuyTim = new JButton("Hủy ");
		btn_HuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_HuyTim.setBounds(650, 24, 72, 36);
		contentPane.add(btn_HuyTim);
		btn_HuyTim.addActionListener(action);

		this.setVisible(true);
	}

	public void xoaForm() {
		this.jTextField_Diem1_TTTS.setText("");
		this.jTextField_Diem2_TTTS.setText("");
		this.jTextField_Diem3_TTTS.setText("");
		this.jTextField_MaThiSinh_TTTS.setText("");
		this.jTextField_NgaySinh_TTTS.setText("");
		this.jTextField_TenThiSinh_TTTS.setText("");
		jComboBox_QueQuan_TTTS.setSelectedIndex(0);
		btnGroupSexTTTS.clearSelection();
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.table.getModel();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String ngaySinh = df.format(ts.getNgaySinh());

		defaultTableModel.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(),
				ts.getQueQuan().getTenTinh() + "", ngaySinh, ts.isGioiTinh() == true ? "Nam" : "Nữ",
				ts.getDiemMon1() + "", ts.getDiemMon2() + "", ts.getDiemMon3() + "" });
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String ngaySinh = df.format(ts.getNgaySinh());

			defaultTableModel.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(),
					ts.getQueQuan().getTenTinh(), ngaySinh, ts.isGioiTinh() == true ? "Nam" : "Nữ",
					ts.getDiemMon1() + "", ts.getDiemMon2() + "", ts.getDiemMon3() });
		} else {
			this.model.update(ts);
			int soLuongDong = defaultTableModel.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = defaultTableModel.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
					String ngaySinh = df.format(ts.getNgaySinh());

					defaultTableModel.setValueAt(ts.getMaThiSinh() + "", i, 0);
					defaultTableModel.setValueAt(ts.getTenThiSinh(), i, 1);
					defaultTableModel.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					defaultTableModel.setValueAt(ngaySinh + "", i, 3);
					defaultTableModel.setValueAt(ts.isGioiTinh() ? "Nam" : "Nữ", i, 4);
					defaultTableModel.setValueAt(ts.getDiemMon1() + "", i, 5);
					defaultTableModel.setValueAt(ts.getDiemMon2() + "", i, 6);
					defaultTableModel.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public void hienThiThongTinThiSinhDaChon() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.table.getModel();
		int i_row = this.table.getSelectedRow();

		Integer maThiSinh = Integer.valueOf(defaultTableModel.getValueAt(i_row, 0) + "");
		String tenThiSinh = defaultTableModel.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(defaultTableModel.getValueAt(i_row, 2) + "");
		Date ngaySinh = new Date(defaultTableModel.getValueAt(i_row, 3) + "");
		boolean gioiTinh = defaultTableModel.getValueAt(i_row, 4).toString().equals("Nam");
		float diemMon1 = Float.valueOf(defaultTableModel.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(defaultTableModel.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(defaultTableModel.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.jTextField_MaThiSinh_TTTS.setText(maThiSinh + "");
		this.jTextField_TenThiSinh_TTTS.setText(tenThiSinh + "");
		this.jComboBox_QueQuan_TTTS.setSelectedItem(tinh.getTenTinh());

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		String ngaySinhHienThi = df.format(ngaySinh);
		this.jTextField_NgaySinh_TTTS.setText(ngaySinhHienThi);
		if (gioiTinh) {
			this.radioBtn_Nam_TTTS.setSelected(true);
		} else {
			this.radioBtn_Nu_TTTS.setSelected(true);
		}
		this.jTextField_Diem1_TTTS.setText(diemMon1 + "");
		this.jTextField_Diem2_TTTS.setText(diemMon2 + "");
		this.jTextField_Diem3_TTTS.setText(diemMon3 + "");

	}

	public ThiSinh getThiSinh(int i_row) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.table.getModel();

		Integer maThiSinh = Integer.valueOf(defaultTableModel.getValueAt(i_row, 0) + "");
		String tenThiSinh = defaultTableModel.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(defaultTableModel.getValueAt(i_row, 2) + "");
		Date ngaySinh = new Date(defaultTableModel.getValueAt(i_row, 3) + "");
		boolean gioiTinh = defaultTableModel.getValueAt(i_row, 4).toString().equals("Nam");
		float diemMon1 = Float.valueOf(defaultTableModel.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(defaultTableModel.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(defaultTableModel.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void thucHienXoaThiSinh() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.table.getModel();
		int i_row = this.table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = this.getThiSinh(i_row);
			defaultTableModel.removeRow(i_row);
			this.model.remove(ts);
		}
	}

	public void thucHienThem() {
		int maThiSinh = Integer.valueOf(this.jTextField_MaThiSinh_TTTS.getText());
		String tenThiSinh = this.jTextField_TenThiSinh_TTTS.getText();
		String queQuan = this.jComboBox_QueQuan_TTTS.getSelectedIndex() + "";
		Date ngaySinh = new Date(this.jTextField_NgaySinh_TTTS.getText());
		boolean gioiTinh = true;
		if (this.radioBtn_Nam_TTTS.isSelected()) {
			gioiTinh = true;
		} else {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.jTextField_Diem1_TTTS.getText());
		float diemMon2 = Float.valueOf(this.jTextField_Diem2_TTTS.getText());
		float diemMon3 = Float.valueOf(this.jTextField_Diem3_TTTS.getText());

		Tinh tinh = Tinh.getTinhById(Integer.valueOf(queQuan) - 1);

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTimKiem() {
		// Gọi hàm hủy tìm kiếm để refresh
		this.thucHienTaiLaiDuLieu();
		// Thực hiện tìm kiếm
		int queQuan = this.jComboBox_QueQuan.getSelectedIndex() - 1;
		String tenTS = this.jTextField_TenThiSinh.getText();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.table.getModel();
		int soLuongDong = defaultTableModel.getRowCount();

		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<>();

		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);

			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = defaultTableModel.getValueAt(i, 2) + "";
				String id = defaultTableModel.getValueAt(i, 0) + "";
				if (!tinhDaChon.getTenTinh().equals(tenTinh)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}

			}
		}
		if (!tenTS.equals("")) {
			for (int i = 0; i < soLuongDong; i++) {
				String tenThiSinhTrongTable = defaultTableModel.getValueAt(i, 1) + "";
				String id = defaultTableModel.getValueAt(i, 0) + "";
				if (tenThiSinhTrongTable.indexOf(tenTS) < 0) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer id : idCuaThiSinhCanXoa) {
			soLuongDong = defaultTableModel.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = defaultTableModel.getValueAt(i, 0) + "";
				if (idTrongTable.equals(id + "")) {
					try {
						defaultTableModel.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void xoaToanBoDuLieuTable() {
		while (true) {
			DefaultTableModel defaultTableModel = (DefaultTableModel) this.table.getModel();
			int soLuongDong = this.table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				try {
					defaultTableModel.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		this.xoaToanBoDuLieuTable();
		for (ThiSinh ts : this.model.getDsts()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAboutMe() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0");
	}

	public void thucHienThoatKhoiChuongTrinh() {
		int luachon = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn thoát khỏi chương trình?", "",
				JOptionPane.YES_NO_OPTION);
		if (luachon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void openFile(String path) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while ((ts = (ThiSinh) ois.readObject()) != null) {
				ds.add(ts);
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.model.setDsts(ds);
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String path = file.getAbsolutePath();
			this.openFile(path);
			thucHienTaiLaiDuLieu();
		}
	}

	public void saveFile(String fileName) {
		FileOutputStream fos;
		try {
			this.model.setTenFile(fileName);
			fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsts()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		JFileChooser fc = new JFileChooser();
		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

}
