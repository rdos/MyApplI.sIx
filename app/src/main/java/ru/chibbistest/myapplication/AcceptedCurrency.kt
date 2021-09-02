package ru.chibbistest.myapplication

sealed class AcceptedCurrency {
    val name: String
        get() = when (this) {
            is Rubel -> "Рубль"
            is Dollar -> "Доллары"
            is Tugrik -> "Вика-приставайка!"
        }

}

class Dollar : AcceptedCurrency()

class Tugrik : AcceptedCurrency()