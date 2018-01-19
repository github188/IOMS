/**
 * @ProjectName PCSP
 * @FileName JasperReportUtils.java
 * @PackageName:cn.com.atnc.pcsp.util
 * @author WangLingbin
 * @date 2015年5月28日下午3:01:52
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.util.file.ProjectFilePath;

/**
 * 报表工具类
 * 
 * @author WangLingbin
 * @date 2015年5月28日 下午3:01:52
 * @since 1.0.0
 */
@Service
public class JasperReportUtils {

	private static String separator;
	private static String reportExt;
	public static final String OUTLINE_ADDRESS = "outline_address";
	public static final String REPORT_ADDRESS = "report_address";

	public static String getReportExt() {
		return reportExt;
	}

	static {
		try {
			Properties p = new Properties();
			InputStream in = new FileInputStream(new File(
					ProjectFilePath.getConfPath() + "file.properties"));
			p.load(in);
			separator = p.getProperty("separator");
			reportExt = p.getProperty("reportExt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取.jrpint的绝对路径
	 * 
	 * @param request
	 * @param reportName
	 *            图片名称
	 * @return
	 * @author WangLingbin
	 * @date 2015年5月28日下午3:03:16
	 * @since 1.0.0
	 */
	public static String getJrprintPath(HttpServletRequest request,
			String reportName) {
		String path = request.getServletContext().getRealPath(
				"/WEB-INF/reports/" + reportName + ".jrprint");
		return path;
	}

	/**
	 * 获取根目录路径
	 * 
	 * @param request
	 * @param reportName
	 *            图片名称
	 * @return
	 * @author WangLingbin
	 * @date 2015年5月28日下午3:03:49
	 * @since 1.0.0
	 */
	public static String getRootPath(HttpServletRequest request,
			String reportName) {
		String path = request.getServletContext().getRealPath(
				"/WEB-INF/reports/" + reportName + ".jasper");
		String rootPath = path.substring(0, path.lastIndexOf(separator));
		return rootPath;
	}

	/**
	 * 获取图片路径
	 * 
	 * @param request
	 * @param reportName
	 *            图片名称
	 * @return
	 * @author WangLingbin
	 * @date 2015年5月28日下午3:04:16
	 * @since 1.0.0
	 */
	public static String getImagePath(HttpServletRequest request,
			String reportName) {
		String path = getRootPath(request, reportName);
		String imagePath = path.substring(0, path.lastIndexOf("WEB-INF"))
				+ "images" + separator + "report" + separator;
		return imagePath;
	}

	/**
	 * 获取.jrpint文件
	 * 
	 * @param request
	 * @param filename
	 *            文件名称
	 * @return
	 * @throws JRException
	 * @author WangLingbin
	 * @date 2015年5月28日下午3:10:55
	 * @since 1.0.0
	 */
	public static JasperPrint getJasperPrint(HttpServletRequest request,
			String filename) throws JRException {
		JasperPrint jasperPrint = null;
		jasperPrint = (JasperPrint) JRLoader.loadObject(new File(
				getJrprintPath(request, filename)));
		return jasperPrint;
	}

	/**
	 * 填充数据
	 * 
	 * @param param
	 * @param request
	 * @param reportName
	 *            报表名称
	 * @param imageName
	 *            图像名称
	 * @param datasource
	 *            数据源
	 * @param hasSubReport
	 *            是否有子报表
	 * @throws JRException
	 * @author WangLingbin
	 * @date 2015年5月28日下午3:11:30
	 * @since 1.0.0
	 */
	public static void fillData(Map<String, Object> param,
			HttpServletRequest request, String reportName, String imageName,
			List<?> datasource, boolean hasSubReport) throws JRException {

		String rootPath = getRootPath(request, reportName);
		String path = rootPath + separator + reportName + ".jasper";
		File file = new File(path);
		if (!file.exists())
			throw new JRRuntimeException(
					"File report.jasper not found. The report design must be compiled first.");
		// Map<String,Object> param = new HashMap<String,Object>();
		if (hasSubReport) {
			param.put("SUBREPORT_DIR", rootPath + separator);
		}
		if (!StringUtils.isEmpty(imageName) && !imageName.trim().equals("")) {
			String imagePath = getImagePath(request, reportName);
			param.put("IMAGE", imagePath + imageName);
		}
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObjectFromFile(file.getPath());
		JasperFillManager.fillReportToFile(jasperReport, rootPath + separator
				+ reportName + ".jrprint", param,
				new JRBeanCollectionDataSource(datasource));
		// System.err.println("fill~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	/**
	 * 导出报表操作
	 * 
	 * @param type
	 *            导出类型
	 * @param request
	 * @param jasperPrint
	 * @return
	 * @throws JRException
	 * @throws IOException
	 * @author WangLingbin
	 * @date 2015年5月28日下午3:12:05
	 * @since 1.0.0
	 */
	public static byte[] exportReport(String type, HttpServletRequest request,
			JasperPrint... jasperPrint) throws JRException, IOException {

		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		for (JasperPrint jp : jasperPrint) {
			jasperPrintList.add(jp);
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (StringUtils.equalsIgnoreCase(type, "pdf")) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(SimpleExporterInput
					.getInstance(jasperPrintList));
			OutputStreamExporterOutput out = new SimpleOutputStreamExporterOutput(
					os);
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			configuration.setCreatingBatchModeBookmarks(true);
			exporter.setConfiguration(configuration);
			exporter.setExporterOutput(out);
			exporter.exportReport();
		} else if (StringUtils.equalsIgnoreCase(type, "doc")) {
			JRRtfExporter exporter = new JRRtfExporter();
			exporter.setExporterInput(SimpleExporterInput
					.getInstance(jasperPrintList));
			SimpleWriterExporterOutput out = new SimpleWriterExporterOutput(os);
			exporter.setExporterOutput(out);
			exporter.exportReport();
		} else if (StringUtils.equalsIgnoreCase(type, "xls")) {
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setExporterInput(SimpleExporterInput
					.getInstance(jasperPrintList));
			SimpleOutputStreamExporterOutput out = new SimpleOutputStreamExporterOutput(
					os);
			exporter.setExporterOutput(out);
			// 设置excel参数
			SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
			configuration.setOnePagePerSheet(false);
			exporter.setConfiguration(configuration);
			exporter.exportReport();
		}
		byte[] bytes = os.toByteArray();
		os.close();
		return bytes;
	}

	public static byte[] exportReport(String type, HttpServletRequest request,
			List<JasperPrint> jasperPrintList) throws JRException, IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (StringUtils.equalsIgnoreCase(type, "pdf")) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(SimpleExporterInput
					.getInstance(jasperPrintList));
			OutputStreamExporterOutput out = new SimpleOutputStreamExporterOutput(
					os);
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			configuration.setCreatingBatchModeBookmarks(true);
			exporter.setConfiguration(configuration);
			exporter.setExporterOutput(out);
			exporter.exportReport();
		} else if (StringUtils.equalsIgnoreCase(type, "doc")) {
			JRRtfExporter exporter = new JRRtfExporter();
			exporter.setExporterInput(SimpleExporterInput
					.getInstance(jasperPrintList));
			SimpleWriterExporterOutput out = new SimpleWriterExporterOutput(os);
			exporter.setExporterOutput(out);
			exporter.exportReport();
		} else if (StringUtils.equalsIgnoreCase(type, "xls")) {
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setExporterInput(SimpleExporterInput
					.getInstance(jasperPrintList));
			SimpleOutputStreamExporterOutput out = new SimpleOutputStreamExporterOutput(
					os);
			exporter.setExporterOutput(out);
			// 设置excel参数
			SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
			configuration.setOnePagePerSheet(false);
			exporter.setConfiguration(configuration);
			exporter.exportReport();
		}
		byte[] bytes = os.toByteArray();
		os.close();
		return bytes;
	}

	public static Map<String, String> saveReturedApplyList(int number,
			String applyBaseInfoID, HttpServletRequest request,
			String reportName) throws Exception {
		Map<String, String> paths = new HashMap<String, String>();
		StringBuffer relativeFilePath = new StringBuffer(request.getScheme()
				+ "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath()
				+ "/returnedApply/" + reportName + "-" + applyBaseInfoID + "-"
				+ number + ".jrprint");
		// 获取报表
		String filePath = getJrprintPath(request, reportName);
		// 获取存储报表的绝对路径
		String absoluteAddress = request.getServletContext().getRealPath(
				"/returnedApply/")
				+ separator
				+ reportName
				+ "-"
				+ applyBaseInfoID
				+ "-"
				+ number
				+ ".jrprint";
		// 保存网络地址和绝对地址
		paths.put(OUTLINE_ADDRESS, relativeFilePath.toString());
		paths.put(REPORT_ADDRESS, absoluteAddress);
		// 将文件保存在absoluteAddress路径下
		InputStream in = new FileInputStream(new File(filePath));
		BufferedInputStream bin = new BufferedInputStream(in);
		File file = new File(absoluteAddress);
		BufferedOutputStream bout = new BufferedOutputStream(
				new FileOutputStream(file));
		Streams.copy(bin, bout, true);
		return paths;
	}

	public static String saveReturedApply(int number,
			HttpServletRequest request, String reportName) throws Exception {
		// 获取报表
		String filePath = getJrprintPath(request, reportName);
		// 获取存储报表的绝对路径
		String absoluteAddress = getRootPath(request, reportName) + separator
				+ "returnedApply" + separator + reportName + number
				+ ".jrprint";
		InputStream in = new FileInputStream(new File(filePath));
		// 将文件保存在absoluteAddress路径下
		BufferedInputStream bin = new BufferedInputStream(in);
		File file = new File(absoluteAddress);
		BufferedOutputStream bout = new BufferedOutputStream(
				new FileOutputStream(file));
		Streams.copy(bin, bout, true);
		return absoluteAddress;
	}

	public static Map<String, String> saveReturedFileList(
			HttpServletRequest request, String reportAddress) throws Exception {
		Map<String, String> paths = new HashMap<String, String>();
		// 截取路径，获得保存文件的路径
		int position = reportAddress.lastIndexOf("/");
		// 文件根目录
		String root = reportAddress.substring(0, position);
		// 文件名字(带后缀名)
		String fileName = reportAddress.substring(position + 1,
				reportAddress.length());
		// 网络路径
		StringBuffer relativeFilePath = new StringBuffer(request.getScheme()
				+ "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath()
				+ "/attached/returnedFile/" + fileName);
		// 将文件保存在absoluteAddress路径下
		String absoluteAddress = root + separator + "returnedFile" + separator
				+ fileName;
		// 保存文件路径
		paths.put(OUTLINE_ADDRESS, relativeFilePath.toString());
		paths.put(REPORT_ADDRESS, absoluteAddress);
		InputStream in = new FileInputStream(new File(reportAddress));
		BufferedInputStream bin = new BufferedInputStream(in);
		File file = new File(absoluteAddress);
		BufferedOutputStream bout = new BufferedOutputStream(
				new FileOutputStream(file));
		Streams.copy(bin, bout, true);
		return paths;
	}

	public static String saveReturedFile(HttpServletRequest request,
			String reportAddress) throws Exception {
		// 截取路径，获得保存文件的路径
		int position = reportAddress.lastIndexOf("/");
		// 文件根目录
		String root = reportAddress.substring(0, position);
		// 文件名字(带后缀名)
		String fileName = reportAddress.substring(position + 1,
				reportAddress.length());
		// 将文件保存在absoluteAddress路径下
		String absoluteAddress = root + separator + "returnedFile" + separator
				+ fileName;
		InputStream in = new FileInputStream(new File(reportAddress));
		BufferedInputStream bin = new BufferedInputStream(in);
		File file = new File(absoluteAddress);
		BufferedOutputStream bout = new BufferedOutputStream(
				new FileOutputStream(file));
		Streams.copy(bin, bout, true);
		return absoluteAddress;
	}

	/**
	 * 获取文件后缀名
	 * 
	 * @param filePath
	 * @return 正常附件后缀名（doc...） 报表后缀名（jrprint）
	 * @author WangLingbin
	 * @date 2015年11月12日上午9:43:27
	 * @since 1.0.0
	 */
	public static String getFileExt(String filePath) {
		int position = filePath.lastIndexOf(".");
		// 获取文件后缀名
		String fileExt = filePath.substring(position + 1, filePath.length());
		return fileExt;
	}

}
