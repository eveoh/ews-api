/**************************************************************************
 * copyright file="TimeChangeRecurrence.java" company="Microsoft"
 *     Copyright (c) Microsoft Corporation.  All rights reserved.
 *
 * Defines the TimeChangeRecurrence.java.
 **************************************************************************/
package microsoft.exchange.webservices.data;

import javax.xml.stream.XMLStreamException;

/**
 * Represents a recurrence pattern for a time change in a time zone.
 */
final class TimeChangeRecurrence extends ComplexProperty {

    /**
     * The day of the week.
     */
    private DayOfTheWeek dayOfTheWeek;

    /**
     * The day of the week index.
     */
    private DayOfTheWeekIndex dayOfTheWeekIndex;

    /**
     * The month.
     */
    private Month month;

    /**
     * Initializes a new instance of the TimeChangeRecurrence class.
     */
    public TimeChangeRecurrence() {
        super();
    }

    /**
     * * Initializes a new instance of the TimeChangeRecurrence class.
     *
     * @param dayOfTheWeekIndex the day of the week index
     * @param dayOfTheWeek      the day of the week
     * @param month             the month
     */
    public TimeChangeRecurrence(DayOfTheWeekIndex dayOfTheWeekIndex, DayOfTheWeek dayOfTheWeek, Month month) {
        this();
        this.dayOfTheWeekIndex = dayOfTheWeekIndex;
        this.dayOfTheWeek = dayOfTheWeek;
        this.month = month;
    }

    /**
     * Gets the day of the week the time change occurs.
     *
     * @return the day of the week
     */
    public DayOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    /**
     * Sets the day of the week.
     *
     * @param dayOfTheWeek the new day of the week
     */
    public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
        if (this.canSetFieldValue(this.dayOfTheWeek, dayOfTheWeek)) {
            this.dayOfTheWeek = dayOfTheWeek;
            this.changed();
        }
    }

    /**
     * Gets the index of the day in the month at which the time change occurs.
     *
     * @return the day of the week index
     */
    public DayOfTheWeekIndex getDayOfTheWeekIndex() {
        return dayOfTheWeekIndex;
    }

    /**
     * Sets the day of the week index.
     *
     * @param dayOfTheWeekIndex the new day of the week index
     */
    public void setDayOfTheWeekIndex(DayOfTheWeekIndex dayOfTheWeekIndex) {
        if (this.canSetFieldValue(this.dayOfTheWeekIndex, dayOfTheWeekIndex)) {
            this.dayOfTheWeekIndex = dayOfTheWeekIndex;
            this.changed();
        }
    }

    /**
     * Gets the month the time change occurs.
     *
     * @return the month
     */
    public Month getMonth() {
        return month;
    }

    /**
     * Sets the month.
     *
     * @param month the new month
     */
    public void setMonth(Month month) {
        if (this.canSetFieldValue(this.month, month)) {
            this.month = month;
            this.changed();
        }
    }

    /**
     * * Writes elements to XML.
     *
     * @param writer the writer
     * @throws XMLStreamException the xML stream exception
     * @throws ServiceXmlSerializationException
     *                            the service xml serialization exception
     */
    protected void writeElementsToXml(EwsServiceXmlWriter writer) throws XMLStreamException,
            ServiceXmlSerializationException {
        if (this.dayOfTheWeek != null) {
            writer.writeElementValue(XmlNamespace.Types, XmlElementNames.DaysOfWeek, this.dayOfTheWeek);
        }

        if (this.dayOfTheWeekIndex != null) {
            writer.writeElementValue(XmlNamespace.Types, XmlElementNames.DayOfWeekIndex, this.dayOfTheWeekIndex);
        }

        if (this.month != null) {
            writer.writeElementValue(XmlNamespace.Types, XmlElementNames.Month, this.month);
        }
    }

    /**
     * * Tries to read element from XML.
     *
     * @param reader the reader
     * @return True if element was read.
     * @throws Exception the exception
     */
    protected boolean tryReadElementFromXml(EwsServiceXmlReader reader) throws Exception {
        if (reader.getLocalName().equalsIgnoreCase(XmlElementNames.DaysOfWeek)) {

            this.dayOfTheWeek = reader.readElementValue(DayOfTheWeek.class);
            return true;
        }
        else if (reader.getLocalName().equalsIgnoreCase(XmlElementNames.DayOfWeekIndex)) {
            this.dayOfTheWeekIndex = reader.readElementValue(DayOfTheWeekIndex.class);
            return true;
        }
        else if (reader.getLocalName().equalsIgnoreCase(XmlElementNames.Month)) {
            this.month = reader.readElementValue(Month.class);
            return true;
        }
        else {
            return false;
        }
    }
}
