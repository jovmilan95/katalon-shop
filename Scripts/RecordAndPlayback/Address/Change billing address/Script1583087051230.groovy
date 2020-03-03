import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'sample.Login.loginIntoApplicationWithGlobalVariable'()

WebUI.click(findTestObject('RecordAndPlayback/Change billing address/lnkAddresses'))

WebUI.click(findTestObject('RecordAndPlayback/Change billing address/lnkEditBillingAddress'))

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtFirstName'), GlobalVariable.billingFirstName)

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtLastname'), GlobalVariable.billingLastName)

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtCompany'), GlobalVariable.billingCompany)

WebUI.click(findTestObject('RecordAndPlayback/Change billing address/lblCountryField'))

WebUI.waitForElementPresent(findTestObject('RecordAndPlayback/Change billing address/txtCountrySearch'), GlobalVariable.waitPresentTimeout)

WebUI.click(findTestObject('RecordAndPlayback/Change billing address/txtCountrySearch'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtCountrySearch'), GlobalVariable.billingCountry)

WebUI.sendKeys(findTestObject('RecordAndPlayback/Change billing address/txtCountrySearch'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtAddress'), GlobalVariable.billingAddress)

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtCity'), GlobalVariable.billingTown)

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtPostcode'), GlobalVariable.billingPostcode)

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtPhone'), GlobalVariable.billingPhone)

WebUI.setText(findTestObject('RecordAndPlayback/Change billing address/txtEmail'), GlobalVariable.billingEmail)

WebUI.click(findTestObject('RecordAndPlayback/Change billing address/btnSave'))

assert WebUI.verifyElementPresent(findTestObject('RecordAndPlayback/Change billing address/divAddressChangedSuccessfully'), 
    GlobalVariable.waitPresentTimeout)

CustomKeywords.'sample.Login.logoutFromApplication'()

WebUI.closeBrowser()

