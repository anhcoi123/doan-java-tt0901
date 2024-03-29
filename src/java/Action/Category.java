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
public class Category extends org.apache.struts.action.Action {

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
	String maloailk="";
	String title="";
	String sort="";
	String txtNoData="";
	ResultSet dt=null;
	HttpSession session=request.getSession();
	// nếu có sắp xếp
	if (request.getParameter("sortList")!=null && !request.getParameter("sortList").equals("default"))
	    sort=request.getParameter("sortList");
	
	// nếu có mã loại lk
	if (request.getParameter("maloailk")!=null)
            maloailk=request.getParameter("maloailk");
	session.setAttribute("maloailk", maloailk);
	// nếu có keyword tìm kiếm
        if (request.getParameter("keyword") != null && (!request.getParameter("keyword").equals("null") && !request.getParameter("keyword").equals("")))
        {
            if (maloailk.equals("0"))
                maloailk = "%";
            title = "Tìm kiếm";
            String keyword = request.getParameter("keyword");
	    session.setAttribute("keyword", keyword);
	    session.setAttribute("title", title);
	    if (sort.equals(""))
		dt = BO.BO_LoaiLK.DTSearchKeyWord(maloailk, keyword);
	    else
		dt = BO.BO_LoaiLK.DTSearchKeyWordSort(maloailk, keyword ,sort);
	    session.setAttribute("category", dt);
	    if (dt==null || !dt.next())
		txtNoData="Không tìm được sản phẩm nào có từ khóa như bạn nhập!";
		
        }
        else
        {
            title = BO.BO_LoaiLK.TenLoaiLK_MALOAILK(maloailk);
            if (title.equals("Không tìm thấy loại linh kiện"))
                txtNoData="Không tìm thấy loại linh kiện";
            else
            {
		session.setAttribute("title", title);
		if (sort.equals(""))
		    dt = BO.BO_LINHKIEN.DTTatCaLK_MaLoaiLK(maloailk);
		else
		    dt=BO.BO_LINHKIEN.DTTatCaLK_MaLoaiLKSort(maloailk,sort);
                session.setAttribute("category", dt);
                if (dt==null || !dt.next())
                    txtNoData="Không có sản phẩm nào thuộc loại này!";
            }
        }
	session.setAttribute("txtNoData",txtNoData);
	return mapping.findForward("category");
    }
}
