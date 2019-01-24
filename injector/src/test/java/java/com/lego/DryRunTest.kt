package java.com.lego

import org.junit.After
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.test.KoinTest
import org.koin.test.checkModules
import com.lego.mydiablo.di.appModule

class DryRunTest: KoinTest {

    @Test
    fun testGraphConfiguration() {
        startKoin(appModule)
        checkModules(appModule)
    }

    @After
    fun after() {
        stopKoin()
    }

}