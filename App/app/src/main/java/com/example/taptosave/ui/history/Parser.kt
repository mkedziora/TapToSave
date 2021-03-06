package com.bi.chartapp

import com.example.taptosave.ui.history.FoodSearch
import com.opencsv.CSVReaderBuilder
import java.io.Reader

class Parser {

    companion object {

        fun toDataSet(reader: Reader): List<FoodSearch> {

            val csvReader = CSVReaderBuilder(reader)
                .withSkipLines(1)
                .build()

            val foodSearches = mutableListOf<FoodSearch>()
            var record = csvReader.readNext()

            while (record != null) {
                foodSearches.add(FoodSearch(record[0], record[1].toInt(), record[2].toInt(), record[3].toInt()))
                record = csvReader.readNext()
            }

            return foodSearches
        }
    }
}