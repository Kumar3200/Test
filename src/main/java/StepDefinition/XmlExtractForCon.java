package StepDefinition;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlExtractForCon {
	public static String  conAsnId;
	public static String batch;
	public static String conQty,env;
	static ArrayList<String> batchValues;
	static ArrayList<String> qtyValues;
	public static void the_Conversion_asn_xml_extract(String filepath) {
		
		try {
			File inputFile= new File(filepath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
			Document  doc =dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			Node conAsnNode = doc.getElementsByTagName("ASNID").item(0);
			NodeList batchList = doc.getElementsByTagName("BatchNumber");
			NodeList conQtyList = doc.getElementsByTagName("ShippedQty");
			Node envNode = doc.getElementsByTagName("DestinationFacilityAliasID").item(0);
			conAsnId=conAsnNode.getTextContent();
			//batch=batchNode.getTextContent();
			//conQty=conQtyNode.getTextContent();
			env=envNode.getTextContent();
			batchValues=new ArrayList<String>();
			for(int i=0;i<batchList.getLength();i++)
			{
				Node batchNode=batchList.item(i);
				if(batchNode.getNodeType()==Node.ELEMENT_NODE) {
					Element element=(Element) batchNode;
					String value=element.getTextContent();
					batchValues.add(value);
				}
			}
			qtyValues=new ArrayList<String>();
			for(int i=0;i<batchList.getLength();i++)
			{
				Node qtyNode=conQtyList.item(i);
				if(qtyNode.getNodeType()==Node.ELEMENT_NODE) {
					Element element=(Element) qtyNode;
					String value=element.getTextContent();
					qtyValues.add(value);
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
