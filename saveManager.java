/**
* \file -saveManager.java
* \author Lewis Edwards 708830
* \date 19th Mar '14
*
* \brief This class will manage the saving and loading of games.
*
*
*
*/


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public saveManager() {

	 try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	
		/**
		*
		*
		*/
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Game");
		doc.appendChild(rootElement);

		Element player = doc.createElement("Player");
		rootElement.appendChild(player);

		Attr attr = doc.createAttribute("number");
		attr.setValue("1");
		player.setAttributeNode(attr);

		Element player1Name = doc.createElement("name");
		name.appendChild(doc.createTextNode("PLAYER 1 NAME GET METHOD"));
		player.appendChild(player1Name);

		Element player1Colour = doc.createElement("colour");
		playercolour.appendChild(doc.createTextNode("GET PLAYER 1 COLOUR"));
		player.appendChild(player1Colour);

		Element player1Type = doc.createElement("player type");
		playerType.appendChild(doc.createTextNode("GET PLAYER 1 TYPE"));
		player.appendChild(player1Type);

		Attr attr = doc.createAttribute("number");
		attr.setValue("2");
		player.setAttributeNode(attr);

		Element player2Name = doc.createElement("name");
		name.appendChild(doc.createTextNode("PLAYER 2 NAME GET METHOD"));
		player.appendChild(player2Name);

		Element player2Colour = doc.createElement("colour");
		playercolour.appendChild(doc.createTextNode("GET PLAYER 2 COLOUR"));
		player.appendChild(player2Colour);

		Element player2Type = doc.createElement("player type");
		playerType.appendChild(doc.createTextNode("GET PLAYER 2 TYPE"));
		player.appendChild(player2Type);


		} 
}