package com.View;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TablePrefTest extends TablePref {

	@Test
	void test() {
		Boolean b;
		for (int i = -5; i < 5; i++) {
			b = ValidateData("true", Integer.toString(i));
			if (i > 0)
				assertTrue(b);
			else
				assertFalse(b);
		}

	}

}
