//https://yellowcodebooks.com/2017/06/14/java-bai-21-ke-thua-lam-quen-voi-ke-thua/#.ZDzB9exBxTa
package main;

import shapes.HinhChuNhat;
import shapes.HinhTron;
import shapes.HinhTru;
import shapes.HinhVuong;

public class MainClass {
	public static void main(String[] args) {
		// Thử nghiệm với lớp Hình tròn
		HinhTron hinhTron = new HinhTron();
		hinhTron.xuatTen();
		hinhTron.nhapBanKinh();
		hinhTron.tinhChuVi();
		hinhTron.tinhDienTich();
		hinhTron.inChuVi();
		hinhTron.inDienTich();

		// Thử nghiệm với lớp Hình trụ
		HinhTru hinhTru = new HinhTru();
		hinhTru.xuatTen();
		hinhTru.nhapChieuCao();
		hinhTru.tinhTheTich();
		hinhTru.inTheTich();

		// Thử nghiệm với lớp Hình chữ nhật
		HinhChuNhat hinhChuNhat = new HinhChuNhat();
		hinhChuNhat.xuatTen();
		hinhChuNhat.nhapChieuDai();
		hinhChuNhat.nhapChieuRong();
		hinhChuNhat.tinhChuVi();
		hinhChuNhat.tinhDienTich();
		hinhChuNhat.inChuVi();
		hinhChuNhat.inDienTich();

		// Thử nghiệm với lớp Hình vuông
		HinhVuong hinhVuong = new HinhVuong();
		hinhVuong.xuatTen();
		hinhVuong.nhapCanh();
		hinhVuong.tinhChuVi();
		hinhVuong.tinhDienTich();
		hinhVuong.inChuVi();
		hinhVuong.inDienTich();
	}
}