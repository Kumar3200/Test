package StepDefinition;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class OutboundXmlextract {
	static String orderId;
	static String env;
	static String qty;
	public static void xmlExtract(String filepath) {
		
		
	try {
		File inputFile= new File(filepath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
		Document  doc =dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		Node envNode = doc.getElementsByTagName("OriginFacilityAliasId").item(0);
		Node orderNode = doc.getElementsByTagName("DistributionOrderId").item(0);
		Node QtyNode = doc.getElementsByTagName("OrderQty").item(0);
		env=envNode.getTextContent();
		orderId=orderNode.getTextContent();
		qty=QtyNode.getTextContent();

	}

	catch (Exception e) {
		e.printStackTrace();
	}
}
}
