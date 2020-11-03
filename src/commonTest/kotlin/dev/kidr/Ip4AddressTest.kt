package dev.kidr

import kotlin.test.Test
import kotlin.test.assertEquals

class Ip4AddressTest {
    @Test
    fun parseMinStringToIp4Address() {
        val input = "0.0.0.0"
        val expected = Ip4Address.MIN_VALUE
        val actual = Ip4Address.parse(input)
        assertEquals(expected, actual, "Could not parse $input to $expected")
    }

    @Test
    fun parseMaxStringToIp4Address() {
        val input = "255.255.255.255"
        val expected = Ip4Address.MAX_VALUE
        val actual = Ip4Address.parse(input)
        assertEquals(expected, actual, "Could not parse $input to $expected")
    }

    @Test
    fun minIp4AddressToString() {
        val input = Ip4Address.MIN_VALUE
        val expected = "0.0.0.0"
        val actual = input.toString()
        assertEquals(expected, actual, "Could not convert $input to $expected")
    }

    @Test
    fun maxIp4AddressToString() {
        val input = Ip4Address.MAX_VALUE
        val expected = "255.255.255.255"
        val actual = input.toString()
        assertEquals(expected, actual, "Could not convert $input to $expected")
    }

    @Test
    fun parseMinLongToIp4Address() {
        val input = 0L
        val expected = Ip4Address.MIN_VALUE
        val actual = Ip4Address.parse(input)
        assertEquals(expected, actual, "Could not parse $input to $expected")
    }

    @Test
    fun parseMaxLongToIp4Address() {
        val input = 4294967295L
        val expected = Ip4Address.MAX_VALUE
        val actual = Ip4Address.parse(input)
        assertEquals(expected, actual, "Could not parse $input to $expected")
    }

    @Test
    fun minIp4AddressToLong() {
        val input = Ip4Address.MIN_VALUE
        val expected = 0L
        val actual = input.toLong()
        assertEquals(expected, actual, "Could not convert $input to $expected")
    }

    @Test
    fun maxIp4AddressToLong() {
        val input = Ip4Address.MAX_VALUE
        val expected = 4294967295L
        val actual = input.toLong()
        assertEquals(expected, actual, "Could not convert $input to $expected")
    }
}
