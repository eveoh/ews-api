package microsoft.exchange.webservices.data;

import microsoft.exchange.webservices.data.exception.translator.EwsExceptionTranslator;
import org.apache.commons.httpclient.Cookie;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class ExchangeServiceBaseFacade {

    protected final EwsExceptionTranslator ewsExceptionTranslator = new EwsExceptionTranslator();

    protected final ExchangeServiceBase es;


    public ExchangeServiceBaseFacade(ExchangeServiceBase es) {
        this.es = es;
    }

    /**
     * @param location
     * @return false if location is null,true if this abstract pathname is absolute,
     */
    public static boolean checkURIPath(String location) {
        return ExchangeServiceBase.checkURIPath(location);
    }

    /**
     * Gets the cookie container. <value>The cookie container.</value>
     *
     * @param url   the url
     * @param value the value
     * @throws ServiceLocalException
     * @throws EWSHttpException
     */
    public void setCookie(Cookie[] rcookies) {
        try {
            es.setCookie(rcookies);
        } catch (EWSHttpException e) {
            throw ewsExceptionTranslator.translate(e);
        }
    }

    /**
     * Gets the cookie.
     *
     * @param url the url
     * @return the cookie
     * @throws IOException        Signals that an I/O exception has occurred.
     * @throws URISyntaxException the uRI syntax exception
     */
    public Cookie[] getCookies() {
        return es.getCookies();
    }

    /**
     * Gets a value indicating whether tracing is enabled.
     *
     * @return True is tracing is enabled
     */
    public boolean isTraceEnabled() {
        return es.isTraceEnabled();
    }

    /**
     * Sets a value indicating whether tracing is enabled.
     *
     * @param traceEnabled true to enable tracing
     */
    public void setTraceEnabled(boolean traceEnabled) {
        es.setTraceEnabled(traceEnabled);
    }

    /**
     * Gets the trace flags.
     *
     * @return Set of trace flags.
     */
    public EnumSet<TraceFlags> getTraceFlags() {
        return es.getTraceFlags();
    }

    /**
     * Sets the trace flags.
     *
     * @param traceFlags A set of trace flags
     */
    public void setTraceFlags(EnumSet<TraceFlags> traceFlags) {
        es.setTraceFlags(traceFlags);
    }

    /**
     * Gets the trace listener.
     *
     * @return The trace listener.
     */
    public ITraceListener getTraceListener() {
        return es.getTraceListener();
    }

    /**
     * Sets the trace listener.
     *
     * @param traceListener the trace listener.
     */
    public void setTraceListener(ITraceListener traceListener) {
        es.setTraceListener(traceListener);
    }

    /**
     * Gets the credentials used to authenticate with the Exchange Web Services.
     *
     * @return credentials
     */
    public ExchangeCredentials getCredentials() {
        return es.getCredentials();
    }

    /**
     * Sets the credentials used to authenticate with the Exchange Web Services. Setting the Credentials property
     * automatically sets the UseDefaultCredentials to false.
     *
     * @param credentials Exchange credentials.
     */
    public void setCredentials(ExchangeCredentials credentials) {
        es.setCredentials(credentials);
    }

    /**
     * Gets a value indicating whether the credentials of the user currently logged into Windows should be used to
     * authenticate with the Exchange Web Services.
     *
     * @return true if credentials of the user currently logged in are used
     */
    public boolean getUseDefaultCredentials() {
        return es.getUseDefaultCredentials();
    }

    /**
     * * Sets a value indicating whether the credentials of the user currently logged into Windows should be used to
     * authenticate with the Exchange Web Services. Setting UseDefaultCredentials to true automatically sets the
     * Credentials property to null.
     *
     * @param value the new use default credentials
     */
    public void setUseDefaultCredentials(boolean value) {
        es.setUseDefaultCredentials(value);
    }

    /**
     * Gets the timeout used when sending HTTP requests and when receiving HTTP responses, in milliseconds.
     *
     * @return timeout in milliseconds
     */
    public int getTimeout() {
        return es.getTimeout();
    }

    /**
     * Sets the timeout used when sending HTTP requests and when receiving HTTP respones, in milliseconds. Defaults to
     * 100000.
     *
     * @param timeout timeout in milliseconds
     */
    public void setTimeout(int timeout) {
        es.setTimeout(timeout);
    }

    /**
     * Gets a value that indicates whether HTTP pre-authentication should be performed.
     *
     * @return true indicates pre-authentication is set
     */
    public boolean isPreAuthenticate() {
        return es.isPreAuthenticate();
    }

    /**
     * Sets a value that indicates whether HTTP pre-authentication should be performed.
     *
     * @param preAuthenticate true to enable pre-authentication
     */
    public void setPreAuthenticate(boolean preAuthenticate) {
        es.setPreAuthenticate(preAuthenticate);
    }

    /**
     * Gets a value indicating whether GZip compression encoding should be accepted. This value will tell the server
     * that
     * the client is able to handle GZip compression encoding. The server will only send Gzip compressed content if
     * it has
     * been configured to do so.
     *
     * @return true if compression is used
     */
    public boolean getAcceptGzipEncoding() {
        return es.getAcceptGzipEncoding();
    }

    /**
     * Gets a value indicating whether GZip compression encoding should be accepted. This value will tell the server
     * that
     * the client is able to handle GZip compression encoding. The server will only send Gzip compressed content if
     * it has
     * been configured to do so.
     *
     * @param acceptGzipEncoding true to enable compression
     */
    public void setAcceptGzipEncoding(boolean acceptGzipEncoding) {
        es.setAcceptGzipEncoding(acceptGzipEncoding);
    }

    /**
     * Gets the requested server version.
     *
     * @return The requested server version.
     */
    public ExchangeVersion getRequestedServerVersion() {
        return es.getRequestedServerVersion();
    }

    /**
     * Gets the user agent.
     *
     * @return The user agent.
     */
    public String getUserAgent() {
        return es.getUserAgent();
    }

    /**
     * Sets the user agent.
     *
     * @param userAgent The user agent
     */
    public void setUserAgent(String userAgent) {
        es.setUserAgent(userAgent);
    }

    /**
     * * Gets information associated with the server that processed the last request. Will be null if no requests
     * have been
     * processed.
     *
     * @return the server info
     */
    public ExchangeServerInfo getServerInfo() {
        return es.getServerInfo();
    }

    /**
     * Sets information associated with the server that processed the last request.
     *
     * @param serverInfo Server Information
     */
    void setServerInfo(ExchangeServerInfo serverInfo) {
        es.setServerInfo(serverInfo);
    }

    /**
     * Gets the web proxy that should be used when sending requests to EWS.
     *
     * @return Proxy the Proxy Information
     */
    public WebProxy getWebProxy() {
        return es.getWebProxy();
    }

    /**
     * Sets the web proxy that should be used when sending requests to EWS. Set this property to null to use the default
     * web proxy.
     *
     * @param value the Proxy Information
     */
    public void setWebProxy(WebProxy value) {
        es.setWebProxy(value);
    }

    /**
     * Gets a collection of HTTP headers that will be sent with each request to EWS.
     *
     * @return httpHeaders
     */
    public Map<String, String> getHttpHeaders() {
        return es.getHttpHeaders();
    }

    /**
     * Gets the on serialize custom soap headers.
     *
     * @return the on serialize custom soap headers
     */
    public List<ICustomXmlSerialization> getOnSerializeCustomSoapHeaders() {
        return es.getOnSerializeCustomSoapHeaders();
    }

    /**
     * Sets the on serialize custom soap headers.
     *
     * @param onSerializeCustomSoapHeaders the new on serialize custom soap headers
     */
    public void setOnSerializeCustomSoapHeaders(List<ICustomXmlSerialization> onSerializeCustomSoapHeaders) {
        es.setOnSerializeCustomSoapHeaders(onSerializeCustomSoapHeaders);
    }

    /**
     * Gets a collection of HTTP headers from the last response.
     */
    public Map<String, String> getHttpResponseHeaders() {
        return es.getHttpResponseHeaders();
    }
}
