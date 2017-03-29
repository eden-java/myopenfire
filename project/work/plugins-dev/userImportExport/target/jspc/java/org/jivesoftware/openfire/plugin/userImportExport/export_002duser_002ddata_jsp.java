/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat8
 * Generated at: 2017-03-12 07:54:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.jivesoftware.openfire.plugin.userImportExport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.util.*;
import org.jivesoftware.openfire.plugin.ImportExportPlugin;
import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.util.ParamUtils;

public final class export_002duser_002ddata_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n");

    boolean exportUsers = request.getParameter("exportUsers") != null;
    boolean success = request.getParameter("success") != null;
    boolean exportToFile = ParamUtils.getBooleanParameter(request, "exporttofile", true);
    boolean xep227Support = ParamUtils.getBooleanParameter(request, "xep227support", false);
    
    ImportExportPlugin plugin = (ImportExportPlugin)XMPPServer.getInstance().getPluginManager(
            ).getPlugin("userimportexport");

    String exportText = "";
    
    Map<String, String> errors = new HashMap<String, String>();
    if (exportUsers) {
        if (exportToFile) {
            String file = ParamUtils.getParameter(request, "exportFile");
            if ((file == null) || (file.length() <= 0)) {
                errors.put("missingFile","missingFile");
            }
            else {
                response.sendRedirect("export-file.jsp?fileName="+file + ( xep227Support ? "&xep227support=true" : ""));
            }
        }
        else {
            try {
                exportText = plugin.exportUsersToString(xep227Support);
            }
            catch (IOException e) {
                errors.put("IOException","IOException");
            }
        }
    }

      out.write("\r\n\r\n<html>\r\n    <head>\r\n        <title>Export User Data</title>\r\n        <meta name=\"pageID\" content=\"import-export-selection\"/>\r\n    </head>\r\n    <body>\r\n\r\n");
 if (errors.size() > 0) { 
      out.write("\r\n\r\n    <div class=\"jive-error\">\r\n    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n    <tbody>\r\n        <tr>\r\n            <td class=\"jive-icon\"><img src=\"images/error-16x16.gif\" width=\"16\" height=\"16\" border=\"0\"></td>\r\n            <td class=\"jive-icon-label\">\r\n            ");
 if (errors.containsKey("missingFile")) { 
      out.write("\r\n                Missing or bad file name.\r\n            ");
 } else if (errors.containsKey("IOException") || errors.containsKey("fileNotCreated")) { 
      out.write("\r\n                Couldn't create export file.\r\n            ");
 } 
      out.write("\r\n            </td>\r\n        </tr>\r\n    </tbody>\r\n    </table>\r\n    </div>\r\n    <br>\r\n\r\n");
 } else if (ParamUtils.getBooleanParameter(request, "success")) { 
      out.write("\r\n\r\n    <div class=\"jive-success\">\r\n    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n    <tbody>\r\n        <tr>\r\n            <td class=\"jive-icon\"><img src=\"images/success-16x16.gif\" width=\"16\" height=\"16\" border=\"0\"></td>\r\n            <td class=\"jive-icon-label\">User data successfully exported.</td>\r\n        </tr>\r\n    </tbody>\r\n    </table>\r\n    </div>\r\n    <br>\r\n    \r\n");
 } 
      out.write("\r\n\r\n<form action=\"export-user-data.jsp?exportUsers\" method=\"post\">\r\n\r\n<div class=\"jive-contentBoxHeader\">Export Options</div>\r\n<div class=\"jive-contentBox\">\r\n    <p>\r\n    Select the radio button next to the desired export option and then click on the Export button.\r\n    </p>\r\n    \r\n    <table cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"100%\">\r\n    <tbody>\r\n        <tr>\r\n            <td width=\"1%\"><input type=\"radio\" name=\"exporttofile\" value=\"true\" ");
      out.print( exportToFile ? "checked" : "" );
      out.write(" id=\"rb01\"/></td>\r\n            <td width=\"99%\"><label for=\"rb01\"><b>To File</b></label> - Save user data to the specified file location.</td>\r\n        </tr>\r\n        <tr>\r\n            <td width=\"1%\">&nbsp;</td>\r\n            <td width=\"99%\">Export File Name:&nbsp;<input type=\"text\" size=\"30\" maxlength=\"150\" name=\"exportFile\"></td>\r\n        </tr>\r\n        <tr>\r\n            <td width=\"1%\"><input type=\"radio\" name=\"exporttofile\" value=\"false\" ");
      out.print( !exportToFile ? "checked" : "" );
      out.write(" id=\"rb02\"/></td>\r\n            <td width=\"99%\"><label for=\"rb02\"><b>To Screen</b></label> - Display user data in the text area below.</td>            \r\n        </tr>\r\n        <tr>\r\n            <td width=\"1%\">&nbsp;</td>\r\n            <td width=\"99%\"><textarea cols=\"80\" rows=\"20\" wrap=off>");
      out.print(exportText );
      out.write("</textarea></td>\r\n        </tr>\r\n         <tr>\r\n            <td width=\"1%\"><input type=\"checkbox\" name=\"xep227support\" ");
      out.print( xep227Support ? "checked" : "" );
      out.write(" id=\"rb03\"/></td>\r\n            <td width=\"99%\"><label for=\"rb03\"><b>XEP-0227</b></label> - Export using format defined in <a href=\"http://www.xmpp.org/extensions/xep-0227.html\" target=\"_blank\">XEP-0227</a>.</td>\r\n        </tr>\r\n    </tbody>\r\n    </table>\r\n</div>\r\n\r\n<input type=\"submit\" value=\"Export\">\r\n</form>\r\n\r\n</body>\r\n</html>");
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
}
