/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Lucifer
 */
public class ThanhToan extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "success";

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
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String success="";
	HttpSession Session=request.getSession();
	if (Session.getAttribute("KhachHang") == null)
	{
            response.sendRedirect("./Login.do?view=thanhtoan");
	    return null;
	}
        if (Session.getAttribute("GioHang") == null)
            return mapping.findForward("home");
	if (request.getParameter("ConfirmThanhToan")!=null && request.getParameter("ConfirmThanhToan").equals("done"))
	{
	    DTO.GioHang gh=(DTO.GioHang)Session.getAttribute("GioHang");
	    DTO.KhachHang kh=(DTO.KhachHang)Session.getAttribute("KhachHang");
	    if (BO.BO_DONDH.ThemGioHangVaoDonDH(gh, kh.getMaKH()).contains("thành công"))
	    {
		success = "Đã đặt mua hàng thành công! Cảm ơn bạn đã mua hàng của chúng tôi";
		Session.setAttribute("success",success);
		Session.setAttribute("GioHang",null);
		return mapping.findForward("home");
	    }
	    else
	    {
		success = "Lỗi: Không thể Đặt mua hàng";
		Session.setAttribute("success",success);
	    }
	}
	return mapping.findForward("thanhtoan");
    }
}
