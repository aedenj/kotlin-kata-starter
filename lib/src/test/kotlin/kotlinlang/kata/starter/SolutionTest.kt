package kotlinlang.kata.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("solution tests")
class SolutionTest {
    private val solution = Solution()

    @ParameterizedTest(name="{0} is {1}")
    @MethodSource("scenarios")
    fun test(input:Boolean, expected:Boolean) {
        assertThat(solution.kata(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun scenarios(): List<Arguments> {
            return listOf(
                Arguments.of(Named.of("true", true), Named.of("true", true))
            )
        }
    }
}
