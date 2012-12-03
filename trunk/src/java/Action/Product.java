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
public class Product extends org.apache.struts.action.Action {

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
	HttpSession session=request.getSession();
	String title = "";
	String txtNoData="";
	DTO.LinhKien lk = new DTO.LinhKien();
	DTO.NhaSX nhasx = new DTO.NhaSX();
	String id = "";
        if (request.getParameter("id") != null)
            id = request.getParameter("id");
        lk = BO.BO_LINHKIEN.searchLK(id);
        if (lk.getMaLK().equals(""))
        {
            txtNoData= "Không có sản phẩm này!";
            title = "Không có sản phẩm này!";
        }
        else
        {
            title = lk.getTenLK();
            String mansx = lk.getMansx();
            nhasx = BO.BO_NhaSX.NhaSX(mansx);
        }
	session.setAttribute("lk", lk);
	session.setAttribute("nhasx", nhasx);
	session.setAttribute("title", title);
	session.setAttribute("txtNoData", txtNoData);
	return mapping.findForward("product");
    }
}
