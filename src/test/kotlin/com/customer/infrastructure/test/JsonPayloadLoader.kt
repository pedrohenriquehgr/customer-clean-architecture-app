package com.customer.infrastructure.test

import org.json.JSONObject
import org.testcontainers.shaded.org.apache.commons.io.IOUtils
import java.io.File
import java.io.FileInputStream
import java.io.IOException


class JsonPayloadLoader {
    companion object {
        fun load(filePath: String): JSONObject {
            try {
                FileInputStream(
                    File(
                        String.format(
                            "src/test/resources/integration-test/use-cases/%s",
                            filePath
                        )
                    )
                ).use { fis ->
                    return JSONObject(IOUtils.toString(fis, "UTF-8"))
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            throw IllegalStateException("Error on loading payload")
        }
    }
}