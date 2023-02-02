package com.afdhal_fa.visitorpattern.data

import com.afdhal_fa.visitorpattern.base.VisitorElement
import com.afdhal_fa.visitorpattern.base.VisitorUIModel

data class Motor(
    val merk:String
):VisitorUIModel(){
    override fun visit(type: VisitorElement): Int {
        return type.type(this)
    }

    companion object{
        const val ID_MODEL = 2
    }
}
