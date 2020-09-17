import java.util

import com.google.gson.Gson
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.{CloseableHttpResponse, HttpPost}
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair


/**
  * Created by zevik on 9/17/20.
  */


sealed class RESTfullClient () {

  @throws(classOf[java.io.IOException])
  @throws(classOf[java.net.SocketTimeoutException])
  def getHTTPRequest(url: String,
                     connectTimeout: Int = 5000,
                     readTimeout: Int = 5000,
                     requestMethod: String = "GET") =
  {
    import java.net.{URL, HttpURLConnection}
    val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
    connection.setConnectTimeout(connectTimeout)
    connection.setReadTimeout(readTimeout)
    connection.setRequestMethod(requestMethod)
    val inputStream = connection.getInputStream
    val content = io.Source.fromInputStream(inputStream).mkString
    if (inputStream != null) inputStream.close
    content
  }



  def postHTTPRequest[T](url:String,body :T):CloseableHttpResponse = {
    // create our object as a json string
    //val spockAsJson = new Gson().toJson(body)
    val spockAsJson = body.toString

    // add name value pairs to a post object
    val post = new HttpPost(url)

    // set the Content-type
    post.setHeader("Content-type", "application/json")

    post.setEntity(new StringEntity(spockAsJson))

    // send the post request
    val client = new DefaultHttpClient
    val response = client.execute(post)

    //println("--- HEADERS ---")
    //response.getAllHeaders.foreach(arg => println(arg))

    return response
  }

}

