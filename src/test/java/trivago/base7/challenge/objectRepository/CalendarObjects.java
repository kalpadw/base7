package trivago.base7.challenge.objectRepository;

/**
 * Class to store the objects relevant to the calendar
 */
public class CalendarObjects {
    public static final String CALENDAR_START_DATE = "//input[@id='cal-start']";
    public static final String CALENDAR_END_DATE = "//input[@id='cal-end']";
    public static final String DATE_PICKER = "//*[contains(@id,'ui-datepicker-div')]";
    public static final String DAY = "//*[contains(@class,'ui-datepicker-calendar')]/tbody/tr/td[.=";
    public static final String MONTH_IN_GRID = "//*[contains(@class,'month-h')]";
    public static final String GRID_BODY_DATES = "//*[contains(@id,'cal-body')]";
}
