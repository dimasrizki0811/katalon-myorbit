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

// START APPLICATION and CHECK BALANCE&KUOTA BEFORE
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'), 
    0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'), 
    0)

Mobile.comment('Balance Dan Kuota Sebelum')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16124086500829190260.png')

// MENUJU KE HALAMAN SHOP
Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (3)'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Internet Malam'), 
    0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Internet Malam'), 
    0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (4)'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Internet Malam (1)'), 
    0)

Mobile.comment('Menuju Ke Halaman Shop')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16617067492357837838.png')

// MENUJU KE HALAMAN DETAIL PAKET
Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (5)'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Deskripsi Paket'), 
    0)

Mobile.comment('Detail Paket - Deskripsi Paket')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556113829.png')

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (6)'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - 1)'), 
    0)

Mobile.comment('Detail Paket - Syarat dan Ketentuan')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556113821.png')

// MENUJU KE HALAMAN METODE PEMBAYARAN
Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (7)'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Pulsa Anda'), 
    0)

Mobile.comment('Menuju Ke Halaman Metode Pembayaran')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556113821.png')

Mobile.closeApplication()

