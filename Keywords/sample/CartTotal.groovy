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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement

import internal.GlobalVariable

public class CartTotal {

	CartTotal() { }

	public Double getSubtotalPrice() {
		return getSubtotalPriceLbl().getText().substring(1) as Double
	}

	public Double getFlatRate() {
		return getFlatRateLbl().getText().substring(1) as Double
	}

	public Double getTotal() {
		return getTotalLbl().getText().substring(1) as Double
	}

	public String getShippingAddress() {
		return getShippingAddressLbl().getText();
	}

	public String updateShippingAddress(String country, String city, String postcode) {
	}
	private WebElement getSubtotalPriceLbl() {
		return findElement(By.cssSelector('[data-title="Subtotal"] .amount'))
	}

	private WebElement getFlatRateLbl() {
		return findElement(By.cssSelector('.shipping .amount'))
	}

	private WebElement getTotalLbl(){
		return findElement(By.cssSelector('.order-total .amount'))
	}

	private WebElement getShippingAddressLbl() {
		return findElement(By.cssSelector('.woocommerce-shipping-destination strong'))
	}

	private WebElement findElement(By by) {
		WebUiCommonHelper.findWebElement(findTestObject('Pages/Cart/cartTotals'), 10)
				.findElement(by);
	}
}
