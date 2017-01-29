package html

import org.w3c.dom.Element
import kotlin.browser.document

enum class HtmlTag(val text: String) {
    H1("h1"),
    DIV("div"),
    P("p"),
    UL("ul"),
    LI("li")
}

fun Element.h1(text: String): Element = textElement(HtmlTag.H1, text)
fun Element.div(f: Element.() -> Unit) = structuralElement(HtmlTag.DIV, f)
fun Element.p(text: String): Element = textElement(HtmlTag.P, text)
fun Element.ul(f: Element.() -> Unit) = structuralElement(HtmlTag.UL, f)
fun Element.li(text: String) = textElement(HtmlTag.LI, text)

private fun Element.textElement(tag: HtmlTag, text: String) = createTag(tag) { textContent = text }
private fun Element.structuralElement(tag: HtmlTag, f: Element.() -> Unit) = createTag(tag) { f() }

private fun Element.createTag(tag: HtmlTag, f: Element.() -> Unit): Element {
    val element = document.createElement(tag.text)
    element.f()
    append(element)
    return element
}