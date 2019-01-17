package com.yalantis.core

import org.junit.After
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.test.KoinTest
import org.koin.test.checkModules
import org.mockito.Mockito.mock
import org.junit.Assert.*

public class DryRunTest: KoinTest {

    public DryRunTest() {

    }

    @After
    fun after() {
//        stopKoin()
    }

    @Test
    public fun testRemoteConfiguration() {
        assertEquals(4, (2 + 2).toLong())
        // startKoin() // todo add core module
//        checkModules { params }
    }

    @Test
    public fun testLocalConfiguration() {
//        startKoin(testApp)
//        checkModules { params }
    }

}