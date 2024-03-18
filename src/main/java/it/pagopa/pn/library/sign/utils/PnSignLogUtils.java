package it.pagopa.pn.library.sign.utils;

public class PnSignLogUtils {

    private PnSignLogUtils() {}

    //ARUBA
    public static final String ARUBA_SIGN_PDF_DOCUMENT = "ArubaSignProviderService.signPdfDocument()";
    public static final String ARUBA_SIGN_XML_DOCUMENT = "ArubaSignProviderService.signXmlDocument()";
    public static final String ARUBA_PKCS_7_SIGNATURE = "ArubaSignProviderService.pkcs7Signature()";
    public static final String INITIALIZING_ARUBA_PROXY_CLIENT = "Initializing Aruba proxy client for '{}' : ArubaServerAddress : {}, EndpointName : {}, ServiceName : {}";
    public static final String SETTING_PROXY_PROPERTIES = "Setting properties for Aruba proxy client : {}";
    public static final String CLIENT_METHOD_INVOCATION = "Client method '{}' - args: '{}'";
    public static final String CLIENT_METHOD_RETURN = "Return client method: {} = {}";

}
