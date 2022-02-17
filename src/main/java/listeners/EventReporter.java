package listeners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

public class EventReporter implements WebDriverListener {
    @Override
    public void beforeAccept(Alert alert) {
        WebDriverListener.super.beforeAccept(alert);
        System.out.println("After Alert Accept " + alert.toString());
    }

    @Override
    public void  afterAccept(Alert alert) {
        WebDriverListener.super.afterAccept(alert);
        System.out.println("After Alert Accept " + alert.toString());
    }

    @Override
    public void afterDismiss(Alert alert) {
        WebDriverListener.super.afterDismiss(alert);
        System.out.println("After Alert Dismiss " + alert.toString());
    }

    @Override
    public void beforeDismiss(Alert alert) {
        WebDriverListener.super.beforeDismiss(alert);
        System.out.println("Before Alert Dismiss: " + alert.toString());
    }

    @Override
    public void beforeClick(WebElement webElement) {
        WebDriverListener.super.beforeClick(webElement);
        System.out.println("Clicking on " + webElement.getText());
    }

    @Override
    public void afterExecuteScript(WebDriver driver, String script,
                                   Object[] object, Object result) {
        WebDriverListener.super.afterExecuteScript(driver, script, object, result);
        System.out.println("After value change of" + script + object + result);

    }

    @Override
    public void afterClick(WebElement webElement) {
        WebDriverListener.super.afterClick(webElement);
        System.out.println("After clicked" + webElement);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        System.out.println("After Find By"  + locator + result);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        System.out.println("After Find By" + locator + result);
    }

    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        WebDriverListener.super.afterPerform(driver, actions);
        System.out.println("After Script" + actions);
    }

    @Override
    public void beforeResetInputState(WebDriver driver) {
        WebDriverListener.super.beforeResetInputState(driver);
    }

    @Override
    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
        WebDriverListener.super.beforePerform(driver, actions);
        System.out.println("Before Script" + driver + driver);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException exception) {
        WebDriverListener.super.onError(target, method, args, exception);
        System.out.println("On Exception" + exception);
    }
}
