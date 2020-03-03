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

WebUI.openBrowser(GlobalVariable.urlShop)

WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)

WebUI.mouseOver(findTestObject('RecordAndPlayback/Product Card/Show View Cart button by clicking on Add To Cart button/firstProductCard'))

WebUI.verifyElementVisible(findTestObject('RecordAndPlayback/Product Card/Show View Cart button by clicking on Add To Cart button/lnkAddToCart'))

WebUI.click(findTestObject('RecordAndPlayback/Product Card/Show View Cart button by clicking on Add To Cart button/lnkAddToCart'))

assert WebUI.verifyElementVisible(findTestObject('RecordAndPlayback/Product Card/Show View Cart button by clicking on Add To Cart button/lnkViewCart'))

WebUI.closeBrowser()

