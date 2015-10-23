package wangp.cxf_client;

import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CxfCommunication {

	public static Object wsInvoke(String wsUrl, String method, Object... arg)
			throws Exception {
		if (StringUtils.isBlank(wsUrl))
			throw new Exception("wsUrl is required.");
		Client client = getCxfClient(wsUrl, null);
		Object[] res = client.invoke(method, arg);
		return res[0];
	}

	public static Object wsInvokeByWsdlFile(String wsUrl, URL wsdlLocation,
			String method, Object... arg) throws Exception {
		if (StringUtils.isBlank(wsUrl))
			throw new Exception("wsUrl is required.");
		Client client = getCxfClient(wsUrl, wsdlLocation);
		Object[] res = client.invoke(method, arg);
		return res[0];
	}

	private final static LRUMap WS_CLIENT_CACHE = new LRUMap(200);

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CxfCommunication.class);

	private static Client getCxfClient(String wsUrl, URL wsdlLocation) {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		String wsdlUrl = wsUrl.concat("?wsdl");
		if (!WS_CLIENT_CACHE.containsKey(wsUrl)) {
			synchronized (CxfCommunication.class) {
				if (!WS_CLIENT_CACHE.containsKey(wsUrl)) {
					LOGGER.debug(
							"cannot find key [{}] from webService client cache",
							new Object[] { wsUrl });
					Client client;
					if (null != wsdlLocation) {
						client = dcf.createClient(wsdlLocation);
					} else {
						client = dcf.createClient(wsdlUrl);
					}
					List<ServiceInfo> lstSI = client.getEndpoint().getService()
							.getServiceInfos();
					if (lstSI != null) {
						for (ServiceInfo si : lstSI) {
							Collection<EndpointInfo> cs = si.getEndpoints();
							if (cs != null) {
								for (EndpointInfo ei : cs) {
									ei.setAddress(wsUrl);
								}
							}
						}
					}
					WS_CLIENT_CACHE.put(wsUrl, client);
				} else {
					LOGGER.debug(
							"load webService client from client cache with key [{}]",
							new Object[] { wsUrl });
				}
			}
		}
		return (Client) WS_CLIENT_CACHE.get(wsUrl);
	}

	public static void main(String[] args) {
		try {
			Object result = wsInvoke(
					"http://127.0.0.1:8080/ws/services/userService",
					"sayHi", "wlh");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}