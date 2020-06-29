package com.example.reporthci.model;

public class Device {

    private String tenThietBi;
    private String loaiThietBi;
    private String duongDay;
    private String viTri;
    private String anhTB;

    public Device(String tenThietBi, String loaiThietBi, String duongDay, String viTri, String anhTB) {
        this.tenThietBi = tenThietBi;
        this.loaiThietBi = loaiThietBi;
        this.duongDay = duongDay;
        this.viTri = viTri;
        this.anhTB = anhTB;
    }

    public Device(String tenThietBi, String loaiThietBi, String duongDay, String viTri) {
        this.tenThietBi = tenThietBi;
        this.loaiThietBi = loaiThietBi;
        this.duongDay = duongDay;
        this.viTri = viTri;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getLoaiThietBi() {
        return loaiThietBi;
    }

    public void setLoaiThietBi(String loaiThietBi) {
        this.loaiThietBi = loaiThietBi;
    }

    public String getDuongDay() {
        return duongDay;
    }

    public void setDuongDay(String duongDay) {
        this.duongDay = duongDay;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getAnhTB() {
        return anhTB;
    }

    public void setAnhTB(String anhTB) {
        this.anhTB = anhTB;
    }
}
