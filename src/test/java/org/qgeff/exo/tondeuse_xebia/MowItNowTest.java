package org.qgeff.exo.tondeuse_xebia;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MowItNowTest {

	@Parameters
	public static Collection<String[]> data() {
		return Arrays.asList(new String[][] { { "1 2 N", "GAGAGAGAA", "1 3 N"  }, { "3 3 E", "AADAADADDA", "5 1 E" } });
	}

	private final Integer MAX_X = 5;
	private final Integer MAX_Y = 5;
	
	private Mower mower;
	private String expected;
	private String actions;

	public MowItNowTest(String input, String actions, String expected) {
		this.mower = new Mower(input.split(" "));
		this.actions = actions;
		this.expected = expected;
	}

	@Test
	public void runIt() {
		Grid grid = new Grid(MAX_X, MAX_Y, mower);
		MowItNow mowIt = new MowItNow(grid);
		
		String result = mowIt.run(actions);
		
		Assertions.assertThat(result).isEqualTo(expected);
	}

}
