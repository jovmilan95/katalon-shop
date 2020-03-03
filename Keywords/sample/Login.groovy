package sample


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

import internal.GlobalVariable
/*
 * Open browser
 * Navigate to URL -> get to Global variable
 * Provide username and password
 * Click on Login
 * */
/*
 * Will read value from Global Variable
 * */
public class Login {
	@Keyword
	def static void loginIntoApplication(String applicationURL,String username,String password){

		WebUI.openBrowser(applicationURL)
		WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)
		WebUI.maximizeWindow()

		WebUI.waitForElementVisible(findTestObject('Pages/MyAccount/nav_HomeMyaccount'), GlobalVariable.waitPresentTimeout)

		WebUI.sendKeys(findTestObject('Pages/MyAccount/txtUsername'), username)
		WebUI.sendKeys(findTestObject('Pages/MyAccount/txtPassword'), password)
		WebUI.click(findTestObject('Pages/MyAccount/btnLogin'))
		WebUI.delay(1)
	}

	@Keyword
	def static void loginIntoApplicationWithGlobalVariable(){
		loginIntoApplication(GlobalVariable.urlLogin, GlobalVariable.username, GlobalVariable.password)
	}

	@Keyword
	def static void loginIntoApplicationWithChangedPasswordWithGlobalVariable(){
		loginIntoApplication(GlobalVariable.urlLogin, GlobalVariable.username, GlobalVariable.newPassword)
	}

	@Keyword
	def static boolean isLogged(){
		return WebUI.waitForElementPresent(findTestObject('Pages/MyAccount/lnkLogout'), GlobalVariable.waitPresentTimeout)
	}

	@Keyword
	def static void logoutFromApplication(){
		WebUI.waitForElementPresent(findTestObject('Pages/MyAccount/lnkMyAccount'), GlobalVariable.waitPresentTimeout)
		WebUI.click(findTestObject('Pages/MyAccount/lnkMyAccount'))
		WebUI.waitForElementPresent(findTestObject('Pages/MyAccount/lnkLogout'), GlobalVariable.waitPresentTimeout)
		WebUI.click(findTestObject('Pages/MyAccount/lnkLogout'))
		WebUI.waitForElementVisible(findTestObject('Pages/MyAccount/nav_HomeMyaccount'), GlobalVariable.waitPresentTimeout)
	}
}
