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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterTest {

	private final Logger logger = Logger.getLogger(ConverterTest.class);

	private Date date;
	private Calendar calendar;
	private LocalDate localDate;
	private LocalDateTime localDateTime;

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

	@Test
	public void localDateToDate() {
		final Calendar dateConvert = Calendar.getInstance();
		dateConvert.setTime(Converter.toDate(this.localDate, null));
		Assert.assertEquals(this.calendar.get(Calendar.DAY_OF_MONTH), dateConvert.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.MONTH), dateConvert.get(Calendar.MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.YEAR), dateConvert.get(Calendar.YEAR));
	}

	@Test
	public void localDateTimeToDate() {
		Assert.assertEquals(this.date, Converter.toDate(this.localDateTime, null));
	}

	@Test
	public void calendarToDate() {
		Assert.assertEquals(this.date, Converter.toDate(this.calendar, null));
	}

	@Test
	public void localDateToCalendar() {
		Assert.assertEquals(this.calendar.get(Calendar.DAY_OF_MONTH),
				Converter.toCalendar(this.localDate, null).get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.MONTH),
				Converter.toCalendar(this.localDate, null).get(Calendar.MONTH));
		Assert.assertEquals(this.calendar.get(Calendar.YEAR),
				Converter.toCalendar(this.localDate, null).get(Calendar.YEAR));
	}

	@Test
	public void localDateTimeToCalendar() {
		Assert.assertEquals(this.calendar, Converter.toCalendar(this.localDateTime, null));
	}

	@Test
	public void dateToCalendar() {
		Assert.assertEquals(this.calendar, Converter.toCalendar(this.date, null));
	}

	@Test
	public void dateToLocalDateTime() {
		Assert.assertEquals(this.localDateTime, Converter.toLocalDateTime(this.date, null));
	}

	@Test
	public void calendartoLocalDateTime() {
		Assert.assertEquals(this.localDateTime, Converter.toLocalDateTime(this.calendar, null));
	}

	@Test
	public void localDateToLocalDateTime() {
		Assert.assertEquals(this.localDateTime.toLocalDate().atStartOfDay(),
				Converter.toLocalDateTime(this.localDate, null));
	}

	@Test
	public void dateToLocalDate() {
		Assert.assertEquals(this.localDate, Converter.toLocalDate(this.date, null));
	}

	@Test
	public void calendarToLocalDate() {
		Assert.assertEquals(this.localDate, Converter.toLocalDate(this.calendar, null));
	}

	@Test
	public void localDateTimeToLocalDate() {
		Assert.assertEquals(this.localDate, Converter.toLocalDate(this.localDateTime, null));
	}
}
