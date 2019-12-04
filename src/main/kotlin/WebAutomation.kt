import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class WebAutomation internal constructor() {
    private val driver: WebDriver

    init {
        System.setProperty("webdriver.chrome.driver", "/Users/ts-navneet.kumar/Downloads/chromedriver")
        driver = ChromeDriver()
        driver.manage().window().maximize()
    }

    fun getContent() {
        var isVisible = false
        do {
            val agreeButtons = driver.findElements(By.cssSelector("button"))
            for (element in agreeButtons) {
                if (element.text == "Download") {
                    element.click()
                    isVisible = true
                }
            }
        } while (!isVisible)
    }

    fun openWebPage(url: String): Boolean {
        driver.get(url)
        return false
    }

    fun enterCredentials(username: String, password: String): Boolean {
        driver.findElement(By.id("username")).sendKeys(username)
        driver.findElement(By.id("password")).sendKeys(password)
        driver.findElement(By.cssSelector("input[type='submit']")).click()
        return false
    }

    fun agreeToPolicy(): Boolean {
        val agreeButtons = driver.findElements(By.cssSelector("button"))
        for (element in agreeButtons) {
            if (element.text == "Agree") {
                element.click()
            }
        }
        return false
    }

    fun enterQuery(query: String): Boolean {
        val textArea = driver.findElement(By.cssSelector("textarea"))
        textArea.clear()
        if (textArea.text.isEmpty())
            textArea.sendKeys(query)
        else {
            println("Again text area is not getting cleared because of some unknown reason")
            return false
        }
        val agreeButtons = driver.findElements(By.cssSelector("button"))
        for (element in agreeButtons) {
            if (element.text == "Run Query") {
                element.click()
            }
        }
        return false
    }
}


