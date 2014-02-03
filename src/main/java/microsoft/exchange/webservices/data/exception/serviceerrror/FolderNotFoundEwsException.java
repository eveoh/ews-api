package microsoft.exchange.webservices.data.exception.serviceerrror;

import microsoft.exchange.webservices.data.exception.PemanentEwsException;

/**
 * Indicates that the folder ID that was passed in does not correspond to a valid folder, or that the delegate does not have permissions to access the folder.
 */
public class FolderNotFoundEwsException extends PemanentEwsException {

    public FolderNotFoundEwsException(Throwable cause) {
        super(cause);
    }
}
