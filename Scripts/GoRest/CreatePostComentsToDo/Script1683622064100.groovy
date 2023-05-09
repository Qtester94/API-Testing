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

respons = WS.sendRequestAndVerify(findTestObject('GoRest/Users'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(respons.getResponseBodyContent())

def value = result.id

GlobalVariable.userID = (value[0])

println(GlobalVariable.userID)

WS.sendRequestAndVerify(findTestObject('GoRest/CreatePost'))

WS.sendRequestAndVerify(findTestObject('GoRest/CreateComents'))

respons1 = WS.sendRequestAndVerify(findTestObject('GoRest/AllToDo'))

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper1.parseText(respons1.getResponseBodyContent())

def value1 = result1.user_id

GlobalVariable.userID = (value1[0])
println(GlobalVariable.userID)

WS.sendRequestAndVerify(findTestObject('GoRest/CreateToDo'))

