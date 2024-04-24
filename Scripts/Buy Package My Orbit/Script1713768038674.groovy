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


// ===============>>>>> BUY PACKAGE ORBIT
//======================> START APPLICATION
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'), 
    0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'), 
    0)

//======================> CHECK QUOTA AND BALANCE BEFORE
Mobile.comment('Balance Dan Kuota Sebelum')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot10985552080094151514.png')

//======================> GO TO SHOP PAGE
Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/Button Menu', [('menu') : 'Store']), 0 // klik menu shop
    )

Mobile.delay(2)

//======================> FILTER SUB MENU
// MENUJU KE HALAMAN SHOP
Mobile.tap(findTestObject('Object Repository/new step parameterize/Tombol Filter'), 0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/Button Filter Internet Malam', [('text') : 'Internet Malam']), 
    0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (4)'), 0)

//Mobile.tap(findTestObject('Object Repository/new step parameterize/Submenu',[('submenu'):'Semua']), 0)
Mobile.delay(2)

Mobile.scrollToText('Rp 6.000')

Mobile.comment('Menuju Ke Halaman Shop')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16617067492357837838.png')

// ======================> GO TO DETAIL PACKAGE
Mobile.tap(findTestObject('Object Repository/new step parameterize/Choose Package Based On Kuota', [('kuota') : '3GB']), 
    0)

int status = 1

if (status == 1) {
    Mobile.comment('Muncul Bottom Sheet Untuk Beli Lagi')

    Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556112329.png')

    Mobile.tap(findTestObject('Object Repository/new step parameterize/Button Beli Lagi'), 0)

    Mobile.waitForElementPresent(findTestObject('Object Repository/Transaction Steps/android.widget.TextView - ID Transaksi'), 
        0)

    'Menuju Ke Halaman Status Transaksi Berhasil\n'
    Mobile.comment('Menuju Ke Halaman Status Transaksi Berhasil')

    Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot11429582412559342387.png')
    // ======================> PAYMENT PROCEED
} else {
    Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Deskripsi Paket'), 
        0)

    Mobile.comment('Detail Paket  Deskripsi Paket')

    Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556113829.png')

    Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (6)'), 0)

    Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - 1)'), 
        0)

    Mobile.comment('Detail Paket  Syarat dan Ketentuan')

    Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot2058095286556113821.png')

    Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (7)'), 0)

    Mobile.verifyElementVisible(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.TextView - Pulsa Anda'), 
        0)

    Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.view.ViewGroup'), 0)

    Mobile.comment('Menuju Ke Halaman Motode Pembayaran dan Pilih Metode Pembayaran Pulsa')

    Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot14538088816619485564.png')

    Mobile.scrollToText('Bayar')

    Mobile.delay(3)

//    Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.widget.TextView - Bayar'), 0)
//
//    Mobile.waitForElementPresent(findTestObject('Object Repository/Transaction Steps/android.widget.TextView - ID Transaksi'), 
//        0)
//
//    Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.widget.ImageView'), 0)
//
//    'Menuju Ke Halaman Status Transaksi Berhasil\n'
//    Mobile.comment('Menuju Ke Halaman Status Transaksi Berhasil')
//
//    Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot11426582452559342387.png')
}


Mobile.closeApplication()

Thread.sleep(60000)

// ======================> CHECK INBOX MY ORBIT ========> COMMENT DULU KARENA DI STEP DARI PAK ANDRI TIDAK ADA CHCEK NOTIFIKASI
//Mobile.startExistingApplication('com.myorbit')
//Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'),
//	0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'),
//	0)
//
//Mobile.tap(findTestObject('Object Repository/new step parameterize/button notification'), 0)
//
//Mobile.delay(2)
////
//Mobile.comment('Check Inbox My Orbit')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot12744918902500336899.png')
//
//Mobile.tap(findTestObject('Object Repository/Check Inbox Steps/android.view.ViewGroup (2)'), 0)
//
//Mobile.tap(findTestObject('Object Repository/Check Inbox Steps/android.widget.TextView - Info'), 0)
//
//Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
//
//Mobile.comment('Check Detail Inbox My Orbit')
//
//Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16085326726417010224.png')
//
//Mobile.closeApplication()
// ======================> CHECK QUOTA AFTER
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'),
	0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'),
	0)

Thread.sleep(2000)
'Get Device Height and Store in device_height variable'

device_Height = Mobile.getDeviceHeight()

'Get Width Height and Store in device_Width variable'

device_Width = Mobile.getDeviceWidth()

'Storing the startX value by dividing device width by 2. Because x coordinates are constant for Vertical Swiping'

int startX = device_Width / 2

'Here startX and endX values are equal for vertical Swiping for that assigning startX value to endX'

int endX = startX

'Storing the startY value'

int startY = device_Height * 0.30

'Storing the endY value'

int endY = device_Height * 0.70

'Swipe Vertical from top to bottom'

Mobile.swipe(startX, endY, endX, startY)

'Swipe Vertical from bottom to top'

Mobile.swipe(startX, startY, endX, endY)


Mobile.comment('Balance Dan Kuota Setelah')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot13830569871800556217.png')

Mobile.closeApplication()



