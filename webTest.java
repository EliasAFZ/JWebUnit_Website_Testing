import org.junit.*;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

/**
 * 
 * @author Elias Afzalzada
 *
 */

public class webTest{

    @Before
    public void prepare() {
        setBaseUrl("http://www.radford.edu/~dbraffitt/itec335/2018/spring/class/");
    }

    @Test //only submit 1 HTML document - backpacks.html - add a title Backpacks, Limited
    public void test_01() {
        beginAt("backpacks2.html");
        assertTitleEquals("Backpacks, Limited");
    }

    @Test //must contain images of at least three backpacks - use id image1, image2, image3
    public void test_02() {
    	beginAt("backpacks2.html");
        assertElementPresent("image1");
        assertElementPresent("image2");
        assertElementPresent("image3");
    	assertImagePresentPartial("http://web.archive.org/web/20120131070136/http://www.northfaceok.org/images/The%20North%20Face%20Backpack%20TNF00063.jpg", "");
        assertImagePresentPartial("http://web.archive.org/web/20120131070136/http://www.northfaceok.org/images/The%20North%20Face%20Backpack%20TNF00074.jpg", "");
        assertImagePresentPartial("http://web.archive.org/web/20120131070136/http://www.northfaceok.org/images/The%20North%20Face%20Backpack%20TNF00060.jpg", "");
    }

    @Test //must have descriptions of at least three backpacks - use id description1, description2, description3
    public void test_03() {
    	beginAt("backpacks2.html");
    	assertElementPresent("description1");
    	assertElementPresent("description2");
    	assertElementPresent("description3");
    }

    @Test //must have at least one unordered list, one ordered list, and one table - use id unorderedList1, orderedList1, table1
    public void test_04() {
    	beginAt("backpacks2.html");
    	assertElementPresent("unorderedList1");
    	assertElementPresent("orderedList1");
    	assertElementPresent("table1");
    }

    @Test //must nest 2 of the above - nest id orderedList1 as part of id unorderedList1
    public void test_05() {
    	beginAt("backpacks2.html");
    	assertElementPresent("orderedList1");
    	assertElementPresent("unorderedList1");
    	assertElementPresentByXPath("//*[@id=\"orderedList1\"]");
    }

    @Test //must have at least one image that is a link to another document - use id image1 as part of id link1
    public void test_06() {
    	beginAt("backpacks2.html");
    	assertElementPresent("image1");
    	assertElementPresent("link1");
    	assertLinkPresentWithImage("http://web.archive.org/web/20120131070136/http://www.northfaceok.org/images/The%20North%20Face%20Backpack%20TNF00063.jpg");
    }

    @Test //must have at least one other hyperlink defined (use absolute URL's) - use id link4
    public void test_07() {
    	beginAt("backpacks2.html");
    	assertLinkPresent("link4");
    }
    
    @Test //at least one hyperlink must be imbedded in a table - use id link3
    public void test_08() {
    	beginAt("backpacks2.html");
    	assertLinkPresent("link3");
    	assertElementPresentByXPath("//*[@id=\"image3\"]");
    }
    
    @Test // make sure to acknowledge copyright for images or web pages you did not create in code and on page - use id copyright1
    public void test_09() {
    	beginAt("backpacks2.html");
    	assertElementPresent("copyright1");
    }
    
    @After
    public void close() {
        closeBrowser();
    }
}