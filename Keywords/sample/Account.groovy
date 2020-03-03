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

import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class Account {

	@Keyword
	def static void changePassword(String currentPassword, String newPassword){
		WebUI.waitForElementPresent(findTestObject('Pages/MyAccount/lnkAccountDetails'), GlobalVariable.waitPresentTimeout)
		WebUI.click(findTestObject('Pages/MyAccount/lnkAccountDetails'))

		WebUI.sendKeys(findTestObject('Pages/AccountDetails/txtCurrentPassword'), currentPassword)
		WebUI.sendKeys(findTestObject('Pages/AccountDetails/txtNewPassword'), newPassword)
		WebUI.sendKeys(findTestObject('Pages/AccountDetails/txtConfirmNewPassword'), newPassword)

		if(newPassword == GlobalVariable.password) {
			//the default password does not meet the password requirements
			//Save btn must be enabled to restore the default password
			WebUI.executeJavaScript("document.querySelector(\"[name='save_account_details']\").removeAttribute('disabled')", null)
		}
		WebUI.click(findTestObject('Pages/AccountDetails/btnSaveChanges'))
	}

	@Keyword
	def static void changePasswordWithGlobalVariable(){
		changePassword(GlobalVariable.password, GlobalVariable.newPassword)
	}

	@Keyword
	def static void restorePasswordWithGlobalVariable(){
		changePassword(GlobalVariable.newPassword, GlobalVariable.password)
	}

	@Keyword
	def static void changeAccountInfo(String firstName, String lastName, String displayName, String email){
		WebUI.waitForElementPresent(findTestObject('Pages/MyAccount/lnkAccountDetails'), GlobalVariable.waitPresentTimeout)
		WebUI.click(findTestObject('Pages/MyAccount/lnkAccountDetails'))

		WebUI.clearText(findTestObject('Pages/AccountDetails/txtFirstName'))
		WebUI.sendKeys(findTestObject('Pages/AccountDetails/txtFirstName'), firstName)

		WebUI.clearText(findTestObject('Pages/AccountDetails/txtLastName'))
		WebUI.sendKeys(findTestObject('Pages/AccountDetails/txtLastName'), lastName)

		WebUI.clearText(findTestObject('Pages/AccountDetails/txtDisplayName'))
		WebUI.sendKeys(findTestObject('Pages/AccountDetails/txtDisplayName'), displayName)

		WebUI.clearText(findTestObject('Pages/AccountDetails/txtEmail'))
		WebUI.sendKeys(findTestObject('Pages/AccountDetails/txtEmail'), email)

		WebUI.click(findTestObject('Pages/AccountDetails/btnSaveChanges'))
	}

	@Keyword
	def static void changeAccountInfoWithGlobalVariable() {
		changeAccountInfo(GlobalVariable.newFirstName,
				GlobalVariable.newLastName ,
				GlobalVariable.newDisplayName,
				GlobalVariable.newEmail)
	}
	@Keyword
	def static boolean verifyInfoChanges(String firstName, String lastName, String displayName, String email) {
		WebUI.waitForElementPresent(findTestObject('Pages/MyAccount/lnkAccountDetails'), GlobalVariable.waitPresentTimeout)
		WebUI.click(findTestObject('Pages/MyAccount/lnkAccountDetails'))

		return WebUI.getAttribute(findTestObject('Pages/AccountDetails/txtFirstName'), "value") == firstName &&
				WebUI.getAttribute(findTestObject('Pages/AccountDetails/txtLastName'), "value") == lastName &&
				WebUI.getAttribute(findTestObject('Pages/AccountDetails/txtDisplayName'), "value") == displayName &&
				WebUI.getAttribute(findTestObject('Pages/AccountDetails/txtEmail'), "value") == email
	}
	@Keyword
	def static boolean verifyInfoChangesWithGlobalVariable() {
		return verifyInfoChanges(GlobalVariable.newFirstName,
				GlobalVariable.newLastName ,
				GlobalVariable.newDisplayName,
				GlobalVariable.newEmail)
	}
}
