package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.QLSVView;

public class QLTSController implements ActionListener {
	private QLSVView qltsView;

	public QLTSController(QLSVView qltsView) {
		this.qltsView = qltsView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		if (command.equals("Thêm")) {
			this.qltsView.xoaForm();
			this.qltsView.model.setLuachon(command);
		} else if (command.equals("Lưu")) {
			try {
				this.qltsView.thucHienThem();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (command.equals("Cập nhật")) {
			this.qltsView.hienThiThongTinThiSinhDaChon();
		} else if (command.equals("Xóa")) {
			this.qltsView.thucHienXoaThiSinh();
		} else if (command.equals("Hủy bỏ")) {
			this.qltsView.xoaForm();
		} else if (command.equals("Tìm")) {
			this.qltsView.thucHienTimKiem();
		} else if (command.equals("Hủy")) {
			this.qltsView.thucHienTaiLaiDuLieu();
		} else if (command.equals("About me")) {
			this.qltsView.hienThiAboutMe();
		} else if (command.equals("Exit")) {
			this.qltsView.thucHienThoatKhoiChuongTrinh();
		} else if (command.equals("Open")) {
			this.qltsView.thucHienOpenFile();
		} else if (command.equals("Save")) {
			this.qltsView.thucHienSaveFile();
		}
	}

}
