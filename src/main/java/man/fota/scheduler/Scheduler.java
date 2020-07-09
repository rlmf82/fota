package man.fota.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import man.fota.service.CSVReaderService;

@Component
public class Scheduler{

	private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

	@Autowired
	private CSVReaderService readerService;
	
	@Scheduled(cron = "${cron.expression}")
	public void reportCurrentTime() {

		try {
			readerService.processFiles();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
}