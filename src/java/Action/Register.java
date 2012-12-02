/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import javax.servlet.FilterChain;
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
public class Register extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "success";
    public String message = "";
    public String errorNhaplaiMK = "";
    public String errorMK = "";
    public String errorCMND = "";
    public String errorDC="", errorTenKH="", errorTenDN = "";
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
        boolean err = false;
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	HttpSession session=request.getSession();
	
	String txtCMND="",txtPass="",txtConfirmPass="",txtDiaChi="",txtTenDN="",txtTenKH="",txtSoDT="";
	if (request.getParameter("txtCMND")!=null)
	    txtCMND=request.getParameter("txtCMND");
	if (request.getParameter("txtPass")!=null)
	    txtPass=request.getParameter("txtPass");
	if (request.getParameter("txtConfirmPass")!=null)
	    txtConfirmPass=request.getParameter("txtConfirmPass");
	if (request.getParameter("txtDiaChi")!=null)
	    txtDiaChi=request.getParameter("txtDiaChi");
	if (request.getParameter("txtTenDN")!=null)
	    txtTenDN=request.getParameter("txtTenDN");
	if (request.getParameter("txtTenKH")!=null)
	    txtTenKH=request.getParameter("txtTenKH");
	if (request.getParameter("txtSoDT")!=null)
	    txtSoDT=request.getParameter("txtSoDT");
	
	
        if (txtCMND.equals(""))
        {
            errorCMND = "Vui lòng nhập CMND";
            err = true;
        }
        if (txtPass.equals(""))
        {
            errorMK = "Vui lòng nhập mật khẩu";
            err = true;
        }
        else
            if (!txtPass.equals(txtConfirmPass))
            {
                errorNhaplaiMK = "Mật khẩu không khớp";
                err = true;
            }
        if (txtDiaChi.equals(""))
        {
            errorDC = "Vui lòng nhập địa chỉ";
            err = true;
        }
        if (txtTenDN.equals(""))
        {
            errorTenDN = "Vui lòng chọn tên đăng nhập";
            err = true;
        }
        if (txtTenKH.equals(""))
        {
            errorTenKH = "Vui lòng cho biết tên của bạn";
            err = true;
        }
        if (err)
        {
            message = "Vui lòng kiểm tra thông tin đã nhập";
	    session.setAttribute("errorNhaplaiMK", errorNhaplaiMK);
	    session.setAttribute("errorMK", errorMK);
	    session.setAttribute("errorCMND", errorCMND);
	    session.setAttribute("errorDC", errorDC);
	    session.setAttribute("errorTenKH", errorTenKH);
	    session.setAttribute("errorTenDN", errorTenDN);
	    session.setAttribute("message", message);
            err = false;
        }
        else
        {
            message = BO.BO_KhachHang.ThemKH(txtTenKH, txtTenDN, txtPass, txtDiaChi, txtSoDT, txtCMND);
    	    session.setAttribute("errorNhaplaiMK", errorNhaplaiMK);
	    session.setAttribute("errorMK", errorMK);
	    session.setAttribute("errorCMND", errorCMND);
	    session.setAttribute("errorDC", errorDC);
	    session.setAttribute("errorTenKH", errorTenKH);
	    session.setAttribute("errorTenDN", errorTenDN);
	    session.setAttribute("message", message);

            if (message.toLowerCase().contains("thành công"))
            {
                session.setAttribute("KhachHang",BO.BO_KhachHang.KTraDangNhap(txtTenDN, txtPass));
                return mapping.findForward("home");
            }
        }
	
	return mapping.findForward("register");
    }
}
