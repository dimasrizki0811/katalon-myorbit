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

def sms = Mobile.getText(findTestObject('Object Repository/Get Text OTP/Last OTP'),
	0)

// Pisahkan string menjadi potongan-potongan kata
def parts = sms.split()

// Iterasi melalui setiap potongan kata dan cek apakah itu merupakan angka
def otp
for (part in parts) {
	if (part.isNumber() && part.length() == 6) { // Angka harus memiliki panjang 6
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