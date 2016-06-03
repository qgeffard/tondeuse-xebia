package org.qgeff.exo.tondeuse_xebia;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class MowItNowTest {
	private static Logger logger = LoggerFactory.getLogger(MowItNowTest.class);

	@Parameters
	public static Collection<String[]> data() {
		try {
			URL url = Thread.currentThread().getContextClassLoader().getResource("dataSet.csv");
			List<String> lines = FileUtils.readLines(new File(url.getPath()), Charset.forName("UTF-8"));
			List<String[]> csvData = new LinkedList<String[]>();
			Boolean firstLine = true;
			for (String line : lines) {
				if (firstLine) {
					firstLine = false;
					continue;
				}
				List<String> strArray = Arrays.asList(line.split(","));
				strArray.forEach(str -> str.replaceAll("\"", ""));
				csvData.add((String[]) strArray.toArray());
			}
			csvData.forEach(strArray -> Arrays.asList(strArray).forEach(str -> logger.trace(str)));
			return csvData;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return Arrays.asList(new String[][] { { "5 5", "1 2 N", "GAGAGAGAA", "1 3 N" }, { "5 5", "3 3 E", "AADAADADDA", "5 1 E" } });
	}

	private Integer maxX = 5;
	private Integer maxY = 5;
	private Mower   mower;
	private String  expected;
	private String  actions;

	public MowItNowTest(String maxXY, String mower, String actions, String expected) {
		this.maxX = Integer.parseInt(maxXY.split(" ")[0]);
		this.maxY = Integer.parseInt(maxXY.split(" ")[1]);
		this.mower = new Mower(mower.split(" "));
		this.actions = actions;
		this.expected = expected;
	}

	@Test
	public void runIt() {
		logger.debug("Start ");
		logger.debug("	Grid : {} en x, {} en y",maxX,maxY);
		logger.debug("	Mower start : {}", mower.toString());
		logger.debug("	Actions : {}", actions);
		
		Grid grid = new Grid(maxX, maxY, mower);
		MowItNow mowIt = new MowItNow(grid);

		String result = mowIt.run(actions);

		logger.debug("	Result : {}", result);
		logger.debug("	Expected : {}", expected);
		logger.debug("End ");
		Assertions.assertThat(result).isEqualTo(expected);
	}

}
