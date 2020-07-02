package man.fota.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampUtils {

	public static String format(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
	}
	
}
