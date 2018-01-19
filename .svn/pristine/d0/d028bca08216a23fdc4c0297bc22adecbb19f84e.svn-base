package cn.com.atnc.ioms.web;




import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.atnc.common.util.AssertUtil;

/**
 * @author:HuangYijie
 * @date:2013-8-28 上午9:24:23
 * @version:1.0
 */

public class BaseFileLoadController extends MyBaseController {

	public void SaveFileFromInputStream(InputStream stream, String path,
			String filename) throws IOException {
		FileOutputStream fs = new FileOutputStream(path + "/" + filename);
		try {
			byte[] buffer = new byte[1024 * 1024];
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = stream.read(buffer)) != -1) {
				bytesum += byteread;
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
		} finally {
			fs.close();
			stream.close();
		}
	}

	protected void doDownLoad(final HttpServletRequest request,
			final HttpServletResponse response, final InputStream stream,
			String displayName) throws IOException {
		AssertUtil.notNull(stream, "被下载的文件流不能为空");
		AssertUtil.hasText(displayName, "显示名称必须指定");
		String ua = request.getHeader("user-agent"); // 获取终端类型
		if (ua == null)
			ua = " User-Agent: Mozilla/4.0 (compatible; MSIE 6.0;) ";
		boolean isIE = ua.toLowerCase().indexOf(" msie ") != -1;

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("application/octet-stream;charset=ISO8859-1");
		if (isIE)
			response.setContentType("application/x-download");// 设置为下载application/x-download
		// 解决中文乱码
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(displayName.getBytes(GBK), ISO8859));

		OutputStream output = null;
		InputStream fis = null;
		try {
			output = response.getOutputStream();
			fis = stream;
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = fis.read(b)) > 0) {
				output.write(b, 0, i);
			}
			output.flush();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (fis != null) {
				fis.close();
				fis = null;
			}
			if (output != null) {
				output.close();
				output = null;
			}
		}
	}

	protected void doDownLoad(HttpServletResponse response, String content,
			String displayName) throws IOException {
		AssertUtil.notNull(content, "被下载的文件内容不能为空");
		AssertUtil.hasText(displayName, "显示名称必须指定");
		response.reset();
		response.setHeader("Pragma", "public");
		response.setDateHeader("Expires", 0);
		response.setContentLength(content.length());
		response.setCharacterEncoding(GBK);
		// response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control",
				"must-revalidate,post-check=0,pre-check=0");
		response.setContentType("application/force-download");
		response.setContentType("application/octet-stream");
		response.setContentType("application/x-download");

		PrintWriter writer = null;
		try {
			// 解决中文乱码
			String fileName = new String(displayName.getBytes(GBK), ISO8859);
			response.setHeader("Content-Disposition", "attachment;filename="
					+ fileName);
			writer = response.getWriter();
			writer.write(content);
			writer.flush();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (writer != null) {
				writer.close();
				writer = null;
			}
		}
	}
}
