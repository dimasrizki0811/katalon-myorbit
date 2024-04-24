
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.io.comparator.LastModifiedFileComparator

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.io.FileType

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase

import org.apache.poi.util.Units
import org.apache.poi.xwpf.usermodel.ParagraphAlignment
import org.apache.poi.xwpf.usermodel.TextAlignment
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFPicture
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.apache.poi.xwpf.usermodel.XWPFSDTCell
import org.apache.poi.xwpf.usermodel.XWPFTable
import org.apache.poi.xwpf.usermodel.XWPFTableCell
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign
import org.apache.poi.xwpf.usermodel.XWPFTableRow
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlBlock

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Stream

/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */
@SetUp(skipped = true) // Please change skipped to be false to activate this method.
def setUp() {
	// Put your code here.
}

/**
 * Clean test suites environment.
 */

@TearDown(skipped = false) // Please change skipped to be false to activate this method.
def tearDown() {	
	String separator = File.separator
	
	String reportDiretory = System.getProperty("user.dir") +separator +"Reports" +separator
	File fileReportDiretory = new File(reportDiretory);
	File[] reportFolders = fileReportDiretory.listFiles()
	Arrays.sort(reportFolders, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR)
	
	def arrayFolderName = [];
	for(File file: reportFolders) {
		if(file.getName().matches(".*[0-9].*")) {
			arrayFolderName.add(file.getName())
		}
	}
	
	String lastFolderName = arrayFolderName.last()
	
	String targetTestSuiteFolder = "Run Test Suite"
	
	String targetReportDiretory = System.getProperty("user.dir") +separator +"Reports" +separator +lastFolderName +separator +targetTestSuiteFolder +separator
	File targetFileReportDiretory = new File(targetReportDiretory);
	File[] targetReportFolders = targetFileReportDiretory.listFiles()
	String getFolderName = targetReportFolders[0].getName()
	
	File junitFileTarget = new File(targetReportDiretory +separator +getFolderName +separator +"JUnit_Report.xml")
	System.out.println(junitFileTarget.exists())
	System.out.println(junitFileTarget.getAbsolutePath())
	
	String filepath =junitFileTarget
	System.out.println("filepath : " +filepath)
//	File file = new File(filepath)
//	//		System.out.println(file.exists())
//	
//			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//			Document doc = docBuilder.parse(filepath)
//			NodeList list = doc.getElementsByTagName("testcase")
//			
//			List<List<String>> listSummary = new ArrayList<List<String>>()
//			List<List<String>> listComments = new ArrayList<List<String>>()
//			List<List<String>> listTakeScreenshots = new ArrayList<List<String>>()
//			
//			for(Node node: list) {
//				String[] lines = node.getChildNodes().item(1).toString().split("\\r?\\n")
//				List<String> comments = new ArrayList<String>();
//				List<String> takeScreenshots = new ArrayList<String>();
//				
//				List<String> summary = new ArrayList<String>();
//				
//				String startDate = ""
//				for(int i=0; i<lines.length; i++) {
//					String line = lines[i].toString()
//					
//					if(i==0) {
//						Pattern pattern = Pattern.compile("CDATA(.*?)TEST_CASE");
//						Matcher matcher = pattern.matcher(line);
//	
//						while (matcher.find()) {
//							startDate = matcher.group(1).replace("[", "").replace(" ", "")
//							StringBuffer sb = new StringBuffer(startDate)
//							startDate = sb.deleteCharAt(sb.length()-1)
//						}
//					}
//					
//					if(line.contains("comment")) {
//						Pattern pattern = Pattern.compile("\"(.*?)\"");
//						Matcher matcher = pattern.matcher(line);
//	
//						while (matcher.find()) {
//							comments.add(matcher.group(1))
//						}
//					}
//					
//					if(line.contains("takeScreenshot")) {
//						Pattern pattern = Pattern.compile("\"(.*?)\"");
//						Matcher matcher = pattern.matcher(line);
//	
//						while (matcher.find()) {
//							takeScreenshots.add(matcher.group(1))
//						}
//					}
//				}
//				
//				String name = node.getAttributes().getNamedItem("name").getNodeValue().split("/")[1]
//				String time = node.getAttributes().getNamedItem("time").getNodeValue()
//				String status = node.getAttributes().getNamedItem("status").getNodeValue()
//				String date = startDate.split("T")[0]
//				String start = startDate.split("T")[1]
//				
//				summary.add(name)
//				summary.add(status)
//				summary.add(date)
//				summary.add(start)
//				summary.add(time)
//				
//				listSummary.add(summary)
//				listComments.add(comments)
//				listTakeScreenshots.add(takeScreenshots)
//			}
//			
//			int totalTc = listSummary.size()
//			
//			//create and insert data to docx using apache poi
//			XWPFDocument document = new XWPFDocument()
//			XWPFTable tblSummary = document.createTable(totalTc, 5)
//			
//			
//			
//			 
//	
//			
//			for(int i=0; i<totalTc; i++) {
//				String name = listSummary.get(i).get(0)
//				String status = listSummary.get(i).get(1)
//				String date = listSummary.get(i).get(2)
//				String start = listSummary.get(i).get(3)
//				String time = listSummary.get(i).get(4)
//				
//				tblSummary.getRow(i).getCell(0).setText(name)
//				tblSummary.getRow(i).getCell(1).setText(status)
//				tblSummary.getRow(i).getCell(2).setText(date)
//				tblSummary.getRow(i).getCell(3).setText(start)
//				tblSummary.getRow(i).getCell(4).setText(time)
//			}
//			
//			XWPFParagraph p = document.createParagraph()
//			XWPFRun r = p.createRun()
//			r.setText("")
//			
//			for(int i=0; i<totalTc; i++) {
//				int totalLoopByComment = listComments.get(i).size()
//				XWPFTable tblEvidence = document.createTable(totalLoopByComment, 3)
//				
//				for(int j=0; j<totalLoopByComment; j++) {
//					String comment = listComments.get(i).get(j)
//					String takeScreenshot = listTakeScreenshots.get(i).get(j)
//					
//					
//					tblEvidence.getRow(j).getCell(0).setText(comment)
//					
//					XWPFTableCell cell = tblEvidence.getRow(j).getCell(1)
//					XWPFParagraph paragraph = cell.addParagraph()
//					XWPFRun run = paragraph.createRun()
//					FileInputStream fis = new FileInputStream(takeScreenshot)
//					run.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, "pict", Units.pixelToEMU(188), Units.pixelToEMU(415))
//					
//					tblEvidence.getRow(j).getCell(2).setText("OK")
//				}
//				
//				p = document.createParagraph()
//				r = p.createRun()
//				r.setText("")
//			}
			
	File file = new File(filepath)
	//		System.out.println(file.exists())
	
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath)
			
			String device = ""
			NodeList propertyList = doc.getElementsByTagName("property")
			for(Node n: propertyList) {
				String name = n.getAttributes().getNamedItem("name")
				String value = n.getAttributes().getNamedItem("value")
				if(name.contains("deviceName")) {
					device = value.split("=")[1].replace("\"", "")
					break
				}
			}
			
			NodeList list = doc.getElementsByTagName("testcase")
			
			List<List<String>> listSummary = new ArrayList<List<String>>()
			List<List<String>> listComments = new ArrayList<List<String>>()
			List<List<String>> listTakeScreenshots = new ArrayList<List<String>>()
			
			for(Node node: list) {
				String[] lines = node.getChildNodes().item(1).toString().split("\\r?\\n")
				List<String> comments = new ArrayList<String>();
				List<String> takeScreenshots = new ArrayList<String>();
				
				List<String> summary = new ArrayList<String>();
				
				String startDate = ""
				for(int i=0; i<lines.length; i++) {
					String line = lines[i].toString()
					
					if(i==0) {
						Pattern pattern = Pattern.compile("CDATA(.*?)TEST_CASE");
						Matcher matcher = pattern.matcher(line);
	
						while (matcher.find()) {
							startDate = matcher.group(1).replace("[", "").replace(" ", "")
							StringBuffer sb = new StringBuffer(startDate)
							startDate = sb.deleteCharAt(sb.length()-1)
						}
					}
					
					if(line.contains("comment")) {
	//					Pattern pattern = Pattern.compile("\"(.*?)\"");
	//					Matcher matcher = pattern.matcher(line);
	//
	//					while (matcher.find()) {
	//						comments.add(matcher.group(1))
	//					}
						
						String getMessageInfoNextTwoLines = lines[i+2].toString()
						getMessageInfoNextTwoLines = getMessageInfoNextTwoLines.split("INFO")[1].replace("]", "")
						getMessageInfoNextTwoLines = getMessageInfoNextTwoLines.replace(getMessageInfoNextTwoLines.substring(0, 3), "")
						comments.add(getMessageInfoNextTwoLines)
					}
					
					if(line.contains("takeScreenshot")) {
						Pattern pattern = Pattern.compile("\"(.*?)\"");
						Matcher matcher = pattern.matcher(line);
	
						while (matcher.find()) {
							takeScreenshots.add(matcher.group(1))
						}
					}
				}
				
				String name = node.getAttributes().getNamedItem("name").getNodeValue().split("/")[1]
				String time = node.getAttributes().getNamedItem("time").getNodeValue()
				if(time.contains(".")) {
					time = time.split("\\.")[0]
				}
				
				String status = node.getAttributes().getNamedItem("status").getNodeValue()
				String date = startDate.split("T")[0]
				String start = startDate.split("T")[1]
				
				summary.add(name)
				summary.add(status)
				summary.add(date)
				summary.add(start)
				summary.add(time)
				
				listSummary.add(summary)
				listComments.add(comments)
				listTakeScreenshots.add(takeScreenshots)
			}
			
			int totalTc = listSummary.size()
			
			//create and insert data to docx using apache poi
			XWPFDocument document = new XWPFDocument()
			
			//table summary +1 rows, to add header table
			XWPFTable tblSummary = document.createTable(totalTc +1, 5)
	//		CTTblWidth cTblWidth = tblSummary.getCTTbl().addNewTblPr().addNewTblW()
	//		cTblWidth.setType(STTblWidth.DXA)
	//		cTblWidth.setW(BigInteger.valueOf(9072))
			
			//table header summary
			XWPFTableRow rowInTbl = tblSummary.getRow(0);
			XWPFTableCell cInTbl = rowInTbl.getCell(0);
			XWPFParagraph pInTbl = cInTbl.addParagraph();
			XWPFRun rInTbL = pInTbl.createRun();
			rInTbL.setText("Name");
			rInTbL.setBold(true)
			cInTbl.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(8000))
			
			CTBookmark bookmarkTblSummary = pInTbl.getCTP().addNewBookmarkStart()
			bookmarkTblSummary.setName("summary")
			bookmarkTblSummary.setId(BigInteger.valueOf(0))
			pInTbl.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(0))
			
			cInTbl = rowInTbl.getCell(1);
			pInTbl = cInTbl.addParagraph();
			rInTbL = pInTbl.createRun();
			rInTbL.setText("Status");
			rInTbL.setBold(true)
			cInTbl.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
			
			cInTbl = rowInTbl.getCell(2);
			pInTbl = cInTbl.addParagraph();
			rInTbL = pInTbl.createRun();
			rInTbL.setText("Date");
			rInTbL.setBold(true)
			cInTbl.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
			
			cInTbl = rowInTbl.getCell(3);
			pInTbl = cInTbl.addParagraph();
			rInTbL = pInTbl.createRun();
			rInTbL.setText("Start");
			rInTbL.setBold(true)
			cInTbl.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
			
			cInTbl = rowInTbl.getCell(4);
			pInTbl = cInTbl.addParagraph();
			rInTbL = pInTbl.createRun();
			rInTbL.setText("Time (s)");
			rInTbL.setBold(true)
			cInTbl.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
			
			
	//		tblSummary.getRow(0).getCell(0).setText("Name")
	//		tblSummary.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(8000))
	//
	//		tblSummary.getRow(0).getCell(1).setText("Status")
	//		tblSummary.getRow(0).getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
	//
	//		tblSummary.getRow(0).getCell(2).setText("Date")
	//		tblSummary.getRow(0).getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
	//
	//		tblSummary.getRow(0).getCell(3).setText("Start")
	//		tblSummary.getRow(0).getCell(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
	//
	//		tblSummary.getRow(0).getCell(4).setText("Time")
	//		tblSummary.getRow(0).getCell(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000))
	
			
			for(int i=0; i<totalTc; i++) {
				String name = listSummary.get(i).get(0)
				String status = listSummary.get(i).get(1)
				String date = listSummary.get(i).get(2)
				String start = listSummary.get(i).get(3)
				String time = listSummary.get(i).get(4)
				
				tblSummary.getRow(i+1).getCell(0).setText(name)
				tblSummary.getRow(i+1).getCell(1).setText(status)
				tblSummary.getRow(i+1).getCell(2).setText(date)
				tblSummary.getRow(i+1).getCell(3).setText(start)
				tblSummary.getRow(i+1).getCell(4).setText(time)
			}
			
			XWPFParagraph p = document.createParagraph()
			XWPFRun r = p.createRun()
			r.setText("")
			
	//		List<String> bookmarks = new ArrayList<String>()
	//		bookmarks.add("book1")
	//		bookmarks.add("book2")
			
			for(int i=0; i<totalTc; i++) {
				int totalLoopByComment = listComments.get(i).size()
				
				//table evidence +6 rows, to add summary
				XWPFTable tblEvidence = document.createTable(totalLoopByComment+6, 3)
				
	//			XWPFParagraph parag = document.createParagraph()
	//			XWPFRun rr = parag.createRun()
	//			rr.setText("Back to summary")
				
				XWPFParagraph parag = tblEvidence.getRow(0).getCell(0).addParagraph()
				parag.setAlignment(ParagraphAlignment.CENTER)
				parag.setPageBreak(true)
				XWPFRun rrr = parag.createRun()
				rrr.setBold(true)
				rrr.setText(listSummary.get(i).get(0))
				
				CTBookmark bookmark = parag.getCTP().addNewBookmarkStart()
				bookmark.setName(listSummary.get(i).get(2).replace("-", "") +"T" +listSummary.get(i).get(3).replace(":", ""))
				bookmark.setId(BigInteger.valueOf(0))
				parag.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(0))
	//
	//			bookmark = parag.getCTP().addNewBookmarkStart();
	//			bookmark.setName("testing_string");
	//			bookmark.setId(BigInteger.valueOf(1));
	//
	//			XWPFRun rr = parag.createRun();
	//			rr.setText("testing string ");
	//
	//			parag.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(1));
	//
	//			bookmark = parag.getCTP().addNewBookmarkStart();
	//			bookmark.setName("after_testing_string");
	//			bookmark.setId(BigInteger.valueOf(2));
	//			parag.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(2));
				
	//			tblEvidence.getRow(0).getCell(0).setText(listSummary.get(i).get(0))
	//			tblEvidence.getRow(0).getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER)
				tblEvidence.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewShd().setFill("82CAFF")
				tblEvidence.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000))
				tblEvidence.getRow(0).getCell(1).setText("")
				tblEvidence.getRow(0).getCell(1).getCTTc().addNewTcPr().addNewShd().setFill("82CAFF")
				tblEvidence.getRow(0).getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(6000))
				tblEvidence.getRow(0).getCell(2).setText("")
				tblEvidence.getRow(0).getCell(2).getCTTc().addNewTcPr().addNewShd().setFill("82CAFF")
				tblEvidence.getRow(0).getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000))
				
				tblEvidence.getRow(1).getCell(0).setText("Item Test")
				tblEvidence.getRow(1).getCell(0).getCTTc().addNewTcPr().addNewShd().setFill("82CAFF")
				tblEvidence.getRow(1).getCell(1).setText("Capture")
				tblEvidence.getRow(1).getCell(1).getCTTc().addNewTcPr().addNewShd().setFill("82CAFF")
				tblEvidence.getRow(1).getCell(2).setText("Status")
				tblEvidence.getRow(1).getCell(2).getCTTc().addNewTcPr().addNewShd().setFill("82CAFF")
				
				tblEvidence.getRow(2).getCell(0).setText("Tanggal Test")
				tblEvidence.getRow(2).getCell(1).setText(listSummary.get(i).get(2))
				tblEvidence.getRow(2).getCell(2).setText("OK")
				
				tblEvidence.getRow(3).getCell(0).setText("Device / OS")
				tblEvidence.getRow(3).getCell(1).setText(device)
				tblEvidence.getRow(3).getCell(2).setText("OK")
				
				tblEvidence.getRow(4).getCell(0).setText("Channel")
				tblEvidence.getRow(4).getCell(1).setText("MyOrbit")
				tblEvidence.getRow(4).getCell(2).setText("OK")
				
				tblEvidence.getRow(5).getCell(0).setText("MSISDN")
				tblEvidence.getRow(5).getCell(1).setText("")
				tblEvidence.getRow(5).getCell(2).setText("OK")
				
				mergeCellsHorizontally(tblEvidence, 1, 0, 2)
	//			mergeCellsHorizontally(tblEvidence, 1, 1, 2)
	//			mergeCellsHorizontally(tblEvidence, 3, 0, 2)
	//			mergeCellsHorizontally(tblEvidence, 4, 0, 2)
	//			mergeCellsHorizontally(tblEvidence, 5, 0, 2)
				
				for(int j=0; j<totalLoopByComment; j++) {
					String comment = listComments.get(i).get(j)
					String takeScreenshot = listTakeScreenshots.get(i).get(j)
					
					tblEvidence.getRow(j+6).getCell(0).setText(comment)
					tblEvidence.getRow(j+6).getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000))
					tblEvidence.getRow(j+6).getCell(0).setVerticalAlignment(XWPFVertAlign.CENTER)
					
					XWPFTableCell cell = tblEvidence.getRow(j+6).getCell(1)
	//				tblEvidence.getRow(j+6).getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER)
					XWPFParagraph paragraph = cell.addParagraph()
					XWPFRun run = paragraph.createRun()
					paragraph.setAlignment(ParagraphAlignment.CENTER)
					paragraph.setVerticalAlignment(TextAlignment.AUTO)
					FileInputStream fis = new FileInputStream(takeScreenshot)
					run.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, "pict", Units.pixelToEMU(168), Units.pixelToEMU(350))
					tblEvidence.getRow(j+6).getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(6000))
	//				tblEvidence.getRow(j+6).getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER)
					
					tblEvidence.getRow(j+6).getCell(2).setText("OK")
					tblEvidence.getRow(j+6).getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000))
					
				}
				
				p = document.createParagraph()
				p.setAlignment(ParagraphAlignment.CENTER)
				r = p.createRun()
				r.setText("Back to summary")
				r.setFontSize(10)
				r.setColor("191970")
				r.addBreak()
			}
			
			Date date = new Date()
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss")
			String currentDateTime = sdf.format(date)
			
			FileOutputStream out = new FileOutputStream(targetReportDiretory +separator +getFolderName +separator +"report " +currentDateTime  +".docx");
			document.write(out);
			out.close();
			Thread.sleep(10000);
			
//					FileOutputStream out = new FileOutputStream("create_table.docx");
//					document.write(out);
//					out.close();
}

private static void mergeCellsHorizontally(XWPFTable table, int col, int fromCol, int toCol) {
	for (int colIndex = fromCol; colIndex <= toCol; colIndex++) {
		XWPFTableCell cell = table.getRow(0).getCell(colIndex);

		if ( colIndex == fromCol ) {
			// The first merged cell is set with RESTART merge value
			cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
		} else {
			// Cells which join (merge) the first one, are set with CONTINUE
			cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
		}
	}
}
	
/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = true) // Please change skipped to be false to activate this method.
def setupTestCase() {
	// Put your code here.
}

/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = true) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	// Put your code here.
}

/**
 * References:
 * Groovy tutorial page: http://docs.groovy-lang.org/next/html/documentation/
 */