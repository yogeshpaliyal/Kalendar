package com.himanshoe.kalendar

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.himanshoe.kalendar.color.KalendarColors
import com.himanshoe.kalendar.color.KalendarThemeColor
import com.himanshoe.kalendar.component.day.config.KalendarDayColors
import com.himanshoe.kalendar.component.day.config.KalendarDayDefaultColors
import com.himanshoe.kalendar.model.KalendarDay
import com.himanshoe.kalendar.model.KalendarEvent
import com.himanshoe.kalendar.model.KalendarType
import com.himanshoe.kalendar.ui.firey.KalendarFirey
import com.himanshoe.kalendar.ui.oceanic.KalendarOceanic
import kotlinx.datetime.LocalDate

@Composable
fun Kalendar(
    modifier: Modifier = Modifier,
    kalendarType: KalendarType = KalendarType.Oceanic,
    kalendarEvents: List<KalendarEvent> = emptyList(),
    kalendarThemeColors: List<KalendarThemeColor> = KalendarColors.defaultColors(),
    onCurrentDayClick: (KalendarDay, List<KalendarEvent>) -> Unit = { _, _ -> },
    kalendarDayColors: KalendarDayColors = KalendarDayDefaultColors.defaultColors(),
    takeMeToDate: LocalDate? = null,
) {
    if (kalendarThemeColors.isEmpty() || kalendarThemeColors.count() < 12) throw Exception("KalendarThemeColor cannot be null or less than 12, If you want to use same color accors months pass kalendarThemeColor = KalendarThemeColor(values)")

    when (kalendarType) {
        KalendarType.Oceanic -> KalendarOceanic(
            modifier = modifier.wrapContentHeight(),
            kalendarEvents = kalendarEvents,
            onCurrentDayClick = onCurrentDayClick,
            kalendarDayColors = kalendarDayColors,
            kalendarThemeColors = kalendarThemeColors,
            takeMeToDate = takeMeToDate
        )
        KalendarType.Firey -> {
            KalendarFirey(
                modifier = modifier.wrapContentHeight(),
                kalendarEvents = kalendarEvents,
                onCurrentDayClick = onCurrentDayClick,
                kalendarDayColors = kalendarDayColors,
                kalendarThemeColors = kalendarThemeColors,
                takeMeToDate = takeMeToDate
            )
        }
    }
}

@Composable
fun Kalendar(
    modifier: Modifier = Modifier,
    kalendarThemeColor: KalendarThemeColor,
    kalendarType: KalendarType = KalendarType.Oceanic,
    kalendarEvents: List<KalendarEvent> = emptyList(),
    onCurrentDayClick: (KalendarDay, List<KalendarEvent>) -> Unit = { _, _ -> },
    kalendarDayColors: KalendarDayColors = KalendarDayDefaultColors.defaultColors(),
    takeMeToDate: LocalDate? = null,
) {
    when (kalendarType) {
        KalendarType.Oceanic -> KalendarOceanic(
            modifier = modifier.wrapContentHeight(),
            kalendarEvents = kalendarEvents,
            onCurrentDayClick = onCurrentDayClick,
            kalendarDayColors = kalendarDayColors,
            kalendarThemeColor = kalendarThemeColor,
            takeMeToDate = takeMeToDate
        )
        KalendarType.Firey -> {
            KalendarFirey(
                modifier = modifier.wrapContentHeight(),
                kalendarEvents = kalendarEvents,
                onCurrentDayClick = onCurrentDayClick,
                kalendarDayColors = kalendarDayColors,
                kalendarThemeColor = kalendarThemeColor,
                takeMeToDate = takeMeToDate
            )
        }
    }
}

@Composable
@Preview
private fun KalendarPreview() {
}
