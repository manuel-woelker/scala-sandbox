package scala.sandbox.tests;

import org.junit._;
import Assert._;


class MonadTest {
	@Test def sample() {
	    assertEquals(42, 6*7)
	  }
	@Test def sample2() {
	    assertEquals(List("foo", "bar"),List("foo", "bar"))
	    assertEquals(List("oof", "rab"),List("foo", "bar").map(_.reverse))
	  }

}
