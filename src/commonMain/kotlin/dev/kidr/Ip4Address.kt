package dev.kidr

@ExperimentalUnsignedTypes
data class Ip4Address(val decimal: UInt) {
    override fun toString() = decimal.toUByteArray().joinToString(".")

    companion object {
        fun parse(address: String): Ip4Address? {
            return address
                .split(".")
                .mapNotNull(String::toUIntOrNull)
                .map(UInt::toUByte)
                .toUByteArray()
                .toUInt()
                .let(::Ip4Address)
        }
    }
}

@ExperimentalUnsignedTypes
internal fun UInt.toUByteArray(): UByteArray {
    return ubyteArrayOf(
        this.shr(24).and(255u).toUByte(),
        this.shr(16).and(255u).toUByte(),
        this.shr(8).and(255u).toUByte(),
        this.shr(0).and(255u).toUByte()
    )
}

@ExperimentalUnsignedTypes
internal fun UByteArray.toUInt(): UInt {
    var bitCount = size * 8 - 8
    return this
        .sumBy { 255u.and(it.toUInt()).shl(bitCount).also { bitCount -= 8 } }
}
