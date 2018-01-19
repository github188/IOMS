/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-6 下午4:02:05
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.file.ProjectFilePath;

/**
 * 
 * 
 * @author:huangyijie
 * @date:2013-9-6 下午4:02:05
 */
@Controller("ExportController")
@RequestMapping("/ueditor/jsp/upload")
public class UEditorDownloadController extends BaseFileLoadController {

	@RequestMapping(value = "/{w}/{w}.{w}")
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException,
			ServiceException {

		String[] paths = request.getRequestURI().split("/", 3);
		String[] names = request.getRequestURI().split("/", 0);
		if (ObjectUtils.isEmpty(paths) || paths.length != 3) {
			throw new ServiceException("解析文件路径失败：" + request.getRequestURI());
		}
		if (ObjectUtils.isEmpty(names) || paths.length < 1) {
			throw new ServiceException("解析文件名失败：" + request.getRequestURI());
		}
		File file = new File(ProjectFilePath.getProjectPath() + paths[2]);
		FileInputStream stream = null;
		stream = new FileInputStream(file);
		super.doDownLoad(request, response, stream, names[names.length - 1]);
	}
}
