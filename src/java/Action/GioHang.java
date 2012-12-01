/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	response.getWriter().write("Deleted");
	return null;

    }
    public ActionForward deleteAll(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)
	throws Exception {

    response.setContentType("text");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("Deleted");
    return null;

    }

    public ActionForward update(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
	response.setContentType("text");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write("Updated");
	return null;
    }
    public ActionForward add(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
	response.setContentType("text");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write("Added");
	return null;
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception{
	if (request.getParameter("method")!=null)
	{
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
