package com.huhuang03.opencommonapi

import com.huhuang03.opencommonapi.model.Greeting
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import javax.servlet.http.HttpServletResponse

@SpringBootApplication
@RestController
class OpencommonapiApplication {
    val counter = AtomicLong()

    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "world") name: String): String {
        return "Hello $name"
    }

    @GetMapping("delayImage")
    fun delayImage(@RequestParam(value = "url", defaultValue = "") url: String, response: HttpServletResponse) {
        println("hello");
        // why you can't use std lib?

//        IOUtils.copy(URL(url).openStream(), response.outputStream)
//        response.flushBuffer()
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "world") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}

fun main(args: Array<String>) {
    runApplication<OpencommonapiApplication>(*args)
}
