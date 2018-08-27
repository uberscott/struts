package org.superbiz.struts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    private final UserRepository userRepository;

    public UsersController( UserRepository userService )
    {
        this.userRepository = userService;
    }

    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUserForm";
    }


    @PostMapping("/addUser")
    public String addUser(@RequestParam("id") long id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName )
    {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        this.userRepository.save(user);

        return "addUser";
    }

    @GetMapping("/findUser")
    public String findUserForm() {
        return "findUserForm";
    }

    @PostMapping("/findUser")
    public String findUser(@RequestParam Long id, Model model) {
        User user = userRepository.findOne(id);

        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            return "findUserForm";
        }

        model.addAttribute("user", user);
        return "displayUser";
    }


    @GetMapping("/list")
    public String listUsers(Model model)
    {
        model.addAttribute("users", userRepository.findAll());
        return "displayUsers";
    }
}
