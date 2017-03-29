/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat8
 * Generated at: 2017-03-12 07:53:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.jivesoftware.openfire.plugin.fastpath;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.jivesoftware.openfire.fastpath.history.AgentChatSession;
import org.jivesoftware.openfire.fastpath.history.ChatSession;
import org.jivesoftware.openfire.fastpath.history.ChatTranscriptManager;
import org.jivesoftware.xmpp.workgroup.utils.ModelUtil;
import java.util.Iterator;
import java.util.List;

public final class chat_002dconversation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

      out.write("\r\n\r\n\r\n<html>\r\n    <head>\r\n        <title>Chat Conversation</title>\r\n        <meta name=\"pageID\" content=\"chat-summary\"/>\r\n      <style type=\"text/css\">\r\n          .conversation-label1 {\r\n              color: blue;\r\n              font-size: 10px;\r\n              font-family: Verdana, Arial, sans-serif;\r\n          }\r\n\r\n          .conversation-label2 {\r\n              color: red;\r\n              font-size: 10px;\r\n              font-family: Verdana, Arial, sans-serif;\r\n          }\r\n\r\n          .notification-label {\r\n              color: #060;\r\n              font-size: 10px;\r\n              font-family: Verdana, Arial, sans-serif;\r\n          }\r\n\r\n          .conversation-body {\r\n               color: black;\r\n               font-size: 11px;\r\n               font-family: Verdana, Arial, sans-serif;\r\n           }\r\n    </style>\r\n    </head>\r\n    <body>\r\n");

    String sessionID = request.getParameter("sessionID");
    ChatSession chatSession = ChatTranscriptManager.getChatSession(sessionID);
    AgentChatSession initial = chatSession.getFirstSession();
    if (initial == null) {
        if (chatSession.getState() == 0) {
            out.println("User Cancelled");
        }
        else if (chatSession.getState() == 1) {
            out.println("User could not be routed");
        }
        else {
            out.println("Agent never joined");
        }
    }
    else {

    }

    List questionList = chatSession.getMetadata().get("question");
    String question = "No question was asked";
    if (questionList != null && questionList.size() > 0) {
        question = (String)questionList.get(0);
        chatSession.getMetadata().remove("question");
    }


      out.write("\r\n<div  class=\"jive-contentBox\">\r\n    <table cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"70%\">\r\n        <h4>Conversation Metadata</h4>\r\n        <tr>\r\n            <td  colspan=1 class=\"conversation-body\">\r\n                <b>Question:</b>\r\n            </td>\r\n            <td colspan=4 class=\"conversation-body\">\r\n                ");
      out.print( question );
      out.write("\r\n            </td>\r\n        </tr>\r\n");

    int counter = 0;
    Iterator<String> metaIter = chatSession.getMetadata().keySet().iterator();
    while (metaIter.hasNext()) {
        String metaname = metaIter.next();
        String metavalue = "";
        metavalue = org.jivesoftware.xmpp.workgroup.request.Request
                .encodeMetadataValue(chatSession.getMetadata().get(metaname));

        counter++;

      out.write("\r\n            <tr>\r\n                <td nowrap class=\"conversation-body\">\r\n                    ");
      out.print( metaname );
      out.write("\r\n                </td>\r\n                <td colspan=\"3\" class=\"conversation-body\">\r\n                    ");
      out.print( metavalue );
      out.write("\r\n            </tr>\r\n");


        }

      out.write('\r');
      out.write('\n');

        String transcript = chatSession.getTranscript();

      out.write("\r\n</table>\r\n   </div>\r\n<br/>\r\n<div  class=\"jive-contentBox\">\r\n <table  cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"70%\">\r\n        <tr class=\"jive-even\" >\r\n            <td colspan=4>\r\n             <h4>Chat Transcripts</h4>\r\n               </td>\r\n        </tr>\r\n        <tr>\r\n          <td>");
      out.print( transcript );
      out.write("</td>\r\n        </tr>\r\n    </table>\r\n");

    if (!ModelUtil.hasLength(chatSession.getTranscript())) {

      out.write("\r\n        <table class=\"jive-table\" cellpadding=\"3\" cellspacing=\"1\" border=\"0\">\r\n            <tr>\r\n                <td class=\"c1\" colspan=4>\r\n                    <tr>\r\n                        <td>\r\n                            No Chats have occured in this workgroup.\r\n                        </td>\r\n                    </tr>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n");

    }

      out.write("\r\n    </body>\r\n</html>\r\n");
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
