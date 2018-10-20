package trivago.base7.challenge.objectRepository;

/**
 * Class to store the objects relevant to the reservation object
 */
public class ReservationObjects {
    public static final String RESERVATIONS_PAGE = "//*[@href='/reservations']";
    public static final String FIRST_RESERVATION = "//*[contains(@class,'flex')]/tbody/tr/td[contains(.,'FEDERER')]";
    public static final String RESERVATION_NAME = "//*[contains(@class,'form-regular')]/div[contains(@class,'box-title')]/div[contains(@class,'name')]";

}
