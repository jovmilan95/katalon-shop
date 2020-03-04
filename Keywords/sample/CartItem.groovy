package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.By
import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class CartItem {

	private WebElement _itemRow

	CartItem(WebElement itemRow) {
		_itemRow = itemRow
	}

	public void setQuantity(Integer q) {
		getQuantityTxt().clear()
		getQuantityTxt().sendKeys(q.toString())
	}

	public Integer getQuantity() {
		return getQuantityTxt().getAttribute('value') as Integer
	}

	public Double getPrice() {
		return getPriceLbl().getText().substring(1) as Double
	}

	public Double getTotalPrice() {
		return getTotalPriceLbl().getText().substring(1) as Double
	}

	public void remove() {
		getRemoveBtn().click()
	}

	public String getName() {
		return getNameLbl().getText()
	}


	private WebElement getRemoveBtn() {
		return findElement(By.cssSelector('.product-remove .remove'))
	}

	private WebElement getNameLbl() {
		return findElement(By.cssSelector('.product-name'))
	}

	private WebElement getPriceLbl() {
		return findElement(By.cssSelector('.product-price .amount'))
	}

	private WebElement getQuantityTxt() {
		return findElement(By.cssSelector('.quantity input'))
	}

	private WebElement getTotalPriceLbl() {
		return findElement(By.cssSelector('.product-subtotal .amount'))
	}

	private WebElement findElement(By by) {
		return _itemRow.findElement(by)
	}
}
