package net.twisterrob.ghlint.results

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LineNumberTest {

	@ValueSource(ints = [1, 42, Int.MAX_VALUE])
	@ParameterizedTest
	fun `created value works`(value: Int) {
		val subject = LineNumber(value)

		subject.number shouldBe value
	}

	@Test fun `0 is invalid`() {
		shouldThrowMessage("Line number must be positive: 0") {
			LineNumber(0)
		}
	}

	@ValueSource(ints = [-1, -42, Int.MIN_VALUE])
	@ParameterizedTest
	fun `negative numbers are invalid`(value: Int) {
		shouldThrowMessage("Line number must be positive: ${value}") {
			LineNumber(value)
		}
	}
}
