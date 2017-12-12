package com.ut;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class ServletExceptionWrapper extends Throwable {

    private String className;
    private String message;

    public ServletExceptionWrapper(String theMessage) {
        super(theMessage);
    }

    public ServletExceptionWrapper() {
    }

    public ServletExceptionWrapper(Element exception) {
        String encodedMessage = exception.getElementsByTagName("message").item(0).getTextContent();

        try {
            this.message = URLDecoder.decode(encodedMessage, "UTF-8");
        } catch (UnsupportedEncodingException var15) {
            throw new RuntimeException(var15);
        }

        this.className = exception.getAttribute("class");
        NodeList nodes = exception.getElementsByTagName("stack");
        int nodeCount = nodes.getLength();
        StackTraceElement[] stack = new StackTraceElement[nodeCount];

        for(int i = 0; i < nodeCount; ++i) {
            Element ele = (Element)nodes.item(i);
            String clazzName = null;

            try {
                clazzName = URLDecoder.decode(ele.getAttribute("class"), "UTF-8");
            } catch (UnsupportedEncodingException var14) {
                clazzName = "UNKNOWN CLASS";
            }

            String methodName = null;

            try {
                methodName = URLDecoder.decode(ele.getAttribute("method"), "UTF-8");
            } catch (UnsupportedEncodingException var13) {
                methodName = "UNKNOWN METHOD";
            }

            String fileName = ele.getAttribute("filename");
            int lineNo = Integer.parseInt(ele.getAttribute("line"));
            StackTraceElement stackElement = new StackTraceElement(clazzName, methodName, fileName, lineNo);
            stack[i] = stackElement;
        }

        super.setStackTrace(stack);
    }

    public String getWrappedClassName() {
        return this.className;
    }

    public String getMessage() {
        return this.message;
    }

    public String getLocalizedMessage() {
        return this.message;
    }
}
