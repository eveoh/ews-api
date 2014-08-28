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
        logger.warn("Request to EWS failed. Here is the request trace:");

        logRequestHeaders();
        logRequestBody();
        logResponseHeaders();
        logResponseBody();
    }

    private void logRequestHeaders() {
        if (request != null) {
            try {
                String headers = EwsUtilities.formatHttpRequestHeaders(request);
                logger.warn(EwsUtilities.formatLogMessage(TraceFlags.EwsRequestHttpHeaders.toString(), headers));
            } catch (EWSHttpException | XMLStreamException | IOException | URISyntaxException e) {
                logger.warn("Could not log request headers of failed request.", e);
            }
        } else {
            logger.warn("Could not log request headers, since the request hasn't been set.");
        }
    }

    private void logRequestBody() {
        if (requestBodyStream != null) {
            logger.warn(EwsUtilities.formatLogMessageWithXmlContent(TraceFlags.EwsRequest.toString(), requestBodyStream));
        } else {
            logger.warn("Could not log request body of failed request, since the stream hasn't been set.");
        }
    }

    private void logResponseHeaders() {
        if (request != null) {
            try {
                String headers = EwsUtilities.formatHttpResponseHeaders(request);
                logger.warn(EwsUtilities.formatLogMessage(TraceFlags.EwsResponseHttpHeaders.toString(), headers));
            } catch (EWSHttpException | IOException | XMLStreamException e) {
                logger.warn("Could not log response headers.", e);
            }
        } else {
            logger.warn("Could not log response headers, since the request hasn't been set.");
        }
    }

    private void logResponseBody() {
        if (responseBodyStream != null) {
            logger.warn(EwsUtilities.formatLogMessageWithXmlContent(TraceFlags.EwsResponse.toString(), responseBodyStream));
        } else {
            logger.warn("Could not log response body of failed request, since the stream hasn't been set.");
        }
    }
}
