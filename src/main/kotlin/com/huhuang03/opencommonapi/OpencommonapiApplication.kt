package com.huhuang03.opencommonapi

import com.huhuang03.opencommonapi.model.Greeting
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.http.MediaType
import org.springframework.util.FileCopyUtils
import org.springframework.util.StreamUtils.copyToString
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.InputStreamReader
import java.util.concurrent.atomic.AtomicLong
import javax.servlet.http.HttpServletResponse

@SpringBootApplication
@RestController
class OpencommonapiApplication {
    val counter = AtomicLong()

    var catesCache = ""

    // how to split to different files?
    @GetMapping("/cates", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun cates(): String {
        if (catesCache.isBlank()) {
            catesCache = FileCopyUtils.copyToString(
                InputStreamReader(DefaultResourceLoader().getResource("json/cates.json").inputStream, Charsets.UTF_8))
        }
        // how to indicate that I'm a json?
        return catesCache
    }

    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "world") name: String): String {
        return "Hello $name"
    }

    @GetMapping("delayImage")
    fun delayImage(@RequestParam(value = "url", defaultValue = "") url: String, response: HttpServletResponse) {
        println("hello");
        // why you can't use std lib?
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "world") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}

fun main(args: Array<String>) {
    runApplication<OpencommonapiApplication>(*args)
}
