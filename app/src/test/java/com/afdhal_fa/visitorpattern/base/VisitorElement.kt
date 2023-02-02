package com.afdhal_fa.visitorpattern.base

import com.afdhal_fa.visitorpattern.data.Car
import com.afdhal_fa.visitorpattern.data.Motor

interface VisitorElement {
    fun type(car: Car): Int

    fun type(motor: Motor): Int

    fun factory(id: Int): VisitorUIModel
}