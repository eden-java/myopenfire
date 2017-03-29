/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat8
 * Generated at: 2017-03-12 07:54:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.jivesoftware.openfire.plugin.packetFilter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.jivesoftware.openfire.plugin.PacketFilterUtil;
import org.jivesoftware.openfire.component.InternalComponentManager;
import org.jivesoftware.openfire.plugin.component.ComponentList;
import org.jivesoftware.openfire.plugin.rules.Rule;
import org.jivesoftware.openfire.plugin.rules.RuleManager;
import org.jivesoftware.openfire.plugin.rules.RuleManagerProxy;
import org.xmpp.packet.JID;
import java.util.List;

public final class pf_002dmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.release();
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

      out.write("\n\n\n\n\n\n\n\n\n");
      org.jivesoftware.util.WebManager webManager = null;
      webManager = (org.jivesoftware.util.WebManager) _jspx_page_context.getAttribute("webManager", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (webManager == null){
        webManager = new org.jivesoftware.util.WebManager();
        _jspx_page_context.setAttribute("webManager", webManager, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\n');

    webManager.init(request, response, session, application, out);
    RuleManager rm = new RuleManagerProxy();
    ComponentList componentManager = ComponentList.getInstance();
    int i = 0;

    boolean moveOne = request.getParameter("moveOne") != null;

    if (moveOne) {
        int destId = new Integer(request.getParameter("moveOne")).intValue();
        int srcId = new Integer(request.getParameter("ruleId")).intValue();
        rm.moveOne(srcId, destId);
        response.sendRedirect("pf-main.jsp");
    }

    List<Rule> rules = rm.getRules();
    int lastOrder = rm.getLastOrder();

      out.write("\n\n<html>\n<head>\n    <style type=\"text/css\">\n        <!--\n        @import url( \"style/packetfilter.css\" );\n        -->\n    </style>\n    <title>\n        ");
      if (_jspx_meth_fmt_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("\n    </title>\n    <meta name=\"pageID\" content=\"packetFilter\"/>\n    <meta name=\"helpPage\" content=\"\"/>\n    <script language=\"JavaScript\" type=\"text/javascript\" src=\"scripts/packetfilter.js\"></script>\n    \n\n</head>\n<body>\n\n\n<div class=\"jive-table\">\n    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n        <thead>\n            <tr>\n                <th nowrap>Rule Type</th>\n                <th nowrap>From</th>\n                <th nowrap>To</th>\n                <th nowrap>Packet Type</th>\n                <th nowrap>Log</th>\n                <th>&nbsp</th>\n            </tr>\n        </thead>\n\n        <tbody>\n            ");

                for (Rule rule : rules) {


            
      out.write("\n\n            <tr class=\"jive-");
      out.print( (((i%2)==0) ? "even" : "odd") );
      out.write("\">\n\n                ");
 if (rule.isDisabled()) { 
      out.write("\n                       <td><strike>");
      out.print(rule.getDisplayName());
      out.write("</strike></td>\n                    ");
} else {
      out.write("\n                        <td>");
      out.print(rule.getDisplayName());
      out.write("</td>\n                    ");
}
      out.write("\n                ");
 if (rule.isDisabled()) { 
      out.write("\n                      <td><strike>");
      out.print(rule.getSource());
      out.write("</strike></td>\n                    ");
} else if (rule.getSourceType().equals(Rule.SourceDestType.Component.toString())
                            && componentManager.getComponentName(new JID(rule.getSource()))!= null) { 
      out.write("\n                        <td>");
      out.print(componentManager.getComponentName(new JID(rule.getSource())));
      out.write("</td>\n                    ");
 } else {
      out.write("\n                       <td>");
      out.print(PacketFilterUtil.formatRuleSourceDest(rule.getSource()));
      out.write("</td>\n                    ");
}
      out.write("\n                ");
 if (rule.isDisabled()) { 
      out.write("\n                         <td><strike>");
      out.print(rule.getDestination());
      out.write("</strike></td>\n                    ");
} else if (rule.getDestType().equals(Rule.SourceDestType.Component.toString())
                            && componentManager.getComponentName(new JID(rule.getDestination()))!= null) {
      out.write("\n                          <td>");
      out.print(componentManager.getComponentName(new JID(rule.getDestination())));
      out.write("</td>\n                   ");
 }else {
      out.write("\n                          <td>");
      out.print(PacketFilterUtil.formatRuleSourceDest(rule.getDestination()));
      out.write("</td>\n                    ");
}
      out.write("\n                ");
 if (rule.isDisabled()) { 
      out.write("\n                         <td><strike>");
      out.print(rule.getPackeType());
      out.write("</strike></td>\n                    ");
} else {
      out.write("\n                        <td>");
      out.print(rule.getPackeType().getDisplayName());
      out.write("</td>\n                    ");
}
      out.write("\n                ");
 if (rule.isDisabled()) { 
      out.write("\n                       <td><strike>");
      out.print(rule.doLog());
      out.write("</strike></td>\n                    ");
} else {
      out.write("\n                      <td>");
      out.print(rule.doLog());
      out.write("</td>\n                    ");
}
      out.write("\n\n                <td><a href=\"delete-rule.jsp?ruleId=");
      out.print(rule.getRuleId());
      out.write("\"><img src=\"/images/delete-16x16.gif\"\n                                                                                width=\"16\" height=\"16\"\n                                                                                border=\"0\"\n                                                                                alt=\"");
      if (_jspx_meth_fmt_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("\"></a>\n                    <!--<a href=\"rule-form.jsp?beforeId=");
      out.print(rule.getRuleId());
      out.write("\">Before</a>\n                    <a href=\"rule-form.jsp?afterId=");
      out.print(rule.getRuleId());
      out.write("\">After</a>-->\n                    ");
if (rule.getOrder() > 1 && i>0) {
      out.write("\n                    <a href=\"pf-main.jsp?moveOne=");
      out.print(rules.get(i-1).getRuleId());
      out.write("&ruleId=");
      out.print(rule.getRuleId());
      out.write("\"><img src=\"arrow_up.png\" width=\"16\" height=\"16\" border=\"0\" alt=\"");
      if (_jspx_meth_fmt_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("\"></a>\n                    ");
}
      out.write("\n                     ");
if (rule.getOrder() != lastOrder) {
      out.write("\n                    <a href=\"pf-main.jsp?moveOne=");
      out.print(rules.get(i+1).getRuleId());
      out.write("&ruleId=");
      out.print(rule.getRuleId());
      out.write("\"><img src=\"arrow_down.png\" width=\"16\" height=\"16\" border=\"0\" alt=\"");
      if (_jspx_meth_fmt_005fmessage_005f3(_jspx_page_context))
        return;
      out.write("\"></a>\n                    ");
}
      out.write("\n                    <a href=\"rule-edit-form.jsp?edit=");
      out.print(rule.getRuleId());
      out.write("\"><img src=\"/images/edit-16x16.gif\" width=\"16\" height=\"16\" border=\"0\" alt=\"");
      if (_jspx_meth_fmt_005fmessage_005f4(_jspx_page_context))
        return;
      out.write("\"></a>\n                </td>\n            </tr>\n            ");

                i++;
                } 
      out.write("\n        </tbody>\n    </table>\n    </div>\n    <input type=\"button\" ONCLICK=\"window.location.href='rule-form.jsp'\" name=\"create\" value=\"");
      if (_jspx_meth_fmt_005fmessage_005f5(_jspx_page_context))
        return;
      out.write("\">\n\n</body>\n</html>\n");
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

  private boolean _jspx_meth_fmt_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f0.setParent(null);
    // /pf-main.jsp(42,8) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f0.setKey("pf.summary.title");
    int _jspx_eval_fmt_005fmessage_005f0 = _jspx_th_fmt_005fmessage_005f0.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f1.setParent(null);
    // /pf-main.jsp(110,85) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f1.setKey("global.click_delete");
    int _jspx_eval_fmt_005fmessage_005f1 = _jspx_th_fmt_005fmessage_005f1.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f1);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f2.setParent(null);
    // /pf-main.jsp(114,174) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f2.setKey("pf.click.up");
    int _jspx_eval_fmt_005fmessage_005f2 = _jspx_th_fmt_005fmessage_005f2.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f2);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f3 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f3.setParent(null);
    // /pf-main.jsp(117,176) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f3.setKey("pf.click.down");
    int _jspx_eval_fmt_005fmessage_005f3 = _jspx_th_fmt_005fmessage_005f3.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f3);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f4 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f4.setParent(null);
    // /pf-main.jsp(119,149) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f4.setKey("pf.click.edit");
    int _jspx_eval_fmt_005fmessage_005f4 = _jspx_th_fmt_005fmessage_005f4.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f4);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f5 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f5.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f5.setParent(null);
    // /pf-main.jsp(128,93) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f5.setKey("pf.create.new.rule");
    int _jspx_eval_fmt_005fmessage_005f5 = _jspx_th_fmt_005fmessage_005f5.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f5);
    return false;
  }
}
