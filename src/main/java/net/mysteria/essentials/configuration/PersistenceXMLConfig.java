package net.mysteria.essentials.configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import net.mysteria.essentials.main.Main;

public class PersistenceXMLConfig {

	private static PersistenceXMLConfig INSTANCE;
	private Main plugin;

	private PersistenceXMLConfig(Main plugin) {
		this.plugin = plugin;
	}

	public static PersistenceXMLConfig getInstance(Main plugin) {
		if (INSTANCE == null) {
			INSTANCE = new PersistenceXMLConfig(plugin);
		}

		return INSTANCE;

	}

	public void writePersistenceXML() {

		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

		try {
			
			System.out.println("Pfad: "+ System.getProperty("user.dir"));
			
			
			XMLStreamWriter writer = xmlOutputFactory
					.createXMLStreamWriter(new FileOutputStream("/plugins/MysteriaEssentials.jar/META-INF/persistence.xml"), "UTF-8");

			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeCharacters("\n");
			writer.writeStartElement("persistence");
			writer.writeAttribute("version", "2.0");
			writer.writeAttribute("xmlns", "http://java.sun.com/xml/ns/persistence");
			writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			writer.writeAttribute("xsi:schemaLocation",
					"http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd");
			writer.writeCharacters("\n");
			writer.writeCharacters("\n");

			writer.writeStartElement("persistence-unit");
			writer.writeAttribute("name", "mysteria_essentials");
			writer.writeAttribute("transaction-type", "RESOURCE_LOCAL");
			writer.writeCharacters("\n\t\t");

			writer.writeStartElement("provider");
			writer.writeCharacters("org.hibernate.jpa.HibernatePersistenceProvider");
			writer.writeEndElement();
			writer.writeCharacters("\n\t\t");

			writer.writeStartElement("properties");
			writer.writeCharacters("\n\t\t");

			writer.writeStartElement("property");
			writer.writeAttribute("name", "javax.persistence.jdbc.driver");
			writer.writeAttribute("value", plugin.getConfig().getString("driver"));
			writer.writeEndElement();
			writer.writeCharacters("\n\t\t\t");

			writer.writeStartElement("property");
			writer.writeAttribute("name", "javax.persistence.jdbc.url");
			writer.writeAttribute("value", plugin.getConfig().getString("url"));
			writer.writeEndElement();
			writer.writeCharacters("\n\t\t\t");

			writer.writeStartElement("property");
			writer.writeAttribute("name", plugin.getConfig().getString("username"));
			writer.writeAttribute("value", "dbadmin");
			writer.writeEndElement();
			writer.writeCharacters("\n\t\t\t");

			writer.writeStartElement("property");
			writer.writeAttribute("name", "javax.persistence.jdbc.password");
			writer.writeAttribute("value", plugin.getConfig().getString("password"));
			writer.writeEndElement();
			writer.writeCharacters("\n\t\t\t");

			writer.writeStartElement("property");
			writer.writeAttribute("name", "hibernate.dialect");
			writer.writeAttribute("value", plugin.getConfig().getString("dialect"));
			writer.writeEndElement();
			writer.writeCharacters("\n\t\t");

			writer.writeEndElement();
			writer.writeCharacters("\n\t");
			writer.writeEndElement();
			writer.writeCharacters("\n");
			writer.writeEndElement();

			writer.writeEndDocument();

		} catch (XMLStreamException | FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
