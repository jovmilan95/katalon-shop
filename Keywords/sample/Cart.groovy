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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement

import internal.GlobalVariable


public class Cart {
	@Keyword
	def void updateCart() {
		WebUI.click(findTestObject('Pages/Cart/updateBtn'));
	}

	@Keyword
	def void clearCart() {
		while (getCartItems().size() != 0) {
			getCartItems().get(0).remove();
		}
	}

	@Keyword
	def boolean isEmpty() {
		return getCartItems().size() == 0
	}

	@Keyword
	def void changeItemQuantityWithGlobalVariable() {
		changeItemQuantity(GlobalVariable.changeQuantity)
	}

	@Keyword
	def void changeItemQuantity(Integer quantity) {
		for(item in getCartItems()) {
			item.setQuantity(quantity)
		}

		updateCart()
		for(item in getCartItems()) {
			println(item.getQuantity())
		}
	}

	@Keyword
	def boolean validateItemSubtotalPrices() {
		for(item in getCartItems()) {
			if(item.getPrice() * item.quantity !=  item.totalPrice)
				return false;
		}

		return true;
	}

	@Keyword
	def boolean validateCartTotalPrice() {
		Double sum = 0;
		for(item in getCartItems()) {
			sum = sum + item.getTotalPrice()
		}

		return sum == getCartTotal().getSubtotalPrice()
	}

	private CartTotal getCartTotal() {
		return new CartTotal()
	}

	private List<CartItem> getCartItems() {
		List<WebElement> rows = WebUiCommonHelper.findWebElements(findTestObject('Pages/Cart/items'), GlobalVariable.waitPresentTimeout)
		List<CartItem> cartItems = []

		for(row in rows) {
			cartItems.add(new CartItem(row))
		}

		return cartItems;
	}
}
