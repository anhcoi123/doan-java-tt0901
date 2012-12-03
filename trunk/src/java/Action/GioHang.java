/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import java.text.*;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Lucifer
 */
public class GioHang extends DispatchAction {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "success";
    public DTO.GioHang gh = new DTO.GioHang();
    String malk = "";
    int SL=0;
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward delete(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
	response.setContentType("text");
	response.setCharacterEncoding("UTF-8");
	HttpSession Session=request.getSession();
	boolean exist = false;
	if (SL <= 0)
	{
	    Exception ex= new Exception("Số lượng phải là số dương");
	    throw ex;
	}
	int thanhtienLK = 0;
	for(Iterator<DTO.LinhKien> lks= gh.getLinhKien().iterator();lks.hasNext();)
	{
	    DTO.LinhKien lk=lks.next();
	    if (lk.getMaLK().equals(malk))
	    {
		gh.setThanhTien(gh.getThanhTien()- (lk.getSoLuong() * lk.getDonGia()));
		gh.getLinhKien().remove(lk);
		break;
	    }
	}
	NumberFormat nf = new DecimalFormat("###,###,##0");
	Session.setAttribute("GioHang", gh);
	String total = nf.format(gh.getThanhTien() * 1.1) + ",000 VNĐ";
	String vat = nf.format(gh.getThanhTien() * 0.1) + ",000 VNĐ";
	String subtotal = nf.format(gh.getThanhTien()) + ",000 VNĐ";
	response.getWriter().write(nf.format(thanhtienLK) + "|" + subtotal + "|" + vat + "|" + total + "|");//"<span style=\"color:green\">Đã thêm vào giỏ hàng</span>");
	return null;

    }
    public ActionForward deleteAll(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)
	throws Exception {

    response.setContentType("text");
    response.setCharacterEncoding("UTF-8");
    HttpSession session=request.getSession();
    session.setAttribute("GioHang",null);
    response.getWriter().write("Deleted");
    return null;

    }

    public ActionForward update(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
	response.setContentType("text");
	response.setCharacterEncoding("UTF-8");
	HttpSession Session=request.getSession();
	boolean exist = false;
	if (SL <= 0)
	{
	    Exception ex= new Exception("Số lượng phải là số dương");
	    throw ex;
	}
	int thanhtienLK = 0;
	for(Iterator<DTO.LinhKien> lks= gh.getLinhKien().iterator();lks.hasNext();)
	{
	    DTO.LinhKien lk=lks.next();
	    if (lk.getMaLK().equals(malk))
	    {
		gh.setThanhTien(gh.getThanhTien()-lk.getSoLuong() * lk.getDonGia());
		lk.setSoLuong(SL);
		gh.setThanhTien(gh.getThanhTien()+lk.getSoLuong() * lk.getDonGia());
		thanhtienLK = SL * lk.getDonGia();
		exist = true;
		break;
	    }
	    if (lk.getSoLuong() <= 0)
	    {
	        gh.getLinhKien().remove(lk);
	        break;
	    }
	}
	if (!exist)
	{
	    DTO.LinhKien lk = BO.BO_LINHKIEN.searchLK(request.getParameter("MALK"));
	    lk.setSoLuong(SL);
	    gh.getLinhKien().add(lk);
	    gh.setThanhTien(gh.getThanhTien() + lk.getDonGia()*SL);
	    thanhtienLK = lk.getDonGia();
	}
	NumberFormat nf = new DecimalFormat("###,###,##0");
	Session.setAttribute("GioHang", gh);
	String total = nf.format(gh.getThanhTien() * 1.1) + ",000 VNĐ";
	String vat = nf.format(gh.getThanhTien() * 0.1) + ",000 VNĐ";
	String subtotal = nf.format(gh.getThanhTien()) + ",000 VNĐ";
	response.getWriter().write(nf.format(thanhtienLK) + "|" + subtotal + "|" + vat + "|" + total + "|");//"<span style=\"color:green\">Đã thêm vào giỏ hàng</span>");
	return null;
    }
    public ActionForward add(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
	response.setContentType("text");
	response.setCharacterEncoding("UTF-8");
	HttpSession Session=request.getSession();
	
	boolean exist = false;
	if (SL <= 0)
	{
	    Exception ex= new Exception("Số lượng phải là số dương");
	    throw ex;
	}
	int thanhtienLK = 0;
	for(Iterator<DTO.LinhKien> lks= gh.getLinhKien().iterator();lks.hasNext();)
	{
	    DTO.LinhKien lk=lks.next();
	    if (lk.getMaLK().equals(malk))
	    {
		gh.setThanhTien(gh.getThanhTien()-lk.getSoLuong() * lk.getDonGia());
		lk.setSoLuong(lk.getSoLuong()+SL);
		gh.setThanhTien(gh.getThanhTien()+lk.getSoLuong() * lk.getDonGia());
		thanhtienLK = SL * lk.getDonGia();
		exist = true;
		break;
	    }
	    if (lk.getSoLuong() <= 0)
	    {
	        gh.getLinhKien().remove(lk);
	        break;
	    }
	    
	}

	if (!exist)
	{
	    DTO.LinhKien lk = BO.BO_LINHKIEN.searchLK(request.getParameter("MALK"));
	    lk.setSoLuong(SL);
	    gh.getLinhKien().add(lk);
	    gh.setThanhTien(gh.getThanhTien() + lk.getDonGia()*SL);
	    thanhtienLK = lk.getDonGia();
	}
	NumberFormat nf = new DecimalFormat("###,###,##0");
	Session.setAttribute("GioHang", gh);
	String total = nf.format(gh.getThanhTien() * 1.1) + ",000 VNĐ";
	String vat = nf.format(gh.getThanhTien() * 0.1) + ",000 VNĐ";
	String subtotal = nf.format(gh.getThanhTien()) + ",000 VNĐ";
	response.getWriter().write(nf.format(thanhtienLK) + "|" + subtotal + "|" + vat + "|" + total + "|");//"<span style=\"color:green\">Đã thêm vào giỏ hàng</span>");
	return null;
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception{
	if (request.getParameter("method")!=null)
	{
	    HttpSession Session=request.getSession();
	    if (request.getParameter("MALK")!=null)
		malk=request.getParameter("MALK");
	    if (Session.getAttribute("GioHang") == null)
		Session.setAttribute("GioHang",new DTO.GioHang());
	    gh = (DTO.GioHang)Session.getAttribute("GioHang");
	    if (request.getParameter("SoLuong")!=null)
		SL = Integer.parseInt(request.getParameter("SoLuong")); // Lấy số lượng
	    // Dieu huong
	    if (request.getParameter("method").toLowerCase().equals("add"))
		return add(mapping, form, request, response);
    	    if (request.getParameter("method").toLowerCase().equals("update"))
		return update(mapping, form, request, response);
	    if (request.getParameter("method").toLowerCase().equals("delete"))
		return delete(mapping, form, request, response);
	    if (request.getParameter("method").toLowerCase().equals("deleteAll"))
		return deleteAll(mapping, form, request, response);
	    return mapping.findForward("giohang");
	}
	return mapping.findForward("giohang");
    }
}
