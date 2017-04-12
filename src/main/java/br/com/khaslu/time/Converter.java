package br.com.khaslu.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Converter {

	private Converter() {
	}

	public static final Date toDate(final LocalDate date, final Date defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toDate(date.atStartOfDay(), defaultDate);
	}

	public static final Date toDate(final LocalDateTime date, final Date defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static final Date toDate(final Calendar date, final Date defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.getTime();
	}

	public static final Calendar toCalendar(final LocalDate date, final Calendar defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toCalendar(date.atStartOfDay(), defaultDate);
	}

	public static final Calendar toCalendar(final LocalDateTime date, final Calendar defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toCalendar(Date.from(date.atZone(ZoneId.systemDefault()).toInstant()), defaultDate);
	}

	public static final Calendar toCalendar(final Date date, final Calendar defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static final LocalDateTime toLocalDateTime(final Date date, final LocalDateTime defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static final LocalDateTime toLocalDateTime(final Calendar date, final LocalDateTime defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toLocalDateTime(date.getTime(), defaultDate);
	}

	public static final LocalDateTime toLocalDateTime(final LocalDate date, final LocalDateTime defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.atStartOfDay();
	}

	public static final LocalDate toLocalDate(final Date date, final LocalDate defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static final LocalDate toLocalDate(final Calendar date, final LocalDate defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return Converter.toLocalDate(date.getTime(), defaultDate);
	}

	public static final LocalDate toLocalDate(final LocalDateTime date, final LocalDate defaultDate) {
		if (Objects.isNull(date)) {
			return defaultDate;
		}
		return date.toLocalDate();
	}

}
