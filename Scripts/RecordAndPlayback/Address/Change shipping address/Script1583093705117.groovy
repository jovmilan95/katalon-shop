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

WebUI.click(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/lnkAddresses'))

WebUI.click(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/lnkEditShippingAddress'))

WebUI.setText(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtFirstName'), GlobalVariable.shippingFirstName)

WebUI.setText(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtLastName'), GlobalVariable.shippingLastName)

WebUI.setText(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtCompany'), GlobalVariable.shippingCompany)

WebUI.click(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/lblCountry'))

WebUI.verifyElementVisible(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtCountrySearch'))

WebUI.setText(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtCountrySearch'), GlobalVariable.shippingCountry)

WebUI.sendKeys(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtCountrySearch'), Keys.chord(
        Keys.ENTER))

WebUI.setText(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtAddress'), GlobalVariable.shippingAddress)

WebUI.setText(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtPostcode'), GlobalVariable.shippingPostcode)

WebUI.setText(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/txtCity'), GlobalVariable.shippingTown)

WebUI.click(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/btnSave'))

assert WebUI.verifyElementPresent(findTestObject('Object Repository/RecordAndPlayback/Change shipping address/divAddressChangedSuccessfully'), 
    GlobalVariable.waitPresentTimeout)

CustomKeywords.'sample.Login.logoutFromApplication'()

WebUI.closeBrowser()

