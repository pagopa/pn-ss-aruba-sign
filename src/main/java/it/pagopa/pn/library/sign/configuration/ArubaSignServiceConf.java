package it.pagopa.pn.library.sign.configuration;

import it.pagopa.pn.transformation.wsdl.ArubaSignService;
import it.pagopa.pn.transformation.wsdl.ArubaSignServiceService;
import lombok.CustomLog;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.namespace.QName;
import java.util.Map;

import static it.pagopa.pn.library.sign.utils.PnSignLogUtils.INITIALIZING_ARUBA_PROXY_CLIENT;
import static it.pagopa.pn.library.sign.utils.PnSignLogUtils.SETTING_PROXY_PROPERTIES;


@Configuration
@CustomLog
public class ArubaSignServiceConf {
    @Value("${aruba.server.address}")
    private String arubaServerAddress;

    @Bean
    public ArubaSignService arubaSignService(ArubaSignServiceProxyProperties arubaSignServiceProxyProperties) {
        var endpointName = ArubaSignServiceService.ArubaSignServicePort;
        var serviceName = ArubaSignServiceService.SERVICE;
        log.debug(INITIALIZING_ARUBA_PROXY_CLIENT, "pn-ss", arubaServerAddress, endpointName, serviceName);
        return initializeFactory(endpointName, serviceName, arubaSignServiceProxyProperties).create(ArubaSignService.class);
    }

    private JaxWsProxyFactoryBean initializeFactory(QName endpointName, QName serviceName, ArubaSignServiceProxyProperties arubaSignServiceProxyProperties) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        Map<String, Object> props = arubaSignServiceProxyProperties.getProperties();
        log.debug(SETTING_PROXY_PROPERTIES, props);
        factory.setProperties(props);
        factory.setServiceClass(ArubaSignService.class);
        factory.setAddress(arubaServerAddress);
        factory.setEndpointName(endpointName);
        factory.setServiceName(serviceName);
        return factory;
    }

}
