import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.browser.JsoupBrowser

/**
  * Created by zevik on 9/17/20.
  */



object ScraperApp extends App {

  val client = new RESTfullClient()
  val browser = JsoupBrowser()

  try {
    val content = client.getHTTPRequest("https://divar.ir/tehran/%D8%AA%D9%87%D8%B1%D8%A7%D9%86/browse/")
    val doc = browser.parseString(content)

    // Extract the <span> elements inside #menu
    val items = doc >> elementList("[class=kt-col-12 kt-col-md-6 kt-col-xxl-4 post-card-item]")


    println("Number of Elements => "+items.size+"\n\n")
    items foreach(item=>{


      val info = item >> pElement("[class=kt-post-card__body]")
      //println(info +"\n\n\n ")


      val title = (info >> pElement("[class=kt-post-card__title]")) >> allText("div")
      println(" \n Title : \n " +title)

      val description = item >> allText("a")
      println(" \n description \n " + description)


      val link = item >?> attr("href")("a")
      link match {
        case Some(value) => println(" \n Link \n " + value)
        case None => println("")
      }


      println(" \n\n ---------------- \n\n")

    })


  } catch {
    case ioe: java.io.IOException =>  // handle this
    case ste: java.net.SocketTimeoutException => // handle this
  }

}


