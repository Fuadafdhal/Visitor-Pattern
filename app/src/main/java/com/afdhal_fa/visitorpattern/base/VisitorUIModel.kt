package com.afdhal_fa.visitorpattern.base

import com.afdhal_fa.visitorpattern.persentation.main.adapter.visitor.VisitorElement

abstract class VisitorUIModel {
    abstract fun type(type: VisitorElement): Int
}