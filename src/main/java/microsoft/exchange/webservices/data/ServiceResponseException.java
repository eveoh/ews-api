/**************************************************************************
 * copyright file="ServiceResponseException.java" company="Microsoft"
 *     Copyright (c) Microsoft Corporation.  All rights reserved.
 *
 * Defines the ServiceResponseException.java.
 **************************************************************************/
package microsoft.exchange.webservices.data;

import java.util.Map;

/**
 * Represents a remote service exception that has a single response.
 */
@SuppressWarnings("ALL")
public class ServiceResponseException extends ServiceRemoteException {

    /**
     * Error details Value keys.
     */
    private static final String ExceptionClassKey = "ExceptionClass";

    /**
     * The Exception message key.
     */
    private static final String ExceptionMessageKey = "ExceptionMessage";

    /**
     * The Stack trace key.
     */
    private static final String StackTraceKey = "StackTrace";

    private static final String InnerErrorResponseCodeKey = "InnerErrorResponseCode";
    private static final String InnerErrorMessageTextKey = "InnerErrorMessageText";


    /**
     * ServiceResponse when service operation failed remotely.
     */
    private ServiceResponse response;

    /**
     * Initializes a new instance.
     *
     * @param response the response
     */
    protected ServiceResponseException(ServiceResponse response) {
        this.response = response;
    }

    /**
     * Gets the ServiceResponse for the exception.
     *
     * @return the response
     */
    public ServiceResponse getResponse() {
        return response;
    }

    /**
     * Gets the service error code.
     *
     * @return the error code
     */
    public ServiceError getErrorCode() {
        return this.response.getErrorCode();
    }

    /**
     * Gets a message that describes the current exception.
     *
     * @return The error message that explains the reason for the exception.
     */
    public String getMessage() {
        StringBuilder builder = new StringBuilder(response.getErrorMessage());

        Map<String, String> errorDetails = response.getErrorDetails();

        if (errorDetails.containsKey(InnerErrorResponseCodeKey) && errorDetails.containsKey(InnerErrorMessageTextKey)) {
            builder.append(" (InnerErrorResponseCode: ").append(errorDetails.get(InnerErrorResponseCodeKey))
                    .append(", InnerErrorMessageText: ").append(errorDetails.get(InnerErrorMessageTextKey)).append(')');
        }

        if (response.getErrorCode() == ServiceError.ErrorInternalServerError) {
            // Bug E14:134792 -- Special case for Internal Server Error.
            // If the server returned stack trace information, include it in the exception message.
            if (errorDetails.containsKey(ExceptionClassKey) &&
                    errorDetails.containsKey(ExceptionMessageKey) &&
                    errorDetails.containsKey(StackTraceKey)) {
                String exceptionClass = errorDetails.get(ExceptionClassKey);
                String exceptionMessage = errorDetails.get(ExceptionMessageKey);
                String stackTrace = errorDetails.get(StackTraceKey);

                return String.format(Strings.ServerErrorAndStackTraceDetails, builder.toString(), exceptionClass,
                        exceptionMessage, stackTrace);
            }
        }

        return builder.toString();
    }
}
