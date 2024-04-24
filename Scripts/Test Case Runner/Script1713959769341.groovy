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

// ===============>>>>> LOGIN TEST CASE
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step login sampai klik button login/android.view.ViewGroup'), 
    0)

Mobile.tap(findTestObject('Object Repository/Step login sampai klik button login/android.view.ViewGroup'), 0)

Mobile.comment('Menuju Ke Halaman Login')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot17835214630489339246.png')

Mobile.setText(findTestObject('Object Repository/Step login sampai klik button login/android.widget.EditText - examplegmail.com'), 
    '082113931132', 0)

Mobile.tap(findTestObject('Object Repository/Step login sampai klik button login/android.widget.TextView - Masukkan Nomor HP atau Email yang Anda Daftarkan'), 
    0)

Mobile.comment('Masukan Email atau Nomor Yang Terdaftar')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot130710273250872867.png')

Mobile.tap(findTestObject('Object Repository/Step login sampai klik button login/android.view.ViewGroup'), 0)

// AMBIL OTP DARI SMS
Mobile.startExistingApplication('com.android.mms')

Mobile.scrollToText('Orbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Get Text OTP/android.widget.TextView - Hindari penipuan Jangan berikan kode OTP kepada siapa pun'), 
    0)

Mobile.tap(findTestObject('Object Repository/Get Text OTP/android.widget.TextView - Hindari penipuan Jangan berikan kode OTP kepada siapa pun'), 
    0)

def sms = Mobile.getText(findTestObject('Object Repository/Get Text OTP/Last OTP'), 0)

// Pisahkan string menjadi potongan-potongan kata
def parts = sms.split()

// Iterasi melalui setiap potongan kata dan cek apakah itu merupakan angka
def otp

for (def part : parts) {
    if (part.isNumber() && (part.length() == 6)) {
        // Angka harus memiliki panjang 6
        otp = part

        break
    }
}

// INPUT OTP
Mobile.startExistingApplication('com.myorbit')

Mobile.delay(5)

Mobile.setText(findTestObject('Object Repository/Step Last Login/android.widget.EditText'), otp, 0)

Mobile.comment('Masukan Kode OTP')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot8984212780594675450.png')

Mobile.tap(findTestObject('Object Repository/Step Last Login/android.view.ViewGroup'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step Last Login/android.widget.TextView - 082114437369'), 
    0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step Last Login/android.widget.ImageView'), 0)

Mobile.comment('User Berhasil Masuk Ke Halaman Beranda')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot15875182626149848142.png')

Mobile.closeApplication()

// ===============>>>>> BUY PACKAGE ORBIT
//======================> START APPLICATION
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'), 
    0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'), 
    0)

//======================> CHECK QUOTA AND BALANCE BEFORE
Mobile.comment('Balance Dan Kuota Sebelum')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16124086500829190260.png')

//======================> GO TO SHOP PAGE
Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/Button Menu', [('menu') : 'Store']), 0 // klik menu shop
    )

Mobile.delay(2)

//======================> FILTER SUB MENU
// MENUJU KE HALAMAN SHOP
Mobile.tap(findTestObject('Object Repository/new step parameterize/Tombol Filter'), 0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/Button Filter Internet Malam', [('text') : 'Orbit Deals']), 
    0)

Mobile.tap(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup (4)'), 0)

//Mobile.tap(findTestObject('Object Repository/new step parameterize/Submenu',[('submenu'):'Semua']), 0)
Mobile.delay(2)

Mobile.scrollToText('Rp 31.000')

Mobile.comment('Menuju Ke Halaman Shop')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16617067492357837838.png')

// ======================> GO TO DETAIL PACKAGE
Mobile.tap(findTestObject('Object Repository/new step parameterize/Choose Package Based On Kuota', [('kuota') : '10GB']), 
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

    Mobile.scrollToText('Cicilan Tanpa Kartu Kredit')

    Mobile.delay(3)

    Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.widget.TextView - Bayar'), 0)

    Mobile.waitForElementPresent(findTestObject('Object Repository/Transaction Steps/android.widget.TextView - ID Transaksi'), 
        0)

    Mobile.tap(findTestObject('Object Repository/Transaction Steps/android.widget.ImageView'), 0)

    'Menuju Ke Halaman Status Transaksi Berhasil\n'
    Mobile.comment('Menuju Ke Halaman Status Transaksi Berhasil')

    Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot11426582452559342387.png')
}


Mobile.closeApplication()

Mobile.delay(10)

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

Mobile.comment('Balance Dan Kuota Setelah')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16124086500829190233.png')

Mobile.closeApplication()

// ===============>>>>> CONSUME SPEEDTEST
// START APPLICATION and CHECK BALANCE&KUOTA BEFORE
Mobile.startExistingApplication('com.myorbit')

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.view.ViewGroup'), 
    0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Step awal sampai metode pembayaran/android.widget.ImageView'), 
    0)

Mobile.comment('Balance dan Kuota Paket Before')

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16124086500829190260.png')

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

Mobile.takeScreenshot('/var/folders/zb/v8_yw3sd0md3rg_vr4q7p7880000gp/T/screenshot16124086500829190260.png')

Mobile.closeApplication()

