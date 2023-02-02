package com.afdhal_fa.visitorpattern.base

import com.afdhal_fa.visitorpattern.data.Car
import com.afdhal_fa.visitorpattern.data.Motor

class VisitorElementFactory : VisitorElement {
    override fun type(car: Car): Int {
        return Car.ID_MODEL
    }

    override fun type(motor: Motor): Int {
        return Motor.ID_MODEL
    }

    override fun factory(id: Int): VisitorUIModel {
        return when (id) {
            Car.ID_MODEL -> Car("Ferary")
            Motor.ID_MODEL -> Motor("Honda")
            else -> throw Exception("Type Model ID Not Found")
        }
    }


}