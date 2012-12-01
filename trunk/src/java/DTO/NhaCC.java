/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import com.sun.faces.facelets.tag.jstl.core.ForEachHandler;

/**
 *
 * @author Khoadd
 */
public class NhaCC {
    private String _maNCC;
    private String _tenNCC;
    private String _diaChi;
    private String _soDT;

    public String getMaNCC() {
        return _maNCC;
    }

    public void setMaNCC(String _maNCC) {
        this._maNCC = _maNCC;
    }

    public String getTenNCC() {
        return _tenNCC;
    }

    public void setTenNCC(String _tenNCC) {
        this._tenNCC = _tenNCC;
    }

    public String getDiaChi() {
        return _diaChi;
    }

    public void setDiaChi(String _diaChi) {
        this._diaChi = _diaChi;
    }

    public String getSoDT() {
        return _soDT;
    }

    public void setSoDT(String _soDT) {
        this._soDT = _soDT;
    }
    
}
