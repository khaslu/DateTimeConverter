package br.com.khaslu.time;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {

	private final Logger logger = Logger.getLogger(Application.class);

	public static void main(final String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	// SAMPLE
	@Override
	public void run(final ApplicationArguments arg0) throws Exception {
		final Calendar calendar = Calendar.getInstance();
		this.logger.info(Converter.toDate(calendar, new Date()));

		final LocalDate date = null;
		this.logger.info(Converter.toCalendar(date, Calendar.getInstance()));
	}

}
