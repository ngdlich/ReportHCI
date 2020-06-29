package com.example.reporthci.model;

public class Report {

    private String tenBaoCao;
    private String thoiGian;
    private String duongDay;
    private String viTri;

    public Report(String tenBaoCao, String thoiGian, String duongDay, String viTri) {
        this.tenBaoCao = tenBaoCao;
        this.thoiGian = thoiGian;
        this.duongDay = duongDay;
        this.viTri = viTri;
    }

    public String getTenBaoCao() {
        return tenBaoCao;
    }

    public void setTenBaoCao(String tenBaoCao) {
        this.tenBaoCao = tenBaoCao;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
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
}
