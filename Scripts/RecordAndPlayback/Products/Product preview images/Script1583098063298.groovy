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

WebUI.openBrowser('')

CustomKeywords.'sample.Shop.navigatetoDetailPage'(GlobalVariable.productName, GlobalVariable.urlProduct)

WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)

WebUI.click(findTestObject('RecordAndPlayback/Products/Product preview images/btnImgPreview'))

assert WebUI.verifyElementPresent(findTestObject('RecordAndPlayback/Products/Product preview images/imgActiveImage'), GlobalVariable.waitPresentTimeout)

WebUI.click(findTestObject('RecordAndPlayback/Products/Product preview images/btnClosePreview'))

assert WebUI.waitForElementNotVisible(findTestObject('Object Repository/RecordAndPlayback/Products/Product preview image zoom in/divImgZoomWrapper'), GlobalVariable.waitPresentTimeout)

WebUI.closeBrowser()

