import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://192.168.64.4:31265")

  val scn = scenario("BasicSimulation")
    .repeat(50) {
      exec(Create.single);
    }

  setUp(
    scn.inject(
      rampUsers(50) over (60 seconds))
  ).protocols(httpConf)
}

object Create {

  val single = {
    exec(http("sayHello")
        .get("/hello")
    );
  }
}