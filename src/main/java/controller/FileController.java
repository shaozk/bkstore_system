package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import utils.TextUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author shaozk
 */
@Controller
public class FileController {

    @RequestMapping("/toUpload")
    public String toUpload() {
        return "/testFileUpload";
    }


    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        // 获取文件名
        String uploadFileName = file.getOriginalFilename();

        // 如果文件名为空，直接返回
        if(TextUtil.isEmpty(uploadFileName)) {
            return "redirect:/testFileUpload";
        }

        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/upload");

        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);

        //文件输入流
        InputStream is = file.getInputStream();
        //文件输出流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName));

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/testFileUpload";

    }
}


