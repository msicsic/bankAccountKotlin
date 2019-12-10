package org.msi.kata.acceptance

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith


@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/resources/features"],
        glue = ["org.msi.kata.acceptance"],
        plugin = ["pretty"])
class RunCucumberTest {
}