package microsoft.exchange.webservices.data;

import microsoft.exchange.webservices.data.exception.translator.EwsExceptionTranslator;

import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * Represents a binding to the Exchange Web Services, but this only only throws runtime exceptions.
 */
public final class ExchangeServiceFacade {

    public final ExchangeService es;
    public final EwsExceptionTranslator ewsExceptionTranslator = new EwsExceptionTranslator();


    public ExchangeServiceFacade(ExchangeService es) {
        this.es = es;
    }

    private RuntimeException translateException(Exception e) {
        throw ewsExceptionTranslator.translate(e);
    }


    /**
     * Obtains a list of folders by searching the sub-folders of the specified folder.
     *
     * @param parentFolderId The Id of the folder in which to search for folders.
     * @param searchFilter   The search filter. Available search filter classes include SearchFilter.IsEqualTo,
     *                       SearchFilter.ContainsSubstring and SearchFilter.SearchFilterCollection
     * @param view           The view controlling the number of folders returned.
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindFoldersResults findFolders(FolderId parentFolderId, SearchFilter searchFilter, FolderView view) {
        try {
            return es.findFolders(parentFolderId, searchFilter, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of folders by searching the sub-folders of the specified folder.
     *
     * @param parentFolderId The Id of the folder in which to search for folders.
     * @param view           The view controlling the number of folders returned.
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindFoldersResults findFolders(FolderId parentFolderId, FolderView view) {
        try {
            return es.findFolders(parentFolderId, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of folders by searching the sub-folders of the specified folder.
     *
     * @param parentFolderName The name of the folder in which to search for folders.
     * @param searchFilter     The search filter. Available search filter classes include SearchFilter.IsEqualTo,
     *                         SearchFilter.ContainsSubstring and SearchFilter.SearchFilterCollection
     * @param view             The view controlling the number of folders returned.
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindFoldersResults findFolders(WellKnownFolderName parentFolderName, SearchFilter searchFilter,
                                          FolderView view) {
        try {
            return es.findFolders(parentFolderName, searchFilter, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Obtains a list of folders by searching the sub-folders of the specified folder.
     *
     * @param parentFolderName the parent folder name
     * @param view             the view
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindFoldersResults findFolders(WellKnownFolderName parentFolderName, FolderView view) {
        try {
            return es.findFolders(parentFolderName, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Creates multiple items in a single EWS call. Supported item classes are EmailMessage, Appointment, Contact,
     * PostItem, Task and Item. CreateItems does not support items that have unsaved attachments.
     *
     * @param items               the items
     * @param parentFolderId      the parent folder id
     * @param messageDisposition  the message disposition
     * @param sendInvitationsMode the send invitations mode
     * @return A ServiceResponseCollection providing creation results for each of the specified items.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<ServiceResponse> createItems(Collection<Item> items, FolderId parentFolderId,
                                                                  MessageDisposition messageDisposition,
                                                                  SendInvitationsMode sendInvitationsMode) {
        try {
            return es.createItems(items, parentFolderId, messageDisposition, sendInvitationsMode);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Updates multiple items in a single EWS call. UpdateItems does not support items that have unsaved attachments.
     *
     * @param items                         the items
     * @param savedItemsDestinationFolderId the saved items destination folder id
     * @param conflictResolution            the conflict resolution
     * @param messageDisposition            the message disposition
     * @param sendInvitationsOrCancellationsMode
     *                                      the send invitations or cancellations mode
     * @return A ServiceResponseCollection providing update results for each of the specified items.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<UpdateItemResponse> updateItems(Iterable<Item> items,
                                                                     FolderId savedItemsDestinationFolderId,
                                                                     ConflictResolutionMode conflictResolution,
                                                                     MessageDisposition messageDisposition,
                                                                     SendInvitationsOrCancellationsMode
                                                                             sendInvitationsOrCancellationsMode) {
        try {
            return es.updateItems(items, savedItemsDestinationFolderId, conflictResolution, messageDisposition, sendInvitationsOrCancellationsMode);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Copies multiple items in a single call to EWS.
     *
     * @param itemIds             the item ids
     * @param destinationFolderId the destination folder id
     * @return A ServiceResponseCollection providing copy results for each of the specified item Ids.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<MoveCopyItemResponse> copyItems(Iterable<ItemId> itemIds,
                                                                     FolderId destinationFolderId) {
        try {
            return es.copyItems(itemIds, destinationFolderId);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Copies multiple items in a single call to EWS.
     *
     * @param itemIds             The Ids of the items to copy.
     * @param destinationFolderId The Id of the folder to copy the items to.
     * @param returnNewItemIds    Flag indicating whether service should return new ItemIds or not.
     * @return A ServiceResponseCollection providing copy results for each of the specified item Ids.
     * @throws Exception
     */
    public ServiceResponseCollection<MoveCopyItemResponse> copyItems(Iterable<ItemId> itemIds,
                                                                     FolderId destinationFolderId,
                                                                     boolean returnNewItemIds) {
        try {
            return es.copyItems(itemIds, destinationFolderId, returnNewItemIds);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Moves multiple items in a single call to EWS.
     *
     * @param itemIds             the item ids
     * @param destinationFolderId the destination folder id
     * @return A ServiceResponseCollection providing copy results for each of the specified item Ids.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<MoveCopyItemResponse> moveItems(Iterable<ItemId> itemIds,
                                                                     FolderId destinationFolderId) {
        try {
            return es.moveItems(itemIds, destinationFolderId);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Moves multiple items in a single call to EWS.
     *
     * @param itemIds             The Ids of the items to move.
     * @param destinationFolderId The Id of the folder to move the items to.
     * @param returnNewItemIds    Flag indicating whether service should return new ItemIds or not.
     * @return A ServiceResponseCollection providing copy results for each of the specified item Ids.
     * @throws Exception
     */
    public ServiceResponseCollection<MoveCopyItemResponse> moveItems(Iterable<ItemId> itemIds,
                                                                     FolderId destinationFolderId,
                                                                     boolean returnNewItemIds) {
        try {
            return es.moveItems(itemIds, destinationFolderId, returnNewItemIds);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of items by searching the contents of a specific folder. Calling this method results in a call to
     * EWS.
     *
     * @param parentFolderId the parent folder id
     * @param queryString    the query string
     * @param view           the view
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindItemsResults<Item> findItems(FolderId parentFolderId, String queryString, ItemView view) {
        try {
            return es.findItems(parentFolderId, queryString, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of items by searching the contents of a specific folder. Calling this method results in a call to
     * EWS.
     *
     * @param parentFolderId the parent folder id
     * @param searchFilter   the search filter
     * @param view           the view
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindItemsResults<Item> findItems(FolderId parentFolderId, SearchFilter searchFilter, ItemView view) {
        try {
            return es.findItems(parentFolderId, searchFilter, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of items by searching the contents of a specific folder. Calling this method results in a call to
     * EWS.
     *
     * @param parentFolderId the parent folder id
     * @param view           the view
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindItemsResults<Item> findItems(FolderId parentFolderId, ItemView view) {
        try {
            return es.findItems(parentFolderId, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of items by searching the contents of a specific folder. Calling this method results in a call to
     * EWS.
     *
     * @param parentFolderName the parent folder name
     * @param queryString      the query string
     * @param view             the view
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindItemsResults<Item> findItems(WellKnownFolderName parentFolderName, String queryString,
                                            ItemView view) {
        try {
            return es.findItems(parentFolderName, queryString, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of items by searching the contents of a specific folder. Calling this method results in a call to
     * EWS.
     *
     * @param parentFolderName the parent folder name
     * @param searchFilter     the search filter
     * @param view             the view
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindItemsResults<Item> findItems(WellKnownFolderName parentFolderName, SearchFilter searchFilter,
                                            ItemView view) {
        try {
            return es.findItems(parentFolderName, searchFilter, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a list of items by searching the contents of a specific folder. Calling this method results in a call to
     * EWS.
     *
     * @param parentFolderName the parent folder name
     * @param view             the view
     * @return An object representing the results of the search operation.
     * @throws Exception the exception
     */
    public FindItemsResults<Item> findItems(WellKnownFolderName parentFolderName, ItemView view) {
        try {
            return es.findItems(parentFolderName, view);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a grouped list of items by searching the contents of a specific folder. Calling this method results in a
     * call to EWS.
     *
     * @param parentFolderId the parent folder id
     * @param queryString    the query string
     * @param view           the view
     * @param groupBy        the group by
     * @return A list of items containing the contents of the specified folder.
     * @throws Exception the exception
     */
    public GroupedFindItemsResults<Item> findItems(FolderId parentFolderId, String queryString, ItemView view,
                                                   Grouping groupBy) {
        try {
            return es.findItems(parentFolderId, queryString, view, groupBy);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a grouped list of items by searching the contents of a specific folder. Calling this method results in a
     * call to EWS.
     *
     * @param parentFolderId the parent folder id
     * @param searchFilter   the search filter
     * @param view           the view
     * @param groupBy        the group by
     * @return A list of items containing the contents of the specified folder.
     * @throws Exception the exception
     */
    public GroupedFindItemsResults<Item> findItems(FolderId parentFolderId, SearchFilter searchFilter, ItemView view,
                                                   Grouping groupBy) {
        try {
            return es.findItems(parentFolderId, searchFilter, view, groupBy);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a grouped list of items by searching the contents of a specific folder. Calling this method results in a
     * call to EWS.
     *
     * @param parentFolderId the parent folder id
     * @param view           the view
     * @param groupBy        the group by
     * @return A list of items containing the contents of the specified folder.
     * @throws Exception the exception
     */
    public GroupedFindItemsResults<Item> findItems(FolderId parentFolderId, ItemView view, Grouping groupBy) {
        try {
            return es.findItems(parentFolderId, view, groupBy);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a grouped list of items by searching the contents of a specific folder. Calling this method results in a
     * call to EWS.
     *
     * @param parentFolderName the parent folder name
     * @param queryString      the query string
     * @param view             the view
     * @param groupBy          the group by
     * @return A collection of grouped items containing the contents of the specified.
     * @throws Exception the exception
     */
    public GroupedFindItemsResults<Item> findItems(WellKnownFolderName parentFolderName, String queryString,
                                                   ItemView view, Grouping groupBy) {
        try {
            return es.findItems(parentFolderName, queryString, view, groupBy);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Obtains a grouped list of items by searching the contents of a specific folder. Calling this method results in a
     * call to EWS.
     *
     * @param parentFolderName the parent folder name
     * @param searchFilter     the search filter
     * @param view             the view
     * @param groupBy          the group by
     * @return A collection of grouped items containing the contents of the specified.
     * @throws Exception the exception
     */
    public GroupedFindItemsResults<Item> findItems(WellKnownFolderName parentFolderName, SearchFilter searchFilter,
                                                   ItemView view, Grouping groupBy) {
        return this.findItems(new FolderId(parentFolderName), searchFilter, view, groupBy);
    }

    /**
     * * Obtains a list of appointments by searching the contents of a specific folder. Calling this method results in a
     * call to EWS.
     *
     * @param parentFolderId the parent folder id
     * @param calendarView   the calendar view
     * @return A collection of appointments representing the contents of the specified folder.
     * @throws Exception the exception
     */
    public FindItemsResults<Appointment> findAppointments(FolderId parentFolderId, CalendarView calendarView) {
        try {
            return es.findAppointments(parentFolderId, calendarView);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Obtains a list of appointments by searching the contents of a specific folder. Calling this method results in a
     * call to EWS.
     *
     * @param parentFolderName the parent folder name
     * @param calendarView     the calendar view
     * @return A collection of appointments representing the contents of the specified folder.
     * @throws Exception the exception
     */
    public FindItemsResults<Appointment> findAppointments(WellKnownFolderName parentFolderName,
                                                          CalendarView calendarView) {
        try {
            return es.findAppointments(parentFolderName, calendarView);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Loads the properties of multiple items in a single call to EWS.
     *
     * @param items       the items
     * @param propertySet the property set
     * @return A ServiceResponseCollection providing results for each of the specified items.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<ServiceResponse> loadPropertiesForItems(Iterable<Item> items,
                                                                             PropertySet propertySet) {
        try {
            return es.loadPropertiesForItems(items, propertySet);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Binds to multiple items in a single call to EWS.
     *
     * @param itemIds     the item ids
     * @param propertySet the property set
     * @return A ServiceResponseCollection providing results for each of the specified item Ids.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<GetItemResponse> bindToItems(Iterable<ItemId> itemIds,
                                                                  PropertySet propertySet) {
        try {
            return es.bindToItems(itemIds, propertySet);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Deletes multiple items in a single call to EWS.
     *
     * @param itemIds                 the item ids
     * @param deleteMode              the delete mode
     * @param sendCancellationsMode   the send cancellations mode
     * @param affectedTaskOccurrences the affected task occurrences
     * @return A ServiceResponseCollection providing deletion results for each of the specified item Ids.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<ServiceResponse> deleteItems(Iterable<ItemId> itemIds, DeleteMode deleteMode,
                                                                  SendCancellationsMode sendCancellationsMode,
                                                                  AffectedTaskOccurrence affectedTaskOccurrences) {
        try {
            return es.deleteItems(itemIds, deleteMode, sendCancellationsMode, affectedTaskOccurrences);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Finds contacts in the user's Contacts folder and the Global Address List (in that order) that have names that
     * match the one passed as a parameter. Calling this method results in a call to EWS.
     *
     * @param nameToResolve the name to resolve
     * @return A collection of name resolutions whose names match the one passed as a parameter.
     * @throws Exception the exception
     */
    public NameResolutionCollection resolveName(String nameToResolve) {
        try {
            return es.resolveName(nameToResolve);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Finds contacts in the user's Contacts folder and the Global Address List (in that order) that have names that
     * match the one passed as a parameter. Calling this method results in a call to EWS.
     *
     * @param nameToResolve        the name to resolve
     * @param parentFolderIds      the parent folder ids
     * @param searchScope          the search scope
     * @param returnContactDetails the return contact details
     * @return A collection of name resolutions whose names match the one passed as a parameter.
     * @throws Exception the exception
     */
    public NameResolutionCollection resolveName(String nameToResolve, Iterable<FolderId> parentFolderIds,
                                                ResolveNameSearchLocation searchScope,
                                                boolean returnContactDetails) {
        try {
            return es.resolveName(nameToResolve, parentFolderIds, searchScope, returnContactDetails);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Finds contacts in the Global Address List and/or in specific contact folders that have names that match the one
     * passed as a parameter. Calling this method results in a call to EWS.
     *
     * @param nameToResolve          The name to resolve.
     * @param parentFolderIds        The Ids of the contact folders in which to look for matching contacts.
     * @param searchScope            The scope of the search.
     * @param returnContactDetails   Indicates whether full contact information should be returned for each of the found
     *                               contacts.
     * @param contactDataPropertySet The property set for the contact details
     * @throws Exception
     * @returns A collection of name resolutions whose names match the one passed as a parameter.
     */
    public NameResolutionCollection resolveName(String nameToResolve, Iterable<FolderId> parentFolderIds,
                                                ResolveNameSearchLocation searchScope, boolean returnContactDetails,
                                                PropertySet contactDataPropertySet) {
        try {
            return es.resolveName(nameToResolve, parentFolderIds, searchScope, returnContactDetails, contactDataPropertySet);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Finds contacts in the Global Address List that have names that match the one passed as a parameter. Calling this
     * method results in a call to EWS.
     *
     * @param nameToResolve          The name to resolve.
     * @param searchScope            The scope of the search.
     * @param returnContactDetails   Indicates whether full contact information should be returned for each of the found
     *                               contacts.
     * @param contactDataPropertySet The property set for the contact details
     * @throws Exception
     * @returns A collection of name resolutions whose names match the one passed as a parameter.
     */
    public NameResolutionCollection resolveName(String nameToResolve, ResolveNameSearchLocation searchScope,
                                                boolean returnContactDetails, PropertySet contactDataPropertySet) {
        try {
            return es.resolveName(nameToResolve, searchScope, returnContactDetails, contactDataPropertySet);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Finds contacts in the user's Contacts folder and the Global Address List (in that order) that have names that
     * match the one passed as a parameter. Calling this method results in a call to EWS.
     *
     * @param nameToResolve        the name to resolve
     * @param searchScope          the search scope
     * @param returnContactDetails the return contact details
     * @return A collection of name resolutions whose names match the one passed as a parameter.
     * @throws Exception the exception
     */
    public NameResolutionCollection resolveName(String nameToResolve, ResolveNameSearchLocation searchScope,
                                                boolean returnContactDetails) {
        try {
            return es.resolveName(nameToResolve, searchScope, returnContactDetails);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Expands a group by retrieving a list of its members. Calling this method results in a call to EWS.
     *
     * @param emailAddress the email address
     * @return URL of the Exchange Web Services.
     * @throws Exception the exception
     */
    public ExpandGroupResults expandGroup(EmailAddress emailAddress) {
        try {
            return es.expandGroup(emailAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Expands a group by retrieving a list of its members. Calling this method results in a call to EWS.
     *
     * @param groupId the group id
     * @return An ExpandGroupResults containing the members of the group.
     * @throws Exception the exception
     */
    public ExpandGroupResults expandGroup(ItemId groupId) {
        try {
            return es.expandGroup(groupId);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Expands a group by retrieving a list of its members. Calling this method results in a call to EWS.
     *
     * @param smtpAddress the smtp address
     * @return An ExpandGroupResults containing the members of the group.
     * @throws Exception the exception
     */
    public ExpandGroupResults expandGroup(String smtpAddress) {
        try {
            return es.expandGroup(smtpAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Expands a group by retrieving a list of its members. Calling this method results in a call to EWS.
     *
     * @param address     the address
     * @param routingType the routing type
     * @return An ExpandGroupResults containing the members of the group.
     * @throws Exception the exception
     */
    public ExpandGroupResults expandGroup(String address, String routingType) {
        try {
            return es.expandGroup(address, routingType);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Get the password expiration date
     *
     * @param mailboxSmtpAddress The e-mail address of the user.
     * @throws Exception
     * @returns The password expiration date
     */
    public Date getPasswordExpirationDate(String mailboxSmtpAddress) {
        try {
            return es.getPasswordExpirationDate(mailboxSmtpAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Subscribes to pull notifications. Calling this method results in a call to EWS.
     *
     * @param folderIds The Ids of the folder to subscribe to
     * @param timeout   The timeout, in minutes, after which the subscription expires. Timeout must be between 1 and
     *                  1440.
     * @param watermark An optional watermark representing a previously opened subscription.
     * @param EventType The event types to subscribe to.
     * @return A PullSubscription representing the new subscription.
     * @throws Exception
     */

    public PullSubscription subscribeToPullNotifications(Iterable<FolderId> folderIds, int timeout, String watermark,
                                                         EventType... eventTypes) {
        try {
            return es.subscribeToPullNotifications(folderIds, timeout, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to subscribes to pull notifications. Calling this method results in a call to EWS.
     *
     * @param callback   The AsyncCallback delegate.
     * @param state      An object that contains state information for this request.
     * @param folderIds  The Ids of the folder to subscribe to.
     * @param timeout    The timeout, in minutes, after which the subscription expires. Timeout must be between 1 and
     *                   1440.
     * @param watermark  An optional watermark representing a previously opened subscription.
     * @param eventTypes The event types to subscribe to.
     * @throws Exception
     * @returns An IAsyncResult that references the asynchronous request.
     */
    public AsyncRequestResult beginSubscribeToPullNotifications(AsyncCallback callback, Object state,
                                                                Iterable<FolderId> folderIds, int timeout,
                                                                String watermark, EventType... eventTypes) {
        try {
            return es.beginSubscribeToPullNotifications(callback, state, folderIds, timeout, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Subscribes to pull notifications on all folders in the authenticated user's mailbox. Calling this method
     * results
     * in a call to EWS.
     *
     * @param timeout    the timeout
     * @param watermark  the watermark
     * @param eventTypes the event types
     * @return A PullSubscription representing the new subscription.
     * @throws Exception the exception
     */
    public PullSubscription subscribeToPullNotificationsOnAllFolders(int timeout, String watermark,
                                                                     EventType... eventTypes) {
        try {
            return es.subscribeToPullNotificationsOnAllFolders(timeout, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to subscribe to pull notifications on all folders in the authenticated user's
     * mailbox. Calling this method results in a call to EWS.
     *
     * @param callback   The AsyncCallback delegate.
     * @param state      An object that contains state information for this request.
     * @param timeout    The timeout, in minutes, after which the subscription expires. Timeout must be between 1 and
     *                   1440.</param>
     * @param watermark  An optional watermark representing a previously opened subscription.
     * @param eventTypes The event types to subscribe to.
     * @throws Exception
     * @returns An IAsyncResult that references the asynchronous request.
     */
    public IAsyncResult beginSubscribeToPullNotificationsOnAllFolders(AsyncCallback callback, Object state, int timeout,
                                                                      String watermark, EventType... eventTypes) {
        try {
            return es.beginSubscribeToPullNotificationsOnAllFolders(callback, state, timeout, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Ends an asynchronous request to subscribe to pull notifications in the authenticated user's mailbox.
     *
     * @param asyncResult An IAsyncResult that references the asynchronous request.
     * @throws Exception
     * @returns A PullSubscription representing the new subscription.
     */
    public PullSubscription endSubscribeToPullNotifications(IAsyncResult asyncResult) {
        try {
            return es.endSubscribeToPullNotifications(asyncResult);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Subscribes to push notifications. Calling this method results in a call to EWS.
     *
     * @param folderIds  the folder ids
     * @param url        the url
     * @param frequency  the frequency
     * @param watermark  the watermark
     * @param eventTypes the event types
     * @return A PushSubscription representing the new subscription.
     * @throws Exception the exception
     */
    public PushSubscription subscribeToPushNotifications(Iterable<FolderId> folderIds, URI url, int frequency,
                                                         String watermark, EventType... eventTypes) {
        try {
            return es.subscribeToPushNotifications(folderIds, url, frequency, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to subscribe to push notifications. Calling this method results in a call to EWS.
     *
     * @param callback   The asynccallback delegate
     * @param state      An object that contains state information for this request
     * @param folderIds  The ids of the folder to subscribe
     * @param url        the url of web service endpoint the exchange server should
     * @param frequency  the frequency,in minutes at which the exchange server should contact the web Service endpoint.
     *                   Frequency must be between 1 and 1440.
     * @param watermark  An optional watermark representing a previously opened subscription
     * @param eventTypes The event types to subscribe to.
     * @return An IAsyncResult that references the asynchronous request.
     * @throws Exception
     * @throws Exception the exception
     */
    public IAsyncResult beginSubscribeToPushNotifications(AsyncCallback callback, Object state,
                                                          Iterable<FolderId> folderIds, URI url, int frequency,
                                                          String watermark, EventType... eventTypes) {
        try {
            return es.beginSubscribeToPushNotifications(callback, state, folderIds, url, frequency, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Subscribes to push notifications on all folders in the authenticated user's mailbox. Calling this method
     * results
     * in a call to EWS.
     *
     * @param url        the url
     * @param frequency  the frequency
     * @param watermark  the watermark
     * @param eventTypes the event types
     * @return A PushSubscription representing the new subscription.
     * @throws Exception the exception
     */
    public PushSubscription subscribeToPushNotificationsOnAllFolders(URI url, int frequency, String watermark,
                                                                     EventType... eventTypes) {
        try {
            return es.subscribeToPushNotificationsOnAllFolders(url, frequency, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to subscribe to push notifications on all folders in the authenticated user's
     * mailbox. Calling this method results in a call to EWS.
     *
     * @param callback   The asynccallback delegate
     * @param state      An object that contains state inforamtion for this request
     * @param url        the url
     * @param frequency  the frequency,in minutes at which the exchange server should contact the web Service endpoint.
     *                   Frequency must be between 1 and 1440.
     * @param watermark  An optional watermark representing a previously opened subscription
     * @param eventTypes The event types to subscribe to.
     * @return An IAsyncResult that references the asynchronous request.
     * @throws Exception
     */
    public IAsyncResult beginSubscribeToPushNotificationsOnAllFolders(AsyncCallback callback, Object state, URI url,
                                                                      int frequency, String watermark,
                                                                      EventType... eventTypes) {
        try {
            return es.beginSubscribeToPushNotificationsOnAllFolders(callback, state, url, frequency, watermark, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }


    /**
     * Ends an asynchronous request to subscribe to push notifications in the authenticated user's mailbox.
     *
     * @param asyncResult An IAsyncResult that references the asynchronous request.
     * @return A PushSubscription representing the new subscription
     * @throws Exception
     */
    public PushSubscription endSubscribeToPushNotifications(IAsyncResult asyncResult) {
        try {
            return es.endSubscribeToPushNotifications(asyncResult);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Subscribes to streaming notifications. Calling this method results in a call to EWS.
     *
     * @param folderIds The Ids of the folder to subscribe to.
     * @param EventType The event types to subscribe to.
     * @return A StreamingSubscription representing the new subscription
     * @throws Exception
     */
    public StreamingSubscription subscribeToStreamingNotifications(Iterable<FolderId> folderIds,
                                                                   EventType... eventTypes) {
        try {
            return es.subscribeToStreamingNotifications(folderIds, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Subscribes to streaming notifications on all folders in the authenticated user's mailbox. Calling this method
     * results in a call to EWS.
     *
     * @param eventTypes The event types to subscribe to.
     * @return A StreamingSubscription representing the new subscription.
     * @throws Exception
     */
    public StreamingSubscription subscribeToStreamingNotificationsOnAllFolders(EventType... eventTypes) {
        try {
            return es.subscribeToStreamingNotificationsOnAllFolders(eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to subscribe to streaming notifications. Calling this method results in a call to
     * EWS.
     *
     * @param callback  The AsyncCallback delegate
     * @param state     An object that contains state information for this request.
     * @param folderIds The Ids of the folder to subscribe to.
     * @param EventType The event types to subscribe to.
     * @return An IAsyncResult that references the asynchronous request
     * @throws Exception
     */
    public IAsyncResult beginSubscribeToStreamingNotifications(AsyncCallback callback, Object state,
                                                               Iterable<FolderId> folderIds,
                                                               EventType... eventTypes) {
        try {
            return es.beginSubscribeToStreamingNotifications(callback, state, folderIds, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to subscribe to streaming notifications on all folders in the authenticated user's
     * mailbox. Calling this method results in a call to EWS.
     *
     * @param callback   The AsyncCallback delegate
     * @param state      An object that contains state information for this request.
     * @param eventTypes
     * @throws Exception
     * @returns An IAsyncResult that references the asynchronous request.
     */
    public IAsyncResult beginSubscribeToStreamingNotificationsOnAllFolders(AsyncCallback callback, Object state,
                                                                           EventType... eventTypes) {
        try {
            return es.beginSubscribeToStreamingNotificationsOnAllFolders(callback, state, eventTypes);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Ends an asynchronous request to subscribe to push notifications in the authenticated user's mailbox.
     *
     * @param asyncResult An IAsyncResult that references the asynchronous request.
     * @return A streamingSubscription representing the new subscription
     * @throws Exception
     * @throws IndexOutOfBoundsException
     */

    public StreamingSubscription endSubscribeToStreamingNotifications(IAsyncResult asyncResult) {
        try {
            return es.endSubscribeToStreamingNotifications(asyncResult);
        } catch (Exception e) {
            throw translateException(e);
        }
    }


    /**
     * * Synchronizes the items of a specific folder. Calling this method results in a call to EWS.
     *
     * @param syncFolderId       The Id of the folder containing the items to synchronize with.
     * @param propertySet        The set of properties to retrieve for synchronized items.
     * @param ignoredItemIds     The optional list of item Ids that should be ignored.
     * @param maxChangesReturned The maximum number of changes that should be returned.
     * @param syncScope          The sync scope identifying items to include in the ChangeCollection.
     * @param syncState          The optional sync state representing the point in time when to start the
     *                           synchronization.
     *
     * @return A ChangeCollection containing a list of changes that occurred in the specified folder.
     * @throws Exception the exception
     */
    public ChangeCollection<ItemChange> syncFolderItems(FolderId syncFolderId, PropertySet propertySet,
                                                        Iterable<ItemId> ignoredItemIds, int maxChangesReturned,
                                                        SyncFolderItemsScope syncScope, String syncState) {
        try {
            return es.syncFolderItems(syncFolderId, propertySet, ignoredItemIds, maxChangesReturned, syncScope, syncState);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to synchronize the items of a specific folder. Calling this method results in a
     * call
     * to EWS.
     *
     * @param callback           The AsyncCallback delegate
     * @param state              An object that contains state information for this request
     * @param syncFolderId       The Id of the folder containing the items to synchronize with
     * @param propertySet        The set of properties to retrieve for synchronized items.
     * @param ignoredItemIds     The optional list of item Ids that should be ignored.
     * @param maxChangesReturned The maximum number of changes that should be returned.
     * @param syncScope          The sync scope identifying items to include in the ChangeCollection
     * @param syncState          The optional sync state representing the point in time when to start the
     *                           synchronization
     * @return An IAsyncResult that references the asynchronous request.
     * @throws Exception
     */
    public IAsyncResult beginSyncFolderItems(AsyncCallback callback, Object state, FolderId syncFolderId,
                                             PropertySet propertySet, Iterable<ItemId> ignoredItemIds,
                                             int maxChangesReturned, SyncFolderItemsScope syncScope,
                                             String syncState) {
        try {
            return es.beginSyncFolderItems(callback, state, syncFolderId, propertySet, ignoredItemIds, maxChangesReturned, syncScope, syncState);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Ends an asynchronous request to synchronize the items of a specific folder.
     *
     * @param asyncResult An IAsyncResult that references the asynchronous request.
     * @throws Exception
     * @returns A ChangeCollection containing a list of changes that occurred in the specified folder.
     */
    public ChangeCollection<ItemChange> endSyncFolderItems(IAsyncResult asyncResult) {
        try {
            return es.endSyncFolderItems(asyncResult);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Synchronizes the sub-folders of a specific folder. Calling this method results in a call to EWS.
     *
     * @param syncFolderId the sync folder id
     * @param propertySet  the property set
     * @param syncState    the sync state
     * @return A ChangeCollection containing a list of changes that occurred in the specified folder.
     * @throws Exception the exception
     */
    public ChangeCollection<FolderChange> syncFolderHierarchy(FolderId syncFolderId, PropertySet propertySet,
                                                              String syncState) {
        try {
            return es.syncFolderHierarchy(syncFolderId, propertySet, syncState);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Begins an asynchronous request to synchronize the sub-folders of a specific folder. Calling this method
     * results in a
     * call to EWS.
     *
     * @param callback     The AsyncCallback delegate
     * @param state        An object that contains state information for this request.
     * @param syncFolderId The Id of the folder containing the items to synchronize with. A null value indicates the
     *                     root
     *                     folder of the mailbox.
     * @param propertySet  The set of properties to retrieve for synchronized items.
     * @param syncState    The optional sync state representing the point in time when to start the synchronization.
     * @return An IAsyncResult that references the asynchronous request
     * @throws Exception
     */
    public IAsyncResult beginSyncFolderHierarchy(AsyncCallback callback, Object state, FolderId syncFolderId,
                                                 PropertySet propertySet, String syncState) {
        try {
            return es.beginSyncFolderHierarchy(callback, state, syncFolderId, propertySet, syncState);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Synchronizes the entire folder hierarchy of the mailbox this Service is connected to. Calling this method
     * results in
     * a call to EWS.
     *
     * @param propertySet The set of properties to retrieve for synchronized items.
     * @param syncState   The optional sync state representing the point in time when to start the synchronization.
     * @return A ChangeCollection containing a list of changes that occurred in the specified folder.
     * @throws Exception
     * @throws
     */
    public ChangeCollection<FolderChange> syncFolderHierarchy(PropertySet propertySet, String syncState) {
        try {
            return es.syncFolderHierarchy(propertySet, syncState);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Ends an asynchronous request to synchronize the specified folder hierarchy of the mailbox this Service is
     * connected
     * to.
     *
     * @param asyncResult An IAsyncResult that references the asynchronous request.
     * @throws Exception
     * @returns A ChangeCollection containing a list of changes that occurred in the specified folder.
     */
    public ChangeCollection<FolderChange> endSyncFolderHierarchy(IAsyncResult asyncResult) {
        try {
            return es.endSyncFolderHierarchy(asyncResult);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Gets Out of Office (OOF) settings for a specific user. Calling this method results in a call to EWS.
     *
     * @param smtpAddress the smtp address
     * @return An OofSettings instance containing OOF information for the specified user.
     * @throws Exception the exception
     */
    public OofSettings getUserOofSettings(String smtpAddress) {
        try {
            return es.getUserOofSettings(smtpAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Sets Out of Office (OOF) settings for a specific user. Calling this method results in a call to EWS.
     *
     * @param smtpAddress the smtp address
     * @param oofSettings the oof settings
     * @throws Exception the exception
     */
    public void setUserOofSettings(String smtpAddress, OofSettings oofSettings) {
        try {
            es.setUserOofSettings(smtpAddress, oofSettings);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Gets detailed information about the availability of a set of users, rooms,
     * and resources within a specified time
     * window.
     *
     * @param attendees     the attendees
     * @param timeWindow    the time window
     * @param requestedData the requested data
     * @param options       the options
     * @return The availability information for each user appears in a unique FreeBusyResponse object. The order of
     * users
     *         in the request determines the order of availability data for each user in the response.
     * @throws Exception the exception
     */
    public GetUserAvailabilityResults getUserAvailability(Iterable<AttendeeInfo> attendees, TimeWindow timeWindow,
                                                          AvailabilityData requestedData,
                                                          AvailabilityOptions options) {
        try {
            return es.getUserAvailability(attendees, timeWindow, requestedData, options);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Gets detailed information about the availability of a set of users, rooms,
     * and resources within a specified time
     * window.
     *
     * @param attendees     the attendees
     * @param timeWindow    the time window
     * @param requestedData the requested data
     * @return The availability information for each user appears in a unique FreeBusyResponse object. The order of
     * users
     *         in the request determines the order of availability data for each user in the response.
     * @throws Exception the exception
     */
    public GetUserAvailabilityResults getUserAvailability(Iterable<AttendeeInfo> attendees, TimeWindow timeWindow,
                                                          AvailabilityData requestedData) {
        try {
            return es.getUserAvailability(attendees, timeWindow, requestedData);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Retrieves a collection of all room lists in the organization.
     *
     * @return An EmailAddressCollection containing all the room lists in the organization
     * @throws Exception the exception
     */
    public EmailAddressCollection getRoomLists() {
        try {
            return es.getRoomLists();
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Retrieves a collection of all room lists in the specified room list in the organization.
     *
     * @param emailAddress the email address
     * @return A collection of EmailAddress objects representing all the rooms within the specifed room list.
     * @throws Exception the exception
     */
    public Collection<EmailAddress> getRooms(EmailAddress emailAddress) {
        try {
            return es.getRooms(emailAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Retrieves a collection of all Conversations in the specified Folder.
     *
     * @param view     The view controlling the number of conversations returned.
     * @param folderId The Id of the folder in which to search for conversations.
     * @throws Exception
     */
    public Collection<Conversation> findConversation(ConversationIndexedItemView view, FolderId folderId) {
        try {
            return es.findConversation(view, folderId);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Sets up a conversation so that any item received within that conversation is always categorized. Calling this
     * method
     * results in a call to EWS.
     *
     * @param conversationId       The id of the conversation.
     * @param categories           The categories that should be stamped on items in the conversation.
     * @param processSynchronously Indicates whether the method should return only once enabling this rule and stamping
     *                             existing items in the conversation is completely done. If processSynchronously is
     *                             false,
     *                             the method returns immediately.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> enableAlwaysCategorizeItemsInConversations(
            Iterable<ConversationId> conversationId, Iterable<String> categories, boolean processSynchronously) {
        try {
            return es.enableAlwaysCategorizeItemsInConversations(conversationId, categories, processSynchronously);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Sets up a conversation so that any item received within that conversation is no longer categorized. Calling this
     * method results in a call to EWS.
     *
     * @param conversationId       The id of the conversation.
     * @param processSynchronously Indicates whether the method should return only once enabling this rule and stamping
     *                             existing items in the conversation is completely done. If processSynchronously is
     *                             false,
     *                             the method returns immediately.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> disableAlwaysCategorizeItemsInConversations(
            Iterable<ConversationId> conversationId, boolean processSynchronously) {
        try {
            return es.disableAlwaysCategorizeItemsInConversations(conversationId, processSynchronously);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Sets up a conversation so that any item received within that conversation is always moved to Deleted Items
     * folder.
     * Calling this method results in a call to EWS.
     *
     * @param conversationId       The id of the conversation.
     * @param processSynchronously Indicates whether the method should return only once enabling this rule and stamping
     *                             existing items in the conversation is completely done. If processSynchronously is
     *                             false,
     *                             the method returns immediately.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> enableAlwaysDeleteItemsInConversations(
            Iterable<ConversationId> conversationId, boolean processSynchronously) {
        try {
            return es.enableAlwaysDeleteItemsInConversations(conversationId, processSynchronously);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Sets up a conversation so that any item received within that conversation is no longer moved to Deleted Items
     * folder. Calling this method results in a call to EWS.
     *
     * @param conversationId       The id of the conversation.
     * @param processSynchronously Indicates whether the method should return only once enabling this rule and stamping
     *                             existing items in the conversation is completely done. If processSynchronously is
     *                             false,
     *                             the method returns immediately.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> disableAlwaysDeleteItemsInConversations(
            Iterable<ConversationId> conversationId, boolean processSynchronously) {
        try {
            return es.disableAlwaysDeleteItemsInConversations(conversationId, processSynchronously);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Sets up a conversation so that any item received within that conversation is always moved to a specific folder.
     * Calling this method results in a call to EWS.
     *
     * @param conversationId       The Id of the folder to which conversation items should be moved.
     * @param destinationFolderId  The Id of the destination folder.
     * @param processSynchronously Indicates whether the method should return only once enabling this rule and stamping
     *                             existing items in the conversation is completely done. If processSynchronously is
     *                             false,
     *                             the method returns immediately.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> enableAlwaysMoveItemsInConversations(
            Iterable<ConversationId> conversationId, FolderId destinationFolderId, boolean processSynchronously) {
        try {
            return es.enableAlwaysMoveItemsInConversations(conversationId, destinationFolderId, processSynchronously);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Sets up a conversation so that any item received within that conversation is no longer moved to a specific
     * folder.
     * Calling this method results in a call to EWS.
     *
     * @param conversationIds      The conversation ids.
     * @param processSynchronously Indicates whether the method should return only once disabling this rule is
     *                             completely
     *                             done. If processSynchronously is false, the method returns immediately.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> disableAlwaysMoveItemsInConversations(
            Iterable<ConversationId> conversationIds, boolean processSynchronously) {
        try {
            return es.disableAlwaysMoveItemsInConversations(conversationIds, processSynchronously);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Moves the items in the specified conversation to the specified destination folder. Calling this method results
     * in a
     * call to EWS.
     *
     * @param idLastSyncTimePairs The pairs of Id of conversation whose items should be moved and the dateTime
     *                            conversation
     *                            was last synced (Items received after that dateTime will not be moved).
     * @param contextFolderId     The Id of the folder that contains the conversation.
     * @param destinationFolderId The Id of the destination folder.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> moveItemsInConversations(
            Iterable<HashMap<ConversationId, Date>> idLastSyncTimePairs, FolderId contextFolderId,
            FolderId destinationFolderId) {
        try {
            return es.moveItemsInConversations(idLastSyncTimePairs, contextFolderId, destinationFolderId);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Copies the items in the specified conversation to the specified destination folder. Calling this method
     * results in a
     * call to EWS.
     *
     * @param idLastSyncTimePairs The pairs of Id of conversation whose items should be copied and the dateTime
     *                            conversation was last synced (Items received after that dateTime will not be copied).
     * @param contextFolderId     The context folder id.
     * @param destinationFolderId The destination folder id.
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> copyItemsInConversations(
            Iterable<HashMap<ConversationId, Date>> idLastSyncTimePairs, FolderId contextFolderId,
            FolderId destinationFolderId) {
        try {
            return es.copyItemsInConversations(idLastSyncTimePairs, contextFolderId, destinationFolderId);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Deletes the items in the specified conversation. Calling this method results in a call to EWS.
     *
     * @param idLastSyncTimePairs The pairs of Id of conversation whose items should be deleted and the date and time
     *                            conversation was last synced (Items received after that date will not be deleted).
     *                            conversation was last synced (Items received after that dateTime will not be copied).
     * @param contextFolderId     The Id of the folder that contains the conversation.
     * @param deleteMode          The deletion mode
     * @throws Exception
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> deleteItemsInConversations(
            Iterable<HashMap<ConversationId, Date>> idLastSyncTimePairs, FolderId contextFolderId,
            DeleteMode deleteMode) {
        try {
            return es.deleteItemsInConversations(idLastSyncTimePairs, contextFolderId, deleteMode);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Sets the read state for items in conversation. Calling this mehtod would result in call to EWS.
     *
     * @param idLastSyncTimePairs The pairs of Id of conversation whose items should read state set and the date and
     *                            time
     *                            conversation was last synced (Items received after that date will not have their read
     *                            state set). was last synced (Items received after that date will not be deleted).
     *                            conversation was last synced (Items received after that dateTime will not be copied).
     * @param contextFolderId     The Id of the folder that contains the conversation.
     * @param isRead              if set to <c>true</c>, conversation items are marked as read; otherwise they are
     *                            marked
     *                            as unread.
     * @throws Exception
     * @throws Exception
     */
    public ServiceResponseCollection<ServiceResponse> setReadStateForItemsInConversations(
            Iterable<HashMap<ConversationId, Date>> idLastSyncTimePairs, FolderId contextFolderId,
            boolean isRead) {
        try {
            return es.setReadStateForItemsInConversations(idLastSyncTimePairs, contextFolderId, isRead);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    // Id conversion operations

    /**
     * * Converts multiple Ids from one format to another in a single call to EWS.
     *
     * @param ids               the ids
     * @param destinationFormat the destination format
     * @return A ServiceResponseCollection providing conversion results for each specified Ids.
     * @throws Exception the exception
     */
    public ServiceResponseCollection<ConvertIdResponse> convertIds(Iterable<AlternateIdBase> ids,
                                                                   IdFormat destinationFormat) {
        try {
            return es.convertIds(ids, destinationFormat);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Converts Id from one format to another in a single call to EWS.
     *
     * @param id                the id
     * @param destinationFormat the destination format
     * @return The converted Id.
     * @throws Exception the exception
     */
    public AlternateIdBase convertId(AlternateIdBase id, IdFormat destinationFormat) {
        try {
            return es.convertId(id, destinationFormat);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Adds delegates to a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox                      the mailbox
     * @param meetingRequestsDeliveryScope the meeting requests delivery scope
     * @param delegateUsers                the delegate users
     * @return A collection of DelegateUserResponse objects providing the results of the operation.
     * @throws Exception the exception
     */
    public Collection<DelegateUserResponse> addDelegates(Mailbox mailbox,
                                                         MeetingRequestsDeliveryScope meetingRequestsDeliveryScope,
                                                         DelegateUser... delegateUsers) {
        try {
            return es.addDelegates(mailbox, meetingRequestsDeliveryScope, delegateUsers);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Adds delegates to a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox                      the mailbox
     * @param meetingRequestsDeliveryScope the meeting requests delivery scope
     * @param delegateUsers                the delegate users
     * @return A collection of DelegateUserResponse objects providing the results of the operation.
     * @throws Exception the exception
     */
    public Collection<DelegateUserResponse> addDelegates(Mailbox mailbox,
                                                         MeetingRequestsDeliveryScope meetingRequestsDeliveryScope,
                                                         Iterable<DelegateUser> delegateUsers) {
        try {
            return es.addDelegates(mailbox, meetingRequestsDeliveryScope, delegateUsers);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Updates delegates on a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox                      the mailbox
     * @param meetingRequestsDeliveryScope the meeting requests delivery scope
     * @param delegateUsers                the delegate users
     * @return A collection of DelegateUserResponse objects providing the results of the operation.
     * @throws Exception the exception
     */
    public Collection<DelegateUserResponse> updateDelegates(Mailbox mailbox,
                                                            MeetingRequestsDeliveryScope meetingRequestsDeliveryScope,
                                                            DelegateUser... delegateUsers) {
        try {
            return es.updateDelegates(mailbox, meetingRequestsDeliveryScope, delegateUsers);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Updates delegates on a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox                      the mailbox
     * @param meetingRequestsDeliveryScope the meeting requests delivery scope
     * @param delegateUsers                the delegate users
     * @return A collection of DelegateUserResponse objects providing the results of the operation.
     * @throws Exception the exception
     */
    public Collection<DelegateUserResponse> updateDelegates(Mailbox mailbox,
                                                            MeetingRequestsDeliveryScope meetingRequestsDeliveryScope,
                                                            Iterable<DelegateUser> delegateUsers) {
        try {
            return es.updateDelegates(mailbox, meetingRequestsDeliveryScope, delegateUsers);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Removes delegates on a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox the mailbox
     * @param userIds the user ids
     * @return A collection of DelegateUserResponse objects providing the results of the operation.
     * @throws Exception the exception
     */
    public Collection<DelegateUserResponse> removeDelegates(Mailbox mailbox, UserId... userIds) {
        try {
            return es.removeDelegates(mailbox, userIds);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Removes delegates on a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox the mailbox
     * @param userIds the user ids
     * @return A collection of DelegateUserResponse objects providing the results of the operation.
     * @throws Exception the exception
     */
    public Collection<DelegateUserResponse> removeDelegates(Mailbox mailbox, Iterable<UserId> userIds) {
        try {
            return es.removeDelegates(mailbox, userIds);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Retrieves the delegates of a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox            the mailbox
     * @param includePermissions the include permissions
     * @param userIds            the user ids
     * @return A GetDelegateResponse providing the results of the operation.
     * @throws Exception the exception
     */
    public DelegateInformation getDelegates(Mailbox mailbox, boolean includePermissions, UserId... userIds) {
        try {
            return es.getDelegates(mailbox, includePermissions, userIds);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * * Retrieves the delegates of a specific mailbox. Calling this method results in a call to EWS.
     *
     * @param mailbox            the mailbox
     * @param includePermissions the include permissions
     * @param userIds            the user ids
     * @return A GetDelegateResponse providing the results of the operation.
     * @throws Exception the exception
     */
    public DelegateInformation getDelegates(Mailbox mailbox, boolean includePermissions,
                                            Iterable<UserId> userIds) {
        try {
            return es.getDelegates(mailbox, includePermissions, userIds);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    // region InboxRule operations

    /**
     * Retrieves inbox rules of the authenticated user.
     *
     * @return A RuleCollection object containing the authenticated users inbox rules.
     * @throws Exception
     */
    public RuleCollection getInboxRules() {
        try {
            return es.getInboxRules();
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Retrieves the inbox rules of the specified user.
     *
     * @param mailboxSmtpAddress The SMTP address of the user whose inbox rules should be retrieved
     * @return A RuleCollection object containing the inbox rules of the specified user.
     * @throws Exception
     */
    public RuleCollection getInboxRules(String mailboxSmtpAddress) {
        try {
            return es.getInboxRules(mailboxSmtpAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Updates the authenticated user's inbox rules by applying the specified operations.
     *
     * @param operations            The operations that should be applied to the user's inbox rules.
     * @param removeOutlookRuleBlob Indicate whether or not to remove Outlook Rule Blob.
     * @throws Exception
     */
    public void updateInboxRules(Iterable<RuleOperation> operations, boolean removeOutlookRuleBlob) {
        try {
            es.updateInboxRules(operations, removeOutlookRuleBlob);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Updates the authenticated user's inbox rules by applying the specified operations.
     *
     * @param operations            The operations that should be applied to the user's inbox rules.
     * @param removeOutlookRuleBlob Indicate whether or not to remove Outlook Rule Blob.
     * @param mailboxSmtpAddress    The SMTP address of the user whose inbox rules should be retrieved
     * @throws Exception
     */
    public void updateInboxRules(Iterable<RuleOperation> operations, boolean removeOutlookRuleBlob,
                                 String mailboxSmtpAddress) {
        try {
            es.updateInboxRules(operations, removeOutlookRuleBlob, mailboxSmtpAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Initializes the Url property to the Exchange Web Services URL for the specified e-mail address by calling the
     * Autodiscover service.
     *
     * @param emailAddress the email address
     * @throws Exception the exception
     */
    public void autodiscoverUrl(String emailAddress) {
        try {
            es.autodiscoverUrl(emailAddress);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Initializes the Url property to the Exchange Web Services URL for the specified e-mail address by calling the
     * Autodiscover service.
     *
     * @param emailAddress                   the email address to use.
     * @param validateRedirectionUrlCallback The callback used to validate redirection URL
     * @throws Exception the exception
     */
    public void autodiscoverUrl(String emailAddress, IAutodiscoverRedirectionUrl validateRedirectionUrlCallback) {
        try {
            es.autodiscoverUrl(emailAddress, validateRedirectionUrlCallback);
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    // Properties

    /**
     * Gets the URL of the Exchange Web Services.
     *
     * @return URL of the Exchange Web Services.
     */
    public URI getUrl() {
        return es.getUrl();
    }

    /**
     * Sets the URL of the Exchange Web Services.
     *
     * @param url URL of the Exchange Web Services.
     */
    public void setUrl(URI url) {
        es.setUrl(url);
    }

    /**
     * Gets the impersonated user id.
     *
     * @return the impersonated user id
     */
    public ImpersonatedUserId getImpersonatedUserId() {
        return es.getImpersonatedUserId();
    }

    /**
     * Sets the impersonated user id.
     *
     * @param impersonatedUserId the new impersonated user id
     */
    public void setImpersonatedUserId(ImpersonatedUserId impersonatedUserId) {
        es.getImpersonatedUserId();
    }

    /**
     * Gets the preferred culture.
     *
     * @return the preferred culture
     */
    public Locale getPreferredCulture() {
        return es.getPreferredCulture();
    }

    /**
     * Sets the preferred culture.
     *
     * @param preferredCulture the new preferred culture
     */
    public void setPreferredCulture(Locale preferredCulture) {
        es.setPreferredCulture(preferredCulture);
    }

    /**
     * Gets the DateTime precision for DateTime values returned from Exchange Web Services.
     *
     * @return the DateTimePrecision
     */
    public DateTimePrecision getDateTimePrecision() {
        return es.getDateTimePrecision();
    }

    /**
     * Sets the DateTime precision for DateTime values Web Services.
     *
     * @return the DateTimePrecision
     */
    public void setDateTimePrecision(DateTimePrecision d) {
        es.setDateTimePrecision(d);
    }

    /**
     * Sets the DateTime precision for DateTime values returned from Exchange Web Services.
     *
     * @param DateTimePrecisione the new DateTimePrecision
     */
    public void setPreferredCulture(DateTimePrecision dateTimePrecision) {
        es.setPreferredCulture(dateTimePrecision);
    }

    /**
     * Gets the file attachment content handler.
     *
     * @return the file attachment content handler
     */
    public IFileAttachmentContentHandler getFileAttachmentContentHandler() {
        return es.getFileAttachmentContentHandler();
    }

    /**
     * Sets the file attachment content handler.
     *
     * @param fileAttachmentContentHandler the new file attachment content handler
     */
    public void setFileAttachmentContentHandler(IFileAttachmentContentHandler fileAttachmentContentHandler) {
        es.setFileAttachmentContentHandler(fileAttachmentContentHandler);
    }

    /**
     * Gets the time zone this service is scoped to.
     *
     * @return the unified messaging
     */
    // public TimeZone getTimeZone() { return es.getTimeZone(); }

    /**
     * * Provides access to the Unified Messaging functionalities.
     *
     * @return the unified messaging
     */
    public UnifiedMessaging getUnifiedMessaging() {
        return es.getUnifiedMessaging();
    }

    /**
     * Gets or sets a value indicating whether the AutodiscoverUrl method should perform SCP (Service Connection Point)
     * record lookup when determining the Autodiscover service URL.
     */
    public boolean getEnableScpLookup() {
        return es.getEnableScpLookup();
    }

    public void setEnableScpLookup(boolean value) {
        es.setEnableScpLookup(value);
    }

    /**
     * Gets or sets a value indicating whether Exchange2007 compatibility mode is enabled. <remarks> In order to support
     * E12 servers, the Exchange2007CompatibilityMode property can be used to indicate that we should use "Exchange2007" as
     * the server version String rather than Exchange2007_SP1. </remarks>
     */
    protected boolean getExchange2007CompatibilityMode() {
        return es.getExchange2007CompatibilityMode();
    }

    protected void setExchange2007CompatibilityMode(boolean value) {
        es.setExchange2007CompatibilityMode(value);
    }

    /**
     * * Retrieves the definitions of the specified server-side time zones.
     *
     * @param timeZoneIds the time zone ids
     * @return A Collection containing the definitions of the specified time zones.
     */
    public Collection<TimeZoneDefinition> getServerTimeZones(Iterable<String> timeZoneIds) {
        return es.getServerTimeZones(timeZoneIds);
    }

    /**
     * Retrieves the definitions of all server-side time zones.
     *
     * @return A Collection containing the definitions of the specified time zones.
     */
    public Collection<TimeZoneDefinition> getServerTimeZones() {
        return es.getServerTimeZones();
    }

    /*
     * (non-Javadoc)
     *
     * @seemicrosoft.exchange.webservices.AutodiscoverRedirectionUrlInterface#
     * autodiscoverRedirectionUrlValidationCallback(java.lang.String)
     */
    public boolean autodiscoverRedirectionUrlValidationCallback(String redirectionUrl) {
        return es.autodiscoverRedirectionUrlValidationCallback(redirectionUrl);
    }

}
