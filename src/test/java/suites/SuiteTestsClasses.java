package suites;

import org.junit.platform.suite.api.*;

import modulo1.integracao.*;
import modulo3.integracao.*;

@Suite
@SuiteDisplayName("Suite Testes Classes")
@SelectClasses({
        IntegracaoTeste01.class,
        IntegracaoTest03.class,
})

public class SuiteTestsClasses {

}

