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
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Lucifer
 */
public class AdminDonDH extends org.apache.struts.actions.DispatchAction {

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
    public ActionForward sua(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	HttpSession Session=request.getSession();
	Session.setAttribute("madhAdmin", request.getParameter("madh"));
	DTO.DonDH dondh=new DTO.DonDH();
	if (request.getParameter("madh")!=null)
	    dondh=BO.BO_DONDH.DonDH(request.getParameter("madh"));
	if (Session.getAttribute("madhAdmin")!=null)
	    dondh=BO.BO_DONDH.DonDH(Session.getAttribute("madhAdmin").toString());
	Session.setAttribute("MADH", dondh.getMaDH());
	Session.setAttribute("MAKH", dondh.getMaKH());
	Session.setAttribute("NGAYDH", dondh.getNgayDH());
	Session.setAttribute("THANHTIEN", dondh.getThanhTien());
	Session.setAttribute("TINHTRANG", dondh.getTinhtrang());
	return mapping.findForward("adminSuaDonDH");
    }
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	HttpSession session=request.getSession();
	if (session.getAttribute("admin")==null)
	    return mapping.findForward("AdminMaster");
	if (request.getParameter("method")!=null && request.getParameter("method").equals("sua"))
	    return sua(mapping, form, request, response);
	else
	    return mapping.findForward("adminDonDH");
    }
}
