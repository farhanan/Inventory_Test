package com.farhan.test.util

import android.util.Patterns
import java.text.DecimalFormat
import java.text.NumberFormat

const val emptyString = ""
const val emptyInt = -1
const val emptyFloat = 0F
const val emptyLong = 0L
const val emptyDouble = 0.0
const val emptyBoolean = false

/**
 * Proceed and Return Non-Null Value of Nullable String
 * @param default is the replacement of nullable value of any word in the string
 * @param condition is the condition which nullable can be replaced with non-null value
 * @return [String]
 */
fun String?.orEmpty(
        default: String = emptyString,
        condition: Regex? = null
): String {
    val regex = condition ?: Regex("^(null|NULL|Null|0)")
    return if(this?.contains(regex) == true) replace(regex, default) else this ?: default
}

/**
 * Proceed and Return Non-Null Value of Nullable String
 * @return [String]
 */
val String?.orEmpty get() = orEmpty(emptyString)

/**
 * Check if string is match for Regular Email Pattern
 * @return [Boolean], if Match and Not Null will return True otherwise false
 */
fun String?.isEmailPattern() = Patterns.EMAIL_ADDRESS.matcher(orEmpty).matches()

/**
 * Check if string is match for Numeric Pattern
 * @return [Boolean], if Match and Not Null will return True otherwise false
 */
fun String?.isNumeric() = orEmpty.toLongOrNull() != null

/**
 * Check if string is match of Alphabet
 * @return [Boolean], if Match and Not Null will return True otherwise false
 */
fun String?.isAlphabet() = orEmpty.matches(Regex("[a-zA-Z]+"))

/**
 * Check if string is match of Alphabet & Space
 * @return [Boolean], if Match and Not Null will return True otherwise false
 */
fun String?.isAlphabetSpace() = orEmpty.matches(Regex("[a-zA-Z\\s]+"))

/**
 * Check if string is contains right Phone Number Pattern such as ID-Prefix and ID-length
 * @return [Boolean], if Match and Not Null will return True otherwise false
 */
fun String?.isPhoneNumber() = isNumeric() &&
        ((orEmpty.startsWith("08") && orEmpty.length == 12) ||
                (orEmpty.startsWith("62") && orEmpty.length == 13) ||
                (orEmpty.startsWith("+62") && orEmpty.length == 14))

/**
 * Proceed and Return Non-Null Value of Nullable CharSequence
 * @param default is the replacement of nullable value of any word in the CharSequence
 * @param condition is the condition which nullable can be replaced with non-null value
 * @return [CharSequence]
 */
fun CharSequence?.orEmpty(
        default: String = emptyString,
        condition: Regex? = null
): CharSequence {
    val regex = condition ?: Regex("^(null|NULL|Null|0)")
    return if(this?.contains(regex) == true) replace(regex, default) else this ?: default
}

/**
 * Proceed and Return Non-Null Value of Nullable CharSequence
 * @return [CharSequence]
 */
val CharSequence?.orEmpty get() = orEmpty(emptyString)

/**
 * Proceed and Return Non-Null Value of Nullable Long
 * @param default is the replacement of nullable value of Long
 * @return [Long]
 */
fun Long?.orEmpty(default: Long = emptyLong) = this ?: default

/**
 * Proceed and Return Non-Null Value of Nullable Long
 * @return [Long]
 */
val Long?.orEmpty get() = orEmpty(emptyLong)

/**
 * Proceed and Return Non-Null Value of Nullable Float
 * @param default is the replacement of nullable value of Float
 * @return [Float]
 */
fun Float?.orEmpty(default: Float = emptyFloat) = this ?: default

/**
 * Proceed and Return Non-Null Value of Nullable Float
 * @return [Float]
 */
val Float?.orEmpty get() = orEmpty(emptyFloat)

/**
 * Proceed and Return Non-Null Value of Nullable Int
 * @param default is the replacement of nullable value of Int
 * @return [Int]
 */
fun Int?.orEmpty(default: Int = emptyInt) = this ?: default

/**
 * Proceed and Return Non-Null Value of Nullable Int
 * @return [Int]
 */
val Int?.orEmpty get() = orEmpty()

/**
 * Format Int to ID Currency Value of String Type
 * @param prefix used for prefix of currency Value with default ID currency (Rp.)
 * @param suffix used for suffix of currency value
 * @return [String] Of ID Currency
 */
fun Int?.asIDCurrency(
    prefix: String = "Rp.",
    suffix: String = ""
) : String {
    val currencyFormat: NumberFormat = DecimalFormat("#,###")
    return "${prefix}${currencyFormat.format(orEmpty).orEmpty()
        .replace(',', '.')} $suffix"
}

/**
 * Proceed and Return Non-Null Value of Nullable Double
 * @param default is the replacement of nullable value of Double
 * @return [Double]
 */
fun Double?.orEmpty(default: Double = emptyDouble) = this ?: default

/**
 * Proceed and Return Non-Null Value of Nullable Double
 * @return [Double]
 */
val Double?.orEmpty get() = orEmpty(emptyDouble)

/**
 * Proceed and Return Non-Null Value of Nullable Boolean
 * @param default is the replacement of nullable value of Boolean
 * @return [Boolean]
 */
fun Boolean?.orEmpty(default: Boolean = emptyBoolean) = this ?: default

/**
 * Proceed and Return Non-Null Value of Nullable Boolean
 * @return [Boolean]
 */
val Boolean?.orEmpty get() = orEmpty()

fun String?.isPasswordValidate() : Boolean{
    val regex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$")
    return this?.contains(regex) == true
}



















