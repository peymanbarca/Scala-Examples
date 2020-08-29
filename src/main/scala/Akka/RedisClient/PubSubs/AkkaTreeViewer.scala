import akka.actor.Props

/**
  * Created by zevik on 8/29/20.
  */
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._



class PrivateMethodCaller(x: AnyRef, methodName: String) {
  def apply(_args: Any*): Any = {
    val args = _args.map(_.asInstanceOf[AnyRef])

    def _parents: Stream[Class[_]] = Stream(x.getClass) #::: _parents.map(_.getSuperclass)

    val parents = _parents.takeWhile(_ != null).toList
    val methods = parents.flatMap(_.getDeclaredMethods)
    val method = methods.find(_.getName == methodName).getOrElse(throw new IllegalArgumentException("Method " + methodName + " not found"))
    method.setAccessible(true)
    method.invoke(x, args: _*)
  }
}

class PrivateMethodExposer(x: AnyRef) {
  def apply(method: scala.Symbol): PrivateMethodCaller = new PrivateMethodCaller(x, method.name)
}



object AkkaTreeViewer extends App {


  implicit val akkaSystem = akka.actor.ActorSystem(name = "OurAkkaSystem")


  // --------------------- print akka system tree -------------
  val res = new PrivateMethodExposer(akkaSystem)('printTree)()
  println(res)

  // to view continuous tree of akka system
  akkaSystem.scheduler.schedule(2 seconds, 5 seconds)(println(res))

}