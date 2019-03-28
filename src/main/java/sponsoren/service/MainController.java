package sponsoren.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sponsoren.orm.AccountEntity;
import sponsoren.orm.LocationEntity;
import sponsoren.orm.SponsorEntity;

import java.util.Optional;

@Controller
@RequestMapping(path="/api")
public class MainController {
    @Autowired private SponsorRepository sponsorRepository;
    @Autowired private SponsorVeranstaltungRepository sponsorVeranstaltungRepository;
    @Autowired private LocationRepository locationRepository;
    @Autowired private AccountRepository accountRepository;

    // GET root
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/pages/final.htm";
    }

    // GET sponsor.Werbetext
    @GetMapping(path="/sponsor/werbetext")
    public @ResponseBody String getSponsorWerbetext(@RequestParam String name) {
        if(name.isEmpty())
            return "missing request parameter ?name="; // TODO use error result code

        Optional<SponsorEntity> s = sponsorRepository.findById(name);
        if(s.isPresent())
        {
            // sponsor found in database
            return s.get().getWerbetext();
        }
        else
            return "Unknown Sponsor '" + name + "'"; // TODO use error result code
    }


    // GET list of all sponsors
    @GetMapping(path="/sponsor/all")
    public @ResponseBody Iterable<SponsorEntity> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    // GET list of all locations
    @GetMapping(path="/location/all")
    public @ResponseBody Iterable<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }

    // GET list of all accounts
    @GetMapping(path="/account/all")
    public @ResponseBody Iterable<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    // GET list of sponsor_veeanstaltung
    /*@GetMapping(path="/sponsor_veranstaltung/all")
    public @ResponseBody Iterable<SponsorVeranstaltungEntity> getAllVeranst() {
        return sponsorVeranstaltungRepository.findAll();
    }*/
}
