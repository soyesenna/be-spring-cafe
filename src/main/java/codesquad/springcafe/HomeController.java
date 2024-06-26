package codesquad.springcafe;

import codesquad.springcafe.article.repository.ArticleRepository;
import codesquad.springcafe.article.service.ArticleService;
import codesquad.springcafe.constants.Constant;
import codesquad.springcafe.user.domain.LoginUser;
import codesquad.springcafe.user.domain.UserIdentity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final ArticleService articleService;

    @Autowired
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public String home(Model model, HttpSession session) {
        model.addAttribute("articles", articleService.getArticlesAsList());

        return "index";
    }
}
