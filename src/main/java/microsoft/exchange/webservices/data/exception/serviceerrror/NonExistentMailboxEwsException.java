package microsoft.exchange.webservices.data.exception.serviceerrror;

import microsoft.exchange.webservices.data.exception.PemanentEwsException;

/**
 * @author Erik van Paassen
 */
public class NonExistentMailboxEwsException extends PemanentEwsException {

    public NonExistentMailboxEwsException(Throwable cause) {
        super(cause);
    }
}
