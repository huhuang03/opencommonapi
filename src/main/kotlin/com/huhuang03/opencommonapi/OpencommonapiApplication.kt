package com.huhuang03.opencommonapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class OpencommonapiApplication {
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "world") name: String): String {
        return "Hello $name"
    }
}

fun main(args: Array<String>) {
    runApplication<OpencommonapiApplication>(*args)
}
