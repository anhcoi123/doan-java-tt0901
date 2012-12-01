/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author Lucifer
 */
public class GioHang
{
        private ArrayList<LinhKien> _linhKien = new ArrayList<LinhKien>();

        private int _thanhTien = 0;

    /**
     * @return the _linhKien
     */
    public ArrayList<LinhKien> getLinhKien() {
	return _linhKien;
    }

    /**
     * @param linhKien the _linhKien to set
     */
    public void setLinhKien(ArrayList<LinhKien> linhKien) {
	this._linhKien = linhKien;
    }

    /**
     * @return the _thanhTien
     */
    public int getThanhTien() {
	return _thanhTien;
    }

    /**
     * @param thanhTien the _thanhTien to set
     */
    public void setThanhTien(int thanhTien) {
	this._thanhTien = thanhTien;
    }
}
