import html.*
import kotlin.browser.document

fun main(args: Array<String>) {

    val items = (1..10).map { "Item$it" }

    document.body?.apply {
        h1("Hello Genbeta Dev!")

        div {
            p("This is a test to generate HTML from Kotlin")

            ul {
                items.forEach { li(it) }
            }
        }
    }
}
