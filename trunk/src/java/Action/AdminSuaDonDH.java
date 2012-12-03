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
public class AdminSuaDonDH extends org.apache.struts.action.Action {

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
	if (request.getParameter("madh")!=null && request.getParameter("tinhtrang")!=null)
	{
	    BO.BO_DONDH.UpdateDonDH(request.getParameter("madh"),request.getParameter("tinhtrang"));
	}
	HttpSession Session=request.getSession();
	DTO.DonDH dondh=new DTO.DonDH();
	dondh=BO.BO_DONDH.DonDH(request.getParameter("madh"));
	Session.setAttribute("MADH", dondh.getMaDH());
	Session.setAttribute("MAKH", dondh.getMaKH());
	Session.setAttribute("NGAYDH", dondh.getNgayDH());
	Session.setAttribute("THANHTIEN", dondh.getThanhTien());
	Session.setAttribute("TINHTRANG", dondh.getTinhtrang());
	return mapping.findForward("adminDonDH");
    }
}
