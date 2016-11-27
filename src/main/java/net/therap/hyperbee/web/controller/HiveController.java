package net.therap.hyperbee.web.controller;

import net.therap.hyperbee.domain.Hive;
import net.therap.hyperbee.service.HiveService;
import net.therap.hyperbee.service.UserService;
import net.therap.hyperbee.web.command.UserIdInfo;
import net.therap.hyperbee.web.helper.UploadedFile;
import net.therap.hyperbee.web.security.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author azim
 * @since 11/22/16
 */
@Controller
@RequestMapping("/user/hive")
public class HiveController {

    private String CREATE_HIVE = "hive/hiveForm";

    private String SHOW_HIVE = "hive/showHive";

    private String HIVE = "hive/hive";

    @Autowired
    private HiveService hiveService;

    @Autowired
    UploadedFile uploadedFile;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String viewHive(ModelMap model, HttpSession session) {
        int userId = getUserIdFromSession(session);
        model.put("hiveList", hiveService.getHiveListByUserId(userId));

        return HIVE;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createHive(Model model) {
        model.addAttribute("hive", new Hive());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("userIdInfo", new UserIdInfo());

        return CREATE_HIVE;
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String viewHivePage(Model model,@PathVariable("id") int id) {
        model.addAttribute("hiveId", id);
        System.out.println("hiveId " + id);
        model.addAttribute("hive", hiveService.retrieveHiveById(id));
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("userIdInfo", new UserIdInfo());

        return SHOW_HIVE;
    }

    @RequestMapping(value = "/insertuser/{hiveId}", method = RequestMethod.POST)
    public String addUserToHive(@ModelAttribute UserIdInfo userIdInfo, Model model, @PathVariable("hiveId") int hiveId) {

        model.addAttribute("userInfoId", userIdInfo);
        hiveService.insertUsersToHive(hiveId, userIdInfo.getUserIdList());

        return "redirect:/user/hive/show/"+hiveId;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveHiveForm(@ModelAttribute Hive hive, @RequestParam CommonsMultipartFile fileUpload, Model model, HttpSession session) throws IOException {
        model.addAttribute("hiveName", hive.getName());

        String filename = uploadedFile.uploadFile(fileUpload, hive.getName());
        hive.setImagePath(filename);

        int userId = getUserIdFromSession(session);
        Hive newHive = hiveService.insertFirstUserToHive(hive,userId);

        hiveService.insertHive(newHive);
        System.out.println("newHive.getname() " + newHive.getName());
        int hiveId = hiveService.getHiveIdByHiveName(newHive.getName());

        return "redirect:/user/hive/show/"+hiveId;
    }

    private int getUserIdFromSession(HttpSession session) {
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");
        return authUser.getId();
    }

}