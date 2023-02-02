package com.afdhal_fa.visitorpattern

import com.afdhal_fa.visitorpattern.base.VisitorElementFactory
import com.afdhal_fa.visitorpattern.data.Car
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainTest {
    val factory = VisitorElementFactory()

    @Test
    fun mainTest() {
        println((factory.factory(Car.ID_MODEL) as Car).merk)
    }
}