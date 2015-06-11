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
            // step 1: ���dom���������������������������ڴ�������Ľ�������
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            /* step 2:��þ����dom������ */
            DocumentBuilder db = dbf.newDocumentBuilder();
            // step3: ����һ��xml�ĵ������Document���󣨸���㣩
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
     * ʹ�õݹ��������������һ��xml�ĵ�
     *
     * @param element
     */
    private static void parseElement(Element element) {
        String tagName = element.getNodeName();

        NodeList children = element.getChildNodes();

        System.out.print("<" + tagName);

        //elementԪ�ص��������������ɵ�NamedNodeMap������Ҫ��������ж�
        NamedNodeMap map = element.getAttributes();

        //�����Ԫ�ش�������
        if (null != map) {
            for (int i = 0; i < map.getLength(); i++) {
                //��ø�Ԫ�ص�ÿһ������
                Attr attr = (Attr) map.item(i);

                String attrName = attr.getName();
                String attrValue = attr.getValue();

                System.out.print(" " + attrName + "=\"" + attrValue + "\"");
            }
        }

        System.out.print(">");

        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            //��ý�������
            short nodeType = node.getNodeType();

            if (nodeType == Node.ELEMENT_NODE) {
                //��Ԫ�أ������ݹ�
                parseElement((Element) node);
            } else if (nodeType == Node.TEXT_NODE) {
                //�ݹ����
                System.out.print(node.getNodeValue());
            } else if (nodeType == Node.COMMENT_NODE) {
                System.out.print("<!--");

                Comment comment = (Comment) node;

                //ע������
                String data = comment.getData();

                System.out.print(data);

                System.out.print("-->");
            }
        }

        System.out.print("</" + tagName + ">");
    }

}

