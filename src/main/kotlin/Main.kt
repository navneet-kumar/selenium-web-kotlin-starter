fun main(args: Array<String>) {
    val automation = WebAutomation()
    automation.openWebPage("")// URL
    automation.enterCredentials("", "") // ID and password
    automation.agreeToPolicy()
    automation.enterQuery("") // Query
    automation.getContent() // IN progress
}