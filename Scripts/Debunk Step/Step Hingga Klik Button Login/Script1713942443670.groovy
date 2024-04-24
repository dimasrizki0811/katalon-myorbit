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

Mobile.closeApplication()

