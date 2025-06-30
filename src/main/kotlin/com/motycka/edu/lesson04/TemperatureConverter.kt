package com.motycka.edu.lesson04

import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger { }

/**
 * Utility object for converting temperature values between Fahrenheit and Celsius
 */
object TemperatureConverter {
    private const val ABSOLUTE_ZERO_C = -273.15
    private const val ABSOLUTE_ZERO_F = -459.67
    /**
     * Converts temperature value given in Fahrenheit to Celsius
     *
     * @param fahrenheit temperature value in Fahrenheit
     * @return temperature value in Celsius
     * @see <a href="https://en.wikipedia.org/wiki/Fahrenheit">Fahrenheit</a>
     * @see <a href="https://en.wikipedia.org/wiki/Celsius">Celsius</a>
     */
    fun toCelsius(fahrenheit: Double): Double? {
        if (fahrenheit < ABSOLUTE_ZERO_F) {
            logger.warn { "Fahrenheit value $fahrenheit is below absolute zero ($ABSOLUTE_ZERO_F°F)." }
            return null
        }
        val result = (fahrenheit - 32) * 5 / 9
        logger.info { "Converted $fahrenheit°F to $result°C" }
        return result
    }

    /**
     * Converts temperature value given in Celsius to Fahrenheit
     *
     * @param celsius temperature value in Celsius
     * @return temperature value in Fahrenheit
     * @see <a href="https://en.wikipedia.org/wiki/Fahrenheit">Fahrenheit</a>
     * @see <a href="https://en.wikipedia.org/wiki/Celsius">Celsius</a>
     */
    fun toFahrenheit(celsius: Double): Double? {
        if (celsius < ABSOLUTE_ZERO_C) {
            logger.warn { "Celsius value $celsius is below absolute zero ($ABSOLUTE_ZERO_C°C)." }
            return null
        }
        val result = celsius * 9 / 5 + 32
        logger.info { "Converted $celsius°C to $result°F" }
        return result
    }

}


fun main() {
    TemperatureConverter.toFahrenheit(34.0).also(::println)
    TemperatureConverter.toCelsius(94.0).also(::println)
}

