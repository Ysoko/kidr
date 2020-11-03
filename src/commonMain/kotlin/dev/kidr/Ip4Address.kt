package dev.kidr

@ExperimentalUnsignedTypes
data class Ip4Address private constructor(private val uInt: UInt) {

    override fun toString(): String = uInt.toUByteArray().joinToString(".")

    fun toLong(): Long = this.uInt.toLong()

    companion object {
        val MIN_VALUE: Ip4Address = Ip4Address(UInt.MIN_VALUE)
        val MAX_VALUE: Ip4Address = Ip4Address(UInt.MAX_VALUE)

        fun parseOrNull(address: String): Ip4Address? = address
            .split(".")
            .map(String::toUInt)
            .map(UInt::toUByte)
            .toUByteArray()
            .toUInt()
            .let(::Ip4Address)

        fun parse(address: String): Ip4Address = parseOrNull(address) 
            ?: throw IllegalArgumentException("Could not parse Ip4Address from: $address")

        fun parseOrNull(address: Long): Ip4Address? = address.toUInt().let(::Ip4Address)

        fun parse(address: Long): Ip4Address? = parseOrNull(address)
            ?: throw IllegalArgumentException("Could not parse Ip4Address from: $address")
    }
}

@ExperimentalUnsignedTypes
private fun UInt.toUByteArray(): UByteArray = ubyteArrayOf(
    this.shr(24).and(255u).toUByte(),
    this.shr(16).and(255u).toUByte(),
    this.shr(8).and(255u).toUByte(),
    this.shr(0).and(255u).toUByte()
)

@ExperimentalUnsignedTypes
private fun UByteArray.toUInt(): UInt {
    var bitCount = size * 8 - 8
    return this
        .sumBy { 255u.and(it.toUInt()).shl(bitCount).also { bitCount -= 8 } }
}
