package controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Downloading", urlPatterns = {"/Downloading"})
public class Downloading extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String applicationPath = request.getServletContext().getRealPath("");
        File newFile = new File(applicationPath + "//files//hello.png");

        response.setHeader("Content-Disposition", "attachment; filename=hello.png");

        OutputStream outputStream = response.getOutputStream();

        Files.copy(
                newFile.toPath(),
                outputStream
        );

    }

}
