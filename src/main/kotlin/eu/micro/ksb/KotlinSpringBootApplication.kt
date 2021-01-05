package eu.micro.ksb

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogConfiguration.BlogProperties::class)
class KotlinSpringBootApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
