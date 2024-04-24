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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// ===============>>>>> CONSUME SPEEDTEST
// START APPLICATION and CHECK BALANCE&KUOTA BEFORE
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'),
	0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'),
	0)

Mobile.comment('Balance dan Kuota Paket Before')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot1562391428000008065.png')

Mobile.closeApplication()

Mobile.startExistingApplication('org.zwanoo.android.speedtest')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step consume quota/android.view.View'), 0)

Mobile.comment('Buka Aplikasi Speedtest')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16277343731287010838.png')

Mobile.tap(findTestObject('Object Repository/Step consume quota/android.view.View'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step consume quota/android.widget.TextView - Mbps'), 0)

WebUI.comment('Jalankan Speedtest')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16576112566209073.png')

Thread.sleep(20000)

Mobile.waitForElementPresent(findTestObject('Object Repository/new step parameterize/android.widget.TextView - DOWNLOAD'),
	0)

Mobile.comment('Melihat Result Speedtest')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot13194284071448124261.png')

Mobile.closeApplication()

Mobile.delay(5)

// START APPLICATION and CHECK BALANCE&KUOTA AFTER
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'),
	0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'),
	0)

Mobile.comment('Balance dan Kuota Paket After')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot17596607106719789484.png')

Mobile.closeApplication()

