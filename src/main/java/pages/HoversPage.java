package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {
    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure( int index){
        WebElement figure = driver.findElements(figureBox).get(index -1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    //inner class for a component that only appears in one page
    //otherwise (if component appears in more than one page)
    //a new page should be created
    //Example: a profile caption that should be seen across all pages of a web platform
    public class FigureCaption{

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        //constructor
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }



        //methods used for verifications over web elements
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getTitle() {
            return caption.findElement(header).getText();
        }

        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
