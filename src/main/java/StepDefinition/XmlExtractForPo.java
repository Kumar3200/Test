package StepDefinition;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XmlExtractForPo {
	public static String  po,env;
	public static String bp;
	static ArrayList<String> qtyValues;
	static ArrayList<String> itemValues;
	
	public static void po_xml_extract_file(String filepath) {
		try {
			File inputFile= new File(filepath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
			Document  doc =dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			Node poNode = doc.getElementsByTagName("OrderId").item(0);
			Node bpNode = doc.getElementsByTagName("BusinessPartnerCode").item(0);
			NodeList itemList = doc.getElementsByTagName("ItemName");
			NodeList qtyList = doc.getElementsByTagName("OrderQty");
			Node envNode = doc.getElementsByTagName("DestinationFacilityAliasId").item(0);
			po=poNode.getTextContent();
			bp=bpNode.getTextContent();
			env=envNode.getTextContent();
			qtyValues=new ArrayList<String>();
			for(int i=0;i<qtyList.getLength();i++)
			{
				Node qtyNode=qtyList.item(i);
				if(qtyNode.getNodeType()==Node.ELEMENT_NODE) {
					Element element=(Element) qtyNode;
					String value=element.getTextContent();
					qtyValues.add(value);
				}
			}
			itemValues=new ArrayList<String>();
			for(int i=0;i<itemList.getLength();i++)
			{
				Node itemNode=itemList.item(i);
				if(itemNode.getNodeType()==Node.ELEMENT_NODE) {
					Element element=(Element) itemNode;
					String value=element.getTextContent();
					itemValues.add(value);
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
