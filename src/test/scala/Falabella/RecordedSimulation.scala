
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://www.qanovagroup.com:2095")
		.inferHtmlResources()
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")

	val headers_0 = Map(
		"Accept-Encoding" -> "gzip, deflate",
		"Pragma" -> "no-cache",
		"Proxy-Connection" -> "keep-alive")

	val headers_1 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Accept-Encoding" -> "gzip, deflate",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "http://www.qanovagroup.com:2095",
		"Proxy-Connection" -> "keep-alive",
		"X-Requested-With" -> "XMLHttpRequest",
		"X-Roundcube-Request" -> "BSwz8CrhjGHuvmPi9WhpfkaDTDzvFYTY")

	val headers_2 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_3 = Map("Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8")

	val headers_5 = Map("Accept" -> "application/json, text/plain, */*")

	val headers_6 = Map(
		"Accept" -> "application/json, text/plain, */*",
		"Content-Type" -> "application/json")

	val headers_9 = Map(
		"Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"Pragma" -> "no-cache")

    val uri2 = "http://www.gstatic.com/generate_204"
    val uri3 = "https://www.falabella.com:443"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get(uri2 + "")
			.headers(headers_0))
		.pause(3)
		.exec(http("request_1")
			.post("/cpsess8933936826/3rdparty/roundcube/?_task=mail&_action=refresh")
			.headers(headers_1)
			.formParam("_mbox", "INBOX")
			.formParam("_folderlist", "1")
			.formParam("_list", "1")
			.formParam("_uids", "279,281,282,285,287,288,289,290,291,292,293,294,295,300,301,303,304,306,307,308,309,310,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,354,355,356,358,359,360,361,362,363,364,365,366,367")
			.formParam("_last", "1554904117")
			.formParam("_remote", "1")
			.formParam("_unlock", "loading1554904177270"))
		.pause(4)
		.exec(http("request_2")
			.get(uri3 + "/falabella-cl/")
			.headers(headers_2)
			.resources(http("request_3")
			.get(uri3 + "/static/RDF/site/home/hero/1s19/04-abril/vitrina_makeup-home-030419-pb-dt-1x.webp")
			.headers(headers_3),
            http("request_4")
			.get(uri3 + "/static/RDF/site/home/hero/1s19/04-abril/vitrina_zapatillas-conadi-080419-pb-1x.webp")
			.headers(headers_3),
            http("request_5")
			.get(uri3 + "/rest/model/falabella/rest/browse/BrowseActor/get-header-main-menu")
			.headers(headers_5),
            http("request_6")
			.get(uri3 + "/rest/model/falabella/rest/browse/BrowseActor/fetch-daily-deals")
			.headers(headers_6),
            http("request_7")
			.get(uri3 + "/static/RDF/site/home/multicategorias/2019/04_Abril/MC1-CMR-LineaBlanca-CV-2x.webp")
			.headers(headers_3),
            http("request_8")
			.get(uri3 + "/static/RDF/site/home/multicategorias/2019/04_Abril/MC2-CMR-Telefonia-PG-2x.webp")
			.headers(headers_3),
            http("request_9")
			.get(uri3 + "/favicon-32x32.png")
			.headers(headers_9)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}