package dev.kidr

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

@ExperimentalUnsignedTypes
class Ip4AddressTest : DescribeSpec({
    describe("toString") {
        it("when decimal is 0u, should be 0.0.0.0") {
            Ip4Address(decimal = 0u)
                .toString()
                .shouldBe("0.0.0.0")
        }
        it("when decimal is 1u, should be 0.0.0.1") {
            Ip4Address(decimal = 1u)
                .toString()
                .shouldBe("0.0.0.1")
        }
        it("when decimal is 2_147_483_647u, should be 127.255.255.255") {
            Ip4Address(decimal = 2_147_483_647u)
                .toString()
                .shouldBe("127.255.255.255")
        }
        it("when decimal is 4_294_967_294u, should be 255.255.255.254") {
            Ip4Address(decimal = 4_294_967_294u)
                .toString()
                .shouldBe("255.255.255.254")
        }
        it("when decimal is 4_294_967_295u, should be 255.255.255.255") {
            Ip4Address(decimal = 4_294_967_295u)
                .toString()
                .shouldBe("255.255.255.255")
        }
    }
    describe("parse") {
        it("when address is 0.0.0.0, should be Ip4Address(0u)") {
            Ip4Address.parse("0.0.0.0")
                .shouldBe(Ip4Address(0u))
        }
        it("when address is 0.0.0.1, should be Ip4Address(1u)") {
            Ip4Address.parse("0.0.0.1")
                .shouldBe(Ip4Address(1u))
        }
        it("when address is 255.255.255.254, should be Ip4Address(4_294_967_294u)") {
            Ip4Address.parse("255.255.255.254")
                .shouldBe(Ip4Address(4_294_967_294u))
        }
        it("when address is 255.255.255.255, should be Ip4Address(4_294_967_295u)") {
            Ip4Address.parse("255.255.255.255")
                .shouldBe(Ip4Address(4_294_967_295u))
        }
    }
})