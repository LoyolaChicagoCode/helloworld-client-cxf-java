package winch.example.message;

import static org.junit.Assert.*;

import javax.xml.ws.BindingProvider;

import org.junit.Test;

public class TestGeneratedClient {
	
	@Test
	public void testSimple() throws Exception {
		MessageServiceService service = new MessageServiceService();
		MessageService client = service.getMessageServicePort();
		assertEquals("1", client.getMessage("hello"));
		assertEquals("1", client.getMessage("hello"));
		assertEquals("1", client.getMessage("hello"));
	}
	
	@Test
	public void testSession() throws Exception {
		MessageServiceService service = new MessageServiceService();
		MessageService client = service.getMessageServicePort();
		((BindingProvider) client).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		assertEquals("1", client.getMessage("hello"));
		assertEquals("2", client.getMessage("hello"));
		assertEquals("3", client.getMessage("hello"));
	}

}
