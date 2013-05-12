package ee.uitest.scala

import org.scalatest.{BeforeAndAfter, FlatSpec}
import org.scalatest.matchers.ShouldMatchers
import com.codeborne.selenide.Selenide._
import com.codeborne.selenide.Condition._
import org.openqa.selenium.By

class GoogleTest extends FlatSpec with BeforeAndAfter with ShouldMatchers {
  "User" can "search for any string" in {
    open("http://google.com")
    $(By.name("q")).setValue("Selenide").pressEnter()
    $("li.g:eq(3)", 0).shouldHave(text("Selenide - Wikipedia, the free encyclopedia"))
    $("li.g", 1).shouldHave(text("codeborne/selenide"))
  }
}