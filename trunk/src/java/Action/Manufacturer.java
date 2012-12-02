/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import java.sql.ResultSet;
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
public class Manufacturer extends org.apache.struts.action.Action {

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
	String mansx="";
	String title="";
	String sort="";
	String txtNoData="";
	ResultSet dt=null;
	HttpSession session=request.getSession();
	// nếu có sắp xếp
	if (request.getParameter("sortList")!=null && !request.getParameter("sortList").equals("default"))
	    sort=request.getParameter("sortList");
	
	// nếu có mã loại lk
	if (request.getParameter("mansx")!=null)
            mansx=request.getParameter("mansx");
	session.setAttribute("mansx", mansx);
	title = BO.BO_NhaSX.TenNhaSX(mansx);
	if (title.equals("Không tìm thấy nhà sản xuất"))
	    txtNoData="Không tìm thấy nhà sản xuất";
	else
	{
	    session.setAttribute("title", title);
	    if (sort.equals(""))
		dt = BO.BO_LINHKIEN.SearchLK_TENNSX(title);
	    else
		dt=BO.BO_LINHKIEN.SearchLK_TENNSXSort(title,sort);
	    session.setAttribute("manufacturer", dt);
	    if (dt==null || !dt.next())
		txtNoData="Không có sản phẩm nào của nhà sản xuất này!";
	}

	session.setAttribute("txtNoData",txtNoData);
	return mapping.findForward("manufacturer");
    }
}
