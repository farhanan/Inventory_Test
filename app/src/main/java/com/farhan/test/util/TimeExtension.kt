package com.farhan.test.util

import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.*
import com.farhan.test.R
import java.text.SimpleDateFormat
import java.util.*

fun FragmentManager.timePicker(
    selection: Long? = null,
    title: String? = null,
    fullScreen: Boolean = false,
    constraint: Pair<Long?,Long?>? = null,
    onSaveClickAction: ((Long) -> Unit)?
) : MaterialDatePicker<Long> {

    val constraintBuilderRange = CalendarConstraints.Builder()

    constraintBuilderRange.setStart(constraint?.first.orEmpty)
    constraintBuilderRange.setEnd(constraint?.second.orEmpty)

    val minValidator = DateValidatorPointForward.from(constraint?.first.orEmpty)
    val maxValidator = DateValidatorPointBackward.before(constraint?.second.orEmpty)

    val validators = listOf(minValidator, maxValidator)
    val dateValidator = CompositeDateValidator.allOf(validators)

    constraintBuilderRange.setValidator(dateValidator)

    return MaterialDatePicker.Builder.datePicker().apply {
        if (selection != null) setSelection(selection)
        if (constraint != null) setCalendarConstraints(constraintBuilderRange.build())

        if (constraint != null) setCalendarConstraints(constraintBuilderRange.build())

        setTheme(
            if (!fullScreen) R.style.ThemeOverlay_MaterialComponents_MaterialCalendar
            else R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen
        )

        if (!title.isNullOrEmpty()) {
            setTitleText(title)
        }

    }.build().apply {
        addOnPositiveButtonClickListener {
            if (onSaveClickAction != null) {
                onSaveClickAction(it)
            } else dismiss()
        }
    }.also {
        it.show(this, javaClass.simpleName)
    }
}

fun FragmentManager.rangeTimePicker(
    selectedRange: Pair<Long,Long>? = null,
    title: String? = null,
    constraint: Pair<Date?,Date?>? = null,
    fullScreen: Boolean = false,
    onSaveClickAction: ((Pair<Long,Long>) -> Unit)?
) : MaterialDatePicker<androidx.core.util.Pair<Long, Long>> {
    val constraintBuilder = CalendarConstraints.Builder()
    val minValidator = DateValidatorPointForward.from(constraint?.first?.time.orEmpty)
    val maxValidator = DateValidatorPointBackward.before(constraint?.second?.time.orEmpty)

    val validators = listOf(minValidator, maxValidator)
    val dateValidator = CompositeDateValidator.allOf(validators)
    constraintBuilder.setValidator(dateValidator)

    return MaterialDatePicker.Builder.dateRangePicker().apply {
        if (!title.isNullOrEmpty()) {
            setTitleText(title)
        }

        if (constraint != null) setCalendarConstraints(constraintBuilder.build())

        setTheme(
            if (!fullScreen) R.style.ThemeOverlay_MaterialComponents_MaterialCalendar
            else R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen
        )

        if (selectedRange != null) {
            setSelection(androidx.core.util.Pair(selectedRange.first, selectedRange.second))
        }

    }.build().apply {
        addOnPositiveButtonClickListener {
            if (onSaveClickAction != null) {
                onSaveClickAction(Pair(it.first.orEmpty(), it.second.orEmpty()))
            } else dismiss()
        }
    }.also {
        it.show(this, javaClass.simpleName)
    }
}


fun getTimeZoneById(id: String = "GMT+07:00"): TimeZone {
    return TimeZone.getTimeZone(id)
}

val applicationTimeZone get() = getTimeZoneById()

fun dateFormatter(format: String = "yyyy-MM-dd"): SimpleDateFormat {
    return SimpleDateFormat(format, Locale("in_ID")).apply {
        timeZone = applicationTimeZone
    }
}

val defaultDateFormat get() = dateFormatter()

