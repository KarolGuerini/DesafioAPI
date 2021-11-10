package com.desafio.rest.suite;

import com.desafio.rest.tests.Login;
import com.desafio.rest.tests.Register;
import com.desafio.rest.tests.Resources;
import com.desafio.rest.tests.Users;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Login.class,
        Register.class,
        Resources.class,
        Users.class
})
public class SuiteDeTestes {

}
