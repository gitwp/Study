package xml.dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomTest1 {
    public static void main(String[] args) throws Exception {
        String path = DomTest1.class.getClassLoader().getResource("users.xml").getPath();

        parserXml(path);
    }

    public static void parserXml(String fileName) {
        try {
            // step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            /* step 2:获得具体的dom解析器 */
            DocumentBuilder db = dbf.newDocumentBuilder();
            // step3: 解析一个xml文档，获得Document对象（根结点）
            Document document = db.parse(fileName);

            //NodeList users = document.getChildNodes();
            NodeList users = document.getElementsByTagName("users");

            for (int i = 0; i < users.getLength(); i++) {
                Node user = users.item(i);
                NodeList userInfo = user.getChildNodes();

                for (int j = 0; j < userInfo.getLength(); j++) {
                    Node node = userInfo.item(j);
                    NodeList userMeta = node.getChildNodes();

                    for (int k = 0; k < userMeta.getLength(); k++) {
                        if (userMeta.item(k).getNodeName() != "#text")
                            System.out.println(userMeta.item(k).getNodeName()
                                    + ":" + userMeta.item(k).getTextContent());
                    }

                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用递归解析给定的任意一个xml文档
     *
     * @param element
     */
    private static void parseElement(Element element) {
        String tagName = element.getNodeName();

        NodeList children = element.getChildNodes();

        System.out.print("<" + tagName);

        //element元素的所有属性所构成的NamedNodeMap对象，需要对其进行判断
        NamedNodeMap map = element.getAttributes();

        //如果该元素存在属性
        if (null != map) {
            for (int i = 0; i < map.getLength(); i++) {
                //获得该元素的每一个属性
                Attr attr = (Attr) map.item(i);

                String attrName = attr.getName();
                String attrValue = attr.getValue();

                System.out.print(" " + attrName + "=\"" + attrValue + "\"");
            }
        }

        System.out.print(">");

        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            //获得结点的类型
            short nodeType = node.getNodeType();

            if (nodeType == Node.ELEMENT_NODE) {
                //是元素，继续递归
                parseElement((Element) node);
            } else if (nodeType == Node.TEXT_NODE) {
                //递归出口
                System.out.print(node.getNodeValue());
            } else if (nodeType == Node.COMMENT_NODE) {
                System.out.print("<!--");

                Comment comment = (Comment) node;

                //注释内容
                String data = comment.getData();

                System.out.print(data);

                System.out.print("-->");
            }
        }

        System.out.print("</" + tagName + ">");
    }

}

