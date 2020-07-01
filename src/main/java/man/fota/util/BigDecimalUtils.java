package man.fota.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalUtils {

	public static BigDecimal format(BigDecimal value) {
		return new BigDecimal(NumberFormat.getInstance().format(value));
	}
	
}
