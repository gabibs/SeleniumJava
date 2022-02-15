package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

    //Let's just start by storing this in a list of web elements [List<WebElement>]
    // so that we know what we have and don't get lost.
    //Next I'm going to do stream, and I'm going to say I want to map.
    //And inside this map I can pass in a Lambda expression.
    // So for every element that's inside this list, I want you to take this action.
    //So, you give it an arrow [ -> ] and the action I want you to take is to get the text.
    //And once you get the text from every element,
    //I want you to collect all of those into a new List and that will be a List of Strings.
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void setMultipleAttribute(){
        String script = "arguments[0].setAttribute('multiple', '')";
        var jsExecutor = (JavascriptExecutor)driver;
        List<WebElement> availableOptions = findDropDownElement().getOptions();
        jsExecutor.executeScript(script, availableOptions.get(0));
        jsExecutor.executeScript(script, availableOptions.get(1));

    }

    //This takes a WebElement, so we can do the driver.findElement
    //because we know that that'll give us a WebElement, and we can pass in this dropdown locator.
    //That will give us an element that we pass to Select
    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }




}
