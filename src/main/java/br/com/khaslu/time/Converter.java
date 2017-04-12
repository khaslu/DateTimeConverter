package br.com.khaslu.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * The Class Converter.
 *
 * @author Lucas Mota Vieira
 * @since 12/04/2017
 */
public class Converter {

	/**
	 * Instantiates a new converter.
	 */
	private Converter() {
	}

	/**
	 * To date.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the date
	 */
	public static final Date toDate(final LocalDate date, final Date defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toDate(date.atStartOfDay(), defaultDate);
	}

	/**
	 * To date.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the date
	 */
	public static final Date toDate(final LocalDateTime date, final Date defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * To date.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the date
	 */
	public static final Date toDate(final Calendar date, final Date defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.getTime();
	}

	/**
	 * To calendar.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the calendar
	 */
	public static final Calendar toCalendar(final LocalDate date, final Calendar defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toCalendar(date.atStartOfDay(), defaultDate);
	}

	/**
	 * To calendar.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the calendar
	 */
	public static final Calendar toCalendar(final LocalDateTime date, final Calendar defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toCalendar(Date.from(date.atZone(ZoneId.systemDefault()).toInstant()), defaultDate);
	}

	/**
	 * To calendar.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the calendar
	 */
	public static final Calendar toCalendar(final Date date, final Calendar defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * To local date time.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the local date time
	 */
	public static final LocalDateTime toLocalDateTime(final Date date, final LocalDateTime defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * To local date time.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the local date time
	 */
	public static final LocalDateTime toLocalDateTime(final Calendar date, final LocalDateTime defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toLocalDateTime(date.getTime(), defaultDate);
	}

	/**
	 * To local date time.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the local date time
	 */
	public static final LocalDateTime toLocalDateTime(final LocalDate date, final LocalDateTime defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.atStartOfDay();
	}

	/**
	 * To local date.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the local date
	 */
	public static final LocalDate toLocalDate(final Date date, final LocalDate defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * To local date.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the local date
	 */
	public static final LocalDate toLocalDate(final Calendar date, final LocalDate defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toLocalDate(date.getTime(), defaultDate);
	}

	/**
	 * To local date.
	 *
	 * @param date
	 *            the date
	 * @param defaultDate
	 *            the default date
	 * @return the local date
	 */
	public static final LocalDate toLocalDate(final LocalDateTime date, final LocalDate defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.toLocalDate();
	}

}
