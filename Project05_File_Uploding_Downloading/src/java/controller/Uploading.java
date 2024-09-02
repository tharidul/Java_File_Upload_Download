package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "Uploading", urlPatterns = {"/Uploading"})
public class Uploading extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        System.out.println(email);
        
        String applicationPath = request.getServletContext().getRealPath("");
        System.out.println(applicationPath);
        File newFile = new File(applicationPath+"//files//hello.png");

        Part filePart = request.getPart("file");
        InputStream inputStream = filePart.getInputStream();
        
        Files.copy(
                inputStream,
                newFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );
        


    }

}
