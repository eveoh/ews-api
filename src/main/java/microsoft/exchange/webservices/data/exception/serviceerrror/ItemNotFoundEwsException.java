package microsoft.exchange.webservices.data.exception.serviceerrror;

import microsoft.exchange.webservices.data.exception.PemanentEwsException;

/**
 * Indicates that the item was not found or you do not have rights to access the item.
 */
public class ItemNotFoundEwsException extends PemanentEwsException {

    public ItemNotFoundEwsException(Throwable cause) {
        super(cause);
    }
}
