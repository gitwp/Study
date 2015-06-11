package xml.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Dom4jTest {

    public static void main(String[] args) throws Exception {
        createXML();
        readXML();
    }

    public static void createXML() throws Exception {
        System.out.println("---------createXML  START------------------");
        // 创建文档并设置文档的根元素节点 ：第一种方式
        // Document document = DocumentHelper.createDocument();
        //
        // Element root = DocumentHelper.createElement("student");
        //
        // document.setRootElement(root);

        // 创建文档并设置文档的根元素节点 ：第二种方式
        Element root = DocumentHelper.createElement("student");
        Document document = DocumentHelper.createDocument(root);

        root.addAttribute("name", "zhangsan");

        Element helloElement = root.addElement("hello");
        Element worldElement = root.addElement("world");

        helloElement.setText("hello");
        worldElement.setText("world");

        helloElement.addAttribute("age", "20");

        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.write(document);

        OutputFormat format = new OutputFormat("    ", true);

        XMLWriter xmlWriter2 = new XMLWriter(new FileOutputStream("student2.xml"), format);
        xmlWriter2.write(document);

        XMLWriter xmlWriter3 = new XMLWriter(new FileWriter("student3.xml"), format);

        xmlWriter3.write(document);
        xmlWriter3.close();
        System.out.println("---------createXML  END------------------");
    }

    public static void readXML() throws Exception{
        System.out.println("---------readXML  START------------------");

        SAXReader saxReader = new SAXReader();

        Document doc = saxReader.read(new File("student2.xml"));

        Element root = doc.getRootElement();

        System.out.println("root element: " + root.getName());

        List childList = root.elements();

        System.out.println(childList.size());

        List childList2 = root.elements("hello");

        System.out.println(childList2.size());

        Element first = root.element("hello");

        System.out.println(first.attributeValue("age"));

        for(Iterator iter = root.elementIterator(); iter.hasNext();)
        {
            Element e = (Element)iter.next();

            System.out.println(e.attributeValue("age"));
        }

        System.out.println("---------------------------");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        org.w3c.dom.Document document = db.parse(new File("student2.xml"));

        DOMReader domReader = new DOMReader();

        //将JAXP的Document转换为dom4j的Document
        Document d = domReader.read(document);

        Element rootElement = d.getRootElement();

        System.out.println(rootElement.getName());



        System.out.println("---------readXML  END------------------");

    }
}