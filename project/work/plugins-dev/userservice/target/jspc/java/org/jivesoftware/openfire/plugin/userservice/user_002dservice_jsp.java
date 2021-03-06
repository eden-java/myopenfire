/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat8
 * Generated at: 2017-03-12 07:55:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.jivesoftware.openfire.plugin.userservice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.util.*;
import org.jivesoftware.openfire.plugin.UserServicePlugin;

public final class user_002dservice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/java_project/company/openfire_src_4_1_3/build/lib/merge/org.apache.taglibs.taglibs-standard-impl.jar!/META-INF/c.tld", Long.valueOf(1384339662000L));
    _jspx_dependants.put("jar:file:/D:/java_project/company/openfire_src_4_1_3/build/lib/merge/org.apache.taglibs.taglibs-standard-impl.jar!/META-INF/fmt.tld", Long.valueOf(1384339662000L));
    _jspx_dependants.put("file:/D:/java_project/company/openfire_src_4_1_3/build/lib/merge/org.apache.taglibs.taglibs-standard-impl.jar", Long.valueOf(1487939628000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');
      org.jivesoftware.util.WebManager admin = null;
      admin = (org.jivesoftware.util.WebManager) _jspx_page_context.getAttribute("admin", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (admin == null){
        admin = new org.jivesoftware.util.WebManager();
        _jspx_page_context.setAttribute("admin", admin, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
 admin.init(request, response, session, application, out ); 
      out.write("\r\n\r\n");
  // Get parameters
    boolean save = request.getParameter("save") != null;
    boolean success = request.getParameter("success") != null;
    String secret = ParamUtils.getParameter(request, "secret");
    boolean enabled = ParamUtils.getBooleanParameter(request, "enabled");
    boolean httpBasicAuth = ParamUtils.getBooleanParameter(request, "authtype");
    String allowedIPs = ParamUtils.getParameter(request, "allowedIPs");

    UserServicePlugin plugin = (UserServicePlugin) XMPPServer.getInstance().getPluginManager().getPlugin("userservice");

    // Handle a save
    Map errors = new HashMap();
    if (save) {
        if (errors.size() == 0) {
            plugin.setEnabled(enabled);
        	plugin.setSecret(secret);
        	plugin.setHttpBasicAuth(httpBasicAuth);
            plugin.setAllowedIPs(StringUtils.stringToCollection(allowedIPs));
            response.sendRedirect("user-service.jsp?success=true");
            return;
        }
    }

    secret = plugin.getSecret();
    enabled = plugin.isEnabled();
    httpBasicAuth = plugin.isHttpBasicAuth();
    allowedIPs = StringUtils.collectionToString(plugin.getAllowedIPs());

      out.write("\r\n\r\n<html>\r\n    <head>\r\n        <title>User Service Properties</title>\r\n        <meta name=\"pageID\" content=\"user-service\"/>\r\n    </head>\r\n    <body>\r\n\r\n\r\n<p>\r\nUse the form below to enable or disable the User Service and configure the secret key or HTTP basic auth.\r\nBy default the User Service plugin is <strong>disabled</strong>, which means that\r\nHTTP requests to the service will be ignored.\r\n</p>\r\n\r\n");
  if (success) { 
      out.write("\r\n\r\n    <div class=\"jive-success\">\r\n    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n    <tbody>\r\n        <tr><td class=\"jive-icon\"><img src=\"images/success-16x16.gif\" width=\"16\" height=\"16\" border=\"0\"></td>\r\n        <td class=\"jive-icon-label\">\r\n            User service properties edited successfully.\r\n        </td></tr>\r\n    </tbody>\r\n    </table>\r\n    </div><br>\r\n");
 } 
      out.write("\r\n\r\n<form action=\"user-service.jsp?save\" method=\"post\">\r\n\r\n<fieldset>\r\n    <legend>User Service</legend>\r\n    <div>\r\n    <p>\r\n    The addition, deletion and editing of users is not normally available outside of the admin console.\r\n    This service lets those administration tasks be performed HTTP requests to provide\r\n    simple integration with other applications.</p>\r\n\r\n    <p>However, the presence of this service exposes a security risk. Therefore,\r\n    a secret key is used to validate legitimate requests to this service. \r\n    Another validation could be done over the HTTP basic authentication. Moreover,\r\n    for extra security you can specify the list of IP addresses that are allowed to\r\n    use this service. An empty list means that the service can be accessed from any\r\n    location. Addresses are delimited by commas.\r\n    </p>\r\n    <ul>\r\n        <input type=\"radio\" name=\"enabled\" value=\"true\" id=\"rb01\"\r\n        ");
      out.print( ((enabled) ? "checked" : "") );
      out.write(">\r\n        <label for=\"rb01\"><b>Enabled</b> - User service requests will be processed.</label>\r\n        <br>\r\n        <input type=\"radio\" name=\"enabled\" value=\"false\" id=\"rb02\"\r\n        ");
      out.print( ((!enabled) ? "checked" : "") );
      out.write(">\r\n        <label for=\"rb02\"><b>Disabled</b> - User service requests will be ignored.</label>\r\n        <br><br>\r\n\r\n        <input type=\"radio\" name=\"authtype\" value=\"true\" id=\"http_basic_auth\"  ");
      out.print( ((httpBasicAuth) ? "checked" : "") );
      out.write(">\r\n        <label for=\"http_basic_auth\">HTTP basic auth - User service REST authentication with Openfire admin account.</label>\r\n        <br>\r\n        <input type=\"radio\" name=\"authtype\" value=\"false\" id=\"secretKeyAuth\"  ");
      out.print( ((!httpBasicAuth) ? "checked" : "") );
      out.write(">\r\n        <label for=\"secretKeyAuth\">Secret key auth - User service REST authentication over specified secret key.</label>\r\n        <br>\r\n        <label style=\"padding-left: 25px\" for=\"text_secret\">Secret key:</label>\r\n        <input type=\"text\" name=\"secret\" value=\"");
      out.print( secret );
      out.write("\" id=\"text_secret\">\r\n        <br><br>\r\n\r\n        <label for=\"text_secret\">Allowed IP Addresses:</label>\r\n        <textarea name=\"allowedIPs\" cols=\"40\" rows=\"3\" wrap=\"virtual\">");
      out.print( ((allowedIPs != null) ? allowedIPs : "") );
      out.write("</textarea>\r\n    </ul>\r\n    </div>\r\n</fieldset>\r\n\r\n<br><br>\r\n\r\n<input type=\"submit\" value=\"Save Settings\">\r\n</form>\r\n\r\n\r\n</body>\r\n</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /user-service.jsp(12,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("admin");
    // /user-service.jsp(12,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/user-service.jsp(12,0) '${admin.manager}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${admin.manager}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
