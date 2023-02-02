package com.afdhal_fa.visitorpattern.base

abstract class VisitorUIModel {
    abstract fun visit(type: VisitorElement):Int
}