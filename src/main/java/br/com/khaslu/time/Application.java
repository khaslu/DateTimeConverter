package br.com.khaslu.time;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class Application.
 *
 * @author Lucas Mota Vieira
 * @since 12/04/2017
 */
@SpringBootApplication
public class Application implements ApplicationRunner {

	/** The logger. */
	private final Logger logger = Logger.getLogger(Application.class);

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(final String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Run.
	 *
	 * @param arg0
	 *            the arg 0
	 * @throws Exception
	 *             the exception
	 * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 */
	// SAMPLE
	@Override
	public void run(final ApplicationArguments arg0) throws Exception {
		final Calendar calendar = Calendar.getInstance();
		this.logger.info(Converter.toDate(calendar, new Date()));

		final LocalDate date = null;
		this.logger.info(Converter.toCalendar(date, Calendar.getInstance()));
	}

}
