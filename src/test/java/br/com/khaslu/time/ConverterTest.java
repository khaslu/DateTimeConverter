package br.com.khaslu.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class ConverterTest.
 *
 * @author Lucas Mota Vieira
 * @since 12/04/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterTest {

	/** The logger. */
	private final Logger logger = Logger.getLogger(ConverterTest.class);

	/** The date. */
	private Date date;

	/** The calendar. */
	private Calendar calendar;

	/** The local date. */
	private LocalDate localDate;

	/** The local date time. */
	private LocalDateTime localDateTime;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		final long milliseconds = System.currentTimeMillis();
		this.logger.info("Milliseconds: " + milliseconds);

		this.date = new Date(milliseconds);
		this.logger.info("date: " + this.date);

		this.calendar = Calendar.getInstance();
		this.calendar.setTime(this.date);
		this.logger.info("calendar: " + this.calendar);

		this.localDate = this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.logger.info("localDate: " + this.localDate);

		this.localDateTime = this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		this.logger.info("localDateTime: " + this.localDateTime);

	}

	/**
	 * Local date to date.
	 */
	@Test
	public void localDateToDate() {
		final Calendar dateConvert = Calendar.getInstance();
		dateConvert.setTime(Converter.toDate(this.localDate, null));
		Assert.assertEquals(this.calendar.get(Calendar.DAY_OF_MONTH), dateConvert.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.MONTH), dateConvert.get(Calendar.MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.YEAR), dateConvert.get(Calendar.YEAR));
	}

	/**
	 * Local date time to date.
	 */
	@Test
	public void localDateTimeToDate() {
		Assert.assertEquals(this.date, Converter.toDate(this.localDateTime, null));
	}

	/**
	 * Calendar to date.
	 */
	@Test
	public void calendarToDate() {
		Assert.assertEquals(this.date, Converter.toDate(this.calendar, null));
	}

	/**
	 * Local date to calendar.
	 */
	@Test
	public void localDateToCalendar() {
		Assert.assertEquals(this.calendar.get(Calendar.DAY_OF_MONTH),
				Converter.toCalendar(this.localDate, null).get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.MONTH),
				Converter.toCalendar(this.localDate, null).get(Calendar.MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.YEAR),
				Converter.toCalendar(this.localDate, null).get(Calendar.YEAR));
	}

	/**
	 * Local date time to calendar.
	 */
	@Test
	public void localDateTimeToCalendar() {
		Assert.assertEquals(this.calendar, Converter.toCalendar(this.localDateTime, null));
	}

	/**
	 * Date to calendar.
	 */
	@Test
	public void dateToCalendar() {
		Assert.assertEquals(this.calendar, Converter.toCalendar(this.date, null));
	}

	/**
	 * Date to local date time.
	 */
	@Test
	public void dateToLocalDateTime() {
		Assert.assertEquals(this.localDateTime, Converter.toLocalDateTime(this.date, null));
	}

	/**
	 * Calendarto local date time.
	 */
	@Test
	public void calendartoLocalDateTime() {
		Assert.assertEquals(this.localDateTime, Converter.toLocalDateTime(this.calendar, null));
	}

	/**
	 * Local date to local date time.
	 */
	@Test
	public void localDateToLocalDateTime() {
		Assert.assertEquals(this.localDateTime.toLocalDate().atStartOfDay(),
				Converter.toLocalDateTime(this.localDate, null));
	}

	/**
	 * Date to local date.
	 */
	@Test
	public void dateToLocalDate() {
		Assert.assertEquals(this.localDate, Converter.toLocalDate(this.date, null));
	}

	/**
	 * Calendar to local date.
	 */
	@Test
	public void calendarToLocalDate() {
		Assert.assertEquals(this.localDate, Converter.toLocalDate(this.calendar, null));
	}

	/**
	 * Local date time to local date.
	 */
	@Test
	public void localDateTimeToLocalDate() {
		Assert.assertEquals(this.localDate, Converter.toLocalDate(this.localDateTime, null));
	}
}
