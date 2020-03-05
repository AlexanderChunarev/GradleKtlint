import org.junit.Assert
import org.junit.Test

class ExampleUnitTest {
    private val str = "MAINActivity"
    private val regex = "[A-Z][A-Z]+".toRegex()

    @Test
    fun test() {
        Assert.assertEquals(true, str.contains(regex))
    }
}
