package eu.micro.ksb

import eu.micro.ksb.persistence.Article
import eu.micro.ksb.persistence.ArticleRepository
import eu.micro.ksb.persistence.User
import eu.micro.ksb.persistence.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @ConstructorBinding
    @ConfigurationProperties("blog")
    data class BlogProperties(var title: String, val banner: Banner) {
        data class Banner(val title: String? = null, val content: String)
    }

    @Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {

        val smaldini = userRepository.save(User("smaldini", "Stéphane", "Maldini"))
        articleRepository.save(
            Article(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        articleRepository.save(
            Article(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
    }
}
