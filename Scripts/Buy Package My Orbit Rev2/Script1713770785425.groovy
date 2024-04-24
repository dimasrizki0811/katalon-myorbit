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

// ==========> START APPLICATION
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'), 
    0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'), 
    0)



// ==========> SS CHECK BALANCE AND QUOTA BEFORE
Mobile.comment('Balance Dan Kuota Sebelum')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16124086500829190260.png')



// ==========> GO TO SHOP PAGE
Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (3)'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Internet Malam'), 
    0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/Button Filter Internet Malam',[('text'):'Promo Terbatas']), 
    0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (4)'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/Category Selected',[('text'):'Promo Terbatas']), 
    0)

Mobile.comment('Menuju Ke Halaman Shop')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16617067492357837838.png')

// ==========> FUNCTION SCROLL
 
Mobile.scrollToText('Rp 20.000')
Mobile.delay(5)





//// ==========> DETAIL PACKAGE DESCRIPTION AND TERMS CONDITIONS
//Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (5)'), 0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Deskripsi Paket'), 
//    0)
//
//Mobile.comment('Detail Paket - Deskripsi Paket')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556113829.png')
//
//Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (6)'), 0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - 1)'), 
//    0)
//
//Mobile.comment('Detail Paket - Syarat dan Ketentuan')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556113821.png')
//
//
//
//// ==========> CLICK BUY AND GO TO PAYMENT METHOD
//Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (7)'), 0)
//
//Mobile.verifyElementVisible(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Pulsa Anda'), 
//    0)
//
//Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.view.ViewGroup'), 0)
//
//Mobile.comment('Menuju Ke Halaman Motode Pembayaran dan Pilih Metode Pembayaran Pulsa')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot14538088816619485564.png')
//
//Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.widget.TextView - Bayar'), 0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/Transaction Steps/android.widget.TextView - ID Transaksi'), 
//    0)
//
//
//
//// ==========> PAYMENT STATUS
//
//Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.widget.ImageView'), 0)
//
//Mobile.comment('Menuju Ke Halaman Status Transaksi Berhasil')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot11426582452559342387.png')
//
//Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.view.ViewGroup (1)'), 0)
//
//Mobile.closeApplication()
//
//
//
//// ==========> CHECK INBOX
//
//Mobile.startExistingApplication('com.myorbit')
//
//Mobile.verifyElementExist(findTestObject('Object Repository/Check Inbox Steps/android.widget.TextView -   3GB'), 0)
//
//Mobile.tap(findTestObject('Object Repository/Check Inbox Steps/android.widget.ImageView'), 0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/Check Inbox Steps/android.view.ViewGroup'), 0)
//
//Mobile.comment('Check Inbox My Orbit')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot12744918902500336899.png')
//
//Mobile.tap(findTestObject('Object Repository/Check Inbox Steps/android.view.ViewGroup (2)'), 0)
//
//Mobile.tap(findTestObject('Object Repository/Check Inbox Steps/android.widget.TextView - Info'), 0)
//
//Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)
//
//Mobile.comment('Check Detail Inbox My Orbit')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16085326726417010224.png')
//
//Mobile.closeApplication()
//
//
//
//// ==========> CHECK BALANCE AND QUOTA AFTER
//
//Mobile.startExistingApplication('com.myorbit')
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'), 
//    0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'), 
//    0)
//
//Mobile.comment('Balance Dan Kuota Setelah')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16124086500829190233.png')
//
//Mobile.closeApplication()

