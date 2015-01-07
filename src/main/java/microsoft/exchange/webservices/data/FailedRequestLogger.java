package microsoft.exchange.webservices.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Erik van Paassen
 */
public class FailedRequestLogger {

    private final Logger logger = LoggerFactory.getLogger(FailedRequestLogger.class);

    private HttpWebRequest request;
    private ByteArrayOutputStream requestBodyStream;
    private ByteArrayOutputStream responseBodyStream;


    public void setRequest(HttpWebRequest request) {
        this.request = request;
    }

    public void setRequestBodyStream(ByteArrayOutputStream requestBodyStream) {
        this.requestBodyStream = requestBodyStream;
    }

    public void setResponseBodyStream(ByteArrayOutputStream responseBodyStream) {
        this.responseBodyStream = responseBodyStream;
    }

    public void log() {
        logger.warn("Request to EWS failed. Trace:\n" + requestHeaders() + '\n' + requestBody() + '\n'
                + responseHeaders() + '\n' + responseBody());
    }

    private String requestHeaders() {
        if (request != null) {
            try {
                String headers = EwsUtilities.formatHttpRequestHeaders(request);
                return EwsUtilities.formatLogMessage(TraceFlags.EwsRequestHttpHeaders.toString(), headers);
            } catch (EWSHttpException | XMLStreamException | IOException | URISyntaxException e) {
                logger.warn("Could not log request headers of failed request.", e);
                return "Could not log request headers of failed request.";
            }
        }

        return "Could not log request headers, since the request hasn't been set.";
    }

    private String requestBody() {
        if (requestBodyStream != null) {
            return EwsUtilities.formatLogMessageWithXmlContent(TraceFlags.EwsRequest.toString(), requestBodyStream);
        }

        return "Could not log request body of failed request, since the stream hasn't been set.";
    }

    private String responseHeaders() {
        if (request != null) {
            try {
                String headers = EwsUtilities.formatHttpResponseHeaders(request);
                return EwsUtilities.formatLogMessage(TraceFlags.EwsResponseHttpHeaders.toString(), headers);
            } catch (EWSHttpException | IOException | XMLStreamException e) {
                logger.warn("Could not log response headers.", e);
                return "Could not log response headers.";
            }
        }

        return "Could not log response headers, since the request hasn't been set.";
    }

    private String responseBody() {
        if (responseBodyStream != null) {
            return EwsUtilities.formatLogMessageWithXmlContent(TraceFlags.EwsResponse.toString(), responseBodyStream);
        }

        return "Could not log response body of failed request, since the stream hasn't been set.";
    }
}
