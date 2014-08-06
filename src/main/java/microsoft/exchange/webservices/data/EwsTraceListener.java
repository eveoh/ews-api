/**************************************************************************
 * copyright file="EwsTraceListener.java" company="Microsoft"
 *     Copyright (c) Microsoft Corporation.  All rights reserved.
 *
 * Defines the EwsTraceListener.java.
 **************************************************************************/
package microsoft.exchange.webservices.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * * EwsTraceListener logs request/responses to a text writer.
 *
 * @see EwsTraceEvent
 */
@SuppressWarnings("ALL")
class EwsTraceListener implements ITraceListener {

    private final Logger logger = LoggerFactory.getLogger(EwsTraceListener.class);

    /**
     * Initializes a new instance of the class.
     */
    protected EwsTraceListener() {
    }

    /**
     * Handles a trace message.
     *
     * @param traceType    the trace type
     * @param traceMessage the trace message
     */
    @Override
    public void trace(String traceType, String traceMessage) {
        logger.trace(traceType + " - " + traceMessage);
    }

}
