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
import java.time.LocalTime as LocalTime
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter

String time = LocalTime.now()

String hh = time.split(':')[0]

String mm = time.split(':')[1]

String ss = time.split(':')[2]

String[] sss = ss.split('\\.')

String totaltime = (hh + mm) + (sss[0])

String date = LocalDateTime.now()

String date1 = date.split('T')[0]

String[] date2 = date1.split('-')

String generic = (((date2[0]) + (date2[1])) + (date2[2])) + totaltime

String mail = generic + '@test.com'

println('random mail = ' + mail)

GlobalVariable.emailRandom = mail

println('Global random mail = ' + GlobalVariable.emailRandom)

response = WS.sendRequestAndVerify(findTestObject('GoRest/CreateNewUser', [('email') : GlobalVariable.emailRandom]))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def value = result.id

GlobalVariable.userID = value

println('User ID is: ' + GlobalVariable.userID)

WS.sendRequestAndVerify(findTestObject('GoRest/UpdateUser'))

println('User ID is: ' + GlobalVariable.userID)

WS.sendRequestAndVerify(findTestObject('GoRest/DeleteUser'))

