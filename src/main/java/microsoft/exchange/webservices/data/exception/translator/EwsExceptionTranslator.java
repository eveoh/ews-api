package microsoft.exchange.webservices.data.exception.translator;

import microsoft.exchange.webservices.data.EWSHttpException;
import microsoft.exchange.webservices.data.ServiceResponseException;
import microsoft.exchange.webservices.data.exception.EwsException;
import microsoft.exchange.webservices.data.exception.HttpEwsException;
import microsoft.exchange.webservices.data.exception.serviceerrror.FolderNotFoundEwsException;
import microsoft.exchange.webservices.data.exception.serviceerrror.ItemNotFoundEwsException;
import microsoft.exchange.webservices.data.exception.serviceerrror.NonExistentMailboxEwsException;

public class EwsExceptionTranslator {

    public EwsException translate(Exception e) {
        if (e instanceof ServiceResponseException) {
            ServiceResponseException sre = (ServiceResponseException) e;

            switch (sre.getErrorCode()) {
                case ErrorFolderNotFound:       throw new FolderNotFoundEwsException(e);
                case ErrorItemNotFound:         throw new ItemNotFoundEwsException(e);
                case ErrorNonExistentMailbox:   throw new NonExistentMailboxEwsException(e);
            }
        } else if (e instanceof EWSHttpException) {
            throw new HttpEwsException(e);
        }

        throw new EwsException(e);
    }
}
