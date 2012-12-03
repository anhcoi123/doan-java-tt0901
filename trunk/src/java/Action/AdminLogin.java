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
public class AdminLogin extends org.apache.struts.action.Action {

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
	HttpSession Session=request.getSession();
        if (request.getParameter("logout") != null)
        {
            Session.setAttribute("admin",null);
            return mapping.findForward("AdminMaster");
        }
        if (Session.getAttribute("admin") != null)
        {
            return mapping.findForward("adminpage");
        }
	
	if (request.getParameter("txtID")!=null && request.getParameter("txtPass")!=null)
	{
	    String txtID=request.getParameter("txtID");
	    String txtPass=request.getParameter("txtPass");
	    String lblError="";
	    if (BO.BO_ADMIN.KiemTraDN(txtID, txtPass))
	    {
		Session.setAttribute("admin","true");
		return mapping.findForward("adminpage");

	    }
	    else
	    {
		lblError = "Mật khẩu hoặc tài khoản không đúng";
	    }
	    Session.setAttribute("lblError", lblError);
	}
	return mapping.findForward("AdminMaster");
    }
}
