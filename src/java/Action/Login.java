/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import javax.jms.Session;
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
public class Login extends org.apache.struts.action.Action {

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
    
    private String success = "";
    private String redirect = "";
    private String errorTenDN="";
    private String errorMK="";
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String success = "";
	String redirect = "";
	String errorTenDN="";
	String errorMK="";
	HttpSession session=request.getSession();
	session.setAttribute("success", "");
	session.setAttribute("errorTenDN", errorTenDN);
	session.setAttribute("errorMK", errorMK);
	if (request.getParameter("logout") != null)
        {
            session.setAttribute("KhachHang",null);
        }
        if (session.getAttribute("KhachHang") != null)
            return mapping.findForward("home");
	
	// Xu ly login
	if (request.getParameter("method")!=null && request.getParameter("method").equals("login"))
	{
	    DTO.KhachHang kh=new DTO.KhachHang();
	    try
	    {
	    String txtTenDN=request.getParameter("txtTenDN");
	    String txtPassword=request.getParameter("txtPassword");
	    kh = BO.BO_KhachHang.KTraDangNhap(txtTenDN, txtPassword);
	    }catch(Exception ex){
		kh=null;
	    }
	    if (kh != null && !kh.getTenKH().equals(""))
	    {
		success = "Đăng nhập thành công";
		if (request.getParameter("view") != null)
		{
		    redirect = request.getParameter("view");
		}
		session.setAttribute("KhachHang",kh);
		session.setAttribute("success", success);
		if (redirect != "")
		{
		    return mapping.findForward(redirect);
		}
		else
		    return mapping.findForward("home");
	    }
	    else
		success = "Lỗi: Không thể đăng nhập vui lòng kiểm tra lại tên đăng nhập/mật khẩu";
	}
	session.setAttribute("success", success);
	return mapping.findForward("login");
    }
}
