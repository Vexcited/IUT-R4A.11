package com.vexcited.myapplication.core

import java.time.Year

class AgeCalculator {
  companion object {
    fun calculateAge(birthYear: Int): Int {
      val currentYear = Year.now().value

      return currentYear - birthYear
    }
  }
}