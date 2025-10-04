package com.omaradev.test_benchmark

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.benchmark.macro.ExperimentalMetricApi
import androidx.benchmark.macro.PowerCategory
import androidx.benchmark.macro.PowerCategoryDisplayLevel
import androidx.benchmark.macro.PowerMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PowerBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @OptIn(ExperimentalMetricApi::class)
    @RequiresApi(Build.VERSION_CODES.Q)
    val powerMetric = PowerMetric(
        PowerMetric.Power(
            categories = mapOf(
                PowerCategory.CPU to PowerCategoryDisplayLevel.TOTAL,
                PowerCategory.DISPLAY to PowerCategoryDisplayLevel.BREAKDOWN
            )
        )
    )


    @OptIn(ExperimentalMetricApi::class)
    @RequiresApi(Build.VERSION_CODES.Q)
    @Test
    fun scrollEnergyCost() = benchmarkRule.measureRepeated(
        packageName = "com.omaradev.benchmark",
        metrics = listOf(powerMetric),
        iterations = 3
    ) {
        pressHome()
        startActivityAndWait()

        device.wait(Until.hasObject(By.text("Product #0")),5_000)


        val list = UiScrollable(UiSelector().scrollable(true))
        list.scrollTextIntoView("Product #50")
    }
}
