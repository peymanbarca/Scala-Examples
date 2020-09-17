import org.apache.commons.io.IOUtils
import com.google.gson.Gson

import scala.util.parsing.json.JSON

/**
  * Created by zevik on 9/17/20.
  */



sealed class DivarRequestBody(jsonrpc:String,id:Int,method:String)






object RESTExample extends App {

  val client = new RESTfullClient()

  val URL = "https://search.divar.ir/json/"
  val payload = "{\"jsonrpc\":\"2.0\",\"id\":0,\"method\":\"getPostList\",\"params\":[[[\"place2\",0,[\"1\"]]],462712402400482]}"

  val content = client.postHTTPRequest(url = URL,body = payload)
  val body = IOUtils.toString(content.getEntity.getContent,  "UTF-8")

  val parsedBody = JSON.parseFull(body.toString)
  parsedBody match {
    case Some(v)=> {
      val m1 = v.asInstanceOf[Map[String,Any]]
      m1 foreach {case (key, value) => {
        println (key + "-->" + value)}
        if (key.toString.equalsIgnoreCase("result")){
          val m2 = value.asInstanceOf[Map[String,Any]]
          val mainInfo = m2.get("post_list") match {
            case Some(u)=>{
              println(u)
              u.asInstanceOf[List[Map[String,Any]]].foreach(item=>{
                try {
                  println(item+"\n----------")
                }
                catch {
                  case e:Exception =>
                }
              })
            }
            case None=>
          }

          val lastPostDate = m2.get("last_post_date") match {
            case Some(u)=>println(" last_post_date : " + u.toString)
            case None=>
          }


        }
      }
    }
    case None=>
  }



}


