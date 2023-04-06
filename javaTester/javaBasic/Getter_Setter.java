package javaBasic;

public class Getter_Setter {
	public class HinhTron {
		private final float PI = 3.14f;
		private float banKinh;
		private float chuVi;
		private float dienTich;

		// Constructor
		public HinhTron(float banKinh) {
			this.banKinh = banKinh;
		}

		public void tinhChuVi() {
			chuVi = 2 * PI * banKinh;
		}

		public void tinhDienTich() {
			dienTich = PI * banKinh * banKinh;
		}
	}

}
