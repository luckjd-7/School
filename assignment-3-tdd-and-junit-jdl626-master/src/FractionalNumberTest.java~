import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by debmduke on 2/7/19.
 */
@RunWith(Arquillian.class)
public class FractionalNumberTest {
    FractionalNumber num1;
    FractionalNumber num2;

    @org.junit.Before
    public void setUp() throws Exception {
        num1 = new FractionalNumber(1, 2);
        num2 = new FractionalNumber(1, 4);
    }

    @org.junit.Test
    public void add() throws Exception {
        num1.add(num2);
        FractionalNumber num3 = new FractionalNumber(3, 4);
        assertEquals(num1, num3);
    }

    @org.junit.Test
    public void subtract() throws Exception {
    }

    @org.junit.Test
    public void multiply() throws Exception {
    }

    @org.junit.Test
    public void divide() throws Exception {
    }

    @org.junit.Test
    public void setDenominator() throws Exception {
    }

    @org.junit.Test
    public void equals() throws Exception {
    }

    @org.junit.Test
    public void toString() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(FractionalNumber.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
