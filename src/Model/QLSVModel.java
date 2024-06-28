package Model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsts;
	private String luachon;
	private String tenFile;

	public QLSVModel() {
		this.dsts = new ArrayList<ThiSinh>();
		this.luachon = "";
		this.tenFile = "";
	}

	public QLSVModel(ArrayList<ThiSinh> dsts) {
		this.dsts = dsts;
	}

	public ArrayList<ThiSinh> getDsts() {
		return dsts;
	}

	public void setDsts(ArrayList<ThiSinh> dsts) {
		this.dsts = dsts;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void insert(ThiSinh ts) {
		this.dsts.add(ts);
	}

	public void remove(ThiSinh ts) {
		for (ThiSinh thiSinh : this.dsts) {
			if (thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
				this.dsts.remove(thiSinh);
			}
		}
	}

	public void update(ThiSinh ts) {
		this.dsts.remove(ts);
		this.dsts.add(ts);
	}

	public String getLuachon() {
		return luachon;
	}

	public void setLuachon(String luachon) {
		this.luachon = luachon;
	}

	public boolean kiemTraTonTai(ThiSinh ts) {
		for (ThiSinh thiSinh : this.dsts) {
			if (thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
				return true;
			}
		}
		return false;
	}

}
