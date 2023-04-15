package StepDefinition;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XmlExtractForTran {
		public static String  asnId;
		public static String ilpnId,env;
		static ArrayList<String> ilpnValues;
     
        public static void transfer_asn_xml_extract(String filepath) {
        	
			try {
		        File inputFile= new File(filepath);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
				Document  doc =dBuilder.parse(inputFile);
				doc.getDocumentElement().normalize();
				Node asnNode = doc.getElementsByTagName("ASNID").item(0);
				NodeList ilpnList = doc.getElementsByTagName("LPNID");
				Node envNode = doc.getElementsByTagName("DestinationFacilityAliasID").item(0);
				ilpnValues=new ArrayList<String>();
				for(int i=0;i<ilpnList.getLength();i++)
				{
					Node ilpnNode=ilpnList.item(i);
					if(ilpnNode.getNodeType()==Node.ELEMENT_NODE) {
						Element element=(Element) ilpnNode;
						String value=element.getTextContent();
						ilpnValues.add(value);
					}
				}
				asnId=asnNode.getTextContent();
				//ilpnId=ilpnNode.getTextContent();
				env=envNode.getTextContent();
				
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	  
}
