package winch.example.message;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.junit.Test;

public class TestJaxWSClient {

	@Test
	public void testSimple() throws Exception {
		URL wsdlURL = new URL("http://localhost:8080/message-cxf/MessageService?wsdl");
		Service service = Service.create(wsdlURL, new QName("http://message.example.winch/", "MessageServiceService"));
		Dispatch<Source> disp = service.createDispatch(new QName("http://message.example.winch/", "MessageServicePort"), Source.class, Service.Mode.PAYLOAD);

		Source request = new StreamSource(new StringReader("<q0:getMessage xmlns:q0=\"http://message.example.winch/\"><message>987</message></q0:getMessage>"));
		String result = ((DOMSource) disp.invoke(request)).getNode().getFirstChild().getFirstChild().getTextContent();
		assertEquals("1", result);
		request = new StreamSource(new StringReader("<q0:getMessage xmlns:q0=\"http://message.example.winch/\"><message>987</message></q0:getMessage>"));
		result = ((DOMSource) disp.invoke(request)).getNode().getFirstChild().getFirstChild().getTextContent();
		assertEquals("1", result);
		request = new StreamSource(new StringReader("<q0:getMessage xmlns:q0=\"http://message.example.winch/\"><message>987</message></q0:getMessage>"));
		result = ((DOMSource) disp.invoke(request)).getNode().getFirstChild().getFirstChild().getTextContent();
		assertEquals("1", result);
	}
	
}
