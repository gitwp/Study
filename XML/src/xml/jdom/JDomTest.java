package xml.jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JDomTest
{
    public static void main(String[] args) throws Exception
    {
        createXML();
        readXML();
    }

    public static void createXML() throws Exception{

        Document document = new Document();

        Element root = new Element("root");
        document.addContent(root);

        Comment comment = new Comment("This is my comments");
        root.addContent(comment);

        Element e = new Element("hello");
        e.setAttribute("sohu", "www.sohu.com");
        root.addContent(e);

        Element e2 = new Element("world");
        Attribute attr = new Attribute("test", "hehe");
        e2.setAttribute(attr);
        e.addContent(e2);

        e2.addContent(new Element("aaa").setAttribute("a", "b")
                .setAttribute("x", "y").setAttribute("gg", "hh").setText("text content"));


        Format format = Format.getPrettyFormat();
        format.setIndent("    ");
//		format.setEncoding("gbk");

        XMLOutputter out = new XMLOutputter(format);
        out.output(document, new FileWriter("jdom.xml"));
    }

    public static void readXML() throws JDOMException, IOException {

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new File("jdom.xml"));

        Element element = doc.getRootElement();
        System.out.println(element.getName());

        Element hello = element.getChild("hello");
        System.out.println(hello.getText());

        List list = hello.getAttributes();

        for(int i = 0 ;i < list.size(); i++)
        {
            Attribute attr = (Attribute)list.get(i);

            String attrName = attr.getName();
            String attrValue = attr.getValue();

            System.out.println(attrName + "=" + attrValue);
        }

        hello.removeChild("world");

        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat().setIndent("    "));
        out.output(doc, new FileOutputStream("jdom2.xml"));
    }
}
