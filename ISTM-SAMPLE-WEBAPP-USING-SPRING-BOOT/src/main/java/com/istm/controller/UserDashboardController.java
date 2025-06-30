package com.istm.controller;

import java.io.IOException;
import java.nio.file.*;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.istm.dao.IncidentRepository;
import com.istm.dao.UserRepository;
import com.istm.entities.Incident;
import com.istm.entities.User;

@Controller
@RequestMapping("/user")
public class UserDashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String userName = principal.getName();
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    }

    @RequestMapping("/dashboard")
    public String userDashboardPage() {
        return "userdashboard.html";
    }

    @RequestMapping("/addincident")
    public String addIncidentPage(Model model) {
        model.addAttribute("incident", new Incident());
        return "addincident";
    }

    @PostMapping("/process-incident")
    public String processIncidentPage(
            @ModelAttribute Incident incident,
            @RequestParam("attachmentFile") MultipartFile attachmentFile,
            Principal principal) {

        String userName = principal.getName();
        User user = userRepository.getUserByUserName(userName);
        incident.setUser(user);

        // Handle file upload
        if (attachmentFile != null && !attachmentFile.isEmpty()) {
            String fileName = Path.of(attachmentFile.getOriginalFilename()).getFileName().toString();
            incident.setAttachment(fileName);

            try {
                String uploadDir = "uploads/";
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Files.copy(attachmentFile.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
                // Optionally, you can add error handling logic
            }
        }

        Incident result = incidentRepository.save(incident);
        System.out.println("Saved incident: " + result);
       

        return "redirect:/user/addincident?success";
    }
}
