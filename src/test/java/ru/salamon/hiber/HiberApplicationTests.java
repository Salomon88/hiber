package ru.salamon.hiber;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class HiberApplicationTests {

    @Test
    void test() {
        log.info("##teamcity[testStarted name='HiberApplicationTests']");
        log.info("##teamcity[testMetadata testName='HiberApplicationTests' name='setUp time' value='+ /usesnpe/UsesRedundant.php:67 WEAK WARNING (int) Type cast is redundant']");
        log.info("##teamcity[testFailed name='HiberApplicationTests' message='failure message' details='message and stack trace']");
        log.info("##teamcity[testFinished name='HiberApplicationTests']");
        assertTrue(false);
    }

}
